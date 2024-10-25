# 5. Definir la función
# rango : (List[int]) -> List[int]
# tal que rango(xs) es la lista formada por el menor y mayor elemento
# de xs.
# rango([3, 2, 7, 5]) == [2, 7]
from typing import List


def rango(lista: List[int]) -> List[int]:
    min = lista[1]
    max = lista[1]
    for i in lista:
        if i < min:
            min = i
        elif i > max:
            max = i
    return [min, max]


print([3, 2, 7, 5])
print(rango([3, 2, 7, 5]))
