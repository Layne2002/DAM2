from typing import List


def unionConjuntos(lista1: List[int], lista2: List[int]) -> List[int]:
    resultado = []
    for i in lista1:
        if i not in resultado and i not in lista2:
            resultado.append(i)
    return resultado


print("[1, 2, 1], [2, 3, 2, 4]")
print("Elementos comunes: ", unionConjuntos([1, 2, 1], [2, 3, 2, 4]))
