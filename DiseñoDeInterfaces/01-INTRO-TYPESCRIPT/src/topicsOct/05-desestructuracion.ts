interface reproductorAudio {
  volumenRadio: number;
  duracionCancion: number;
  cancion: string;
  detalles: Detalles;
}
interface Detalles {
  autor: string;
  anyo: number;
}

const reproductorAudio: reproductorAudio = {
  volumenRadio: 0,
  duracionCancion: 0,
  cancion: "",
  detalles: {
    autor:"Quevedo",
    anyo: 2020,
  }
};

const { cancion } = reproductorAudio;
console.log("Canción:", cancion);

const { autor } = reproductorAudio.detalles;
console.log("Autor:", autor);

const { cancion: cancion2 } = reproductorAudio;

const {
  cancion: miCancion,
  duracionCancion: miDuracion,
  detalles,
} = reproductorAudio;
const { autor: autor2 } = detalles;
console.log("Canción:", miCancion);
console.log("Duración:", miDuracion);
console.log("Autor:", autor2);

export {};
