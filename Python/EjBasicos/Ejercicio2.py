"""2. Escribe un programa que recoja dos números enteros por teclado y muestre
los siguientes resultados: suma, resta, multiplicación, división real, división
entera, resto de la división entera y potencia."""

x = int(input("Introduce el primer número: "))
y = int(input("Introduce el segundo número: "))

print("La suma de ", x, " + ", y, " es: ", x+y)
print("La resta de ", x, " - ", y, " es: ", x-y)
print("La multiplicación de ", x, " por ", y, " es: ", x*y)
print("La division real de ", x, " entre ", y, " es: ", float(x)/float(y))
print("La división entera de ", x, " y de ", y, " es: ", int(x/y))
print("El resto de la division entera de ", x, " y de ", y, " es: ", x % y)
print("La potencia de ", x, " elevado a ", y, " es: ", x**y)
