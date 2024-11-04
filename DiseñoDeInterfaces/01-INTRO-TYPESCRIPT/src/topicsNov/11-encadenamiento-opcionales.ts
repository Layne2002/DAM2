export interface Pasajero {
  nombre: string;
  hijos?: string[];
}
const pasajero1: Pasajero = {
  nombre: "Antonia",
};
const pasajero2: Pasajero = {
  nombre: "Pilar",
  hijos: ["Antonio", "Paula", "Isabel"],
};

const imprimirHijos = (pasajero: Pasajero) => {
  const cuantosHijos = pasajero.hijos?.length || 0;
  console.log(pasajero.nombre, cuantosHijos);
};

const numeroHijos = (pasajero: Pasajero) => {
  const numeroHijos = pasajero.hijos?.length;
  return numeroHijos;
};

imprimirHijos(pasajero1);
imprimirHijos(pasajero2);

console.log(numeroHijos(pasajero2));
