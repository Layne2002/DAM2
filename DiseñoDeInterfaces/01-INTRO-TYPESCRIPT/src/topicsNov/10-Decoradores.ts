function decoradorClase(constructor: any) {
  return class extends constructor {
    nuevaPropiedad = "Esto es una nueva propiedad";
    hola = "Adios";
  }
}

@decoradorClase
export class Superclase {
  public miPropiedad: string = "Patata";
  print() {
    console.log("Hola Mundo!");
  }
}
console.log(Superclase);
const superClase = new Superclase();
console.log(superClase);