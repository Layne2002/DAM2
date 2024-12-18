import { Component } from '@angular/core';
import { dbzListaComponent } from '../components/Lista/dbz-lista.component';
import { AddPersonajeComponent } from '../components/AddPersonaje/dbz-addPersonaje.component';
import { DbzService } from '../services/dbz.service';
@Component({
  selector: 'app-dbz-main-page',
  templateUrl: 'main-page.component.html',
  standalone: true,
  imports: [dbzListaComponent, AddPersonajeComponent],
})
export class MainPageComponent {
  constructor(public dbzService: DbzService) {}
}
