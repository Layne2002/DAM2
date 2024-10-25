"""2. Repite el ejercicio anterior, pero ahora lo que se leen son textos. La condición
de finalización será la cadena vacía."""
x = None
lista = []
print("Dime cadenas de texto y luego te los enseño en ordenes diferentes!")
while x != "":
    x = input("Escribe una cadena de texto o una vacía para parar...\n")
    lista.append(x)
lista.remove("")
print("Las cadenas en orden de introduccion:")
for i in lista:
    print(i, end=" ")
input("\nEnter para continuar...")
print("Cadenas en orden alfabetico:")
lista.sort()
for i in lista:
    print(i, end=" ")
input("\nEnter para continuar...")
print("Valores en orden contrario al alfabetico:")
lista.sort(reverse=True)
for i in lista:
    print(i, end=" ")
