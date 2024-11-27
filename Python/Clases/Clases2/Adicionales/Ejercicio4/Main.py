from Empleados import Asalariado, PorHora, Comisionista, Empleado
# Crear una lista de empleados
empleados = [
    Asalariado("Juan Pérez", 2000),               
    # Asalariado con salario fijo
    # Por Hora con tarifa de 15 y 150 horas trabajadas
    PorHora("Ana Gómez", 15, 150),
    # Comisionista con salario base y comisiones
    Comisionista("Carlos Rodríguez", 1200, 5, 50000),
    # Asalariado con salario fijo
    Asalariado("María López", 2200),
    # Por Hora con tarifa de 20 y 160 horas trabajadas
    PorHora("Luis Martínez", 20, 160),
    # Comisionista con salario base y comisiones
    Comisionista("Lucía Sánchez", 1000, 10, 30000)
]

Empleado.mostrar_empleados(empleados)

# Calcular el salario total de la empresa
salario_total = Empleado.calcular_salario_total(empleados)
print(f"Salario total de la empresa: {salario_total} €")
