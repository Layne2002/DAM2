# Clase base Habitacion
class Habitacion:
    def __init__(self, nombre, precio_base):
        self.nombre = nombre
        self.precio_base = precio_base

    def calcular_precio(self, noches):
        # Método base, será sobrescrito por las clases derivadas
        return self.precio_base * noches


# Clase derivada HabitacionIndividual
class HabitacionIndividual(Habitacion):
    def __init__(self):
        super().__init__("Individual", 50)  # Precio base de 50€

    def calcular_precio(self, noches):
        return self.precio_base * noches


# Clase derivada HabitacionDoble
class HabitacionDoble(Habitacion):
    def __init__(self, desayuno=False):
        super().__init__("Doble", 75)  # Precio base de 75€
        self.desayuno = desayuno

    def calcular_precio(self, noches):
        precio_total = self.precio_base * noches
        if self.desayuno:
            precio_total += 10 * noches  # Suplemento de desayuno por noche
        return precio_total


# Clase derivada HabitacionSuite
class HabitacionSuite(Habitacion):
    def __init__(self):
        super().__init__("Suite", 150)  # Precio base de 150€

    def calcular_precio(self, noches):
        precio_total = self.precio_base * noches
        if noches > 3:
            descuento = precio_total * 0.10  # 10% de descuento para más de 3 noches
            precio_total -= descuento
        return precio_total
