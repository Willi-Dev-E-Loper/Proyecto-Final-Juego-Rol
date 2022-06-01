# Proyecto-Finla-Juego-Rol
 Proyecto de final de curso de la asignatura de programación.

# Uso:
Descargar el archivo .jar y ejecutarlo desde consola con el comando java Es necesario tener el jdk instalado.

# Como se juega:
El juador, al entrar, verá un menu donde tendra que elegir el numero que corresponda a la opción deseada:

# Configuracion:
- Gestionar Jugadores:
  - Crear
  - Mostrar
  - Borrar
  - Asignar jugador a equipo
  - Asignar objeto a jugador
  - Borrar todo
  - Salir
- Gestionar Equipos:
  - Crear
  - Mostrar
  - Borrar
  - Asignar equipo a jugador
  - Borrar todo
  - Salir
- Gestión de objetos:
  - Crear
  - Mostrar
  - Borrar
  - Asignar objeto a jugador
  - Borrar todo
  - Salir
- Jugar:
  - Reglas: Se realizaran combates aleatorios, evitando los combates contra si mismos, y al final se imprimira el ranking basandose en los puntos de vida que le queden a los jugadores
  - Exportar configuracion: - Se guardaran todas tus configuraciones en archivos para posteriormente poder importarlos en la siguiente opcion.
  - Importar
  - Salir
# Tipo de jugadores
 - Humanos:Los jugadores de tipo Human no podrán tener más de 100 puntos de vida y sus atributos no se ven afectados.
 - Guerreros: Debido a su entrenamiento, tienen una gran agilidad. Si el golpe no es superior a 5 puntos, éste queda reducido a 0. El golpe (hit) es la diferencia entre el ataque que sufre y la defensa del jugador.
 - Alien:Los jugadores de tipo Alien enloquecen cuando atacan, pero olvidan su defensa. Cuando un ‘Alien’ ataca, si no está gravemente herido (puntos de vida superiores a 20) aumentan en 3 sus puntos de ataque y disminuyen en 3 sus puntos de defensa. Si están gravemente heridos (puntos de vida iguales o inferiores a 20) se comportan de forma normal.
# Equipos
Un equipo puede contener los jugadores que quiera pero no pueden tener el mismo nombre.
Un jugador puede pertenecer a varios equipos.
# Objetos
Los objetos se crearan con el nombre que se le indique y se le asignaran aleatoriamente los puntos de ataque y de defensa en un rango de 0 a 10.
Un objeto solo puede pertenecer a un jugador
Un jugador puede poseer cuantos objetos quiera.