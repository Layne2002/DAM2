from Persona import Persona
class Cuenta:
    def __init__(self, titular, cantidad=0):
        self.titular = titular
        self._cantidad = cantidad

    def set_titular(self, titular):
        self.titular = titular

    def get_titular(self):
        return self.titular

    def get_cantidad(self):
        return self._cantidad

    def ingresar(self, cantidad):
        if cantidad > 0:
            self._cantidad += cantidad
        else:
            print("La cantidad a ingresar debe ser positiva.")

    def retirar(self, cantidad):
        if cantidad > 0:
            self._cantidad -= cantidad
        else:
            print("La cantidad a retirar debe ser positiva.")

    def mostrar(self):
        print(f"Titular: {self.titular.get_nombre()} {self.titular.get_apellidos()}")
        print(f"DNI: {self.titular.get_dni()}")
        print(f"Edad: {self.titular.get_edad()}")
        print(f"Cantidad en cuenta: {self._cantidad} euros")
