"""5. Escribe un programa que recoja un número por teclado y muestre los primeros
cuadrados hasta llegar al número introducido. Por ejemplo, si se ha introducido
el valor 5, se debe mostrar:
1 4 9 16 25"""
x = int(input("Dime un numero y te dire los cuadrados hasta ese numero\n"))
print("Cuadrados de todos los números hasta el ",x)
for i in range(1,x+1):
    print(i," x ",i," = ",i*i)