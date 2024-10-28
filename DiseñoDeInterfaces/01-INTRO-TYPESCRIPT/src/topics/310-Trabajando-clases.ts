// importamos Expediente del anterior ejercicio
import { Expediente } from "./3.7-desestArrays.ts";

// Creamos clase Estudiante
export class Estudiante {
  constructor(
    public nombre: string,
    public apellidos: string,
    public edad: number,
    public direccion: string,
    public expediente: Expediente,
    public sexo: string
  ) {}
}

// Creamos los 2 expedientes y estudiantes
const expediente1: Expediente = {
  curso: "DAM",
  media: 4.5,
};
const expediente2: Expediente = {
  curso: "Cocina de Pollo Frito",
  media: 4.5,
};
const estudiante1 = new Estudiante(
  "Karim",
  "Zinnatullin",
  22,
  "Málaga",
  expediente1,
  "Masculino"
);
const estudiante2 = new Estudiante(
  "Coronel",
  "Sanders",
  62,
  "Kentucky",
  expediente2,
  "Masculino"
);

// mostramos los 2 estudiantes
console.log(estudiante1);
console.log(estudiante2);

// creamos la clase instituto
export class Instituto {
  constructor(
    public centro: string,
    public localidad: string,
    public alumnos: Estudiante[]
  ) {}
}

// creamos un instituto nuevo
const instituto1 = new Instituto("IES Playamar", "Playamar", [
  estudiante1,
  estudiante2,
]);

// mostramos el instituto
console.log(instituto1);
export {};
