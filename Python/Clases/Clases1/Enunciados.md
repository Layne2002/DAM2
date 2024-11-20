# CLASES

1. Crea una clase Persona para guardar nombre, dirección y teléfono de una
persona.

2. Crea un programa que utilice la clase Persona para almacenar un diccionario de contactos. El diccionario será un conjunto de datos donde la clave de cada entrada es el nombre de la persona (en mayúsculas) y el valor es un objeto de la clase Persona que guarda el nombre, dirección y teléfono.

    El programa mostrará el siguiente menú de opciones:

    ```.
    MENÚ DE OPCIONES
    a) Listado de contactos por orden alfabético.
    b) Añadir un nuevo contacto.
    c) Modificar un contacto.
    d) Buscar un número de teléfono.
    e) Eliminar un contacto.
    f) Salir
    ```

    Si se ha indicado una opción correcta, se ejecuta según estas instrucciones que se indican a continuación. Una vez finalizada la opción se espera a que se pulse una tecla para continuar.

    Las opciones del programa son:

    Listado de contactos por orden alfabético. Se muestra el contenido ordenado
    por orden alfabético de los contactos, con el siguiente formato:
    ``
    Nombre: xxx Dirección: xxx Teléfono: xxx
    ``
    Añadir un nuevo contacto.
    Se debe leer por teclado un nombre de contacto,
    dirección y número de teléfono. Se añade en el diccionario. Si ya existe, se informa que ya existe y pregunta si se quiere actualizar su teléfono. Si se responde afirmativamente se actualiza.

    Modificar un contacto.
    Se pide un nombre de contacto. Si no existe, se pregunta si se desea insertar. Si se responde afirmativamente (o el contacto ya existía), se pide la dirección y el número de teléfono, y se actualiza el diccionario.

    Buscar un número de teléfono.
    Se pide un número de teléfono de contacto y se busca en el diccionario. Si se encuentra, se indica el nombre del contacto, en otro caso se indica que no se encuentra.

    Eliminar un contacto.
    Se pide un nombre de contacto. Si no existe, se indica que no se encuentra, si existe se debe eliminar del diccionario.

    Salir. Mientras el usuario no seleccione esta opción, tras finalizar cada opción debe mostrar de nuevo el menú de opciones. Con esta opción el programa finaliza.
