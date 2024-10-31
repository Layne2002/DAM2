a = int(input("Introduce el primer numero\n"))
b = int(input("Ahora el segundo\n"))
c = int(input("Y el tercero:\n"))


def mayor(a, b):
    if (a > b):
        return a
    else:
        return b


def menor(a, b):
    if (a < b):
        return a
    else:
        return b


print("El número mayor es: ", mayor(mayor(a, b), c))
print("El número menor es: ", menor(menor(a, b), c))
