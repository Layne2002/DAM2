mes = int(input("Dime el número del mes:\n"))
match mes:
    case 1,3,5,7,8,10,12:
        print("El mes tiene 31 dias")
    case 4,6,9,11:
        print("El mes tiene 30 dias")
    case 2:
        print("el mes tiene 28 dias")
    case _:
        print("has introducido un numero equivocado")