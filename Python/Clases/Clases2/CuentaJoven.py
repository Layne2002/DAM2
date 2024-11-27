from Cuenta import Cuenta
class CuentaJoven(Cuenta):
    def __init__(self, titular, bonificacion=0, cantidad=0):
        super().__init__(titular, cantidad)
        self.bonificacion = bonificacion

    def set_bonificacion(self, bonificacion):
        if 0 <= bonificacion <= 100:
            self.bonificacion = bonificacion
        else:
            print("La bonificación debe ser un valor entre 0 y 100.")

    def get_bonificacion(self):
        return self.bonificacion

    def mostrar(self):
        super().mostrar()
        print(f"Bonificación: {self.bonificacion}%")
