import { Injectable } from '@angular/core';
import { Personaje } from '../interfaces/personaje.interface';
import { v4 as uuid } from 'uuid';
@Injectable({ providedIn: 'root' })
export class DbzService {
  constructor() {}

  public personajes: Personaje[] = [
    {
      id: uuid(),
      nombre: 'Krillin',
      fuerza: 500,
    },
    {
      id: uuid(),
      nombre: 'Goku',
      fuerza: 10000,
    },
    {
      id: uuid(),
      nombre: 'Vegeta',
      fuerza: 2000,
    },
  ];
  public addPersonaje(personaje: Personaje): void {
    const newPersonaje: Personaje = { id: uuid(), ...personaje };

    this.personajes.push(newPersonaje);
  }

  public deletePersonaje(id: string): void {
    console.log(
      'Eliminado: ' +
        this.personajes.find((personaje) => personaje.id === id)!.nombre
    );

    this.personajes = this.personajes.filter(
      (personaje) => personaje.id !== id
    );
  }
}
