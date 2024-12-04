import { Component } from '@angular/core';

import { ContadorModule } from './contador/components/contador/contador.module';
import { HeroesModule } from './heroes/heroes.module';

import { CentrosComponent } from './centros/centros.component';
import { MainPageComponent } from './dbz/pages/main-page.component';
@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  imports: [MainPageComponent, HeroesModule, ContadorModule],
})
export class AppComponent {
  public title: string = 'Bomboclaat';
}
