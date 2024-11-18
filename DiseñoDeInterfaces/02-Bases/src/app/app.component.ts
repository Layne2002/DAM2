import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ContadorComponent } from './contador/contador.components';
import { HeroeComponent } from "./heroes/heroe/heroe.component";
import { ListaComponent } from './heroes/lista/lista.component';

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  imports: [ContadorComponent, HeroeComponent,ListaComponent],
})
export class AppComponent {
  public title: string = 'Bomboclaat';
}
