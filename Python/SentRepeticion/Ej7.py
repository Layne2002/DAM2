"""7. Escribe un programa que recoja una cadena de texto por teclado y una letra a
buscar. Luego debe buscar dicha letra por la cadena y al finalizar debe indicar
el número de veces que se repite la letra en el texto."""
cadena = input("Dime una cadena de texto\n")
letra = input("Dime una letra y te diré cuantas veces aparece en la cadena\n")
contador = 0
for i in cadena:
    if letra == i:
        contador += 1
print("La letra ", letra, " aparece ", contador, " veces")
