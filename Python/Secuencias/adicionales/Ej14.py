from typing import List


def elementosComunes(lista1: List[int], lista2: List[int]) -> List[int]:
    resultado = []
    for i in lista1:
        if i not in resultado and i in lista2:
            resultado.append(i)
    return resultado


print("[1, 2, 1], [2, 3, 2, 4]")
print("Elementos comunes: ", elementosComunes([1, 2, 1], [2, 3, 2, 4]))
