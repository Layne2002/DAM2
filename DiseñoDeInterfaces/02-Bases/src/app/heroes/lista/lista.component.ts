import { Component } from '@angular/core';

@Component({
  selector: 'app-heore-lista',
  standalone: true,
  imports: [],
  templateUrl: './lista.component.html',
  styleUrl: './lista.component.css'
})
export class ListaComponent {
  public nombreCentro: string = 'IES Playamar';
  public localidad: string = 'Torremolinos';
  public familiasType: number = 1;

 public get familia():string{
  switch(this.familiasType){
    case 1:{
      return ""
    }
  }
 }
  public get nombreCapitalizado(): string {
    return this.nombre.toLocaleUpperCase();
  }
  public getDescripcionHeroe(): string {
    return `${this.nombre} - ${this.edad}`;
  }
  private getNombrePrivado(): string {
    return 'Kakarot';
  }
}
