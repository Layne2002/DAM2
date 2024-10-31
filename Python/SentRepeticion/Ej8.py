x = int(input("Dime un número y te diré si es primo\n"))

primo = True
if x != 0 and x != 1:
    for i in range(2, x):
        if x % i == 0:
            primo = False
            break
else:
    primo = False
if primo == True:
    print("Es primo")
else:
    print("NO es primo")
