CREATE DATABASE transacciones;
USE transacciones;

CREATE TABLE Articulos (
    codart INTEGER PRIMARY KEY,
    descripcion TEXT NOT NULL,
    existencias INTEGER NOT NULL,
    precio REAL NOT NULL
);

CREATE TABLE Riders (
    codigo INTEGER PRIMARY KEY,
    nombre TEXT NOT NULL,
    disponible TEXT CHECK (disponible IN ('S', 'N')) NOT NULL
);

CREATE TABLE Pedidos (
    codped INTEGER PRIMARY KEY,
    fecha TEXT NOT NULL,
    codcli INTEGER NOT NULL,
    direccion TEXT NOT NULL,
    codart INTEGER NOT NULL,
    cantidad INTEGER NOT NULL,
    Entregado DATETIME,
    FOREIGN KEY (codart) REFERENCES Articulos (codart)
);

CREATE TABLE Envios (
    codenvio INTEGER PRIMARY KEY auto_increment,
    codped INTEGER NOT NULL,
    codrider INTEGER NOT NULL,
    terminado TEXT,
    FOREIGN KEY (codped) REFERENCES Pedidos (codped),
    FOREIGN KEY (codrider) REFERENCES Riders (codigo)
);
-- ------------------------------------------------------
INSERT INTO Articulos (codart, descripcion, existencias, precio)
VALUES (1, 'Laptop', 10, 1000.0),
       (2, 'Mouse', 50, 20.0),
       (3, 'Teclado', 30, 50.0);

INSERT INTO Riders (codigo, nombre, disponible)
VALUES (1, 'Juan', 'S'),
       (2, 'María', 'S'),
       (3, 'Pedro', 'S');
