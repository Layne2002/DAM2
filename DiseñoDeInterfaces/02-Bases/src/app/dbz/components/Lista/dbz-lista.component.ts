import { CommonModule } from '@angular/common';
import { Component, Input, Output,EventEmitter } from '@angular/core';
import { Personaje } from '../../interfaces/personaje.interface';
@Component({
  selector: 'dbz-lista',
  templateUrl: 'dbz-lista.component.html',
  standalone:true,
  imports:[CommonModule]
})
export class dbzListaComponent {
  @Input('miLista')
  public listaPersonajes: Personaje[]=[{
    nombre: 'Trunks',
    fuerza:7000
  }];



  @Output()
  public onDeletePersonaje: EventEmitter<number> = new EventEmitter();

  public eliminarPersonaje (indice:number){
    console.log(this.listaPersonajes[indice]);
    this.onDeletePersonaje.emit(indice);
  }
}
