"""15. Diseña una función que reciba dos listas y devuelva los elementos que pertenecen a
una o a otra, pero sin repetir ninguno (unión de conjuntos).
Ejemplo: si recibe las listas 1 2 1 y 2 3 2 4 , devolverá la lista 1 2 3 4 ."""
from typing import List


def unionConjuntos(lista1: List[int], lista2: List[int]) -> List[int]:
    resultado = []
    for i in lista1:
        if i not in resultado:
            resultado.append(i)
    for i in lista2:
        if i not in resultado:
            resultado.append(i)
    return resultado


print("[1, 2, 1], [2, 3, 2, 4]")
print("Elementos comunes: ", unionConjuntos([1, 2, 1], [2, 3, 2, 4]))
