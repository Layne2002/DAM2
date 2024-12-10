from conexion import BaseModel, Ubicaciones, Maquinas, db

db.connect()
db.create_tables([Ubicaciones, Maquinas])
db.close()


def alta_maquina(modelo, descripcion, ram, hd, cpu, cod_ubicacion):
    Maquinas.create(
        modelo=modelo,
        descripcion=descripcion,
        ram=ram,
        hd=hd,
        cpu=cpu,
        cod_ubicacion=cod_ubicacion
    )

def consulta_por_modelo(modelo):
    try:
        maquina = Maquinas.get(Maquinas.modelo == modelo)
        ubicacion = maquina.cod_ubicacion.lugar if maquina.cod_ubicacion else "Sin ubicación asignada"
        print(f'Modelo: {maquina.modelo}, RAM: {maquina.ram}, Ubicación: {ubicacion}')
        return maquina
    except Maquinas.DoesNotExist:
        print("No se encontró una máquina con ese modelo.")
        return None

def actualizar_maquina(codigo, ram=None, hd=None, cod_ubicacion=None):
    query = Maquinas.update(
        ram=ram,
        hd=hd,
        cod_ubicacion=cod_ubicacion
    ).where(Maquinas.codigo == codigo)
    query.execute()

def listar_maquinas_por_ubicacion(cod_ubicacion):
    maquinas = Maquinas.select().where(Maquinas.cod_ubicacion == cod_ubicacion)
    return list(maquinas)


# Conexión
db.connect()

# Alta de ubicaciones
ubicacion, creada = Ubicaciones.get_or_create(lugar='Almacén Central')

if creada:
    print("Nueva ubicación creada.")
else:
    print("Ubicación ya existente.")

# Alta de una máquina
alta_maquina(
    modelo='Macbook Pro M2',
    descripcion='Macbook de Apple 2022',
    ram='8GB',
    hd='1TB SSD',
    cpu='Apple M2 Chip',
    cod_ubicacion=ubicacion
)

# Consultar máquina por modelo
maquina = consulta_por_modelo('Macbook Pro M2')
if maquina:
    print(f'Modelo: {maquina.modelo}, RAM: {maquina.ram}, Ubicación: {maquina.cod_ubicacion.lugar}')

# Actualizar máquina
actualizar_maquina(maquina.codigo, ram='32GB')

# Listar máquinas por ubicación
maquinas = listar_maquinas_por_ubicacion(ubicacion.cod)
for m in maquinas:
    print(f'Modelo: {m.modelo}, RAM: {m.ram}, Ubicación: {m.cod_ubicacion.lugar}')

db.close()
