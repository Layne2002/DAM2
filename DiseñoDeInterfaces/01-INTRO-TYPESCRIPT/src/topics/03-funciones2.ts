interface Personaje{
    nombre: string,
    pv: number,
    muestraPV: () => void
}
const curarPersonaje = (personaje: Personaje, cantidad: number) =>{
    personaje.pv += cantidad;
}

const saiyan: Personaje = {
    nombre: 'Goku',
    pv: 50,
    muestraPV(){
        console.log('Puntos de vida ${this.pv}');
    }
}

saiyan.muestraPV();
curarPersonaje(saiyan,50);
saiyan.muestraPV();
export{};