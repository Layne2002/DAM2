nota = float(input("introduce la nota media del alumno:\n"))
if (nota < 0 or nota > 10):
    print("Error. número fuera de rango")
elif (nota < 5):
    print("Suspenso")
elif (nota < 6):
    print("suficiente")
elif (nota < 7):
    print("bien")
elif (nota < 9):
    print("notable")
elif (nota < 10):
    print("sobresaliente")
else:
    print("matricula de honor")
