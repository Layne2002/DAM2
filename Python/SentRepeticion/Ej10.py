x = int(input("Dime la altura del triangulo:\n"))
for i in range(x):
    cadena = ""
    for y in range(2*i+1, 0, -2):
        cadena += str(y)+" "
    print(cadena)
