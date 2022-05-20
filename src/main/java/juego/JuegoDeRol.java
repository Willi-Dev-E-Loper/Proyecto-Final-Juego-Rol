package juego;

import entidades.Alien;
import entidades.Human;
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
    public static void main( String[] args )
    {
        pruebaFase1();
    }
}
