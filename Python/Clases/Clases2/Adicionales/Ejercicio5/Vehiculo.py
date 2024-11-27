class Vehiculo:
    def __init__(self, id_vehiculo, modelo, estado='disponible'):
        # Identificador único del vehículo (matrícula o número de registro)
        self.id_vehiculo = id_vehiculo
        self.modelo = modelo  # Modelo del vehículo
        self.estado = estado  # Estado del vehículo (disponible o en servicio)

    def cambiar_estado(self):
        """Cambia el estado del vehículo entre 'disponible' y 'en servicio'"""
        if self.estado == 'disponible':
            self.estado = 'en servicio'
        else:
            self.estado = 'disponible'

    def mostrar_informacion(self):
        """Muestra la información del vehículo"""
        print(f"ID: {self.id_vehiculo}")
        print(f"Modelo: {self.modelo}")
        print(f"Estado: {self.estado}")


class Auto(Vehiculo):
    def __init__(self, id_vehiculo, modelo, numero_asientos, estado='disponible'):
        super().__init__(id_vehiculo, modelo, estado)
        if numero_asientos <= 1:
            raise ValueError(
                "El número de asientos debe ser mayor a 1 para un automóvil.")
        self.numero_asientos = numero_asientos  # Número de asientos del automóvil

    def mostrar_informacion(self):
        """Muestra la información específica del automóvil"""
        super().mostrar_informacion()
        print(f"Número de asientos: {self.numero_asientos}")


class Camion(Vehiculo):
    def __init__(self, id_vehiculo, modelo, capacidad_carga, estado='disponible'):
        super().__init__(id_vehiculo, modelo, estado)
        if capacidad_carga <= 0:
            raise ValueError(
                "La capacidad máxima de carga debe ser mayor a 0 para un camión.")
        # Capacidad de carga máxima en kilogramos
        self.capacidad_carga = capacidad_carga

    def mostrar_informacion(self):
        """Muestra la información específica del camión"""
        super().mostrar_informacion()
        print(f"Capacidad de carga: {self.capacidad_carga} kg")
