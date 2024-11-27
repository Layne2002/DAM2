# Clase base Vehiculo
class Vehiculo:
    def __init__(self, modelo, año):
        self.modelo = modelo
        self.año = año

    def calcular_consumo(self, kilometros):
        # Método base, será sobrescrito por las clases derivadas
        pass


# Clase derivada Coche
class Coche(Vehiculo):
    def __init__(self, modelo, año):
        super().__init__(modelo, año)

    def calcular_consumo(self, kilometros):
        # Los coches consumen 5 litros cada 100 km
        return (kilometros / 100) * 5


# Clase derivada Camion
class Camion(Vehiculo):
    def __init__(self, modelo, año, carga_toneladas):
        super().__init__(modelo, año)
        self.carga_toneladas = carga_toneladas

    def calcular_consumo(self, kilometros):
        # Los camiones consumen 20 litros cada 100 km, más un 10% por tonelada de carga
        consumo_base = (kilometros / 100) * 20
        incremento_carga = consumo_base * (0.10 * self.carga_toneladas)
        return consumo_base + incremento_carga


# Clase derivada Moto
class Moto(Vehiculo):
    def __init__(self, modelo, año):
        super().__init__(modelo, año)

    def calcular_consumo(self, kilometros):
        # Las motos consumen 3 litros cada 100 km
        return (kilometros / 100) * 3
