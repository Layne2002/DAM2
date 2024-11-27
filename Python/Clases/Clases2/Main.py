from CuentaJoven import CuentaJoven
from Persona import Persona
from Cuenta import Cuenta

# Crear una persona
persona1 = Persona("Juan", "Pérez", "12345678A", 30)
persona2 = Persona("Ana", "Gómez", "87654321B", 22)

# Crear una cuenta normal
cuenta_normal = Cuenta(persona1, 500)

# Crear una cuenta joven
cuenta_joven = CuentaJoven(persona2, 5, 1000)

# Mostrar información de las cuentas
print("\nCuenta Normal:")
cuenta_normal.mostrar()

print("\nCuenta Joven:")
cuenta_joven.mostrar()

# Realizar ingresos y retiradas
cuenta_normal.ingresar(200)
cuenta_normal.retirar(100)

cuenta_joven.ingresar(300)
cuenta_joven.retirar(500)

# Mostrar nuevamente las cuentas después de las operaciones
print("\nCuenta Normal después de las operaciones:")
cuenta_normal.mostrar()

print("\nCuenta Joven después de las operaciones:")
cuenta_joven.mostrar()
