"""19.Diseña una función que, dada una lista de números, devuelva otra lista con solo
aquellos números de la primera que son primos."""
from typing import List


def primos(lista: List[int]) -> List[int]:
    resultado = []
    for i in lista:
        primo = True
        for j in range(2, i-1):
            if i % j == 0:
                primo = False
        if primo == True:
            resultado.append(i)
    return resultado


lista = [1, 17, 3, 5, 66, 3345, 555, 5003]
print(lista)
print(primos(lista))
