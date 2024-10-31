from typing import List


def finales(n, lista: List[int]) -> List[int]:
    return lista[n:]


lista = [2, 5, 4, 7, 9, 6]
print(lista)
print(finales(3, lista))
