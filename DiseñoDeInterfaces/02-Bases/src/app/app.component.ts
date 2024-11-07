import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  public title: string = 'Mi primera app de Angular';
  public contador: number = 10;
  public intervalo: number = 1;

  aumentarIntervalo(): void {
    this.intervalo += 1;
  }
  disminuirIntervalo(): void {
    this.intervalo -= 1;
  }
  reestablecerIntervalo(): void {
    this.intervalo = 1;
  }
  incrementarPor(): void {
    this.contador += this.intervalo;
  }
  disminuirPor(): void {
    this.contador -= this.intervalo;
  }
  reestablecerContador(): void {
    this.contador = 0;
  }
}
