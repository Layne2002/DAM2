# 8. # Ejercicio 13. Definir la función
# segmento : (int, int, list[A]) -> list[A]
# tal que segmento(m, n, xs) es la lista de los elementos de xs
# comprendidos entre las posiciones m y n. Por ejemplo,
# segmento(3, 4, [3, 4, 1, 2, 7, 9, 0]) == [1, 2]
# segmento(3, 5, [3, 4, 1, 2, 7, 9, 0]) == [1, 2, 7]
# segmento(5, 3, [3, 4, 1, 2, 7, 9, 0]) == []
# ---------------------------------------------------------------------"""
from typing import List


def segmento(m, n, lista: List[int]) -> List[int]:
    return lista[m-1:n]


lista = [3, 4, 1, 2, 7, 9, 0]
print(lista)
print(segmento(3, 4, lista))
print(segmento(3, 5, lista))
print(segmento(5, 3, lista))
