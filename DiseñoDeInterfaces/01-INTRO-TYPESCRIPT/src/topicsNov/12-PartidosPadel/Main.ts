import { Arbitro } from "./Arbitro.ts";
import { Equipo } from "./Equipo.ts";
import { Partido, imprimirCalendario } from "./Partido.ts";

// Creamos 3 equipos
export const equipo1: Equipo = {
  nombre: "Los Chulos",
  miembros: [
    {
      // miembro 1
      nombre: "Karim",
      apellidos: "Zinnatullin",
      genero: "Masculino",
      telefono: "12345678",
      categoria: 4,
      direccion: {
        calle: "Los Álamos",
        CP: 25435,
        localidad: "Málaga",
        provincia: "Málaga",
      }

    },
    {
      // miembro 2
      nombre: "David",
      apellidos: "Revuelta",
      genero: "Masculino",
      telefono: "55567894",
      categoria: 3,
      direccion: {
        calle: "Los Arcos",
        CP: 25554,
        localidad: "Benalmádena",
        provincia: "Málaga",
      }
    },
  ],
};
export const equipo2: Equipo = {
  nombre: "Los Gurmets",
  miembros: [
    {
      // miembro 1
      nombre: "Alberto",
      apellidos: "Chicote",
      genero: "Masculino",
      telefono: "987655412",
      categoria: 1,
      direccion: {
        calle: "Pesadilla en la Cocina",
        CP: 27534,
        localidad: "Getafe",
        provincia: "Madrid",
      }
    },
    {
      //miembro 2
      nombre: "Gordon",
      apellidos: "Ramsey",
      genero: "Masculino",
      telefono: "5555-2342",
      categoria: 2,
      direccion: {
        calle: "Lamb Sauce St.",
        CP: 65467,
        localidad: "Springfield",
        provincia: "Ohio",
      },
    },
  ],
};
export const equipo3: Equipo = {
  nombre: "Los Pollos hermanos",
  miembros: [
    {
      // miembro 1
      nombre: "Walter",
      apellidos: "Heartwell White",
      genero: "Masculino",
      telefono: "5554-7656",
      categoria: 6,
      direccion: {
        calle: "308, Negra Arroyo Lane",
        CP: 87104,
        localidad: "Albuquerque",
        provincia: "New Mexico",
      }
    },
    {
      // miembro 2
      nombre: "Skyler",
      apellidos: "White",
      genero: "Femenino",
      telefono: "5554-1138",

      categoria: 5,
      direccion: {
        calle: "308, Negra Arroyo Lane",
        CP: 87104,
        localidad: "Albuquerque",
        provincia: "New Mexico",
      }
    },
  ],
};

// Ahora creamos 2 Árbitros
const arbitro1: Arbitro = {
  nombre: "Dwight",
  apellidos: "Kurt Schrute",
  genero: "Masculino",
  telefono: "5566-4677",
  colegiado: 7,
  direccion: {
    calle: "Rural Rt. 6, 'Schrute Farms'",
    CP: 18431,
    localidad: "Scranton",
    provincia: "Pennsylvania",
  }
};
const arbitro2: Arbitro = {
  nombre: "Michael",
  apellidos: "Scott",
  genero: "Masculino",
  telefono: "5576-7759",
  colegiado: 69,
  direccion: {
    calle: "126 Kellum Court",
    CP: 18510,
    localidad: "Scranton",
    provincia: "Pennsylvania",
  }
};

// Ahora, creamos un calendario con 3 partidos
export const calendario: Partido[] = [
  new Partido( // partido 1
    "10/3/2024",
    "18:00",
    "Padel Family",
    3,
    arbitro1,
    [{ juegos: [2, 4] }, { juegos: [3, 1] }, { juegos: [2, 0] }],
  ),
  new Partido( // partido 2
    "06/7/2024",
    "15:30",
    "Padel Sports Resort",
    4,
    arbitro2,
    [{ juegos: [1, 6] }, { juegos: [0, 4] }, { juegos: [0, 3] }],
    equipo2,
    equipo3
  ),
  new Partido( // Partido 3
    "19/9/2024",
    "12:00",
    "Pistas Padel Paco",
    1,
    arbitro2,
    [{ juegos: [3, 2] }, { juegos: [1, 3] }],
    equipo1,
    equipo3
  ),
];

imprimirCalendario(calendario);