import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MainPageComponent } from './pages/main-page.component';
import { dbzListaComponent } from './components/Lista/dbz-lista.component';
import { AddPersonajeComponent } from './components/AddPersonaje/dbz-addPersonaje.component';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    FormsModule,
    MainPageComponent,
    dbzListaComponent,
    AddPersonajeComponent,
  ],
})
export class DbzModule {}
