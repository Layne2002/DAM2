class Persona:
    def __init__(self, nombre="", apellidos="", dni="", edad=0):
        self.setNombre(nombre)
        self.setApellidos(apellidos)
        self.setDni(dni)
        self.setEdad(edad)

    # Setter y getter para nombre
    def setNombre(self, nombre):
        if nombre != "":
            self._nombre = nombre.upper()
        else:
            self._nombre = nombre

    def getNombre(self):
        return self._nombre

    # Setter y getter para apellidos
    def setApellidos(self, apellidos):
        if apellidos != "":
            self._apellidos = apellidos.upper()
        else:
            self._apellidos = apellidos

    def getApellidos(self):
        return self._apellidos

    # Setter y getter para direccion
    def setDireccion(self, direccion):
        if direccion != "":
            self._direccion = direccion.upper()
        else:
            self._direccion = direccion

    def getDireccion(self):
        return self._direccion

    # Setter y getter para DNI
    def setDni(self, dni):
        if dni != "":
            self._dni = dni.upper()
        else:
            self._dni = dni
    
    #Setter y getter para edad
    def setEdad(self,edad):
        if isinstance(edad,int) and edad>0:
            self._edad = edad
        else:
            self._edad = 0
    
    def getEdad(self):
        return self._edad
    
    # Método mostrar
    def mostrar(self):
        print(f'Nombre: {self.getNombre()}')
        print(f'Apellidos: {self.getApellidos()}')
        print(f'DNI: {self.getDni()}')
        print(f'Edad: {self.getEdad()}')

    # Método mayor de edad
    def mayorDeEdad(self):
        return self.getEdad() >= 18