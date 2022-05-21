package entidades;

public class Alien extends Player{
    private final int potenciador = 3;
    private final int penalizacion = 3;

    public Alien(String name, int p_ataque, int p_defensa, int p_vida) {
        super(name, p_ataque, p_defensa, p_vida);
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
            if (this.getP_vida()<=20){
                System.out.println("Atacando: " + this);
                System.out.println("Atacado: " + a);

                a.hit(this.getP_ataque(), a);

                this.hit(a.getP_ataque(), this);
                System.out.println("Atacando: " + this);
                System.out.println("Atacado: " + a);
            }else {
                this.setP_ataque(getP_ataque()+3);
                this.setP_defensa(getP_defensa()-3);


                System.out.println("Atacando: " + this);
                System.out.println("Atacado: " + a);

                a.hit(this.getP_ataque(),this );


                this.hit(a.getP_ataque(), a);
                System.out.println("Atacando: " + this);
                System.out.println("Atacado: " + a);
            }

        }




       /* if (a_class.equalsIgnoreCase("human")){
        }else if (a_class.equalsIgnoreCase("alien")){
        }else if (a_class.equalsIgnoreCase("warrior")){
        }*/
    }



}
