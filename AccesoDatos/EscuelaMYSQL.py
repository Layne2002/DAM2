# Karim Zinnatullin
import mysql.connector

connection = mysql.connector.connect(
    host='79.72.53.157',
    user='director',
    password="Director123",
    database="escuela",
)

cursor = connection.cursor()

# Funciones


def matricular_estudiante():
    try:
        id_estudiante = int(input("Ingrese el ID del estudiante: "))
        id_curso = int(input("Ingrese el ID del curso: "))
        fecha_inicio = input("Ingrese la fecha de inicio (YYYY-MM-DD): ")
        fecha_fin = input("Ingrese la fecha de fin (YYYY-MM-DD): ")
        calificacion = input(
            "Ingrese la calificación (opcional, presione Enter para omitir): ")
        calificacion = None if calificacion == "" else float(calificacion)

        query = """
        INSERT INTO matriculas (id_estudiante, id_curso, fecha_inicio, fecha_fin, calificacion)
        VALUES (%s, %s, %s, %s, %s)
        """
        cursor.execute(query, (id_estudiante, id_curso,
                       fecha_inicio, fecha_fin, calificacion))
        connection.commit()
        print("Estudiante matriculado correctamente.")
    except mysql.connector.Error as err:
        print(f"Error al matricular estudiante: {err}")


def listar_estudiantes_en_curso():
    try:
        id_curso = int(input("Ingrese el ID del curso: "))
        query = """
        SELECT E.id_estudiante, E.nombre, E.correo
        FROM estudiantes E
        INNER JOIN matriculas M ON E.id_estudiante = M.id_estudiante
        WHERE M.id_curso = %s
        """
        cursor.execute(query, (id_curso,))
        estudiantes = cursor.fetchall()
        if estudiantes:
            print(f"Estudiantes matriculados en el curso {id_curso}:")
            for estudiante in estudiantes:
                print(
                    f"- ID: {estudiante[0]}, Nombre: {estudiante[1]}, Correo: {estudiante[2]}")
        else:
            print("No hay estudiantes matriculados en este curso.")
    except mysql.connector.Error as err:
        print(f"Error al listar estudiantes: {err}")


def baja_estudiante_en_curso():
    try:
        id_estudiante = int(input("Ingrese el ID del estudiante: "))
        id_curso = int(input("Ingrese el ID del curso: "))
        query = """
        DELETE FROM matriculas
        WHERE id_estudiante = %s AND id_curso = %s
        """
        cursor.execute(query, (id_estudiante, id_curso))
        connection.commit()
        if cursor.rowcount > 0:
            print("El estudiante fue dado de baja correctamente.")
        else:
            print("No se encontró la matrícula para eliminar.")
    except mysql.connector.Error as err:
        print(f"Error al dar de baja al estudiante: {err}")


def actualizar_precio_curso():
    try:
        id_curso = int(input("Ingrese el ID del curso: "))
        nuevo_precio = float(
            input("Ingrese el nuevo precio mensual del curso: "))
        query = """
        UPDATE cursos
        SET precio = %s
        WHERE id_curso = %s
        """
        cursor.execute(query, (nuevo_precio, id_curso))
        connection.commit()
        print("Precio del curso actualizado correctamente.")
    except mysql.connector.Error as err:
        print(f"Error al actualizar el precio: {err}")


def emitir_recibos_por_estudiante():
    try:
        id_estudiante = int(input("Ingrese el ID del estudiante: "))
        query = """
        SELECT C.nombre, C.precio, M.fecha_inicio, M.fecha_fin
        FROM cursos C
        INNER JOIN matriculas M ON C.id_curso = M.id_curso
        WHERE M.id_estudiante = %s
        """
        cursor.execute(query, (id_estudiante,))
        recibos = cursor.fetchall()
        if recibos:
            print(f"Recibos para el estudiante {id_estudiante}:")
            total = 0
            for recibo in recibos:
                curso, precio, inicio, fin = recibo
                print(
                    f"- Curso: {curso}, Precio: {precio}, Desde: {inicio}, Hasta: {fin}")
                total += precio
            print(f"Total a pagar: {total} €")
        else:
            print("El estudiante no tiene recibos generados.")
    except mysql.connector.Error as err:
        print(f"Error al emitir recibos: {err}")

# Menú interactivo


def mostrar_menu():
    while True:
        print("\n=== Menú de Gestión de Cursos ===")
        print("1. Matricular a un estudiante en un curso")
        print("2. Listar estudiantes en un curso")
        print("3. Dar de baja a un estudiante en un curso")
        print("4. Actualizar el precio de un curso")
        print("5. Emitir recibos por estudiante")
        print("6. Salir")

        try:
            opcion = int(input("Seleccione una opción: "))
            if opcion == 1:
                matricular_estudiante()
            elif opcion == 2:
                listar_estudiantes_en_curso()
            elif opcion == 3:
                baja_estudiante_en_curso()
            elif opcion == 4:
                actualizar_precio_curso()
            elif opcion == 5:
                emitir_recibos_por_estudiante()
            elif opcion == 6:
                print("Saliendo del programa...")
                break
            else:
                print("Opción no válida. Intente de nuevo.")
        except ValueError:
            print("Por favor, ingrese un número válido.")


# Llamar al menú
try:
    mostrar_menu()
except KeyboardInterrupt:
    print("\nPrograma terminado por el usuario.")
finally:
    if connection.is_connected():
        cursor.close()
        connection.close()
        print("Conexión cerrada.")
