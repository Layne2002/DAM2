interface Alumno {
  nombre: string;
  apellidos: string;
  modulos: string[];
  expedientes: Expediente[];
}

export interface Expediente {
  curso: string;
  media: number;
}

const alumnos: Alumno[] = [
  {
    nombre: "karim",
    apellidos: "zingangulin",
    modulos: ["Programacion", "Bases de Datos", "FOL"],
    expedientes: [
      {
        curso: "2023-2024",
        media: 7.43,
      },
      {
        curso: "2024-2025",
        media: 1,
      },
    ],
  },
  {
    nombre: "Alberto",
    apellidos: "Chicote",
    modulos: ["Panadería", "Charcutería", "Pasteleria"],
    expedientes: [
      {
        curso: "1987 a.C. - 1986 a.C.",
        media: 9.7,
      },
      {
        curso: "1986 a.C. . 1985 a.C.",
        media: 9.8,
      },
    ],
  },
  {
    nombre: "Florencio",
    apellidos: "Flores Jardín",
    modulos: ["Amapolas", "Rosas", "Estiercol 101"],
    expedientes: [
      {
        curso: "2015-2016",
        media: 6.7,
      },
      {
        curso: "2016-2017",
        media: 5.6,
      },
    ],
  },
];

const [,alumno2 ,] = alumnos;
const { nombre, apellidos, modulos, expedientes } = alumno2;
const [modulo1] = modulos;
const [expediente1] = expedientes;
const { curso, media } = expediente1;

console.table(`Nombre completo: ${nombre} ${apellidos}`)
console.table(`Primer módulo profesional: ${modulo1}`)
console.table(`Curso: ${curso}, Nota media: ${media}`)

export {};
