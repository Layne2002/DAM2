"""5. Escribe un programa que calcule el precio de entrada a un museo a partir de
la edad del visitante, teniendo en cuenta que:
a. Menores de 5 años entran gratis.
b. Niños entre 5 años y 18 (sin llegar a los 18) pagan 3€.
c. Mayores de edad hasta los 65 (sin llegar a los 65) pagan 6€.
d. Jubilados entran gratis."""
edad = int(input("Introduce tu edad:\n"))

if edad < 5 or edad >= 65:
    print("Entras gratis!")
elif edad >= 5 and edad < 18:
    print("El precio es 3 euros!")
elif edad >= 18 and edad < 65:
    print("El precio es 6 euros!")
