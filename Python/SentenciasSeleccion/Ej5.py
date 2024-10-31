edad = int(input("Introduce tu edad:\n"))

if edad < 5 or edad >= 65:
    print("Entras gratis!")
elif edad >= 5 and edad < 18:
    print("El precio es 3 euros!")
elif edad >= 18 and edad < 65:
    print("El precio es 6 euros!")
