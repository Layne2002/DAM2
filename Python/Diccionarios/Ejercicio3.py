# El enunciado se encuentra en enunciados.md
frutas = {
    "manzana": 0.75,
    "pera": 0.9,
    "banana": 1.25,
    "chirimoya": 1.95,
    "mango": 1.75,
    "naranja": 0.85,
    "mandarina": 0.65,
    "uvas": 1.65
}
print("Frutas disponibles:")
for i in frutas:
    print(i, end=" ")
print("")  # Para que el siguiente print no se pegue a la misma linea
while True:
    nombre = input("Dime el nombre de la fruta que se ha vendido:\n").lower()
    if nombre in frutas:
        vendidos = float(input("Cuantos kilos de se han vendido?\n"))
        total = frutas[nombre]*vendidos
        print(vendidos, " Kg de ", nombre, " salen a ", total, " euros.")
    else:
        print("La fruta ", nombre, " no existe!")
    input("Dale a Enter...")
    seguir = int(input("Quieres hacer otra consulta? 1-Si 0-No\n"))
    if seguir == 0:
        break
