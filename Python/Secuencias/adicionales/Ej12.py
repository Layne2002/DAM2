def numeroMayor(a: int, b: int):
    if a > b:
        return 10*a+b
    else:
        return 10*b+a


print("(2,5) == ", numeroMayor(2, 5))
print("(5,2) == ", numeroMayor(5, 2))
