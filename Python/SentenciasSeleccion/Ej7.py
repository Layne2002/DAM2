hora = int(input("Dime la hora del dia\n"))
if (hora >= 7 and hora < 12):
    print("Buenos días")
elif (hora >= 12 and hora < 20):
    print("Buenas tardes")
else:
    print("Buenas noches")
