import { Profesor } from "./11-Profesor.ts";
import { Alumno } from "./11-Alumno.ts";

const profesor1 = new Profesor(
  "Coronel",
  "Sanders",
  40,
  "Malaga",
  "Masculino",
  "IES Playamar",
  "Pollo Frito",
  "Cocina"
);

const alumno1 = new Alumno(
  "Karim",
  "Zinnatullin",
  22,
  "Malaga",
  "Masculino",
  "Colegio Cerrado de Calderón",
  "2º Bachillerato",
  ["Matemáticas", "Física", "Historia"]
);
console.log({ profesor1 });
console.log({ alumno1 });

export {};
