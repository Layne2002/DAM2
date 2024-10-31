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
