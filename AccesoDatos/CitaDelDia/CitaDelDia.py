import socket
import random

citas = [
    "I guess I can go anywhere I want. If only I knew where to go.",
    "People have to follow their hearts, and if their hearts lead them to Wal-Mart, so be it.",
    "No cuentes los días, haz que los días cuenten.",
    "La felicidad no es algo hecho. Viene de tus propias acciones.",
    "El éxito es la suma de pequeños esfuerzos repetidos día tras día."
]

# 1. Crear el socket
server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# 2. Enlazar el socket a una dirección y puerto
server_address = ('0.0.0.0', 2017)
server_socket.bind(server_address)

# 3. Poner el socket en modo escucha
server_socket.listen(5)  # Permite hasta 5 conexiones

print(f"Servidor escuchando en {server_address}")

while True:
    # 4. Aceptar conexiones
    client_socket, client_address = server_socket.accept()
    print(f"Conexión aceptada de {client_address}")

    # 5. Manejar la conexión
    data = client_socket.recv(1024).decode('utf-8')  # Recibir datos del cliente
    print(f"Datos recibidos: {data}")

    # Seleccionar una cita aleatoria
    cita_del_dia = random.choice(citas)

    # Enviar la cita al cliente
    client_socket.sendall(cita_del_dia.encode('utf-8'))  # Enviar la cita como respuesta

    # 6. Cerrar la conexión
    client_socket.close()
