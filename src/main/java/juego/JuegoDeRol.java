package juego;
import entidades.*;
import io.leer;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;

/**
 * &#064;Author   Guillermo Mora Bertó
 *
 */
public class JuegoDeRol implements Serializable {//Serializable para poder manejar ficheros

    //Metodo importarPlayer recibe un arraylist de tipo Player y crea un fichero llamado players.dat donde almacena los objetos.
    public  static void importarPlayer(ArrayList<Player> p) throws IOException { //Lanzo la excepcion aqui y en el main lo capturo con un bloque try-catch
        String fichero_destino = "players.dat";
        FileOutputStream fichero = new FileOutputStream(fichero_destino);
        ObjectOutputStream obj = new ObjectOutputStream(fichero);
        obj.writeObject(p);
        System.out.println("Lista de jugadores importada al fichero con nombre "+ fichero_destino);

    }
    public  static void importarRanking(ArrayList<Player> p) throws IOException { //Lanzo la excepcion aqui y en el main lo capturo con un bloque try-catch
        String fichero_destino = "ranking.dat";
        FileOutputStream fichero = new FileOutputStream(fichero_destino);
        ObjectOutputStream obj = new ObjectOutputStream(fichero);
        obj.writeObject(p);
        System.out.println("Ranking importado al fichero con nombre "+ fichero_destino);

    }
    //Metodo importarTeam recibe un arraylist de tipo Team y crea un fichero llamado teams.dat donde almacena los objetos.
    public  static void importarTeam(ArrayList<Team> p) throws IOException { //Lanzo la excepcion aqui y en el main lo capturo con un bloque try-catch
        String fichero_destino = "teams.dat";
        FileOutputStream fichero = new FileOutputStream(fichero_destino);
        ObjectOutputStream obj = new ObjectOutputStream(fichero);
        obj.writeObject(p);
        System.out.println("Lista de equipos importada al fichero con nombre "+ fichero_destino);

    }
    //Metodo importarItem recibe un arraylist de tipo Item y crea un fichero llamado items.dat donde almacena los objetos.
    public  static void importarItem(ArrayList<Item> p) throws IOException { //Lanzo la excepcion aqui y en el main lo capturo con un bloque try-catch
        String fichero_destino = "items.dat";
        FileOutputStream fichero = new FileOutputStream(fichero_destino);
        ObjectOutputStream obj = new ObjectOutputStream(fichero);
        obj.writeObject(p);
        System.out.println("Lista de items importada al fichero con nombre "+ fichero_destino);

    }
    //Metodo exportarPlayer recibe un arraylist de tipo Player y exporta desde el fichero players.dat donde estan almacenados los objetos.
    public  static ArrayList<Player> exportarPlayer(ArrayList<Player> p) throws IOException{
        String fichero_origen = "players.dat";
        FileInputStream fichero = new FileInputStream(fichero_origen);
        ObjectInputStream obj = new ObjectInputStream(fichero);
        try {
            p = (ArrayList<Player>) obj.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (p.size()>0){
            System.out.println("Exportado con exito");
        }
        return p;

    }
    public  static ArrayList<Player> exportarRanking(ArrayList<Player> p) throws IOException{
        String fichero_origen = "ranking.dat";
        FileInputStream fichero = new FileInputStream(fichero_origen);
        ObjectInputStream obj = new ObjectInputStream(fichero);
        try {
            p = (ArrayList<Player>) obj.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (p.size()>0){
            System.out.println("Exportado con exito");
        }
        return p;

    }
    //Metodo exportarTeam recibe un arraylist de tipo Team y exporta desde el fichero teams.dat donde estan almacenados los objetos.
    public  static ArrayList<Team> exportarTeam(ArrayList<Team> p) throws IOException, ClassNotFoundException {
        String fichero_origen = "teams.dat";
        FileInputStream fichero = new FileInputStream(fichero_origen);
        ObjectInputStream obj = new ObjectInputStream(fichero);
        p = (ArrayList<Team>) obj.readObject();
        if (p.size()>0){
            System.out.println("Exportado con exito");
        }
        return p;
    }
    //Metodo exportarItem recibe un arraylist de tipo Item y exporta desde el fichero items.dat donde estan almacenados los objetos.
    public  static ArrayList<Item> exportarItem(ArrayList<Item> p) throws IOException, ClassNotFoundException {
        String fichero_origen = "items.dat";
        FileInputStream fichero = new FileInputStream(fichero_origen);
        ObjectInputStream obj = new ObjectInputStream(fichero);
        p = (ArrayList<Item>) obj.readObject();
        if (p.size()>0){
            System.out.println("Exportado con exito");
        }
        return p;
    }
    //Metodo pruebaFase1
    //Crea un jugador de cada tipo y realiza ataques entre ellos.
    public static void pruebaFase1() {

        Human a = new Human("paco", 30, 20,100);
        Warrior b = new Warrior("Suerko", 76, 4,150);
        Alien c = new Alien("AODN28", 44, 18,100);
        System.out.println("Ataque 1");
        c.attack(a);
        System.out.println("Ataque 2");
        a.attack(c);
        System.out.println("Ataque 3");
        b.attack(a);
        System.out.println("Ataque 4");
        a.attack(b);
        c.attack(a);

    }
    //Metodo pruebaFase2
    //Crea un jugador de cada clase y un par de equipos
    //Añade y quita los jugadores de  los equipos y realiza ataques entre ellos.
    public static void pruebaFase2() {

        Human a = new Human("paco", 30, 20,100);
        Warrior b = new Warrior("Suerko", 76, 4,100);
        Alien c = new Alien("AODN28", 44, 18,100);
        Team t = new Team("prove");
        Team tt = new Team("prove2");
        System.out.println("Ataque 1");


        a.addTeam(t);
        t.addPlayer(c);
        t.addPlayer(b);
        a.addTeam(tt);
        tt.addPlayer(c);
        tt.addPlayer(b);
        System.out.println("equipo 1 sin borrar");
        t.toString();
        System.out.println("equipo 2 sin borrar");
        tt.toString();
        a.removeTeam(t);
        tt.removePlayer(c);

        System.out.println("22");

        System.out.println("equipo 1 borrado");
        t.toString();
        System.out.println("equipo 2 borrado");
        tt.toString();
        System.out.println("Compruebo equalsTeam");
        System.out.println(t.equalTeam(t));
        System.out.println(t.equalTeam(tt));
        System.out.println("Compruebo equalsPlayer");
        System.out.println(a.equalPlayers(a));
        System.out.println(a.equalPlayers(b));
        System.out.println("Ataques");
        c.attack(a);
        System.out.println("Ataque 2");
        a.attack(c);
        System.out.println("Ataque 3");
        b.attack(a);
        System.out.println("Ataque 4");
        a.attack(b);
        c.attack(a);

    }
    //Metodo pruebaFase3 junto con la fase4
    //Consiste en un menu de configuracion en el que puedes configurar jugadores, equipos e items
    //Una opcion de jugar, en la cual de manera aleatoria se ppelearan entre si los jugadores hasta que solo uno quede con vida
    //Opcion de exportar con la que guardaras tus configuraciones
    //Opcion de importar con la que cargaras tus configuraciones
    //Salir
    public static void pruebaFase3() {

        System.out.println("JUEGO DE ROL");
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Team> teams = new ArrayList<>();
        ArrayList<Player> ranking = new ArrayList<>();
        int opcion = 0;
        while (opcion != 5) {//Hasta que la opcion no sea 5 que corresponde a salir, se repetira el bucle.
            opcion = leer.leerEntero("Elige una opcion:\n" +//Menu principal, introducir el numero correspondiente a cada oppcion
                    "1-Configuracion\n" +
                    "2-Jugar\n" +
                    "3-Exportar configuracion\n" +
                    "4-Importar configuracion\n" +
                    "5-Salir");

            switch (opcion) {//Segun la opcion introducida entrara en el case corresppondiente
                case 1:
                    //Configuracion
                    int op = 0;
                    while (op != 4) {//Hasta que la opcion no sea 4 que corresponde a salir, se repetira el bucle.
                        op = leer.leerEntero("Elige una opcion:\n" +//Menu configuracion, introducir el numero correspondiente a cada oppcion
                                "1-Gestionar jugadores\n" +
                                "2-Gestionar equipos\n" +
                                "3-Gestionar objetos\n" +
                                "4-Salir");
                        switch (op) {
                            case 1:
                                //Gestion de jugadores
                                int o = 0;
                                while (o != 7) {
                                    o = leer.leerEntero("Elige una opcion:\n" +//Menu gestion de jugadores, introducir el numero correspondiente a cada oppcion
                                            "1-Crear jugador\n" +
                                            "2-Mostrar jugadores\n" +
                                            "3-Borrar jugadores\n" +
                                            "4-Asignar jugador a esquipo\n" +
                                            "5-Aignar objeto a jugador\n" +
                                            "6-Borrar jugadores\n" +
                                            "7-Salir");
                                    switch (o) {
                                        case 1://Crear jugador
                                            int check = 0;
                                            while (check != 1) {//Se repite hasta que el usuario quiere dejar de crear jugadores
                                                int tipo = leer.leerEntero("Que tipo de jugador quieres?\n" +//Menu eleccion de jugador, introducir el numero correspondiente a cada oppcion
                                                        "1-Humano\n" +
                                                        "2-Warrior\n" +
                                                        "3-Alien");
                                                String name = leer.leerTexto("Nombre de el jugador: ");//Introduce nombre de jugador
                                                int pa = leer.leerEntero("Puntos de ataque: ");//Introduce puntos de ataque
                                                int pv = 100;//Puntos de vida 100 por defecto
                                                int pd = pv - pa;//Puntos de defensa, la diferencia entr a la vida y el ataque


                                                String c = leer.leerTexto("Los puntos de vida por defecto son 100, desea cambiarlos?: s/n");//Opcion para cambiar los puntos de vida
                                                int v =0;
                                                boolean bv= false;
                                                if (c.equalsIgnoreCase("s")) {
                                                    v= leer.leerEntero("Introduce la nueva vida: ");//Variable con la nueva vida
                                                    bv =  true;//Flag para saber si la vida sera ppopr defecto o introducida
                                                }
                                                boolean che = false;
                                                try {
                                                    for (Player p : players) {
                                                        if (p.getName().equalsIgnoreCase(name)) {
                                                            che = true;//Flag para saber si el nombre del jugador existe
                                                            break;
                                                        }
                                                    }
                                                }catch (IndexOutOfBoundsException e){
                                                    //Capturo la  posible excepcion
                                                }

                                                if (tipo == 1) {//Si es 1 se crea un humano
                                                    if (bv){//Si se quiere introducir la vida se usara la variable con la nueva vida (v) en el constructor
                                                        if (players.isEmpty() || !che) {//Se comprueba si el jugador ya existe
                                                            Human human = new Human(name, pa, pd,v);
                                                            try {
                                                                players.add(human);

                                                            }catch (NullPointerException e){//Capturo la posible Nullpointerexception
                                                                System.out.println("Ha habido un error, vuelva a intentarlo.");
                                                            }

                                                            System.out.println(human);
                                                        } else {//Si existe se pide que introduzca otro
                                                            System.out.println("El nombre de jugador ya existe, elija otro.");
                                                        }
                                                    }else {//Si se quiere la vida por defecto se hace lo mismo pero con la variable (pv) que contiene la vida a 100;
                                                        if (players.isEmpty() || !che) {
                                                            Human human = new Human(name, pa, pd,pv);
                                                            try {
                                                                players.add(human);

                                                            }catch (NullPointerException e){//Capturo la posible Nullpointerexception
                                                                System.out.println("Ha habido un error, vuelva a intentarlo.");
                                                            }
                                                            System.out.println(human);
                                                            System.out.println(players.size());
                                                        } else {
                                                            System.out.println("El nombre de jugador ya existe, elija otro.");
                                                        }
                                                    }
                                                } else if (tipo == 2) {//Hace lo mismo que lo anterior pero con la opcion 2 se creara una Warrior
                                                    if (bv){
                                                        if (players.isEmpty() || !che) {
                                                            Warrior warrior = new Warrior(name, pa, pd,v);
                                                            try {
                                                                players.add(warrior);
                                                            }catch (NullPointerException e){//Capturo la posible Nullpointerexception
                                                                System.out.println("Ha habido un error, vuelva a intentarlo.");
                                                            }
                                                            System.out.println(warrior);
                                                        } else {
                                                            System.out.println("El nombre de jugador ya existe, elija otro.");
                                                        }
                                                    }else {
                                                        if (players.isEmpty() || !che) {
                                                            Warrior warrior = new Warrior(name, pa, pd,pv);

                                                            try {
                                                                players.add(warrior);
                                                            }catch (NullPointerException e){//Capturo la posible Nullpointerexception
                                                                System.out.println("Ha habido un error, vuelva a intentarlo.");
                                                            }
                                                            System.out.println(warrior);
                                                        } else {
                                                            System.out.println("El nombre de jugador ya existe, elija otro.");
                                                        }
                                                    }
                                                } else if (tipo == 3) {//Hace lo mismo que lo anterior pero con la opcion 3 se creara un Alien
                                                    if (bv){
                                                        if (players.isEmpty() || !che) {
                                                            Alien alien = new Alien(name, pa, pd, v);
                                                            try {
                                                                players.add(alien);
                                                            }catch (NullPointerException e){//Capturo la posible Nullpointerexception
                                                                System.out.println("Ha habido un error, vuelva a intentarlo.");
                                                            }
                                                            System.out.println(alien);
                                                        } else {
                                                            System.out.println("El nombre de jugador ya existe, elija otro.");
                                                        }
                                                    }else {
                                                        if (players.isEmpty() || !che) {
                                                            Alien alien = new Alien(name, pa, pd, pv);
                                                            try {
                                                                players.add(alien);
                                                            }catch (NullPointerException e){//Capturo la posible Nullpointerexception
                                                                System.out.println("Ha habido un error, vuelva a intentarlo.");
                                                            }
                                                            System.out.println(alien);
                                                        } else {
                                                            System.out.println("El nombre de jugador ya existe, elija otro.");
                                                        }
                                                    }
                                                }
                                                check = leer.leerEntero("Para salir pulse 1.");//Para salir pulsa 1
                                            }
                                            break;

                                        case 2:
                                            //Imprimo la informacion de los jugadores
                                            toString(players);
                                            break;
                                        case 3:
                                            //Borrar jugador
                                            String n = leer.leerTexto("Nombre de el jugador a borrar");

                                            try {
                                                for (Player p : players) {//Recorro el array y si encuentra el jugador, lo borra
                                                    boolean equ = p.getName().equalsIgnoreCase(n);
                                                    if (equ) {
                                                        players.remove(p);
                                                    } else {
                                                        System.out.println("Jugador no encontrado");
                                                    }
                                                }
                                            } catch (ConcurrentModificationException e) {//Capturo la posible ConcurrentModificationException
                                                //Capturo la excepcion pero no mustro nada
                                            }

                                            break;
                                        case 4:
                                            //Asignar jugador a equipo
                                            try {
                                                if (teams.isEmpty()) {//Si no tienes equipos antes deberas crear uno
                                                    System.out.println("Antes debes crear un equipo");
                                                } else {
                                                    //Se introduce el nombre de el jugador y de el equipo
                                                    String j = leer.leerTexto("Nombre de el jugador: ");
                                                    String t = leer.leerTexto("Nombre de el equipo: ");

                                                    //Uso el metodo findTeam y findPlayer para buscarlos dentro de el array
                                                    Player p1 = findPlayer(j, players);
                                                    Team t1 = findTeam(t, teams);
                                                    //El metodo addPlayer se encarga de asignarlo.
                                                    t1.addPlayer(p1);

                                                    System.out.println("Jugador añadido con exito");
                                                }
                                            }catch (NullPointerException e){//Capturo la excepcion en caso de que no exista
                                                System.out.println("Ha habido algun error, vuelve a intentarlo.");
                                            }
                                            break;
                                        case 5:
                                            //Asignar objeto a jugador
                                            try {
                                                if (items.isEmpty()) {//La lista de objetos no puede estar vacia
                                                    System.out.println("Antes debes crear un objeto");
                                                } else {
                                                    String j = leer.leerTexto("Nombre de el jugador: ");
                                                    String ob = leer.leerTexto("Nombre de el objeto: ");

                                                    //Uso el metodo findItem y findPlayer para buscarlos dentro de el array
                                                    Player ppp = findPlayer(j, players);
                                                    Item ttt = findItem(ob, items);
                                                    //El metodo addItem se encarga de asignarlo.
                                                    ppp.addItem(ttt);


                                                    System.out.println("Objeto añadido con exito");
                                                }
                                            }catch (NullPointerException e){//Capturo la excepcion en caso de que no exista
                                                System.out.println("Ha habido algun error, vuelva a intentarlo.");
                                            }

                                            break;
                                        case 6:
                                            //Borrar todos los jugadores
                                            players.clear();
                                            System.out.println("Jugadores borrados");

                                        case 7:
                                            //Salir
                                            break;

                                    }
                                }
                                break;

                            case 2:
                                //Gestion de equipos
                                int ge = 0;
                                while (ge != 6) {
                                    ge = leer.leerEntero("Elige una opcion:\n" +//Menu gestion de equippos, introducir el numero correspondiente a cada oppcion
                                            "1-Crear equipo\n" +
                                            "2-Mostrar equipos\n" +
                                            "3-Borrar equipo\n" +
                                            "4-Asignar equipo a jugador\n" +
                                            "5-Borrar equipos\n" +
                                            "6-Salir");
                                    switch (ge) {
                                        case 1:
                                            int check = 0;
                                            while (check != 1) {//Se repite hasta que el usuario quiere dejar de crear equiipos
                                                try {
                                                    String name = leer.leerTexto("Nombre de el equipo: ");//Introduce el nombre del equipo
                                                    boolean che = false;
                                                    for (Team t : teams) {
                                                        if (t.getName().equalsIgnoreCase(name)) {
                                                            che = true;//Si encuentra el equipo devuelve true.
                                                            break;
                                                        }
                                                    }

                                                    if (teams.isEmpty() || !che) {//Si esta vacia o no existe lo añade
                                                        Team team = new Team(name);
                                                        teams.add(team);
                                                    } else {
                                                        System.out.println("El equipo ya existe, elija otro.");
                                                    }

                                                    check = leer.leerEntero("Para salir pulse 1.");
                                                }catch (NullPointerException e){//Capturo excepcion por si no existe
                                                    System.out.println("Ha habido algun error, vuelva a intentarlo.");
                                                }
                                                }

                                            break;

                                        case 2:
                                            //Imprimo la informacion de los equipos
                                            teamsToString(teams);
                                            break;
                                        case 3:
                                            //Borrar equipo
                                            String n = leer.leerTexto("Nombre de el equipo a borrar");
                                            try {
                                                for (Team t : teams) {
                                                    if (t.getName().equalsIgnoreCase(n)) {
                                                        teams.remove(t);//Si el equipo existe lo borrara.
                                                    } else {
                                                        System.out.println("Equipo no encontrado");
                                                    }
                                                }
                                            } catch (ConcurrentModificationException e) {//Posible excepcion de acceso concurrente
                                                //Capturo la excepcion pero no mustro nada
                                            }

                                            break;
                                        case 4:
                                            //Asignar equipo a jugador
                                            try {
                                                if (players.isEmpty()) { //Si no tienes jugfadores antes deberas crear uno
                                                    System.out.println("Antes debes crear un jugador");
                                                } else {
                                                    String j = leer.leerTexto("Nombre de el jugador: ");
                                                    String t = leer.leerTexto("Nombre de el equipo: ");//Se introduce el nombre de el jugador y de el equipo
                                                    //Uso el metodo findTeam y findPlayer para buscarlos dentro de el array
                                                    Player pp = findPlayer(j, players);
                                                    Team tt = findTeam(t, teams);
                                                    //El metodo addPlayer se encarga de asignarlo.
                                                    pp.addTeam(tt);
                                                    System.out.println("Equipo añadido con exito");
                                                }
                                            }catch (NullPointerException e){//Capturo la excepcion en caso de que no exista

                                                System.out.println("Ha habido algun problema, vuelva a intentarlo.");
                                            }


                                            break;
                                        case 5:
                                            //Borrar todos los equipos
                                            teams.clear();
                                            System.out.println("Equipos borrados.");
                                        case 6:
                                            //Salir
                                            break;


                                    }
                                }
                                break;


                            case 3:
                                //Gestion de objetos
                                int go = 0;
                                while (go != 5) {
                                    go = leer.leerEntero("Elige una opcion:\n" +//Menu gestion de items, introducir el numero correspondiente a cada oppcion
                                            "1-Crear objeto\n" +
                                            "2-Mostrar objeto\n" +
                                            "3-Borrar objeto\n" +
                                            "4-Asignar objeto a jugador\n" +
                                            "5-Borrar objetos\n" +
                                            "5-Salir");
                                    switch (go) {
                                        case 1:
                                            int check = 0;
                                            while (check != 1) {
                                                //Los puntos de ataque y de defensa de los objetos se generaran aleatorios en un rango de 0 a 10
                                                int ab = (int) (Math.random() * (10));
                                                int db = (int) (Math.random() * (10));

                                                String name = leer.leerTexto("Nombre de el objeto: ");//Se introduce el nombre de el objeto
                                                boolean che = false;
                                                for (Item i : items) {
                                                    if (i.getName().equalsIgnoreCase(name)) {
                                                        che = true;//Se comprueba si existe
                                                        break;
                                                    }
                                                }

                                                if (items.isEmpty() || !che) {//Si no existe o esta vacia se crea y se añade el item con los puntos random creados anteriormente
                                                    Item item = new Item(name, ab, db);
                                                    items.add(item);
                                                } else {
                                                    System.out.println("El objeto ya existe, elija otro.");
                                                }

                                                check = leer.leerEntero("Para salir pulse 1.");
                                            }
                                            break;

                                        case 2:
                                            //Imprimo la informacion de los items
                                            itemsToString(items);
                                            break;
                                        case 3:

                                            //Asignar objeto a jugador
                                            String j = leer.leerTexto("Nombre de el jugador: ");
                                            String ob = leer.leerTexto("Nombre de el objeto: ");

                                            try {
                                                if (items.isEmpty()) {//Antes de asignar un objeto debes crearlo
                                                    System.out.println("No hay objetos que borrar");
                                                } else {
                                                    Player p2 =findPlayer(j, players);
                                                    Item i2 = findItem(ob, items);

                                                    p2.removeItem(i2);
                                                    System.out.println("Objeto borrado con exito");
                                                }
                                            } catch (ConcurrentModificationException e) {
                                                //Capturo la excepcion pero no mustro nada

                                            }

                                            break;
                                        case 4:
                                            //Asignar objeto a jugador
                                            try {
                                                if (items.isEmpty()) {
                                                    System.out.println("Antes debes crear un objeto");
                                                } else {
                                                    String jn = leer.leerTexto("Nombre de el jugador: ");
                                                    String obn = leer.leerTexto("Nombre de el objeto: ");
                                                    findPlayer(jn, players).addItem(findItem(obn, items));
                                                    System.out.println("Objeto añadido con exito");
                                                }
                                            }catch (NullPointerException e){
                                                System.out.println("Algo ha salido mal, vuelve a intentarlo");
                                            }

                                            break;
                                        case 5:
                                            //Borrar todos los objetos
                                            items.clear();
                                            System.out.println("Equipos borrados.");
                                        case 6:
                                            //Salir
                                            break;
                                    }
                                }
                        }
                    }
                    break;
                case 2:
                    //Jugar
                    int cuenta_vivos = players.size();//Variable que cuenta los jugadores vivos

                    while (cuenta_vivos != 0){//Mientras el numero de jugadores vivos sea distinto a 0
                        //Se crean dos numero random con rango de 0 a el lenght del array players
                        int random1 = (int) (Math.random() * ((players.size())));
                        int random2 = (int) (Math.random() * ((players.size())));
                        //Si escogen dos jugadores random
                        Player uno = players.get(random1);
                        Player dos = players.get(random2);
                        if (uno.equals(dos)) {//Se comprueba si son iguales para no pelear con ellos mismos
                            System.out.println("No puedes pelear contra ti mismo");
                        } else {
                            uno.attack(dos);//Se produce el ataque
                            //Si uno de los dos jugadores tiene la vida igual o inferior a 0 (que no se puede) se decrementa en uno la lista de vivos
                            //Asi hasta que solo quede uno con vida
                            if (uno.getP_vida() <= 0 ) {
                                cuenta_vivos--;
                            }else if ( dos.getP_vida() <= 0){
                                cuenta_vivos--;
                            }
                        }
                    }
                    //Ordeno el array de jugadoores para obtener un ranking basado en la vida
                    Collections.sort(players);
                    System.out.println("Ranking de jugadores:");

                    //Recorro la lista de jugadores para mostrar el ranking
                    try {
                        for (int i =1; i< 6; i++){
                            System.out.println(i+"º "+ players.get(i-1).getName() +" Vida resultante: "+ players.get(i-1).getP_vida());
                            ranking.add(players.get(i-1));
                        }
                    }catch (IndexOutOfBoundsException e){
                        //Capturo excepppcion por si hay menos jugadores
                    }



                    break;
                case 3:
                    //Importar configuracion
                    try {
                        //Hago uso de los metodos estaticos descritos anteriormente capturando la posible excepcion
                        importarPlayer(players);
                        importarTeam(teams);
                        importarItem(items);
                        importarRanking(ranking);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 4:
                    //Exportar la configuracion
                    try {
                        //Hago uso de los metodos estaticos descritos anteriormente capturando la posible excepcion

                        players = exportarPlayer(players);
                        teams = exportarTeam(teams);
                        items = exportarItem(items);
                        exportarRanking(ranking);
                    } catch (IOException | RuntimeException | ClassNotFoundException e) {
                        System.out.println("No se ha podido expoprtar con exito, algun archivo no existe o esta dañado");
                    }
                    break;
                case 5:
                    //Salir
                    break;

            }
        }


    }
    //Metodo que imprime la informacion del array de juadores
    public static void toString(ArrayList<Player> a) {
        for (Player p : a) {
            System.out.println(p.toString());
        }
    }
    //Metodo que imprime la informacion del array de equipos

    public static void teamsToString(ArrayList<Team> a) {
        for (Team p : a) {
            System.out.println(p.toString());
        }
    }
    //Metodo que imprime la informacion del array de obetos

    public static void itemsToString(ArrayList<Item> a) {
        for (Item p : a) {
            System.out.println(p.toString());
        }
    }
    //Metodo que recibe un nombre y un arraylist de jugadores como parametro y devuelve el jugador en caso de encontrarlo
    //Manejado lanzando NullPointer en caso de que no exista el jugador
    public static Player findPlayer(String name, ArrayList<Player> players) throws NullPointerException {
        Player player = null;
        for (Player p : players) {
            if (p.getName().equalsIgnoreCase(name)) {
                player = p;
            }
        }
        return player;
    }
    //Metodo que recibe un nombre y un arraylist de equipos como parametro y devuelve el equipo en caso de encontrarlo
    //Manejado lanzando NullPointer en caso de que no exista el equipo
    public static Team findTeam(String name, ArrayList<Team> teams) throws IndexOutOfBoundsException {
        Team team = null;

        for (Team p : teams) {
            if (p.getName().equalsIgnoreCase(name)) {
                team = p;
                break;
            }
        }
        return team;
    }
    //Metodo que recibe un nombre y un arraylist de items como parametro y devuelve el item en caso de encontrarlo
    //Manejado lanzando NullPointer en caso de que no exista el item
    public static Item findItem(String name, ArrayList<Item> items) throws IndexOutOfBoundsException {
        Item item = null;
        try {
            for (Item p : items) {
                if (p.getName().equalsIgnoreCase(name)) {
                    item = p;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Algo ha salido mal, objeto extraviado.");
        }
        return item;
    }

    public static void main(String[] args) {
        pruebaFase3();
    }
}


