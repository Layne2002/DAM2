import { ListaComponent } from './components/lista/lista.component';
import { HeroeComponent } from './components/heroe/heroe.component';
import {NgModule} from '@angular/core';

import { CommonModule } from '@angular/common';

@NgModule({
declarations:[
  HeroeComponent,ListaComponent
],
imports:[
  CommonModule
],
exports:[
  HeroeComponent,ListaComponent
]
})
export class HeroesModule{

}
