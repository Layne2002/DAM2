def sumar(x, y) -> int:
    return x+y


print("Me dirás 3 números y te diré su suma!")
a = int(input("Dime el 1er número:\n"))
b = int(input("Dime el 2o número:\n"))
c = int(input("Dime el 3er número:\n"))
resultado = sumar(sumar(a, b), c)
print("La suma de ", a, " + ", b, " + ", c, " es: ", resultado)
