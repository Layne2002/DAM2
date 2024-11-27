## Función para ordenar un diccionario:
def ordena(dicc):
   
    for c in sorted(dicc.items()):
    #para ordenar descendentemente el campo clave(mayor primero)
    for c in sorted(dicc.items(), key=lambda x: x[0], reverse=True):
    #ordenar por campo clave
    for c in sorted(dicc.items(),key=lambda x:x[0]):
    #ordenar por longitud campo clave
    for c in sorted(dicc.items(),key=lambda x:-len(x)):
    #ordenar por longitud campo valor, descendentemente (el mas largo primero)
    for c in sorted(dicc.items(),key=lambda x:-len(x[1])):
    #ordenar por longitud campo valor, ascendente(el mas corto primero)
    for c in sorted(dicc.items(),key=lambda x:-len(x[::-1])):
     #ordenar por longitud campo valor ascendente(el mas corto primero) (otra forma)
    for c in sorted(dicc.items(),key=lambda x:-len(x[1]),reverse = True):
        print(c)