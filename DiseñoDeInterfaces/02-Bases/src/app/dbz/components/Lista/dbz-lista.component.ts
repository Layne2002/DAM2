import { CommonModule } from '@angular/common';
import { Component, OnInit, Input, Output } from '@angular/core';
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



  public borrarPersonaje(): void {
    this.onNewPersonaje.emit(this.personaje);
    // Inicializamos valores
    this.personaje = {
      nombre: '',
      fuerza: 0,
    };
  }
}
