"""20.Diseña una función que, dada una lista de números, devuelva una lista con todos los
pares de números que podemos formar con uno de la primera lista y otro de la segunda. Por
ejemplo, si se suministran las listas 1 3 5 y 2 5 , la lista resultante es 1 2 1 5 3 2 3 5 5 2 5 5 ."""
from typing import List


def primos(lista1: List[int], lista2: List[int]) -> List[int]:
    resultado = []
    for i in lista1:
        for j in lista2:
            resultado.append(i)
            resultado.append(j)
    return resultado


lista1 = [1, 3, 5]
lista2 = [2, 5]
print(lista1, " ", lista2)
print(primos(lista1, lista2))
