export class Persona {
  public nombre: String;
  direccion: String;
  public altura?: number;
  private edad: number;
  constructor() {
    this.nombre = "Goku";
    this.direccion = "Málaga";
    this.edad = 30;
  }
}
export class PersonaCutre {
  public nombre: String;
  direccion: String;
  public altura?: number;
  private edad;

  constructor(
    nombre: string,
    direccion: string,
    altura?: number,
    edad: number = 0
  ) {
    this.nombre = nombre;
    this.direccion = direccion;
    this.edad = edad;
    this.altura = altura;
  }
}
export class PersonaGuay {
  constructor(
    public nombre: string,
    public direccion: string,
    public altura?: number,
    private edad: number = 0
  ) {}
}
const goku = new Persona();
const gohan = new PersonaCutre("Gohan", "Torremolinos", 98);
const bulma = new PersonaCutre("Bulma", "Vélez-Málaga", 8);
console.log(goku);
console.log(gohan);
console.log(bulma);
