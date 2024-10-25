import {
  Instituto,
  ListadoAlumnos,
  mostrarAlumnos,
  Enseñanza,
  matricularAlumno,
  direccionInstituto,
} from "./t9modulo-instituto";

const instituto1: Instituto = {
  nombre: "IES Playamar",
  director: "Alberto Cañaveral",
  telefono: "123456679",
  correo: "iesplayamar@email.com",
  direccion: {
    calle: "Calle Otoño",
    cp: 29620,
    localidad: "Torremolinos",
    provincia: "Malaga",
  },
  listadoAlumnos: [],
};

const alumno1: ListadoAlumnos = {
  nombre: "Karim",
  edad: 22,
  sexo: "Masculino",
  direccion: {
    calle: "Calle Invierno",
    cp: 29002,
    localidad: "Torremolinos",
    provincia: "Malaga",
  },
  enseñanza: null,
};

const alumno2: ListadoAlumnos = {
  nombre: "David",
  edad: 20,
  sexo: "Masculino",
  direccion: {
    calle: "Verano",
    cp: 29140,
    localidad: "Malaga",
    provincia: "Malaga",
  },
  enseñanza: null,
};

const enseñanza1: Enseñanza = {
  nivel: "2ºDAM",
  obligatoria: false,
  horario: "Tarde",
  ramaProfesional: "Informatica",
};
const enseñanza2: Enseñanza = {
  nivel: "3 de primaria",
  obligatoria: true,
  horario: "Mañana",
};

const enseñanza3: Enseñanza = {
  nivel: "1ºDAW",
  obligatoria: false,
  horario: "Tarde",
};

// matriculando a los alumnos
matricularAlumno(instituto1, alumno1, enseñanza1);
matricularAlumno(instituto1, alumno2, enseñanza2);
matricularAlumno(instituto1, alumno2, enseñanza3);

// mostramos a todos los alumnos
mostrarAlumnos(instituto1);

// mostramos la direccion del instituto
direccionInstituto(instituto1);
export {};
