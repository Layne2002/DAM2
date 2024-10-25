#   1. Escribe un programa python que pida un número por teclado y que
#   cree un diccionario cuyas
#   claves sean desde el número 1 hasta el número indicado, y los valores
#   sean los cuadrados de las claves.
numero = int(input("Introduce un numero: "))

diccionario = {i: i**2 for i in range(1, numero + 1)}

print("Diccionario de números y sus cuadrados:", diccionario)
