x = 2
while x % 2 == 0:
    x = int(input("Dime un número impar\n"))

for i in range(1, x):
    cadena = ""
    for y in range(i*2-1):
        cadena += "*"
    print(cadena)
