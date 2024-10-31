x = int(input("Dime un numero y te dire los cuadrados hasta ese numero\n"))
print("Cuadrados de todos los números hasta el ",x)
for i in range(1,x+1):
    print(i," x ",i," = ",i*i)