# 4. Definir la función
# rota : (int, List[A]) -> List[A]
# tal que rota(n, xs) es la lista obtenida poniendo los n primeros
# elementos de xs al final de la lista. Por ejemplo,
# rota(1, [3, 2, 5, 7]) == [2, 5, 7, 3]
# rota(2, [3, 2, 5, 7]) == [5, 7, 3, 2]
# rota(3, [3, 2, 5, 7]) == [7, 3, 2, 5]
from typing import List


def rota(n: int, xs: List[int]) -> List[int]:
    return xs[n:]+xs[:n]


print(rota(1, [3, 2, 5, 7]))
print(rota(2, [3, 2, 5, 7]))
print(rota(3, [3, 2, 5, 7]))
