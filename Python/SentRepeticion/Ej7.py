cadena = input("Dime una cadena de texto\n")
letra = input("Dime una letra y te diré cuantas veces aparece en la cadena\n")
contador = 0
for i in cadena:
    if letra == i:
        contador += 1
print("La letra ", letra, " aparece ", contador, " veces")
