package model.personnage;

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
                * int streng: dommage de base en combat
                * int intell: augmente la second barre
                * int pui: dommage de base des sorts
            déclaration des méthodes :
                *coup: inflige des dégats physiques à l'adversaire
                * calcPhyDmg() retour les dégats physique du perso

        1.2 : 21/03/2019
            déclaration des méthodes :
                * soigner: remonte la vie du Personnage
*/

abstract public class Personnage {

    protected String name;
    protected int life;
    protected int lifeMax;

    //attribut afficher
    protected int streng;
    protected int intell;
    protected int pui;

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

    public void soigner(int life){
        this.setLife(this.getLife() + life);
    }

    abstract public int calcPhyDmg();

    abstract protected int calcMagDmg();

    /*
    Déclaration des contructeurs
     */
    public Personnage(){}

    public Personnage(String name, int life){
        this.name = name;
        this.streng = 5;
        this.intell = 5;
        this.pui = 10;
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

    public int getPui() {
        return pui;
    }

    public void setPui(int pui) {
        this.pui = pui;
    }

    public int getIntell() {
        return intell;
    }

    public void setIntell(int intell) {
        this.intell = intell;
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
        this.life = life > lifeMax ? lifeMax : life;
        //TODO pour détruire l'objet il faudrat le retirer de l'objet world auquel il sera associé
        //à faire quand le monde sera créer en attend test des hp (si trop chiant ajouter un bool vivant)
    }

    //TODO a supprime quand plus de test à effectuer
    /*
     Retourne la liste des différents stats
     */
    public void presentation(){
        String pres = "Je m'appel " + name + ", je possède " + life + " point de vie.";
        System.out.println(pres);
    }

    public void getStat(){
        System.out.println("Force : " + this.streng);
        System.out.println("Inteligence : " + this.intell);
    }
}
