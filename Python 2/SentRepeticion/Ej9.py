"""9. Escribe un programa que recoja un número impar. Debe asegurarse de que
sea impar, en caso de no serlo debe descartarlo y pedirlo de nuevo. Una vez
tenga el número impar debe mostrar una pirámide de asteriscos cuya base es
igual al número introducido. Por ejemplo, si se introduce el valor 7 se debe
mostrar:
*
***
*****
*******"""
x = 2
while x % 2 == 0:
    x = int(input("Dime un número impar\n"))

for i in range(1, x):
    cadena = ""
    for y in range(i*2-1):
        cadena += "*"
    print(cadena)
