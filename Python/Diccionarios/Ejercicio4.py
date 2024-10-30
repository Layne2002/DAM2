# El enunciado está en enunciados.md
alumnos = {}

numAlumnos = int(input("Cuantos alumnos quieres meter?\n"))

for i in range(numAlumnos):
    print("---------------------------")
    nombre = input("Dime el nombre del alumno:\n")

    if nombre in alumnos:
        print(f"Error: El alumno {nombre} ya existe.")
        continue

    notas = []

    while True:
        nota = float(
            input(f"Introduce una nota para {nombre} (negativo para terminar): "))

        if nota < 0:
            break

        if nota <= 10:
            notas.append(nota)
        else:
            print(f"Error: La nota {nombre} es demasiado alta (máximo 10).")

    alumnos[nombre] = notas

print("\n------------------------------------")
print("Lista de alumnos y sus notas medias:")
for nombre, notas in alumnos.items():
    if notas:  # Verificar que la lista de notas no esté vacía
        media = sum(notas) / len(notas)
        print(f"{nombre}: Nota media = {media:.2f}")
    else:
        print(f"{nombre}: No se introdujeron notas.")
