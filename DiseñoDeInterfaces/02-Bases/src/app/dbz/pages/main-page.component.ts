import { Component, OnInit } from '@angular/core';
import { dbzListaComponent } from '../components/Lista/dbz-lista.component';
import { AddPersonajeComponent } from '../components/AddPersonaje/dbz-addPersonaje.component';
import { Personaje } from '../interfaces/personaje.interface';
@Component({
  selector: 'app-dbz-main-page',
  templateUrl: 'main-page.component.html',
  standalone: true,
  imports: [dbzListaComponent, AddPersonajeComponent],
})
export class MainPageComponent {
  public personajes: Personaje[] = [
    {
      nombre: 'Krillin',
      fuerza: 500,
    },
    {
      nombre: 'Goku',
      fuerza: 10000,
    },
    {
      nombre: 'Vegeta',
      fuerza: 2000,
    },
  ];
}
