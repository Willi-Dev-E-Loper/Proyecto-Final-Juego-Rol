package entidades;

public class Human extends Player{
    public Human(String name, int p_ataque, int p_defensa, int p_vida) {
        super(name, p_ataque, p_defensa, p_vida);
        if (this.getClass().getSimpleName().equalsIgnoreCase("human") && this.getP_vida()>100){
            System.out.println("El humano no puede tener mas de 100 puntos de vida.\nSe han asignado el maximo de puntos.");
            this.setP_vida(100);
        }else {
            System.out.println(this.getClass().getSimpleName() + " creado con exito.");

        }
    }



}
