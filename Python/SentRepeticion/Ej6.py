"""6. Escribe un programa que recoja un número de filas y columnas, y muestre una
tabla con tantas filas y columnas como indicadas, numerando las celdas de
izquierda a derecha y de arriba abajo. Por ejemplo, si se introducen 2 filas y 3
columnas, se debe mostrar:
1 2 3
4 5 6"""
filas = int(input("Dime el número de filas\n"))
columnas = int(input("Dime el numero de columnas\n"))
contador = 1
for i in range(1, filas+1):
    for y in range(1, columnas+1):
        print(contador, end=" ")
        contador += 1
    print()
