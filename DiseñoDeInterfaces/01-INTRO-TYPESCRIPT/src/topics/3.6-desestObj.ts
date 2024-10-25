interface Alumno {
  nombre: string;
  apellidos: string;
  anyoNacimiento: number;
  nacionalidad: string;
  matricula: Matricula;
}
interface Matricula {
  modulos: string[];
  ciclo: string;
  centroEducativo: CentroEducativo;
}
interface CentroEducativo {
  centro: string;
  localidad: string;
  postal: number;
  telefono: string;
}

const alumno1: Alumno = {
  nombre: "karim",
  apellidos: "zingangulin",
  anyoNacimiento: 2002,
  nacionalidad: "Rusa",
  matricula: {
    modulos: ["Programacion", "FOL"],
    ciclo: "2 DAM",
    centroEducativo: {
      centro: "IES Playamar",
      localidad: "Playamar",
      postal: 23442,
      telefono: "123435677",
    },
  },
};
const alumno2: Alumno = {
  nombre: "David",
  apellidos: "Ruiz",
  anyoNacimiento: 2004,
  nacionalidad: "Española",
  matricula: {
    modulos: ["Bases de datos", "Maquillaje"],
    ciclo: "3 DAM",
    centroEducativo: {
      centro: "IES Los Pinillos",
      localidad: "Torremolinos",
      postal: 25322,
      telefono: "123545457",
    },
  },
};

console.table(alumno1);
const { nombre: nombre, apellidos: apellidos } = alumno2;
const { ciclo: ciclo } = alumno2.matricula;
const  centro  = alumno2.matricula.centroEducativo.centro;

console.log("Alumno: ", nombre, apellidos);
console.log("Ciclo Formativo: ", ciclo);
console.log("Centro: ", centro);
export {};
