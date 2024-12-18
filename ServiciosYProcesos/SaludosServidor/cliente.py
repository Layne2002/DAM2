import socket

def comprobar_puerto(host, port):
    """Comprueba si el puerto está abierto."""
    try:
        with socket.create_connection((host, port), timeout=5):
            print(f"El puerto {port} en {host} está abierto.")
            return True
    except (socket.timeout, ConnectionRefusedError):
        print(f"El puerto {port} en {host} no está disponible.")
        return False

def cliente_saludo(host, port):
    """Cliente que se conecta al servidor y sigue el protocolo de saludo."""
    if not comprobar_puerto(host, port):
        return
    
    try:
        # Crear el socket
        cliente_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        cliente_socket.connect((host, port))
        print("Conexión establecida con el servidor.")

        # Recibir la pregunta del servidor
        question = cliente_socket.recv(1024).decode('utf-8')
        print(f"Servidor: {question}")

        # Enviar el nombre al servidor
        nombre = "karim"  # Nombre a enviar
        cliente_socket.sendall(nombre.encode('utf-8'))

        # Recibir el saludo del servidor
        saludo = cliente_socket.recv(1024).decode('utf-8')
        print(f"Servidor: {saludo}")

        # Cerrar el socket
        cliente_socket.close()
        print("Conexión cerrada.")
    except ConnectionRefusedError:
        print("Error: El servidor rechazó la conexión.")
    except socket.timeout:
        print("Error: Se agotó el tiempo de espera de la conexión.")
    except Exception as e:
        print(f"Error inesperado: {e}")

if __name__ == "__main__":
    host = "79.72.53.157"
    port = 5000
    cliente_saludo(host, port)
