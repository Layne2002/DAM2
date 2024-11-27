from Hotel import HabitacionDoble, HabitacionSuite, HabitacionIndividual
# Crear una lista de habitaciones con diferentes configuraciones
habitaciones = [
    # Habitacion Individual (50 € por noche)
    HabitacionIndividual(),
    # Habitacion Doble con desayuno (75 € + 10 € por noche)
    HabitacionDoble(desayuno=True),
    # Habitacion Suite (150 € por noche)
    HabitacionSuite(),
    # Habitacion Doble sin desayuno (75 € por noche)
    HabitacionDoble(desayuno=False),
    # Habitacion Suite (150 € por noche)
    HabitacionSuite(),
    # Habitacion Suite para más de 3 noches (descuento del 10%)
    HabitacionSuite()
]

# Calcular el precio total de las reservas para varias estancias
reservas = [
    # 2 noches en una habitación individual
    {"habitacion": habitaciones[0], "noches": 2},
    # 3 noches en una habitación doble con desayuno
    {"habitacion": habitaciones[1], "noches": 3},
    # 5 noches en una suite (descuento del 10%)
    {"habitacion": habitaciones[2], "noches": 5},
    # 1 noche en una habitación doble sin desayuno
    {"habitacion": habitaciones[3], "noches": 1},
    # 4 noches en una suite (descuento del 10%)
    {"habitacion": habitaciones[4], "noches": 4},
    # 6 noches en una suite (descuento del 10%)
    {"habitacion": habitaciones[5], "noches": 6}
]

# Mostrar los precios totales de cada reserva
for reserva in reservas:
    habitacion = reserva["habitacion"]
    noches = reserva["noches"]
    print(f"Reserva: {habitacion.nombre}")
    print(f"Noches: {noches}")
    print(f"Precio total: {habitacion.calcular_precio(noches)} €")
    print("-" * 40)
