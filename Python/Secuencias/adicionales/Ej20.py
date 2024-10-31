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
