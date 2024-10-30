export class Persona {
  constructor(
    private nombre: string,
    private apellidos: string,
    private edad: number,
    private localidad: string,
    private sexo?: string
  ) {
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.edad = edad;
    this.localidad = localidad;
    this.sexo = sexo;
  }
}
export {};
