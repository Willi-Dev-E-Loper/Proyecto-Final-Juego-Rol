package entidades;

import java.util.ArrayList;

public class Team {
    public String name;
    private ArrayList<Player> players = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }
    public void siz(){
        System.out.println(players.size());
    }
    public void addPlayer (Player p ){
        if (players.isEmpty() || !players.contains(p)){
            players.add(p);
            p.addTeam(this);
        }

    }

    public void removePlayer (Player p ){
        if (players.contains(p)){
            players.remove(p);
            p.removeTeam(this);
        }

    }
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

    @Override
    public String toString() {
        for(Player player:players){
            System.out.println(player.toString());
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
