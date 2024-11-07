
# FUNCIONES

Usa funciones para escribir de forma sencilla un programa con las siguientes
instrucciones:

1- Al arrancar debe mostrar un menú de opciones como el siguiente:

```.Spanish
MENÚ DE OPCIONES
a) Mostrar un rombo.
b) Adivinar un número.
c) Resolver una ecuación de segundo grado.
d) Tabla de números.
e) Cálculo del número factorial de un número.
f) Cálculo de un número de la sucesión de Fibonacci.
g) Tabla de multiplicar.
h) Salir
```

2- El usuario introducirá la opción que debe ejecutar. Para ello, introducirá una letra (ya sea minúscula o mayúscula) de la operación a realizar. En caso de introducir una letra incorrecta se mostrará un mensaje de error.

3- Si se ha indicado una opción correcta, se ejecuta según estas instrucciones que se indican a continuación. Una vez finalizada la opción se espera a que se pulse una tecla para continuar.

4- Si la entrada de datos es numérica, hay que asegurarse de que el valor introducido es un número. Procura que el programa sea robusto. Es decir, que se controlen los errores en el programa.

## Opciones del programa

**Mostrar un rombo**. Se debe recoger un número impar (debe asegurarse de que
sea impar, en caso de no serlo debe descartarlo y pedirlo de nuevo). Una vez
tenga el número impar debe mostrar un rombo de asteriscos. Por ejemplo, si se
introduce el valor 7 se debe mostrar:

```.Python
*
***
*****
*******
*****
***
*
```

**Adivinar un número**. Se debe averiguar un número aleatorio entre 1 y 100. El usuario debe adivinarlo. En cada intento el programa nos debe dar una pista (es mayor, o es menor). El proceso continuará hasta que el usuario acierte el resultado.

**Resolver una ecuación de segundo grado**. Se deben leer los tres coeficientes de una ecuación de segundo grado y encontrar la solución. Si la tiene, porque hay ecuaciones que no tienen solución.

**Tabla de números**. Se debe pedir un número de filas y un número de columnas. A continuación, mostrará una tabla con números aleatorios con las filas y columnas indicadas.

**Cálculo del número factorial de un número**. Se debe pedir un número y se debe calcular su factorial (este ejercicio ya está resuelto, prueba a hacer una solución recursiva).

**Cálculo de un número de la sucesión de Fibonacci**. Se debe pedir una posición y debe calcular el número de la sucesión de Fibonacci en esa posición. La sucesión de Fibonacci es la siguiente:

``
1 1 2 3 5 8 13 21...
``

Es decir, a partir de los dos primeros valores (que son 1), cualquier valor es la suma de los dos anteriores.

**Tabla de multiplicar**. Se debe pedir un número y debe mostrar la tabla de multiplicar de ese número.

**Salir**. Mientras el usuario no seleccione esta opción, tras finalizar cada opción debe mostrar de nuevo el menú de opciones. Con esta opción el programa finaliza.
