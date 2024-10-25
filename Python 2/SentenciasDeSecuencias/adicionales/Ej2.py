"""2. Definir una función que, al recibir una cadena de texto, cuente cuántas palabras hay y
devuelva dicho valor."""


def contarPalabras(cadena) -> int:
    cadena = cadena.split(" ")
    return len(cadena)


cadena = input("Dime una cadena y te diré cuantas palabras tiene:\n")
vocales = contarPalabras(cadena)
print("En la cadena hay ", vocales, " palabras")
