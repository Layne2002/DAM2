from typing import List


def eliminarRepetidos(lista: List[int]) -> List[int]:
    resultado = []
    for i in lista:
        if i not in resultado:
            resultado.append(i)
    return resultado


print("[1, 2, 1, 3, 2]")
print(eliminarRepetidos([1, 2, 1, 3, 2]))
