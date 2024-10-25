import random
import math


def mostrarRombo():
    altura = int(
        input("Dime la altura del rombo (debe ser un número impar): \n"))

    while altura % 2 == 0:
        print("Debe ser un número impar.")
        altura = int(
            input("Dime la altura del rombo (debe ser un número impar): \n"))

    mitad = altura // 2

    for i in range(mitad + 1):
        espacios = " " * (mitad - i)
        estrellas = "*" * (2 * i + 1)
        print(espacios + estrellas)

    for i in range(mitad - 1, -1, -1):
        espacios = " " * (mitad - i)
        estrellas = "*" * (2 * i + 1)
        print(espacios + estrellas)


def adivinarNumero():
    rand = random.randint(1, 100)
    respuesta = int(
        input("Adivina el número que estoy pensando! (entre 1 y 100)\n"))
    if respuesta != rand:
        while respuesta != rand:
            if respuesta > rand:
                respuesta = int(
                    input("El numero que pienso es más BAJO! intenta de nuevo\n"))
            elif respuesta < rand:
                respuesta = int(
                    input("El numero que pienso es más ALTO! intenta de nuevo\n"))
        print("ADIVINASTEEE, el numero que pensaba era el ", rand)
    else:
        print("Adivinasteee")


def resolverEcuacion():
    a = int(input("Dime el valor de a:\n"))
    b = int(input("Dime el valor de b:\n"))
    c = int(input("Dime el valor de c:\n"))
    if a == 0:
        if b == 1:
            sol = c*-1
            print("La solución es: ", sol)
        elif b == 0:
            print("Entonces no es una ecuación!")
        else:
            sol = (c*-1)/b
            print("La solución es: ", sol)
    else:
        disc = (b*b - 4*a*c)
        if disc < 0:
            print("No tiene solución real")
        elif disc == 0:
            sol = (-1*b)/(2*a)
            print("La solución es: ", sol)
        else:
            sol1 = (-b+math.sqrt(disc))/(2*a)
            sol2 = (-b-math.sqrt(disc))/(2*a)
            print("Las dos soluciones posibles son: ", sol1, " y ", sol2)


def tablaNumeros():
    filas = int(input("Dime el número de filas\n"))
    columnas = int(input("Dime el numero de columnas\n"))
    contador = 1
    for i in range(1, filas+1):
        for y in range(1, columnas+1):
            print(random.randint(1, 100), end=" ")
        print()


def factorial():
    def fact(x):
        if x == 0 or x == 1:
            return 1
        else:
            return x * fact(x-1)
    num = int(input("dime un numero y te dire su factorial:\n"))
    print("El factorial de ", num, " es ", fact(num))


def fibonacci():
    pos = int(input("Dime la posicion de la sucesion que quieres saber:\n"))
    if pos == 1 or pos == 2:
        print("En la posicion ", pos, " se encuentra el numero 1")
    elif pos <= 0:
        print("No existe tal posición en la sucesión de fibonacci")
    else:
        a, b = 1, 1
        for i in range(2, pos):
            a, b = b, a+b
        print("En la posicion ", pos, " se encuentra el numero ", b)


def tablaMultiplicar():
    num = int(input("Dime un número y te diré su tabla de multiplicar:\n"))
    print("TABLA DEL ", num, ":")
    for i in range(1, 11):
        print(num, " x ", i, " = ", i*num)


print("Elije una opcion: \na.-Mostrar un rombo \nb.-Adivinar un numero \nc.-Resolver una ecuacion de segundo grado \nd.-Tabla de numeros")
print("e.-Cálculo del número factorial de un número \nf.-Cálculo de un número de la sucesión de Fibonacci")
print("g.-Tabla de multiplicar \nh.-Salir")
opcion = input()
while opcion != "h" and opcion != "H":
    match opcion:
        case 'a' | 'A':
            mostrarRombo()
        case 'b' | 'B':
            adivinarNumero()
        case 'c' | 'C':
            resolverEcuacion()
        case 'd' | 'D':
            tablaNumeros()
        case 'e' | 'E':
            factorial()
        case 'f' | 'F':
            fibonacci()
        case 'g' | 'G':
            tablaMultiplicar()
        case 'h' | 'H':
            print("Hasta luego!")
        case _:
            print("Opción no válida")
    input("Dale a Enter para continuar...")
    print("----------------------------------------------------------")
    print("Elije una opcion: \na.-Mostrar un rombo \nb.-Adivinar un numero \nc.-Resolver una ecuacion de segundo grado \nd.-Tabla de numeros")
    print("e.-Cálculo del número factorial de un número \nf.-Cálculo de un número de la sucesión de Fibonacci")
    print("g.-Tabla de multiplicar \nh.-Salir")
    opcion = input()
