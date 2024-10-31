num = int(input("dime un numero y te dire su factorial:\n"))
resultado = 1
for i in range(2, num+1):
    resultado *= i
print(resultado)
