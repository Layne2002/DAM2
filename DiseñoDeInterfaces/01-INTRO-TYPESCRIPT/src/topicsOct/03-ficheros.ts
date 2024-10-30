// Definimos las funciones necesarias
function suma(x:number, y:number){
    return x+y;
}
function resta(x:number,y:number){
    return x-y;
}
function multiplicar(x:number, y:number){
    return x*y;
}
function dividir(x:number, y:number){
    if(y==0){
        return 0;
    }else{
        return x/y;
    }
}

// creamos las constantes 
const resSuma = suma(2,6);
const resResta = resta(50,23);
const resMult = multiplicar(4,7);
const resDividir = dividir(10,2);

// mostramos las constantes por consola
console.log({resSuma});
console.log({resResta});
console.log({resMult});
console.log({resDividir});
