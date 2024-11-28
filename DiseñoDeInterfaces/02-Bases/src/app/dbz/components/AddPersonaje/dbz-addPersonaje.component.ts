import { Component, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Personaje } from '../../interfaces/personaje.interface';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'dbz-add-personaje',
  templateUrl: 'dbz-addpersonaje.component.html',
  standalone: true,
  imports: [FormsModule, CommonModule],
})
export class AddPersonajeComponent {
  @Output()
  public onNewPersonaje: EventEmitter<Personaje> = new EventEmitter();

  public personaje: Personaje = {
    nombre: '',
    fuerza: 0,
  };
  public addPersonaje(): void {
    console.log("addPersonaje")
    console.log(this.personaje);
    if(this.personaje.nombre.length==0) return;
    this.onNewPersonaje.emit(this.personaje);
    // Inicializamos valores
    this.personaje.nombre = '';
    this.personaje.fuerza = 0;
  }
}
