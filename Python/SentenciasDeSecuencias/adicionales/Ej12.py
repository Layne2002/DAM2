# 12. Definir la función
# numeroMayor : (int, int) -> int
# tal que numeroMayor(x, y) es el mayor número de dos cifras que puede
# construirse con los dígitos x e y. Por ejemplo,
# numeroMayor(2, 5) == 52
# numeroMayor(5, 2) == 52
def numeroMayor(a: int, b: int):
    if a > b:
        return 10*a+b
    else:
        return 10*b+a


print("(2,5) == ", numeroMayor(2, 5))
print("(5,2) == ", numeroMayor(5, 2))
