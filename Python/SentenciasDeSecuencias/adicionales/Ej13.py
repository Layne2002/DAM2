"""13. Definir una función que recibe una lista y devuelve
otra cuyos elementos son los de la primera, pero sin repetir ninguno; 
es decir, si la función recibe la lista 1 2 1 3 2 , devolverá la lista 1 2 3 ."""
from typing import List


def eliminarRepetidos(lista: List[int]) -> List[int]:
    resultado = []
    for i in lista:
        if i not in resultado:
            resultado.append(i)
    return resultado


print("[1, 2, 1, 3, 2]")
print(eliminarRepetidos([1, 2, 1, 3, 2]))
