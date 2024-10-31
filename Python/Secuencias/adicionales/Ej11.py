from typing import Tuple, TypeVar
A = TypeVar('A')
B = TypeVar('B')
def intercambia (x: tuple[A,B]) ->tuple[B,A]:
    return (x[1], x[0])
print("(2,5) == ",intercambia((2,5)))
print("(5,2) == ",intercambia((5,2)))