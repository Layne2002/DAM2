from typing import List


def rota(n: int, xs: List[int]) -> List[int]:
    return xs[n:]+xs[:n]


print(rota(1, [3, 2, 5, 7]))
print(rota(2, [3, 2, 5, 7]))
print(rota(3, [3, 2, 5, 7]))
