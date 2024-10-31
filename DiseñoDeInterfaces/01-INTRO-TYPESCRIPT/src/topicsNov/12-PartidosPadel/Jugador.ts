import { Persona } from "./Persona.ts";
import { Direccion } from "./Persona.ts";
export class Jugador extends Persona {
  constructor(
    nombre: string,
    apellidos: string,
    genero: string,
    telefono: string,
    direccion: Direccion,
    public categoria: 1 | 2 | 3 | 4 | 5 | 6
  ) {
    super(nombre, apellidos, genero, telefono, direccion);
  }
}
