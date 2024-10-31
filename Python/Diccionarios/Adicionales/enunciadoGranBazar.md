<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicios con Diccionarios</title>

</head>
<body>

    <h1>Ejercicios con Diccionarios Adicionales</h1>
    
    <h2>1. Información del Usuario</h2>
    <p>
        Escribir un programa que pregunte al usuario su nombre, edad, dirección y teléfono y lo guarde en un diccionario. 
        Después debe mostrar por pantalla el mensaje:
    </p>
    <pre>
        &lt;nombre&gt; tiene &lt;edad&gt; años, vive en &lt;dirección&gt; y su número de teléfono es &lt;teléfono&gt;.
    </pre>

    <h2>2. Manejo de Varios Nombres</h2>
    <p>
        Modificar el programa anterior para que pueda manejar varios nombres.
    </p>

    <h2>3. Análisis de Ventas de "El Gran Bazar"</h2>
    <p>
        La tienda "El Gran Bazar" desea analizar sus ventas diarias y mensuales. 
        Tienes un diccionario que contiene las ventas de cada producto para cada día del mes.
        Cada producto tiene registrado cuántas unidades se vendieron en cada día del mes.
    </p>
    <p>
        Debes realizar un análisis que incluya:
    </p>
    <ol>
        <li>Venta total mensual de cada producto.</li>
        <li>Producto más vendido y menos vendido del mes.</li>
        <li>Ventas diarias del producto con mayor venta mensual.</li>
        <li>Día con mayor cantidad de ventas para cada producto.</li>
    </ol>
    
    <h3>Datos de Ejemplo</h3>
    <p>
        Supón que tienes las ventas de cuatro productos (A, B, C, D) durante cinco días. 
        El formato del diccionario de ventas es el siguiente:
    </p>
    <pre>
        ventas = {
            "A": {1: 5, 2: 3, 3: 6, 4: 8, 5: 1},
            "B": {1: 3, 2: 7, 3: 2, 4: 0, 5: 4},
            "C": {1: 6, 2: 4, 3: 3, 4: 5, 5: 2},
            "D": {1: 0, 2: 2, 3: 1, 4: 3, 5: 0}
        }
    </pre>
    <p>
        En este diccionario, las claves principales son los productos y cada clave de producto tiene un diccionario 
        anidado donde las claves son los días y los valores son las unidades vendidas.
    </p>
    
    <h2>Objetivo del Ejercicio</h2>
    <p>
        Escribe un programa que:
    </p>
    <ol>
        <li>Calcule el total de unidades vendidas en el mes para cada producto.</li>
        <li>Identifique el producto con más y menos ventas en el mes.</li>
        <li>Muestre las ventas diarias del producto más vendido.</li>
        <li>Encuentre el día con la mayor venta para cada producto.</li>
    </ol>

</body>
</html>

