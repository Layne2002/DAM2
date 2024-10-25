"""3. Escribe un programa que recoja números por teclado hasta que se introduzca
el valor cero. A continuación, debe mostrar el número de valores introducidos,
el valor mínimo introducido, el máximo, la suma de todos ellos y su media
aritmética (todos los cálculos sin contar el cero)"""

contador = 0
suma = 0
x = int(input("Introduce numeros o un 0 para parar\n"))
min = x
max = x
while x != 0:
    if x > max:
        max = x
    if x < min:
        min = x
    suma = suma + x
    contador += 1
    x = int(input())
if contador > 0:
    print("El número máximo ha sido: ", max)
    print("El número mínimo ha sido el: ", min)
    print("La suma de todos los números es: ", suma)
    print("La media de los números ha sido: ", suma/contador)
else:
    print("Bueno pues nada")
