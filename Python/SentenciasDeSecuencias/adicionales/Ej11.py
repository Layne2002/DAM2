# 11. Definir la función
# intercambia : (tuple[A, B]) -> tuple[B, A]
# tal que intercambia(p) es el punto obtenido intercambiando las
# coordenadas del punto p. Por ejemplo,
# intercambia((2,5)) == (5,2)
# intercambia((5,2)) == (2,5)
from typing import Tuple, TypeVar
A = TypeVar('A')
B = TypeVar('B')
def intercambia (x: tuple[A,B]) ->tuple[B,A]:
    return (x[1], x[0])
print("(2,5) == ",intercambia((2,5)))
print("(5,2) == ",intercambia((5,2)))