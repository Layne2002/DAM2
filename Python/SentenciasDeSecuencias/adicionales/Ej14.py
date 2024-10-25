"""14. Diseña una función que reciba dos listas y devuelva los elementos comunes a ambas,
sin repetir ninguno (intersección de conjuntos).
Ejemplo: si recibe las listas 1 2 1 y 2 3 2 4 , devolverá la lista 2 ."""
from typing import List


def elementosComunes(lista1: List[int], lista2: List[int]) -> List[int]:
    resultado = []
    for i in lista1:
        if i not in resultado and i in lista2:
            resultado.append(i)
    return resultado


print("[1, 2, 1], [2, 3, 2, 4]")
print("Elementos comunes: ", elementosComunes([1, 2, 1], [2, 3, 2, 4]))
