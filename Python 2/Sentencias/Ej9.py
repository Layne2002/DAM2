"""9. Escribe un programa que recoja un año e indique si se trata de un año bisiesto
o no. Un año es bisiesto si cumple estas condiciones:
a. El año es divisible por 4.
b. Si además el año es divisible por 100, debe ser también divisible por
400.
Ejemplos:
- 1992 es bisiesto (cumple el caso a. Al no ser divisible por 100 no aplica el
caso b)
- 2023 no es bisiesto (no cumple ningún caso)
- 2000 es bisiesto (cumple los casos a y b)
- 1900 no es bisiesto (cumple el caso a, pero no el b porque es divisible por
100 y no por 400)"""
anyo = int(input("Introduce un año y te diré si es bisiesto o no:\n"))
if (anyo % 4 == 0):
    if (anyo % 100 == 0):
        if (anyo % 400 == 0):
            print("El año ", anyo, " SI es bisiesto (cumple casos a y b)")
        else:
            print("El año ", anyo,
                  " NO es bisiesto (cumple caso  pero no b, no divisible entre 400)")
    else:
        print("El año ", anyo,
              " SI es bisiesto (al ser indivisible entre 100 no aplica caso b)")
else:
    print("El año ", anyo, " NO es bisiesto (no cumple ningun caso)")
