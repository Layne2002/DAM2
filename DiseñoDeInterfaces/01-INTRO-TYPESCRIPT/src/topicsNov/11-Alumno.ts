import { Persona } from "./11-Persona.ts";
export class Alumno extends Persona {
  constructor(
    nombre: string,
    apellidos: string,
    edad: number,
    localidad: string,
    sexo: "Masculino" | "Femenino" | "Otro",
    private centro: string,
    private curso: string,
    private asignaturas: string[]
  ) {
    super(nombre, apellidos, edad, localidad, sexo);
    this.centro = centro;
    this.curso = curso;
    this.asignaturas = asignaturas;
  }
}
export {};
