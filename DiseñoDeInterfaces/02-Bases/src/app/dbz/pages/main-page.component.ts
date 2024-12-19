import { Component } from '@angular/core';
import { dbzListaComponent } from '../components/Lista/dbz-lista.component';
import { AddPersonajeComponent } from '../components/AddPersonaje/dbz-addPersonaje.component';
import { DbzService } from '../services/dbz.service';
import { Personaje } from '../interfaces/personaje.interface';

@Component({
  selector: 'app-dbz-main-page',
  templateUrl: 'main-page.component.html',
  standalone: true,
  imports: [dbzListaComponent, AddPersonajeComponent],
})
export class MainPageComponent {
  constructor(private dbzService: DbzService) {}

  get personajes(): Personaje[] {
    return this.dbzService.personajes;
  }
  onNewPersonaje(personaje: Personaje): void {
    this.dbzService.addPersonaje(personaje);
  }
  onDeletePersonaje(id: string): void {
    this.dbzService.deletePersonaje(id);
  }
}
