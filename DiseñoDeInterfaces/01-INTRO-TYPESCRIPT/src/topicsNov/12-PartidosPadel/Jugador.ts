import { Persona } from "./Persona.ts";
import { Direccion } from "./Persona.ts";
export class Jugador extends Persona {
  constructor(
    nombre: string,
    apellidos: string,
    genero: string,
    telefono: string,
    public categoria: 1 | 2 | 3 | 4 | 5 | 6,
    // agregado un ? para que sea opcional la direccion
    direccion?: Direccion
  ) {
    super(nombre, apellidos, genero, telefono, direccion);
  }
}
