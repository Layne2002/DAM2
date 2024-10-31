from typing import List

def segmento(m, n, lista: List[int]) -> List[int]:
    return lista[m-1:n]

lista = [3, 4, 1, 2, 7, 9, 0]
print(lista)
print(segmento(3, 4, lista))
print(segmento(3, 5, lista))
print(segmento(5, 3, lista))
