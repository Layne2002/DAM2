'''NOMBRE Y APELLIDOS: Karim Zinnatullin
Desarrolla un programa en Python que gestione un sistema de biblioteca.No hace falta que comentes cada cosa que realices pero sí lo que consideres debería saber otro compañero tuyo, para cuando te vayas de vacaciones y tu compañero debe manipular tu código. Este programa debe cumplir los siguientes requisitos:

1.Define una clase base Material que tenga atributos comunes a todos los materiales de la biblioteca, como:
id (único para cada material)
título
autor
año de publicación '''


class Material:
    def __init__(self, id, titulo, autor, anyo) -> None:
        self.id = id
        self.titulo = titulo
        self.autor = autor
        self.anyo = anyo

    def toString(self):
        return "ID: "+str(self.id)+", Título: "+self.titulo+", Autor: "+self.autor+", Año Publicación: "+str(self.anyo)


'''2.Crea dos clases que hereden de Material

Libro: Incluye atributos adicionales como género (debe seleccionarse entre una lista predefinida: "Ficción", "No Ficción", "Terror", "Ciencia") y número de páginas (debe ser mayor a 0).

Revista: Incluye atributos adicionales como número de edición y mes de publicación (debe seleccionarse entre los meses válidos: "Enero", "Febrero", ..., "Diciembre")'''


class Libro(Material):
    def generarGenero(opcion):
        generos = ["Ficción", "No Ficción", "Terror", "Ciencia"]
        return generos[opcion-1]

    def __init__(self, id, titulo, autor, anyo, genero, paginas) -> None:
        super().__init__(id, titulo, autor, anyo)
        self.genero = Libro.generarGenero(genero)
        # si el numero de paginasintroducido es 0 o menos, se asignará 1
        self.paginas = max(1, paginas)

    def toString(self):
        cadena = super().toString()
        return cadena+", Género: "+str(self.genero)+", Páginas: "+str(self.paginas)


class Revista(Material):
    def generarMes(opcion):
        meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                 "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"]
        return meses[opcion-1]

    def __init__(self, id, titulo, autor, anyo, edicion, mesPublicacion) -> None:
        super().__init__(id, titulo, autor, anyo)
        self.edicion = edicion
        # mesPublicacion ha de ser el numero del mes (Ejemplo: Septiembre = 9, Diciembre = 12, Enero = 1)
        self.mesPublicacion = Revista.generarMes(mesPublicacion)

    def toString(self):
        cadena = super().toString()
        return cadena+", Edición: "+str(self.edicion)+", Mes de publicación: "+str(self.mesPublicacion)


'''3.Utiliza un diccionario para almacenar los materiales, donde la clave sea el id y el valor sea un objeto de tipo Libro o Revista.'''
'''4.Mantén una lista de todos los id existentes para verificar que no se repitan al agregar nuevos materiales.'''
# Hecho en el main

'''5. Generar Estadísticas:debe devolver todos estos valores
Total de materiales registrados.
Número de libros y revistas.
Promedio de páginas para los libros.
Ayuda: se puede usar la siguiente función: Ej: isinstance(m, Libro)--> devuelve true si el objeto m es de tipo Libro'''


def generarEstadisticas(materiales):
    total_materiales = 0
    total_libros = 0
    total_revistas = 0
    paginas_libros = 0
    for x, m in materiales.items():
        total_materiales += 1
        if isinstance(m, Libro):
            total_libros += 1
            paginas_libros += m.paginas
        else:
            total_revistas += 1
    if total_libros != 0:
        promedio_paginas = paginas_libros/total_libros
    else:
        promedio_paginas = 0
    print(f"Total de materiales registrados: {total_materiales}")
    print(f"Libros: {total_libros}")
    print(f"Revistas: {total_revistas}")
    print(f"Promedio de páginas para los libros: {promedio_paginas}")


'''6.Implementa un menú que permita al usuario realizar las siguientes acciones:
Agregar Material: Permite al usuario agregar un nuevo Libro o Revista.
Listar Materiales: Muestra una lista de todos los materiales registrados con sus detalles. Elije la forma de presentación más adecuada para que el usuario lo vea claro.
Buscar Material por ID: Permite al usuario buscar un material específico por su id.
Eliminar Material: Elimina un material específico usando su id.
Generar Estadísticas
Salir: Termina la ejecución del programa.'''


def mostrar_menu():
    print("-----------------------------------------------------")
    print("MENÚ DE OPCIONES")
    print("a) Agregar Material")
    print("b) Listar Materiales.")
    print("c) Buscar Material por ID.")
    print("d) Eliminar Material.")
    print("e) Generar Estadísticas.")
    print("f) Salir")


def main():
    materiales = {
        1: Libro(54, "Harry potter 1", "JK Rowling", 2000, 0, 246),
        2: Libro(55, "Harry potter 2", "JK Rowling", 2002, 1, 276),
        3: Revista(56, "Top Gun 54", "Alberto chicote", 2023, 146, 4),
        4: Revista(57, "Spider-Man 32", "JK Rowling", 2021, 246, 3),
    }
    # la lista para los IDs
    IDs = [54, 55, 56, 57]
    while True:
        mostrar_menu()
        opcion = input("Selecciona una opción: ").lower()
        print("-----------------------------------------------------")
        match opcion:
            case 'a':
                id = int(input("Dime el id del material:\n"))
                if id not in IDs:
                    tipo = int(
                        input("1- Agregar un libro 2- Agregar una revista\n"))
                    if tipo == 1 or tipo == 2:
                        titulo = input("Dime el título:\n")
                        autor = input("Dime su autor:\n")
                        anyo = int(input("Dime el año de su publicacion\n"))
                        posicion = len(materiales)+1
                        if tipo == 1:
                            genero = int(
                                input("Dime el genero: 1-Ficción, 2-No Ficción, 3-Terror, 4-Ciencia\n"))
                            paginas = int(input("Dime el numero de páginas\n"))
                            materiales[posicion] = Libro(
                                id, titulo, autor, anyo, genero, paginas)
                        else:
                            edicion = int(input("Dime el número de edición\n"))
                            mes = (int(input("Dime el numero de mes:\n")))
                            materiales[posicion] = Revista(
                                id, titulo, autor, anyo, edicion, mes)
                        IDs.append(id)
                    else:
                        print("debes eligir 1 o 2 (libro o revista)")
                else:
                    print("El ID "+str(id)+" ya existe para otro material")

            case 'b':
                print("Listado de materiales:")
                for id, material in materiales.items():
                    print(material.toString())

            case 'c':
                idBusca = int(input("Introduce el id del material: \n"))
                cadena = "No se encuentra el material con el id "+str(idBusca)
                for x, v in materiales.items():
                    if idBusca == v.id:
                        cadena = v.toString()
                print(cadena)

            case 'd':
                elimina = int(input("Dime el ID del material a borrar:\n"))
                encontrado = False
                for x, v in materiales.items():
                    if elimina == v.id:
                        posicion = x
                        encontrado = True
                        print(v.toString())
                if encontrado == True:
                    materiales.pop(posicion)
                    print("Se ha eliminado correctamente.")
                else:
                    print("No se encuentra el material con el ID "+elimina)
            case 'e':
                generarEstadisticas(materiales)
            case 'f':
                print("Saliendo del programa.")
                break
            case _:
                print("Opción no válida. Inténtalo de nuevo.")
        print("-----------------------------------------------------")
        input("Dale a Enter para continuar...")


if __name__ == "__main__":
    main()
