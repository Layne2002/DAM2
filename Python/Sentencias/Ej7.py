"""7. Escribe un programa que recoja la hora del día y devuelva un saludo, según
las siguientes reglas:
INTERVALO DE HORAS SALUDO
[7,12) Buenos días
[12, 20) Buenas tardes
En otro caso Buenas noches"""
hora = int(input("Dime la hora del dia\n"))
if (hora >= 7 and hora < 12):
    print("Buenos días")
elif (hora >= 12 and hora < 20):
    print("Buenas tardes")
else:
    print("Buenas noches")
