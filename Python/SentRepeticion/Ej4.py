x = int(input("Dime la altura del triangulo:\n"))

for i in range(x):
    cadena = "*"
    for y in range(i):
        cadena += "*"
    print(cadena)
