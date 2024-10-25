#9. Definir la función
# extremos : (int, list[A]) -> list[A]
# tal que extremos(n, xs) es la lista formada por los n primeros
# elementos de xs y los n finales elementos de xs. Por ejemplo,
# extremos(3, [2, 6, 7, 1, 2, 4, 5, 8, 9, 2, 3]) == [2, 6, 7, 9, 2, 3]"""
from typing import List
def extremos(n,lista:List[int])->List[int]:
    lista = lista[:n] + lista[-n:]
  #  lista.append(lista[:n])
    return lista

lista= [2, 6, 7, 1, 2, 4, 5, 8, 9, 2, 3]
print(lista)
print(extremos(3,lista))
