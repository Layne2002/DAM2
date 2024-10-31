import { Persona } from "./Persona.ts";
import { Direccion } from "./Persona.ts";
export class Arbitro extends Persona {
  constructor(
    nombre: string,
    apellidos: string,
    genero: string,
    telefono: string,
    direccion: Direccion,
    public colegiado: number
  ) {
    super(nombre, apellidos, genero, telefono, direccion);
  }
}
