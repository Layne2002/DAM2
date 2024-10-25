"""7. Escribe un programa que recoja un número y muestre su representación en
código binario."""
numero = int(input("Dime un número y te lo diré en binario:\n"))
binario = bin(numero)
print(binario[2:])
