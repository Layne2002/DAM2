# 7. # Definir la función
# finales : (int, list[A]) -> list[A]
# tal que finales(n, xs) es la lista formada por los n finales
# elementos de xs. Por ejemplo,
# finales(3, [2, 5, 4, 7, 9, 6]) == [7, 9, 6]"""
from typing import List


def finales(n, lista: List[int]) -> List[int]:
    return lista[n:]


lista = [2, 5, 4, 7, 9, 6]
print(lista)
print(finales(3, lista))
