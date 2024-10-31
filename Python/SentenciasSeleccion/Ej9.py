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
