import { Arbitro } from "./Arbitro.ts";
import { Equipo } from "./Equipo.ts";
interface Set {
  juegos: [number, number];
}
export class Partido {
  constructor(
    public fecha: string,
    public hora: string,
    public recinto: string,
    public pista: number,
    public arbitro: Arbitro,
    public sets: Array<Set>,
    public equipoLocal?: Equipo,
    public equipoVisitante?: Equipo
  ) {}
  determinarGanador(): string {
    // contadores de victorias de cada equipo
    let setsLocal = 0;
    let setsVisitante = 0;

    // bucle para recorrer todos los resultados del array de Sets
    for (const set of this.sets) {
      // [0] = equipo local , [1] = equipo visitante
      if (set.juegos[0] > set.juegos[1]) {
        setsLocal++;
      } else if (set.juegos[1] > set.juegos[0]) {
        setsVisitante++;
      }
    }
    if (this.equipoLocal != null && this.equipoVisitante != null) {
      if (setsLocal > setsVisitante) {
        return `El equipo ${this.equipoLocal.nombre} ha ganado al equipo ${this.equipoVisitante.nombre} por ${setsLocal} sets a ${setsVisitante}.`;
      } else if (setsLocal < setsVisitante) {
        return `El equipo ${this.equipoVisitante.nombre} ha ganado al equipo ${this.equipoLocal.nombre} por ${setsVisitante} sets a ${setsLocal}.`;
      } else {
        return `El equipo ${this.equipoVisitante.nombre} y el equipo ${this.equipoLocal.nombre} han empatado ${setsVisitante} sets a ${setsLocal}.`;
      }
    } else {
      return `No hay equipo ganador.`;
    }
  }
}
export function imprimirCalendario(calendario: Partido[]): void {
  calendario.forEach((partido) => {
    const emparejamiento = `${
      partido.equipoLocal?.nombre || "Equipo Local Desconocido"
    } vs ${partido.equipoVisitante?.nombre || "Equipo Visitante Desconocido"}`;
    const fecha = partido.fecha;
    const arbitro = partido.arbitro.nombre;
    const direccionArbitro =
      partido.arbitro?.direccion || "Dirección de árbitro Desconocida";
    console.log(`Partido: ${emparejamiento}`);
    console.log(`Fecha: ${fecha}`);
    console.log(`Árbitro: ${arbitro}`);
    console.log(`Dirección del Árbitro: ${direccionArbitro}`);
    console.log("---------------------------");
  });
}
