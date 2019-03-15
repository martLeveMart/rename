package model.Personnage;

/*Déclaration des méthodes
History:
        1.0 : 09/12/2016
            déclaration des méthodes :
                *Personnages : Le constructeur par défaut du Personnage
                *Personnages(int vie, string nom) : constructeur 1
                *takeDmg : La fonction permettant de perdre des PV lorsqu'on attaque le Personnage
                *Presentation : Affiche les caractéristiques du Personnage
*/

abstract public class Personnage {

    protected String name;
    protected int life;

    public Personnage(){

    }

    public Personnage(String name, int life){
        this.name = name;
        this.life = life;
    }

    public void takeDmg(int dmg){
        life -= dmg;
        if(life < 0)
            life = 0;
    }

    public void presentation(){
        String pres = "Je m'appel " + name + ", je possède " + life + " point de vie.";
        System.out.println(pres);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
