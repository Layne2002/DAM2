from peewee import *
import mysql.connector

# Conexión a la base de datos MySQL
db = MySQLDatabase(
    'inventario',  # Nombre de la BD
    user='root',   # Usuario
    password='karim2002',  # Contraseña
    host='localhost',
    port=3306
)

# Definición de modelos
class BaseModel(Model):
    class Meta:
        database = db

class Ubicaciones(BaseModel):
    cod = AutoField()
    lugar = CharField()

class Maquinas(BaseModel):
    codigo = AutoField()
    modelo = CharField()
    descripcion = TextField(null=True)
    ram = CharField(null=True)
    hd = CharField(null=True)
    cpu = CharField(null=True)
    cod_ubicacion = ForeignKeyField(Ubicaciones, backref='maquinas', null=True)
