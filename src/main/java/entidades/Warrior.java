package entidades;
/**
 * @author Guillermo Mora Bertó
 */
public class Warrior extends Human{
    //Constructor de la clase Warrior, hereda de la superclase Human
    public Warrior(String name, int p_ataque, int p_defensa, int p_vida) {
        super(name, p_ataque, p_defensa,  p_vida);
        System.out.println(this.getClass().getSimpleName() + " creado con exito.");

    }



}
