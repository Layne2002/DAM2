import { Persona } from "./11-Persona.ts";
export class Profesor extends Persona {
  constructor(
    nombre: string,
    apellidos: string,
    edad: number,
    localidad: string,
    sexo: "Masculino" | "Femenino" | "Otro",
    private centro: string,
    private especialidad: string,
    private departamento: string
  ) {
    super(nombre, apellidos, edad, localidad, sexo);
  }
}
export {};
