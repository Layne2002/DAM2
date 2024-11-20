import { Component } from '@angular/core';

@Component({
  selector: 'app-contador',
  templateUrl: './contador.component.html',
  standalone: false,
})
export class ContadorComponent {
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
