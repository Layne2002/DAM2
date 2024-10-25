"""4. Escribe un programa que recoja tres números y calcule su media aritmética."""
cantidad = 3
valores = []
contador = 0
for i in range(0, cantidad):
    a = int(input("Introduce un número:\n"))
    valores.append(a)
    contador = contador + a
print("La media de esos números es: ", contador/cantidad)
