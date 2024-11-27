from abc import ABC, abstractmethod


class Empleado(ABC):
    contador = 0

    def __init__(self, nombre):
        self.nombre = nombre
        self.id = Empleado.contador
        Empleado.contador += 1

    def get_id(self):
        return self.id

    def calcular_salario_total(empleados):
        total = 0
        for Empleado in empleados:
            total += Empleado.calcular_salario()
        return total

    def mostrar_empleados(empleados):
        for Empleado in empleados:
            print(f"{type(Empleado).__name__}: {Empleado.nombre}")
            print(f"ID: {Empleado.get_id()}")
            print(f"Salario: {Empleado.calcular_salario()}")
            print("---")
    @abstractmethod
    def calcular_salario(self):
        pass


class Asalariado(Empleado):
    def __init__(self, nombre, salario):
        super().__init__(nombre)
        self.salario = salario

    def calcular_salario(self):
        return self.salario


class PorHora(Empleado):
    def __init__(self, nombre, horas, tarifa):
        super().__init__(nombre)
        self.horas = min(horas, 160)
        self.tarifa = tarifa

    def calcular_salario(self):
        return self.tarifa * self.horas


class Comisionista(Empleado):
    def __init__(self, nombre, salario_base, comision, ventas):
        super().__init__(nombre)
        self.salario_base = salario_base
        self.comision = comision
        self.ventas = ventas

    def calcular_salario(self):
        return self.salario_base + (self.comision / 100)*self.ventas
