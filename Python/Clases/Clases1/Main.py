class Persona:
    def __init__(self, nombre, direccion, telefono):
        self.nombre = nombre
        self.direccion = direccion
        self.telefono = telefono

    def __str__(self):
        return f"Nombre: {self.nombre}, Dirección: {self.direccion}, Teléfono: {self.telefono}"


def mostrar_menu():
    print("\n---------------------------------------------")
    print("MENÚ DE OPCIONES")
    print("a) Listado de contactos por orden alfabético")
    print("b) Añadir un nuevo contacto")
    print("c) Modificar un contacto")
    print("d) Buscar un número de teléfono")
    print("e) Eliminar un contacto")
    print("f) Salir")


def listar_contactos(contactos):
    if len(contactos) == 0:
        print("No hay contactos añadidos.")
    else:
        print("\nContactos ordenados alfabéticamente:")
        for nombre, persona in sorted(contactos.items()):
            print(persona)


def anadir_contacto(contactos):
    nombre = input("Introduce el nombre del contacto: ").upper()
    if nombre in contactos:
        print("El contacto ya existe.")
        actualizar = input(
            "¿Quieres actualizar su teléfono? (s/n): ").lower()
        if actualizar == "s":
            telefono = input("Introduce el nuevo teléfono: ")
            contactos[nombre].telefono = telefono
            print("Teléfono actualizado.")
    else:
        direccion = input("Introduce la dirección: ")
        telefono = input("Introduce el teléfono: ")
        contactos[nombre] = Persona(nombre, direccion, telefono)
        print("Contacto añadido.")


def modificar_contacto(contactos):
    nombre = input(
        "Introduce el nombre del contacto a modificar: ").upper()
    if nombre not in contactos:
        agregar = input(
            "El contacto no existe. ¿Deseas añadirlo? (s/n): ").lower()
        if agregar == "s":
            anadir_contacto(contactos)
    else:
        direccion = input("Introduce la nueva dirección: ")
        telefono = input("Introduce el nuevo teléfono: ")
        contactos[nombre].direccion = direccion
        contactos[nombre].telefono = telefono
        print("Contacto modificado.")


def buscar_telefono(contactos):
    telefono = input("Introduce el número de teléfono a buscar: ")
    for nombre, persona in contactos.items():
        if persona.telefono == telefono:
            print(f"El teléfono pertenece a: {nombre}")
            return
    print("Teléfono no encontrado.")


def eliminar_contacto(contactos):
    nombre = input(
        "Introduce el nombre del contacto a eliminar: ").upper()
    if nombre in contactos:
        del contactos[nombre]
        print("Contacto eliminado.")
    else:
        print("El contacto no existe.")


def main():
    contactos = {}
    while True:
        mostrar_menu()
        opcion = input("Selecciona una opción: ").lower()
        if opcion == "a":
            listar_contactos(contactos)
        elif opcion == "b":
            anadir_contacto(contactos)
        elif opcion == "c":
            modificar_contacto(contactos)
        elif opcion == "d":
            buscar_telefono(contactos)
        elif opcion == "e":
            eliminar_contacto(contactos)
        elif opcion == "f":
            print("Saliendo del programa. ¡Hasta luego!")
            break
        else:
            print("Opción no válida. Intenta de nuevo.")
        input("\nPulsa Enter para continuar...")


if __name__ == "__main__":
    main()
