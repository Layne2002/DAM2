from typing import List
def extremos(n,lista:List[int])->List[int]:
    lista = lista[:n] + lista[-n:]
  #  lista.append(lista[:n])
    return lista

lista= [2, 6, 7, 1, 2, 4, 5, 8, 9, 2, 3]
print(lista)
print(extremos(3,lista))
