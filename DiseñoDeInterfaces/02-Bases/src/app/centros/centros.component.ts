import { Component } from '@angular/core';
import { Centro } from './centro.model';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-centros',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './centros.component.html',
  styleUrl: './centros.component.css',
})
export class CentrosComponent {
  centros: Centro[] = [
    { id: 1, nombre: 'IES Playamar', direccion: 'Calle Ayala' },
    { id: 2, nombre: 'Novaschool Añoreta', direccion: 'Calle Orfilia' },
    { id: 2, nombre: 'Miguel de Ohio', direccion: 'Calle los pinillos' },
    { id: 3, nombre: 'IES Hielo de Hierro', direccion: 'Calle Cervantes' },
  ];
  pila: Centro[] = [];
  posicionActual: number = 0;

  avanzar() {
    if (this.posicionActual < this.centros.length - 1) {
      this.posicionActual++;
    }
  }

  retroceder() {
    if (this.posicionActual > 0) {
      this.posicionActual--;
    }
  }

  eliminar() {
    if (this.centros.length > 0) {
      const centroEliminado = this.centros.splice(this.posicionActual, 1)[0];
      this.pila.push(centroEliminado);

      if (this.posicionActual >= this.centros.length) {
        this.posicionActual = Math.max(0, this.centros.length - 1);
      }
    }
  }

  insertar() {
    if (this.pila.length > 0) {
      const centroInsertado = this.pila.pop();
      if (centroInsertado) {
        this.centros.splice(this.posicionActual, 0, centroInsertado);
      }
    }
  }
}
