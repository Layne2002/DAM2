export interface Alumno {
    nombre: string; 
    apellidos: string; 
    nacionalidad: string; 
    anoNacimiento: number; 
    telefono: string; 
    email: string; 
    modulosMatriculados: string[]; 
    convalidaFOL_EIE: boolean; 
    // La interrogación marca que es opcional
    nivelPadel?: string; 
    centroProcedencia?: string; 
}
// Creamos los dos alumnos (cualquier parecido con personas 
// reales es coincidencia)
const alumno1: Alumno ={
    nombre: 'Karim',
    apellidos: 'Zinnatullin',
    nacionalidad: 'Rusa',
    anoNacimiento: 2002,
    telefono: '12345678',
    email: 'karim@email.com',
    modulosMatriculados:['Programación','Empresas','Diseño de Interfaces'],
    convalidaFOL_EIE: false,
    nivelPadel: 'Maestro',
    centroProcedencia: 'IES Playamar'
  };
  const alumno2: Alumno ={
    nombre: 'Ana',
    apellidos: 'Zinnatullina',
    nacionalidad: 'Española',
    anoNacimiento: 2002,
    telefono: '12333344',
    email: 'anita@email.com',
    modulosMatriculados:['Bases de datos','Programacion'],
    convalidaFOL_EIE: true,
    nivelPadel: 'Nulo'
  };
  
  // Mostramos los alumnos en forma de tabla en la consola
  console.table([alumno1,alumno2]);
  export{}