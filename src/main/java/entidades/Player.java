package entidades;

import java.util.ArrayList;

public abstract class Player {
    private String name;
    private int p_ataque;
    private int p_defensa;

    private int p_vida;

    private ArrayList<Team> teams= new ArrayList<>();


    public Player(String name, int p_ataque, int p_defensa, int p_vida) {

        this.name = name;
        this.p_ataque = p_ataque;
        this.p_defensa = p_defensa;
        this.p_vida = p_vida;
    }

    public void attack(Player a) {
        String a_class = a.getClass().getSimpleName();
        if (this.getP_vida() <= 0 || a.getP_vida() <=0){ //Compruebo si algun jugador no tiene vida antes de la pelea para que no se efectue
            if (this.getP_vida() <= 0){
                System.out.println(this.getName() + " esta muerto");
            }else{
                System.out.println(a.getName() + " esta muerto");
            }

        }else {

            if ((this.getP_ataque()- a.getP_defensa())<0){// Si los puntos de el que ataca son menores que los puntos de defensa de el oponente el golpe sera nulo
                System.out.println("Atacando: " + this);
                System.out.println("Atacado: " + a);
                System.out.println("El ataque no ha tenido efecto");

                this.hit(a.getP_ataque(), a);


                System.out.println("Atacando: " + this);
                System.out.println("Atacado: " + a);

            }else if ((a.getP_ataque()- this.getP_defensa())<0){
                System.out.println("Atacando: " + this);
                System.out.println("Atacado: " + a);

                a.hit(this.getP_ataque(), this);

                System.out.println("El ataque no ha tenido exito");



                System.out.println("Atacando: " + this);
                System.out.println("Atacado: " + a);
            }else{
                if (a_class.equalsIgnoreCase("alien") && a.getP_vida()>20){//Si es alien el atacado y tine mas de 20 puntos de vida se actualizab sus stats.
                    a.setP_ataque(a.getP_ataque()+3);
                    a.setP_defensa(a.getP_defensa()-3);
                }


                System.out.println("Atacando: " + this);
                System.out.println("Atacado: " + a);

                a.hit(this.getP_ataque(),this);


                this.hit(a.getP_ataque(), a);


                System.out.println("Atacando: " + this);
                System.out.println("Atacado: " + a);
            }
        }
    }
    //Metodo hit, recive como parametro los puntos de ataque y el jugador (este parametro lo he añadido para poder imprimir la informacion de ambos)
    protected void hit(int attackPoints, Player p) {
        String p_class = p.getClass().getSimpleName();
        String t_class = this.getClass().getSimpleName();


        System.out.println(this.getName() +
                " es golpeado con " +
                p.getP_ataque() +
                " y se defiende con "+
                this.getP_defensa() +
                ". Vidas "+ this.getP_vida() +
                "-"+
                (p.getP_ataque()- this.getP_defensa())+
                "="+ (this.getP_vida() - (p.getP_ataque()- this.getP_defensa())));

        if (t_class.equalsIgnoreCase("warrior" ) && attackPoints<=5){ //Si el que ataca es warrior y tiene menos de 5 puntos de ataque
            attackPoints = 0;
            int vida = getP_vida();
            if (vida<=0){ //Si la vida es menor o igual a 0 pone la vida a 0 y devuelve que ha sido derrotado
                setP_vida(0);
                System.out.println(this.getName() + " ha sido derrotado");
            }else {
                setP_vida(vida);
            }

        }
        if (p_class.equalsIgnoreCase("warrior" ) && attackPoints<=5){
            attackPoints = 0;
            int vida = getP_vida();
            if (vida<=0){
                setP_vida(0);
                System.out.println(this.getName() + " ha sido derrotado");
            }else {
                setP_vida(vida);
            }

        }else {
            int vida = getP_vida() - (attackPoints - getP_defensa());
            if (vida<=0){
                setP_vida(0);
                System.out.println(this.getName() + " ha sido derrotado");
            }else {
                setP_vida(vida);
            }
        }
    }


    public void addTeam (Team t)  {
        if (teams.isEmpty() || !teams.contains(t)){
            teams.add(t);
            t.addPlayer(this);
        }

    }

    public void removeTeam (Team t ){
        if (teams.contains(t)){
            teams.remove(t);
            t.removePlayer(this);
        }
    }

    public boolean equalClass ( Player p){
        String t_class = this.getClass().getSimpleName();
        String p_class = p.getClass().getSimpleName();
        boolean flag = false;
        if (t_class.equalsIgnoreCase(p_class)){
            flag = true;
        }
        return flag;
    }
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

    @Override
    public String toString() {
        return name + "  " +
                "PA:" + p_ataque +
                " /  PD:" + p_defensa +
                " /  PV:" + p_vida +
                "  (pertenece ha " + teams.size() + " equipo/s)";
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
    public void setP_vida(int p_vida) {
        this.p_vida = p_vida;
    }
    public void setP_ataque(int p_ataque) {
        this.p_ataque = p_ataque;
    }

    public void setP_defensa(int p_defensa) {
        this.p_defensa = p_defensa;
    }
}
