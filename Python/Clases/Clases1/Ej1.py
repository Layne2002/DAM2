class Persona:
    def __init__(self, nombre, direccion, telefono):
        self.nombre = nombre
        self.direccion = direccion
        self.telefono = telefono

    def __str__(self):
        return f"Nombre: {self.nombre}, Dirección: {self.direccion}, Teléfono: {self.telefono}"


karim = Persona("Karim Zinnatullin", "Calle Atocha 6", "123123123")
print(karim)
