import { Component, OnInit } from '@angular/core';
import { Personaje } from '../../interfaces/personaje.interface';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'dbz-add-personaje',
  templateUrl: 'dbz-addpersonaje.component.html',
  standalone: true,
  imports: [FormsModule],
})
export class AddPersonajeComponent {
  public personaje: Personaje = {
    nombre: '',
    fuerza: 0,
  };
  public addPersonaje(): void {
    console.log(this.personaje);
  }
}
