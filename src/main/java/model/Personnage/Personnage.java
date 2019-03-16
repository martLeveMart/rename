package model.Personnage;

/*Déclaration des méthodes
History:
        1.0 : 15/03/2019
            déclaration des méthodes :
                *Personnages : Le constructeur par défaut du Personnage
                *Personnages(int vie, string nom) : constructeur 1
                *takeDmg : La fonction permettant de perdre des PV lorsqu'on attaque le Personnage
                *Presentation : Affiche les caractéristiques du Personnage

        1.1 : 16/03/2019
            ajout attribut:
                *streng: int dommage de base en combat
            déclaration des méthodes :
                *coup: inflige des dégats physiques à l'adversaire
*/

abstract public class Personnage {

    protected String name;
    protected int life;
    protected int lifeMax;

    //attribut afficher
    protected int streng;

    public void takeDmg(int dmg){
        life -= dmg;
        if(life < 0)
            life = 0;
        if(life > lifeMax)
            life = lifeMax;
    }

    public void coup(Personnage cible){
        cible.takeDmg(this.calcPhyDmg());
    }

    public int calcPhyDmg(){
        double dmg = Math.ceil(this.streng/10.0);
        if(dmg < 0)
            dmg = 0;
        return (int)dmg;
    }

    /*
    Déclaration des contructeurs
     */
    public Personnage(){

    }

    public Personnage(String name, int life){
        this.name = name;
        this.streng = 5;
        if(life < 0)
            life = 0;
        this.life = life;
        lifeMax = life;
    }

    /*
    Déclaration des getters et setters
     */
    public int getStreng() {
        return streng;
    }

    public void setStreng(int streng) {
        this.streng = streng;
    }

    public int getLifeMax() {
        return lifeMax;
    }

    public void setLifeMax(int lifeMax) {
        this.lifeMax = lifeMax;
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

    public void presentation(){
        String pres = "Je m'appel " + name + ", je possède " + life + " point de vie.";
        System.out.println(pres);
    }
}
