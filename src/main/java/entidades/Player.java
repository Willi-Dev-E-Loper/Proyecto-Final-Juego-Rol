package entidades;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Player implements Serializable, Comparable<Player> {
    private String name;
    private int p_ataque;
    private int p_defensa;

    private  int p_vida;

    private ArrayList<Team> teams= new ArrayList<>();
    public ArrayList<Item> items= new ArrayList<>();
    @Override
    public int compareTo(Player p) {
        return p.getP_vida() - this.getP_vida();
    }

    //Constructor para Player
    //Recibe como parametros: Nombre, Puntos de ataque, Puntos de defensa y Puntos de vida
    public Player(String name, int p_ataque, int p_defensa, int p_vida) {
        this.name = name;
        this.p_ataque = p_ataque;
        this.p_defensa = p_defensa;
        this.p_vida = p_vida;
        if (this.p_ataque<=50){
            System.out.println("Los puntos de ataque no pueden ser inferiores ni iguales a 50, se asignara el minimo por defecto");
            setP_ataque(51);
        }
    }

    //Metodo attack
    //Recibe como parametro el jugador a atacar
    public void attack(Player a) {
        String t_class = this.getClass().getSimpleName();

        String a_class = a.getClass().getSimpleName();
        if (this.getP_vida() <= 0 || a.getP_vida() <=0){ //Compruebo si algun jugador no tiene vida antes de la pelea para que no se efectue
            if (this.getP_vida() <= 0){
                System.out.println(this.getName() + " esta muerto");
                System.out.println(a.getName() + " es el ganador");
            }else{
                System.out.println(a.getName() + " esta muerto");
                System.out.println(this.getName() + " es el ganador");

            }

        }else {//Si los dos jugadores tiene vida, pelean
            //Recorro los items y acumulo en las variables ba y bd el total de puntos de ataque del atacante (ba) y defendido (bd)  para sumarlo a posterior
            int ba = 0;
            int bd = 0;
            for (Item i: this.items){
                ba += i.attackBonus;
            }
            for (Item i: a.items){
                bd += i.attackBonus;
            }

            ba+=this.getP_ataque();
            bd+=a.getP_ataque();

            if ((this.getP_ataque()- a.getP_defensa())<0){// Si los puntos de el que ataca son menores que los puntos de defensa de el oponente el golpe sera nulo
                System.out.println("Atacando: " + this);
                System.out.println("Atacado: " + a);
                System.out.println("El ataque no ha tenido efecto");

                this.hit(bd, a);


                System.out.println("Atacando: " + this);
                System.out.println("Atacado: " + a);

            }else if ((a.getP_ataque()- this.getP_defensa())<0){// Si los puntos de el que defiende son mayores que los puntos de ataque de el oponente el golpe sera nulo
                System.out.println("Atacando: " + this);
                System.out.println("Atacado: " + a);

                a.hit(ba, this);

                System.out.println("El ataque no ha tenido exito");



                System.out.println("Atacando: " + this);
                System.out.println("Atacado: " + a);
            }else{
                //Si el que ataca es de el tipo Alien y su vida es superior a 20, se le añadiran 3 puntos de ataque y se le restaran 3 puntos de defensa de manera acumulativa.
                if (t_class.equalsIgnoreCase("alien") && this.getP_vida()>20){//Si es alien el atacado y tine mas de 20 puntos de vida se actualizab sus stats.
                    this.setP_ataque(this.getP_ataque()+3);
                    this.setP_defensa(this.getP_defensa()-3);
                    System.out.println("Atacando: " + this);
                    System.out.println("Atacado: " + a);
                    this.hit(bd, a);

                    a.hit(ba+3,this);



                    System.out.println("Atacando: " + this);
                    System.out.println("Atacado: " + a);

                //Si el que defiende es de el tipo Alien y su vida es superior a 20, se le añadiran 3 puntos de ataque y se le restaran 3 puntos de defensa de manera acumulativa.
                } else if (a_class.equalsIgnoreCase("alien") && a.getP_vida()>20){//Si es alien el atacado y tine mas de 20 puntos de vida se actualizab sus stats.
                    a.setP_ataque(a.getP_ataque()+3);
                    a.setP_defensa(a.getP_defensa()-3);
                    System.out.println("Atacando: " + this);
                    System.out.println("Atacado: " + a);
                    this.hit(bd+3, a);

                    a.hit(ba,this);



                    System.out.println("Atacando: " + this);
                    System.out.println("Atacado: " + a);


                }else {//Si no pasa nada de lo anterior, el ataque procedera de manera natural.
                    System.out.println("Atacando: " + this);
                    System.out.println("Atacado: " + a);

                    a.hit(ba,this);

                    this.hit(bd, a);


                    System.out.println("Atacando: " + this);
                    System.out.println("Atacado: " + a);
                }
            }
        }
    }
    //Metodo hit, recibe como parametro los puntos de ataque y el jugador (este parametro lo he añadido para poder imprimir la informacion de ambos)
    protected void hit(int attackPoints, Player p) {
        String p_class = p.getClass().getSimpleName();
        String t_class = this.getClass().getSimpleName();
        if (items.isEmpty()){ //Si no tiene items golpeara de manera natural.
            //Se imprime la informacion de el combate
            System.out.println(this.getName() +
                    " es golpeado con " +
                    attackPoints +
                    " y se defiende con "+
                    this.getP_defensa() +
                    ". Vidas "+ this.getP_vida() +
                    "-"+
                    (attackPoints- this.getP_defensa())+
                    "="+ (this.getP_vida() - (attackPoints- this.getP_defensa())));

            if (t_class.equalsIgnoreCase("warrior" ) && attackPoints<=5){ //Si el que ataca es warrior y tiene menos de 5 puntos de ataque

                int vida = getP_vida();
                if (vida<=0){ //Si la vida es menor o igual a 0 pone la vida a 0 y devuelve que ha sido derrotado
                    setP_vida(0);
                    System.out.println(this.getName() + " ha sido derrotado");
                }else {
                    setP_vida(vida);
                }

            }else if (p_class.equalsIgnoreCase("warrior" ) && attackPoints<=5){//Si el que defiende es warrior y tiene menos de 5 puntos de ataque

                int vida = getP_vida();
                if (vida<=0){
                    setP_vida(0);
                    System.out.println(this.getName() + " ha sido derrotado");
                }else {
                    this.setP_vida(vida);
                }

            }else {//Si no sucede nada de lo anterior, se golpea de manera natural.
                int vida = (this.getP_vida() - (attackPoints- this.getP_defensa()));
                if (vida<=0){
                    setP_vida(0);
                    System.out.println(this.getName() + " ha sido derrotado");
                }else {
                    System.out.println(vida);
                    setP_vida(vida);
                    System.out.println("vida despues" + vida);
                }
            }
        }else{
            //Si se contienen items, recorro la lista y acumulo los puntos de defensa de los items en la variable bd, para sumarlos popsteriormente.

            int bd = 0;
            for (Item i: items){
                bd += i.defenseBonus;
            }


            System.out.println(this.getName() +
                    " es golpeado con " +
                    attackPoints +
                    " y se defiende con "+
                    (this.getP_defensa() + bd)+
                    ". Vidas "+ this.getP_vida() +
                    "-"+
                    (attackPoints- (this.getP_defensa() + bd))+
                    "="+ (this.getP_vida() - (attackPoints- (this.getP_defensa() + bd))));

            if (t_class.equalsIgnoreCase("warrior" ) && attackPoints<=5){ //Si el que ataca es warrior y tiene menos de 5 puntos de ataque

                int vida = getP_vida();
                if (vida<=0){ //Si la vida es menor o igual a 0 pone la vida a 0 y devuelve que ha sido derrotado
                    setP_vida(0);
                    System.out.println(this.getName() + " ha sido derrotado");
                }else {
                    setP_vida(vida);
                }

            }else if (p_class.equalsIgnoreCase("warrior" ) && attackPoints<=5){//Si el que defiende es warrior y tiene menos de 5 puntos de ataque

                int vida = getP_vida();
                if (vida<=0){//Si la vida es menor o igual a 0 pone la vida a 0 y devuelve que ha sido derrotado
                    setP_vida(0);
                    System.out.println(this.getName() + " ha sido derrotado");
                }else {//Sino se coloca la vida con el setter.
                    setP_vida(vida);
                }
            }else {//Si no sucede nada de lo anterior, se golpea de manera natural añadiendo la bonificacion por items.
                int vida = (this.getP_vida() - (attackPoints - (this.getP_defensa() + bd)));
                if (vida<=0){
                    setP_vida(0);
                    System.out.println(this.getName() + " ha sido derrotado");
                }else {
                    setP_vida(vida);
                }
            }
        }


    }

    //Metodo addTeam
    //Recibe como parametro un Team
    //Si el array teams esta vacio o no contiene el objeto, añade el  equipo y de manera recursiva  tambien añade el jugador.
    public void addTeam (Team t)  {
        if (teams.isEmpty() || !teams.contains(t)){
            teams.add(t);
            t.addPlayer(this);
        }

    }
    //Metodo removeTeam
    //Recibe como parametro un Team
    //Si el array teams  contiene el objeto, borra el  equipo y de manera recursiva  tambien borra el jugador.
    public void removeTeam (Team t ){
        if (teams.contains(t)){
            teams.remove(t);
            t.removePlayer(this);
        }
    }
    //Metodo equalClass
    //Recibe como parametro el jugador a comparar y se encarga de comparar si son el tipo de objeto.
    public boolean equalClass ( Player p){
        String t_class = this.getClass().getSimpleName();
        String p_class = p.getClass().getSimpleName();
        boolean flag = false;
        if (t_class.equalsIgnoreCase(p_class)){
            flag = true;
        }
        return flag;
    }
    //Metodo equalPlayer
    //Recibe como parametro un jugador y compara uno a uno sus atributos para determinar si son o no son exactamente iguales.
    //Devuelve un booleano.
    public boolean equalPlayers ( Player p){
        String t_name = this.getName();
        String p_name = p.getName();
        int t_pa = this.getP_ataque();
        int p_pa = p.getP_ataque();
        int t_pd = this.getP_defensa();
        int p_pd = p.getP_defensa();
        int t_pv = this.getP_vida();
        int p_pv = p.getP_vida();
        boolean flag = false;
        if (t_name.equalsIgnoreCase(p_name) && t_pa == p_pa && t_pd == p_pd && t_pv ==p_pv){
            flag = true;
        }
        return flag;
    }
    //Metodo equals
    //Igual que el anterior pero solo compara el nombre del objeto.
    public boolean equals(Player p){
        boolean b = false;
        if (this.getName().equalsIgnoreCase(p.getName())){
            b=true;
        }
        return b;
    }
    //Metodo que recibe un item como parametro, verifica que si la array esta vacia o ya contiene el item y si no, lo añade
    public void addItem(Item i){
        if (items.isEmpty() || !items.contains(i)){
            items.add(i);
        }
    }
    //Metodo que recibe un item como parametro y lo borra.
    public void removeItem(Item i){
        items.remove(i);
    }
    //Metodo sobreescrito toString que imprime la informacion de el jugador, incluido el numero de equipos a los que pertenece y los items que posee.
    @Override
    public String toString() {
        String cad = "";
        for (Item i:items){
            cad += "\n"+i.toString() ;
        }
        return name + "  " +
                "PA:" + p_ataque +
                " /  PD:" + p_defensa +
                " /  PV:" + getP_vida() +
                "  (pertenece ha " + teams.size() + " equipo/s)" +
                "\nEquipamiento activo: " +
                cad;

    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public int getP_ataque() {
        return p_ataque;
    }

    public int getP_defensa() {
        return p_defensa;
    }

    public int getP_vida() {
        return p_vida;
    }
    public void setP_vida(int vida) {
        this.p_vida = vida;
    }
    public void setP_ataque(int p_ataque) {
        this.p_ataque = p_ataque;
    }

    public void setP_defensa(int p_defensa) {
        this.p_defensa = p_defensa;
    }
}
