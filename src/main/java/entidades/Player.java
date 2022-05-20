package entidades;

public class Player {
    private String name;
    private int p_ataque;
    private int p_defensa;
    private int p_vida;

    public void setP_vida(int p_vida) {
        this.p_vida = p_vida;
    }

    public Player(String name, int p_ataque, int p_defensa, int p_vida) {
        this.name = name;
        this.p_ataque = p_ataque;
        this.p_defensa = p_defensa;
        this.p_vida = p_vida;
        System.out.println(this.getClass().getSimpleName() + " creado con exito.");
    }


    public void attack(Player a) {
        //String a_class = a.getClass().getSimpleName();
        if (this.getP_vida() <= 0 || a.getP_vida() <=0){
            if (this.getP_vida() <= 0){
                System.out.println(this.getName() + " esta muerto");
            }else{
                System.out.println(a.getName() + " esta muerto");
            }

        }else {

            System.out.println("Atacando: " + this);
            System.out.println("Atacado: " + a);
            System.out.println(a.getName() +
                    " es golpeado con " +
                    this.getP_ataque() +
                    " y se defiende con "+
                    a.getP_defensa() +
                    ". Vidas "+ a.getP_vida() +
                    "-"+
                    (this.getP_ataque()- a.getP_defensa())+
                    "="+ (a.getP_vida() - (this.getP_ataque()- a.getP_defensa())));
            a.hit(this.getP_ataque());

            System.out.println(this.getName() +
                    " es golpeado con " +
                    a.getP_ataque() +
                    " y se defiende con "+
                    this.getP_defensa() +
                    ". Vidas "+ this.getP_vida() +
                    "-"+
                    (a.getP_ataque()- this.getP_defensa())+
                    "="+ (this.getP_vida() - (a.getP_ataque()- this.getP_defensa())));
            this.hit(a.getP_ataque());


            System.out.println("Atacando: " + this);
            System.out.println("Atacado: " + a);
        }



       /* if (a_class.equalsIgnoreCase("human")){
        }else if (a_class.equalsIgnoreCase("alien")){
        }else if (a_class.equalsIgnoreCase("warrior")){
        }*/
    }
    protected void hit(int attackPoints) {
        int vida = getP_vida() - (attackPoints - getP_defensa());
        if (vida<=0){
            setP_vida(0);
            System.out.println(this.getName() + " ha sido derrotado");
        }else {
            setP_vida(vida);
        }
    }

    @Override
    public String toString() {
        return name + "  " +
                "PA:" + p_ataque +
                " /  PD:" + p_defensa +
                " /  PV:" + p_vida +
                '}';
    }

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
}
