"""6. Escribe un programa que recoja las notas de las tres evaluaciones de un
alumno. A continuación debe calcular y mostrar la nota final, teniendo en
cuenta que la primera evaluación cuenta un 20% de la nota final, la segunda
evaluación un 35% y la tercera evaluación un 45%."""
nota1 = float(input("Introduce la nota de la primera evaluación:\n"))
nota2 = float(input("Introduce la nota de la segunda evaluación:\n"))
nota3 = float(input("Introduce la nota de la tercera evaluación:\n"))
media = nota1*0.2 + nota2*0.35 + nota3*0.45
print("La media del alumno es: ", media)
