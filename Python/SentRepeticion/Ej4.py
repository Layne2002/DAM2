"""4. Escribe un programa que recoja un número y muestre un triángulo. Por
ejemplo, si se ha introducido el valor 5, se debe mostrar:
*
**
***
****
*****
"""
x = int(input("Dime la altura del triangulo:\n"))

for i in range(x):
    cadena = "*"
    for y in range(i):
        cadena += "*"
    print(cadena)
