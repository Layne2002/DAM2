import { CommonModule } from '@angular/common';
import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Personaje } from '../../interfaces/personaje.interface';
@Component({
  selector: 'dbz-lista',
  templateUrl: 'dbz-lista.component.html',
  standalone: true,
  imports: [CommonModule],
})
export class dbzListaComponent {
  @Input('miLista')
  public listaPersonajes: Personaje[] = [];

  @Output()
  public onDeletePersonaje: EventEmitter<string> = new EventEmitter();

  public eliminarPersonaje(id: string | undefined) {
    this.onDeletePersonaje.emit(id);
  }
}
