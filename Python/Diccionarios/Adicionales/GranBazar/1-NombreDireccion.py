
personas = {}
for i in range(2):
    nombre = input("Dime tu nombre:\n")
    edad = int(input("Dime tu edad:\n"))
    direccion = input("Tu dirección:\n")
    tel = input("Tu teléfono:\n")

    personas[nombre] = {
        'edad': edad,
        'direccion': direccion,
        'telefono': tel
    }
for nombre, datos in personas.items():
    print(f"{nombre} tiene {datos['edad']} años, vive en {
          datos['direccion']} y su numero de telefono es {datos['telefono']}.")
