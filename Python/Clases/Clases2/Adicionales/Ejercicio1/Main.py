from Productos import Electronico, Ropa,Comida

# Crear una lista de productos
productos = [
    Electronico("Televisor", 500, 15),  # Descuento del 15%, pero el máximo es 10%
    Ropa("Camiseta", 20, 25),           # Descuento del 25%, pero el máximo es 20%
    Comida("Manzanas", 3),              # No tiene descuento
    Electronico("Portátil", 1000, 8),   # Descuento del 8%
    Ropa("Pantalones", 40, 10),         # Descuento del 10%
    Comida("Pan", 1)                    # No tiene descuento
]

# Mostrar el precio final de cada producto
for producto in productos:
    print(f"Producto: {producto.nombre}")
    print(f"Precio original: {producto.precio}€")
    print(f"Descuento: {producto.descuento}%")
    print(f"Precio final: {producto.precio_final()}€")
    print("-" * 40)
