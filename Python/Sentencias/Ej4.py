"""4. Escribe un programa que recoja dividendo y divisor, y realice su división
siempre que el divisor sea distinto de cero."""
dividendo = int(input("dime el dividendo:\n"))
divisor = int(input("dime el divisor\n"))
if (divisor != 0):
    print("El resultado de la division es: ", dividendo/divisor)
else:
    print("No se puede dividir por cero")
