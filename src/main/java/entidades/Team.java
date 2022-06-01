package entidades;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * @author Guillermo Mora Bertó
 */

public class Team implements Serializable {
    public String name;
    private ArrayList<Player> players = new ArrayList<>();

    //Contructor del objeto Team que recibe como parametro el nombre del equipo.
    public Team(String name) {
        this.name = name;
    }
    //Metodo addPlayer
    //Recibe como parametro un Player
    //Si el array players esta vacio o no contiene el objeto, añade el jugador y de manera recursiva  tambien añade el equipo.
    public void addPlayer (Player p ){
        if (players.isEmpty() || !players.contains(p)){
            players.add(p);
            p.addTeam(this);
        }

    }
    //Metodo removePlayer
    //Recibe como parametro un Player
    //Si el array players contiene el objeto, borra el jugador y de manera recursiva  tambien borra el equipo.
    public void removePlayer (Player p ){
        if (players.contains(p)){
            players.remove(p);
            p.removeTeam(this);
        }

    }
    //Metodo equalTeam recibe un Team como parametro y se encarga de comparar uno a uno los atributos del equipo
    //Devuelve un booleano.
    public boolean equalTeam (Team t ){
        String t_name = this.getName();
        String p_name = t.getName();
        int t_size = this.players.size();
        int p_size = t.players.size();
        boolean flag = false;
        if (p_name.equalsIgnoreCase(t_name) && t_size == p_size){
            flag = true;
        }
        return flag;
    }
    //Metodo toString sobreescrito que imprime la informacion de los equipos.

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(Player player:players){
            str.append(this.getName()).append("\n").append(player.toString()).append("\n");
        }
        return str.toString();
    }
    //Getter
    public String getName() {
        return name;
    }

}
