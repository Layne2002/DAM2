"""3. Escribe un programa lea un texto y determine si es un palíndromo. Procura
crear una función palindromo(s) -> Bool.
NOTA: una cadena es palíndromo si se lee igual de izquierda a derecha que
de derecha a izquierda. Por ejemplo, la palabra OSO es un palíndromo."""


def palindromo(a, b) -> bool:
    cadena1 = []
    cadena2 = []
    for i in a:
        cadena1.append(i)
    for i in b:
        cadena2.append(i)
    cadena2.reverse()
    if (cadena1 == cadena2):
        return True
    else:
        return False


print("Me diras 2 cadenas y diré si son palíndromos!")
cadena1 = input("Dime la 1a cadena...\n")
cadena2 = input("Dime la 2a cadena...\n")
print("---------------------------")
if palindromo(cadena1, cadena2):
    print("Las cadenas SI son palíndromos!")
else:
    print("Las cadenas NO son palíndromos!")
print("Cadenas introducidas:")
print(cadena1)
print(cadena2)
