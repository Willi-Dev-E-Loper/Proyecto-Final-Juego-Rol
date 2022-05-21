package juego;

import entidades.Alien;
import entidades.Human;
import entidades.Team;
import entidades.Warrior;

/**
 * Hello world!
 *
 */
public class JuegoDeRol
{
    public static void pruebaFase1(){

        Human a =new Human("paco", 30, 20, 125);
        Warrior b =new Warrior("Suerko", 76, 4, 118);
        Alien c =new Alien("AODN28", 44, 18, 118);
        System.out.println("Ataque 1");
        c.attack(a);
        System.out.println("Ataque 2");
        a.attack(c);
        System.out.println("Ataque 3");
        b.attack(a);
        System.out.println("Ataque 4");
        a.attack(b);
        c.attack(a);

    }
    public static void pruebaFase2(){

        Human a =new Human("paco", 30, 20, 125);
        Warrior b =new Warrior("Suerko", 76, 4, 118);
        Alien c =new Alien("AODN28", 44, 18, 118);
        Team t = new Team("prove");
        Team tt = new Team("prove2");
        System.out.println("Ataque 1");


        a.addTeam(t);
        t.addPlayer(c);
        t.addPlayer(b);
        a.addTeam(tt);
        tt.addPlayer(c);
        tt.addPlayer(b);
        System.out.println("equipo 1 sin borrar");
        t.toString();
        System.out.println("equipo 2 sin borrar");
        tt.toString();
        a.removeTeam(t);
        tt.removePlayer(c);

        System.out.println("22");

        System.out.println("equipo 1 borrado");
        t.toString();
        System.out.println("equipo 2 borrado");
        tt.toString();
        System.out.println("Compruebo equalsTeam");
        System.out.println(t.equalTeam(t));
        System.out.println(t.equalTeam(tt));
        System.out.println("Compruebo equalsPlayer");
        System.out.println(a.equalPlayers(a));
        System.out.println(a.equalPlayers(b));
        System.out.println("Ataques");
        c.attack(a);
        System.out.println("Ataque 2");
        a.attack(c);
        System.out.println("Ataque 3");
        b.attack(a);
        System.out.println("Ataque 4");
        a.attack(b);
        c.attack(a);

    }
    public static void main( String[] args )
    {
        pruebaFase2();


    }
}
