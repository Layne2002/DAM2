export interface Instituto {
  nombre: string;
  director: string;
  telefono: string;
  correo: string;
  direccion: Direccion;
  listadoAlumnos: ListadoAlumnos[];
}

export interface ListadoAlumnos {
  nombre: string;
  edad: number;
  sexo: string;
  direccion: Direccion;
  enseñanza: Enseñanza | null;
}

export interface Enseñanza {
  nivel: string;
  obligatoria: boolean;
  horario: string;
  ramaProfesional?: string;
}

export interface Direccion {
  calle: string;
  cp: number;
  localidad: string;
  provincia: string;
}

export function matricularAlumno(
  instituto: Instituto,
  alumno: ListadoAlumnos,
  enseñanza: Enseñanza
): void {
  alumno.enseñanza = enseñanza;

  const alumnoExiste = instituto.listadoAlumnos.find(
    (a) => a.nombre === alumno.nombre
  );

  if (!alumnoExiste) {
    instituto.listadoAlumnos.push(alumno);
  } else {
    console.log(
      `El alumno ${alumno.nombre} ya esta matriculado en el istituto`
    );
  }
}

export function mostrarAlumnos(instituto: Instituto): void {
  const { listadoAlumnos, nombre } = instituto;
  console.log(`Alumnos del instituto ${nombre}`);

  listadoAlumnos.forEach(({ nombre, enseñanza, direccion }) => {
    if (enseñanza) {
      const { localidad } = direccion;
      const { nivel } = enseñanza;
      console.log(`Nombre: ${nombre}`);
      console.log(`Nivel matriculado: ${nivel}`);
      console.log(`Localidad de residencia: ${localidad}`);
    } else {
      console.log("La enseñanza es nula.");
    }
  });
}

export function direccionInstituto(instituto: Instituto): void {
  const {
    direccion: { calle, cp, localidad, provincia },
    nombre,
  } = instituto;
  console.log(
    `Instituto: ${nombre}, calle: ${calle}, codigo postal: ${cp}, localidad: ${localidad}, provincia: ${provincia}`
  );
}
