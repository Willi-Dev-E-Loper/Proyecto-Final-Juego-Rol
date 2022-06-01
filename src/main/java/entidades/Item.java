package entidades;

import java.io.Serializable;

public class Item implements Serializable {
    String name;
    int attackBonus;
    int defenseBonus;

    //Constructor del objeto item, recibe como parametro el nombre, el bonus de ataque y el bonus de defensa
    public Item(String name, int attackBonus, int defenseBonus) {
        this.name = name;
        this.attackBonus = attackBonus;
        this.defenseBonus = defenseBonus;
    }

    //Metodo toString sobreescrito que imprime la informacion de los items.
    @Override
    public String toString() {
        return "-"+name +
                "   BA:  " + attackBonus + "  /" +
                "   BD:  " + defenseBonus;
    }
    //Getter
    public String getName() {
        return name;
    }

}
