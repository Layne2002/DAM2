"""17. Diseña una función que, dada una lista de números, devuelva otra lista que solo
incluya sus números impares."""
from typing import List


def impares(lista1: List[int]) -> List[int]:
    resultado = []
    for i in lista1:
        if i % 2 != 0:
            resultado.append(i)
    return resultado


print("[2, 3, 2, 4, 7, 9, 9]")
print("Elementos comunes: ", impares([2, 3, 2, 4, 7, 9, 9]))
