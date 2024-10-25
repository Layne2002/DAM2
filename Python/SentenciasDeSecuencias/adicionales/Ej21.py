"""21.Diseña una función que, dada una lista de números, devuelva una lista con todos los
pares de números amigos que podemos formar con uno de la primera lista y otro de la
segunda."""
from typing import List


def divisoresPropios(n: int) -> int:
    suma = 0
    for i in range(1, n):
        if n % i == 0:
            suma += i
    return suma


def amigos(lista1: List[int], lista2: List[int]) -> List[tuple]:
    resultado = []
    for i in lista1:
        for j in lista2:
            if divisoresPropios(i) == j and divisoresPropios(j) == i:
                resultado.append((i, j))
    return resultado


lista1 = [220, 284, 1184, 1210]
lista2 = [284, 220, 1210, 1184]

resultado = amigos(lista1, lista2)
print("Pares de números amigos:", resultado)
