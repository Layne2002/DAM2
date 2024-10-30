# El enunciado está en enunciado.md
def mostrar_menu():
    print("MENÚ DE OPCIONES")
    print("a) Listado de teléfonos, usando el orden por defecto.")
    print("b) Listado de teléfonos por orden alfabético.")
    print("c) Añadir un nuevo contacto.")
    print("d) Modificar el teléfono de un contacto.")
    print("e) Buscar un número de teléfono.")
    print("f) Eliminar un contacto.")
    print("g) Borrar el listín telefónico.")
    print("h) Salir")


def main():
    agenda = {}
    while True:
        mostrar_menu()
        opcion = input("Selecciona una opción: ").lower()

        match opcion:
            case 'a':
                print("Listado de teléfonos, usando el orden por defecto:")
                for nombre, telefono in agenda.items():
                    print(f"{nombre}- {telefono}")
            case 'b':
                print("Listado de teléfonos, usando el orden por defecto:")
                for nombre, telefono in sorted(agenda.keys()):
                    print(f"{nombre}- {telefono}")
            case 'c':
                nombre = input("Introduce el nombre del contacto: ")
                if nombre in agenda:
                    actualizar = int(input(
                        f"{nombre} ya existe en su agenda. Desea actualizar su teléfono? (1-SI 0-NO)\n"))
                    if actualizar == 0:
                        print("Contacto no actualizado.")
                    else:
                        telefono = input("Introduce el número de teléfono: ")
                        agenda[nombre] = telefono
                        print(f"Contacto '{nombre}' añadido.")
                        input("Dale a Enter para continuar...")
                        continue
                else:
                    telefono = input("Introduce el número de teléfono: ")
                    agenda[nombre] = telefono
                    print(f"Contacto '{nombre}' añadido.")
            case 'd':
                nombre = input("Introduce el nombre del contacto: ")
                if nombre not in agenda:
                    actualizar = int(input(
                        f"{nombre} no existe en su agenda. Desea añadirlo? (1-SI 0-NO)\n"))
                    if actualizar == 0:
                        print("Contacto no añadido.")
                    else:
                        telefono = input("Introduce el número de teléfono: ")
                        agenda[nombre] = telefono
                        print(f"Contacto '{nombre}' añadido.")
                        input("Dale a Enter para continuar...")
                        continue
                else:
                    telefono = input("Introduce el número de teléfono nuevo: ")
                    agenda[nombre] = telefono
                    print(f"Contacto '{nombre}' actualizado.")
            case 'e':
                telf = input("Que número de teléfono quieres buscar?\n")
                encontrado = False
                for nombre, telefono in agenda.items():
                    if telefono == telf:
                        encontrado = True
                        print(f"El teléfono pertenece a {nombre}.")
                if encontrado == False:
                    print(f"No se encuentra el teléfono {telf}")
            case 'f':
                nombre = input("Dime el nombre que quieres borrar:\n")
                encontrado = False
                for i in agenda:
                    if nombre == i:
                        encontrado = True
                        agenda.pop(i)
                        print(f"Se ha borrado a {nombre}.")
                if encontrado == False:
                    print(f"No se encuentra a {nombre} en la agenda.")
            case 'g':
                seguro = int(
                    input("Estás seguro de que quieres borrar toda la agenda? (1-SI 0-NO)"))
                if seguro == 1:
                    agenda = {}
                    print("La agendea ha sido borrada con éxito.")
                else:
                    print("Se cancela el borrado de la agenda.")
            case 'h':
                print("Saliendo del programa.")
                break
            case _:
                print("Opción no válida. Inténtalo de nuevo.")
        input("Dale a Enter para continuar...")


if __name__ == "__main__":
    main()
