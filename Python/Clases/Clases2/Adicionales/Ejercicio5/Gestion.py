from Vehiculo import *


class GestionFlota:
    def __init__(self):
        self.flota = {}  # Diccionario que almacenará los vehículos con el id como clave

    def registrar_vehiculo(self, vehiculo):
        """Registra un vehículo en la flota"""
        if vehiculo.id_vehiculo in self.flota:
            print(f"El vehículo con ID {
                  vehiculo.id_vehiculo} ya está registrado.")
        else:
            self.flota[vehiculo.id_vehiculo] = vehiculo
            print(f"Vehículo con ID {
                  vehiculo.id_vehiculo} registrado con éxito.")

    def consultar_vehiculo(self, id_vehiculo):
        """Consulta los datos de un vehículo por su ID"""
        vehiculo = self.flota.get(id_vehiculo)
        if vehiculo:
            vehiculo.mostrar_informacion()
        else:
            print(f"No se encontró el vehículo con ID {id_vehiculo}.")

    def listar_vehiculos_disponibles(self):
        """Lista todos los vehículos disponibles en la flota"""
        disponibles = [vehiculo for vehiculo in self.flota.values(
        ) if vehiculo.estado == 'disponible']
        if disponibles:
            print("Vehículos disponibles:")
            for vehiculo in disponibles:
                vehiculo.mostrar_informacion()
                print("---")
        else:
            print("No hay vehículos disponibles.")

    def eliminar_vehiculo(self, id_vehiculo):
        """Elimina un vehículo de la flota por su ID"""
        if id_vehiculo in self.flota:
            del self.flota[id_vehiculo]
            print(f"Vehículo con ID {id_vehiculo} eliminado.")
        else:
            print(f"No se encontró el vehículo con ID {id_vehiculo}.")

    def cambiar_estado_vehiculo(self, id_vehiculo):
        """Cambia el estado de un vehículo de disponible a en servicio o viceversa"""
        vehiculo = self.flota.get(id_vehiculo)
        if vehiculo:
            vehiculo.cambiar_estado()
            print(f"Estado del vehículo con ID {
                  id_vehiculo} cambiado a {vehiculo.estado}.")
        else:
            print(f"No se encontró el vehículo con ID {id_vehiculo}.")
