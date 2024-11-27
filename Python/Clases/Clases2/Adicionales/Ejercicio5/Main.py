from Gestion import GestionFlota
from Vehiculo import *

# Crear el gestor de la flota
gestion_flota = GestionFlota()

# Registrar vehículos
auto1 = Auto(id_vehiculo="A123", modelo="Toyota Corolla", numero_asientos=5)
camion1 = Camion(id_vehiculo="C456", modelo="Volvo FH", capacidad_carga=12000)
auto2 = Auto(id_vehiculo="A789", modelo="Honda Civic", numero_asientos=4)

gestion_flota.registrar_vehiculo(auto1)
gestion_flota.registrar_vehiculo(camion1)
gestion_flota.registrar_vehiculo(auto2)

# Consultar vehículos
print("\nConsultar vehículo con ID A123:")
gestion_flota.consultar_vehiculo("A123")

# Listar vehículos disponibles
print("\nListar vehículos disponibles:")
gestion_flota.listar_vehiculos_disponibles()

# Cambiar el estado de un vehículo
print("\nCambiar estado del vehículo con ID A123:")
gestion_flota.cambiar_estado_vehiculo("A123")

# Eliminar un vehículo
print("\nEliminar vehículo con ID A789:")
gestion_flota.eliminar_vehiculo("A789")

# Listar vehículos disponibles después de eliminar uno
print("\nListar vehículos disponibles después de eliminar A789:")
gestion_flota.listar_vehiculos_disponibles()
