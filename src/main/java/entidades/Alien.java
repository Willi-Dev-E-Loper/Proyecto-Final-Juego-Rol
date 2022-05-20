package entidades;

public class Alien extends Player{
    private final int potenciador = 10;
    private final int penalizacion = 5;

    public Alien(String name, int p_ataque, int p_defensa, int p_vida) {
        super(name, p_ataque, p_defensa, p_vida);
    }


}
