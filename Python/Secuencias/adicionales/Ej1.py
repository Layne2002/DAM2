def contarVocales(cadena) -> int:
    cadena = cadena.lower()
    contador = 0
    for i in cadena:
        if i in ["a", "e", "i", "o", "u"]:
            contador += 1
    return contador


cadena = input("Dime una cadena y te diré cuantas vocales tiene:\n")
vocales = contarVocales(cadena)
print("En la cadena hay ", vocales, " vocales")
