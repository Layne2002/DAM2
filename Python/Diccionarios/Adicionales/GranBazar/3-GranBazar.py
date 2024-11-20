# Datos
ventas = {
    "Monster": {1: 5, 2: 3, 3: 6, 4: 8, 5: 1},
    "Fanta": {1: 3, 2: 7, 3: 2, 4: 0, 5: 4},
    "Red Bull": {1: 6, 2: 4, 3: 3, 4: 5, 5: 2},
    "Aquarius": {1: 0, 2: 2, 3: 1, 4: 3, 5: 0}
}

# 1. Venta total mensual de cada producto
totales_mensuales = {producto: sum(dias.values()) for producto, dias in ventas.items()}
print("Ventas totales mensuales por producto:")
for producto, total in totales_mensuales.items():
    print(f"{producto}: {total} unidades")

# 2. Producto más vendido y menos vendido
producto_mas_vendido = max(totales_mensuales, key=totales_mensuales.get)
producto_menos_vendido = min(totales_mensuales, key=totales_mensuales.get)
print(f"\nProducto más vendido: {producto_mas_vendido} con {totales_mensuales[producto_mas_vendido]} unidades")
print(f"Producto menos vendido: {producto_menos_vendido} con {totales_mensuales[producto_menos_vendido]} unidades")

# 3. Ventas diarias del producto más vendido
print(f"\nVentas diarias del producto más vendido ({producto_mas_vendido}):")
for dia, ventas_diarias in ventas[producto_mas_vendido].items():
    print(f"Día {dia}: {ventas_diarias} unidades")

# 4. Día con mayor cantidad de ventas para cada producto
print("\nDía con mayor cantidad de ventas para cada producto:")
for producto, dias in ventas.items():
    dia_max = max(dias, key=dias.get)
    print(f"{producto}: Día {dia_max} con {dias[dia_max]} unidades")
