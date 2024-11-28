import { Component} from '@angular/core';
import { CommonModule } from '@angular/common';
import { Personaje } from '../../interfaces/personaje.interface';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'dbz-add-personaje',
  templateUrl: 'dbz-addpersonaje.component.html',
  standalone: true,
  imports: [FormsModule,CommonModule],
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
