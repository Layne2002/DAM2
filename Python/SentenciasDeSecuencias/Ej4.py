"""4. Escribe un programa que lea dos textos y compruebe si una es palíndromo de
la otra. El programa debe preguntar si se desea comprobar teniendo en cuenta
mayúsculas/minúsculas o no."""


def palindromo(a, b, mayus) -> bool:
    if mayus == 0:
        cad1 = a.upper()
        cad2 = b.upper()
    else:
        cad1 = a
        cad2 = a
    lista1 = []
    lista2 = []
    for i in cad1:
        lista1.append(i)
    for i in cad2:
        lista2.append(i)
    lista2.reverse()
    if (lista1 == lista2):
        return True
    else:
        return False


print("Me diras 2 cadenas y diré si son palíndromos!")
cadena1 = input("Dime la 1a cadena...\n")
cadena2 = input("Dime la 2a cadena...\n")
mayus = int(
    input("Quieres que tenga en cuenta las mayusculas y minúsculas? 1-SI , 0-NO"))
print("---------------------------")
if palindromo(cadena1, cadena2, mayus):
    print("Las cadenas SI son palíndromos!")
else:
    print("Las cadenas NO son palíndromos!")
print("Cadenas introducidas:")
print(cadena1)
print(cadena2)
