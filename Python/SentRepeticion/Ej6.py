filas = int(input("Dime el número de filas\n"))
columnas = int(input("Dime el numero de columnas\n"))
contador = 1
for i in range(1, filas+1):
    for y in range(1, columnas+1):
        print(contador, end=" ")
        contador += 1
    print()
