# 2. Escribe un programa que lea una cadena y devuelva un diccionario con
#   la cantidad de apariciones de cada carácter en la cadena.
cadena = input(
    "Dime una cadena y te diré cauntas veces aparece cada caracter:\n")

caracteres = {}
for i in cadena:
    if i in caracteres:
        caracteres[i] += 1
    else:
        caracteres[i] = 1
del caracteres[' ']  # Borro el caracter del espacio/vacio porque no me gusta

print(caracteres)
