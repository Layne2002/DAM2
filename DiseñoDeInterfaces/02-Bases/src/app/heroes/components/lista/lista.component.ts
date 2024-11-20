import { Component } from '@angular/core';
@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
  styleUrl: './lista.component.css',
})
export class ListaComponent {
  public nombresHeroes: string[] = [
    'Goku',
    'Piccolo',
    'Vegeta',
    'Gohan',
    'Trunks',
  ];
  public heroeEliminado?: string;
  public eliminaultimoHeroe():void{
    this.heroeEliminado = this.nombresHeroes.pop();
  }
}
