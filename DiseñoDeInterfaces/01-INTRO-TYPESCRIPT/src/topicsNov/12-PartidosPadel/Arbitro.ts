import { Persona } from "./Persona.ts";
import { Direccion } from "./Persona.ts";
export class Arbitro extends Persona {
  constructor(
    nombre: string,
    apellidos: string,
    genero: string,
    telefono: string,
    public colegiado: number,
    //Agregado el ?
    direccion?: Direccion
  ) {
    super(nombre, apellidos, genero, telefono, direccion);
  }
}
