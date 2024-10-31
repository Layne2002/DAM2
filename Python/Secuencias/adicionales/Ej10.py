from typing import List


def mayorRectangulo(r1: tuple[float, float], r2: tuple[float, float]) -> tuple[float, float]:
    if r1[0]*r1[1] >= r2[0]*r2[1]:
        return r1
    else:
        return r2


print("(4,6) y (3,7) == ", mayorRectangulo((4, 6), (3, 7)))
print("(4,6) y (3,8) == ", mayorRectangulo((4, 6), (3, 8)))
print("(4,6) y (3,9) == ", mayorRectangulo((4, 6), (3, 9)))
