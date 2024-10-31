# T 3.13 Trabajando con genéricos

Vamos a crear una serie de clases, tenéis que elegir sabiamente si utilizáis Herencia o Composición. Si "es un" o "tiene un".  
Crear las interfaces que consideréis.  
  
Queremos gestionar una liga de pádel local. Vamos a tener una serie de **jugadores**, **equipos** de dos jugadores y **árbitros**.  
Además vamos a tener un **calendario** de partidos.  
Un calendario será un listado indefinido de partidos entre 2 equipos en una fecha, hora, recinto, pista y árbitro concretos.  
Tanto de los jugadores como de los árbitros, vamos a almacenar los siguientes datos:

-   Nombre
-   Apellidos
-   Género
-   Teléfono
-   Dirección (Calle, CP, Localidad, Provincia)

De los jugadores almacenaremos:

-   Categoría: 1/2/3/4/5/6

De los árbitros:

-   Número Colegiado

Crear las clases, herencias, composiciones e interfaces necesarias para gestionar el ejercicio.  
Crear al menos 3 equipos, 2 árbitros y un calendario con 3 partidos.  
Mostrar el calendario con toda la información posible.  
  
Para nota: Añadir una propiedad en el partido con un array de Set, y que cada Set tenga dos números (la cantidad de juegos que ha ganado cada equipo en dicho set), de forma que podáis recorrer el array y dirimir quien ha ganado el partido. De esta forma podéis crear un método en la clase partido que diga algo así: El equipo López-Martín ha ganado al equipo Carrasco-Beltrán por 2 sets a 1.