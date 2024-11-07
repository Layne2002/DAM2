# Ejercicios con diccionarios adicionales

1 Escribir un programa que pregunte al usuario su nombre, edad, dirección y teléfono y lo guarde en un diccionario. Después debe mostrar por pantalla el mensaje:

`<nombre> tiene <edad> años,vive en <dirección> y
 su número de teléfono es <teléfono>.`

2 Modificar el programa anterior para que pueda manejar varios nombres.

3 La tienda "El Gran Bazar" desea analizar sus ventas diarias y mensuales. Tienes un diccionario que contiene las ventas de cada producto para cada día del mes. Cada producto tiene registrado cuántas unidades se vendieron en cada día del mes.

Debes realizar un análisis que incluya:

1. **Venta total mensual** de cada producto.

2. **Producto más vendido** y **menos vendido** del mes.

3. **Ventas diarias** del producto con mayor venta mensual.

4. **Día con mayor cantidad de ventas** para cada producto.

## **Datos de ejemplo**

Supón que tienes las ventas de cuatro productos (A, B, C, D) durante cinco días. El formato del diccionario de ventas es el siguiente:

ventas = {

"A": {1: 5, 2: 3, 3: 6, 4: 8, 5: 1},

"B": {1: 3, 2: 7, 3: 2, 4: 0, 5: 4},

"C": {1: 6, 2: 4, 3: 3, 4: 5, 5: 2},

"D": {1: 0, 2: 2, 3: 1, 4: 3, 5: 0}

}

En este diccionario, las claves principales son los productos y cada clave de producto tiene un diccionario anidado donde las claves son los días y los valores son las unidades vendidas.

### Objetivo del ejercicio

Escribe un programa que:

1. Calcule el total de unidades vendidas en el mes para cada producto.

2. Identifique el producto con más y menos ventas en el mes.

3. Muestre las ventas diarias del producto más vendido.

4. Encuentre el día con la mayor venta para cada producto
