from typing import List


def interior(lista: List[int]) -> List[int]:
    return lista[1:-1]


lista = [2, 5, 3, 7, 3]
print(lista)
print(interior(lista))
