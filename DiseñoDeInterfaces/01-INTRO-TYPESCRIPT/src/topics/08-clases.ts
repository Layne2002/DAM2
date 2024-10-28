export class Persona {
  public nombre: String;
  direccion: String;
  public altura?: number;
  private edad: number;
  constructor() {
    this.nombre = "Goku";
    this.direccion = 'Málaga';
    this.edad = 30;
  }
}
const goku = new Persona();
console.log(goku);
