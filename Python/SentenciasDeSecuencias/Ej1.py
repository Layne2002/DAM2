"""1. Escribe un programa que recoja números de teclado hasta que se introduce un
cero. Luego debe mostrar la secuencia de números de tres modos:
a. En el orden en que se introdujeron.
b. En orden creciente.
c. En orden decreciente."""
x = int
lista = []
print("Voy a recoger numeros y luego te los enseño en ordenes diferentes!")
while x != 0:
    x = int(input("Dime un número o el 0 para parar...\n"))
    lista.append(x)
lista.remove(0)
print("Los valores en orden de introduccion:")
for i in lista:
    print(i, end=" ")
input("\nEnter para continuar...")
print("Valores en orden creciente:")
lista.sort()
for i in lista:
    print(i, end=" ")
input("\nEnter para continuar...")
print("Valores en orden decreciente:")
lista.sort(reverse=True)
for i in lista:
    print(i, end=" ")
