import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-lista',
  standalone: true,
  imports: [CommonModule],
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
