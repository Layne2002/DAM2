"""10.Escribe un programa que recoja la edad del usuario y muestre la edad que
tendrá dentro de 5, 10 y 15 años."""
edad=int(input("Dime tu edad:\n"))
if(edad<0):
    print("tu edad no puede ser negativa")
    print("Dentro de 5 años tendrás ",edad+5," años")
    print("Dentro de 10 años tendrás ",edad+10," años")
    print("Dentro de 15 años tendrás ",edad+15," años")
elif(edad>120):
    print("Dentro de 5 años estarás muerto")
    print("Dentro de 10 años estarás muerto")
    print("Dentro de 15 años estarás muerto") 
else:
    print("Dentro de 5 años tendrás ",edad+5," años")
    print("Dentro de 10 años tendrás ",edad+10," años")
    print("Dentro de 15 años tendrás ",edad+15," años")
    print("probando el commit")
