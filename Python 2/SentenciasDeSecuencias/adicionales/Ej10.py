# 10. Las dimensiones de los rectángulos puede representarse
# por pares; por ejemplo, (5,3) representa a un rectángulo de base 5 y
# altura 3.
#
# Definir la función
# mayorRectangulo : (tuple[float, float], tuple[float, float])
# -> tuple[float, float]
# tal que mayorRectangulo(r1, r2) es el rectángulo de mayor área entre
# r1 y r2. Por ejemplo,
# mayorRectangulo((4, 6), (3, 7)) == (4, 6)
# mayorRectangulo((4, 6), (3, 8)) == (4, 6)
# mayorRectangulo((4, 6), (3, 9)) == (3, 9)
# ---------------------------------------------------------------------
from typing import List


def mayorRectangulo(r1: tuple[float, float], r2: tuple[float, float]) -> tuple[float, float]:
    if r1[0]*r1[1] >= r2[0]*r2[1]:
        return r1
    else:
        return r2


print("(4,6) y (3,7) == ", mayorRectangulo((4, 6), (3, 7)))
print("(4,6) y (3,8) == ", mayorRectangulo((4, 6), (3, 8)))
print("(4,6) y (3,9) == ", mayorRectangulo((4, 6), (3, 9)))
