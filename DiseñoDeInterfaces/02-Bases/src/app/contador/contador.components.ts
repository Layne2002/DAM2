import { Component } from '@angular/core';

@Component({
  selector: 'app-contador',
  template: `
    <h2>Contador: {{ contador }}</h2>
    <button (click)="incrementarPor()">+ {{ intervalo }}</button>
    <button (click)="disminuirPor()">- {{ intervalo }}</button>
    <button (click)="reestablecerContador()">RESET</button>
    <br />
    <br />
    <button (click)="aumentarIntervalo()">Aumentar intervalo</button>
    <button (click)="disminuirIntervalo()">Disminuir intervalo</button>
    <button (click)="reestablecerIntervalo()">Reestablecer intervalo</button>
    <hr />
  `,
  standalone: true,
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
