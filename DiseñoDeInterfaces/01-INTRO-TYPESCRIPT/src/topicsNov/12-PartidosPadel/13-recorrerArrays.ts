import { calendario, equipo1, equipo2, equipo3 } from "./Main.ts";
import { Jugador } from "./Jugador.ts";

// funcion que recorre cualquier array
function mostrarElementos<T>(array: T[]): void {
  array.forEach((elemento, index) => {
    console.log(`Elemento en posición ${index}:`, elemento);
  });
}

// creando un array de jugadores
const miembros1: Jugador[] = equipo1.miembros;
const miembros2: Jugador[] = equipo2.miembros;
const miembros3: Jugador[] = equipo3.miembros;
const jugadoresArray: Jugador[] = miembros1.concat(miembros2, miembros3);

// mostrando el listado de partidos
console.log("Listado de Partidos:");
mostrarElementos(calendario);

//Mostrando el listado de jugadores
console.log("Listado de jugadores:");
mostrarElementos(jugadoresArray);
