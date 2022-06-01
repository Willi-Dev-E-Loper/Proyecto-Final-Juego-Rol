package entidades;

public class Alien extends Player{
    //Constructor de la clase Alien, hereda de la superclase Player
    public Alien(String name, int p_ataque, int p_defensa, int p_vida) {
        super(name, p_ataque, p_defensa, p_vida);
        System.out.println(this.getClass().getSimpleName() + " creado con exito.");
    }



}
