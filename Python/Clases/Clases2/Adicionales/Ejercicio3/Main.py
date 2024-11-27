from Vehiculos import Coche, Camion, Moto
# Crear instancias de cada tipo de vehículo
coche = Coche("Toyota Corolla", 2020)
camion = Camion("Volvo FH", 2018, 10)  # Camión con 10 toneladas de carga
moto = Moto("Honda CBR500R", 2021)

# Calcular el consumo de cada vehículo para un trayecto de 200 km
kilometros = 200

print(f"Consumo del coche {coche.modelo} para {kilometros} km: {
      coche.calcular_consumo(kilometros)} litros")
print(f"Consumo del camión {camion.modelo} para {kilometros} km con {
      camion.carga_toneladas} toneladas de carga: {camion.calcular_consumo(kilometros)} litros")
print(f"Consumo de la moto {moto.modelo} para {kilometros} km: {
      moto.calcular_consumo(kilometros)} litros")
