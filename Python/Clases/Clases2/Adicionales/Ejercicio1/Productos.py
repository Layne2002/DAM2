# Clase base Producto
class Producto:
    def __init__(self, nombre, precio, descuento):
        self.nombre = nombre
        self.precio = precio
        self.descuento = descuento

    def precio_final(self):
        # Método general que se sobrescribirá en las clases derivadas
        return self.precio * (1 - self.descuento / 100)


# Clase derivada Electronico
class Electronico(Producto):
    def __init__(self, nombre, precio, descuento=0):
        super().__init__(nombre, precio, descuento)
        # El descuento máximo es 10%
        if self.descuento > 10:
            self.descuento = 10

    def precio_final(self):
        return self.precio * (1 - self.descuento / 100)


# Clase derivada Ropa
class Ropa(Producto):
    def __init__(self, nombre, precio, descuento=0):
        super().__init__(nombre, precio, descuento)
        # El descuento máximo es 20%
        if self.descuento > 20:
            self.descuento = 20

    def precio_final(self):
        return self.precio * (1 - self.descuento / 100)


# Clase derivada Comida
class Comida(Producto):
    def __init__(self, nombre, precio):
        super().__init__(nombre, precio, descuento=0)

    def precio_final(self):
        # La comida no tiene descuento, así que el precio final es igual al precio original
        return self.precio