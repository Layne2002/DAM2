# 6. Definir la función
# interior : (list[A]) -> list[A]
# tal que interior(xs) es la lista obtenida eliminando los extremos de
# la lista xs. Por ejemplo,
# interior([2, 5, 3, 7, 3]) == [5, 3, 7]"""
from typing import List


def interior(lista: List[int]) -> List[int]:
    return lista[1:-1]


lista = [2, 5, 3, 7, 3]
print(lista)
print(interior(lista))
