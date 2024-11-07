# DICCIONARIOS

Crea un programa que utilice un diccionario para crear un listín telefónico. El
diccionario estará formado por pares (nombre, teléfono).

1. Al arrancar debe mostrar un menú de opciones como el siguiente:

```.Spanish
MENÚ DE OPCIONES
a) Listado de teléfonos, usando el orden por defecto.
b) Listado de teléfonos por orden alfabético.
c) Añadir un nuevo contacto.
d) Modificar el teléfono de un contacto.
e) Buscar un número de teléfono.
f) Eliminar un contacto.
g) Borrar el listín telefónico.
h) Salir
```

2 El usuario introducirá la opción que debe ejecutar. Para ello, introducirá una letra
(ya sea minúscula o mayúscula) de la operación a realizar. En caso de introducir
una letra incorrecta se mostrará un mensaje de error.
3 Si se ha indicado una opción correcta, se ejecuta según estas instrucciones que
se indican a continuación. Una vez finalizada la opción se espera a que se pulse
una tecla para continuar.
4 Las opciones del programa son:

```.Spanish
Listado de teléfonos, usando el orden por defecto. Se muestra por pantalla el
contenido del diccionario, según el orden por defecto (el de inserción de
elementos). El listado será de la forma:

Nombre – Teléfono.
```

```.Spanish
Listado de teléfonos por orden alfabético. Ahora se muestra el contenido
ordenado por orden alfabético de los contactos.
```

```.Spanish
Añadir un nuevo contacto. Se debe leer por teclado un nombre de contacto y su
número de teléfono. Se añade en el diccionario. Si ya existe, se informa que ya
existe y pregunta si se quiere actualizar su teléfono. Si se responde
afirmativamente se actualiza.
```

```.Spanish
Modificar el teléfono de un contacto. Se pide un nombre de contacto. Si no
existe, se pregunta si se desea insertar. Si se responde afirmativamente (o el
contacto ya existía), se pide el número de teléfono y se actualiza el diccionario.
```

```.Spanish
Buscar un número de teléfono. Se pide un número de teléfono de contacto y se
busca en el diccionario. Si se encuentra, se indica el nombre del contacto, en otro
caso se indica que no se encuentra.
```

```.Spanish
Eliminar un contacto. Se pide un nombre de contacto. Si no existe, se indica que
no se encuentra, si existe se debe eliminar del diccionario.
```

```.Spanish
Borrar el listín telefónico. Se pide confirmación de la operación.
Si el usuario responde afirmativamente, se borra todo el diccionario.
```

```.Spanish
Salir. Mientras el usuario no seleccione esta opción, tras finalizar cada opción
debe mostrar de nuevo el menú de opciones. Con esta opción el programa finaliza.
```
