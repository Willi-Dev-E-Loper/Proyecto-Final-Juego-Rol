package entidades;

public class Warrior extends Human{
    public Warrior(String name, int p_ataque, int p_defensa, int p_vida) {
        super(name, p_ataque, p_defensa, p_vida);
    }



    protected void hit(int attackPoints) {

        if (attackPoints<5){
            attackPoints=0;
            int vida = getP_vida() - (attackPoints - getP_defensa());
            if (vida<=0){
                setP_vida(0);
                System.out.println(this.getName() + " ha sido derrotado");
            }else {
                setP_vida(vida);
            }
        }else {
            int vida = getP_vida() - (attackPoints - getP_defensa());
            if (vida<=0){
                setP_vida(0);
                System.out.println(this.getName() + " ha sido derrotado");
            }else {
                setP_vida(vida);
            }
        }

    }
}
