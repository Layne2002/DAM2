export class Persona {
  constructor(
    public nombre: string,
    public apellidos: string,
    public genero: string,
    public telefono: string,
    // agregado un ? para que sea opcional la direccion
    public direccion?: Direccion
  ) {}
}
export interface Direccion {
  calle: string;
  CP: number;
  localidad: string;
  provincia: string;
}
export{}