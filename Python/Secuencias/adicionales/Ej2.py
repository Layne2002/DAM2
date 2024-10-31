def contarPalabras(cadena) -> int:
    cadena = cadena.split(" ")
    return len(cadena)


cadena = input("Dime una cadena y te diré cuantas palabras tiene:\n")
vocales = contarPalabras(cadena)
print("En la cadena hay ", vocales, " palabras")
