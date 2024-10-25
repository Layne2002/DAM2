"""10.Escribe un programa que recoja un número y muestre un triángulo formado por
secuencias decrecientes de números impares. Por ejemplo, si se introduce el
5 se debe mostrar:
1
3 1
5 3 1
7 5 3 1
9 7 5 3 1"""
x = int(input("Dime la altura del triangulo:\n"))
for i in range(x):
    cadena = ""
    for y in range(2*i+1, 0, -2):
        cadena += str(y)+" "
    print(cadena)
