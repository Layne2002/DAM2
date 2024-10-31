import { Jugador } from "./Jugador.ts";
export class Equipo {
  constructor(public nombre: string, public miembros: Jugador[]) {}
}
