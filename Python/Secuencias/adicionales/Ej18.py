from typing import List


def nombreLetra(a: str, lista1: List[str]) -> List[str]:
    if len(a) > 1:
        return []
    else:
        resultado = []
        for i in lista1:
            if i[0] == a or i[0] == a.upper():
                resultado.append(i)
        return resultado


lista = ['Alberto', 'Pablo', 'Olivia', 'Anastiasia']
print(lista)
print("Nombres que empiezanpor 'a': ", nombreLetra("a", lista))
