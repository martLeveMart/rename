package model.Personnage.Mage;

import model.Personnage.Personnage;

/* Déclaration des méthodes
Historique:

            1.0 : 15/03/2019
                déclaration des méthodes :
                    *Mage: constructeur par défaut du Mage
                    *Mage(string nom, int mana, int vie): constructeur
                    *Presentation: Affiche les caractéristique pour le Mage

            1.1 : 16/03/2019
                *TraitMagique: inflige des dégats magiques à l'adversaire
                *SurchargeMagique: détermine si il reste du mana au mage
                Ajout d'un objet inventaire
                    *Mage(string nom, int mana, int vie, Objet): constructeur 2
                Ajout d'une méthode d'attaque
                    *TraitDeFeu(Personnages &cible, double rapport), sort de feu standart
*/
public class Mage extends Personnage {

    protected int mana;
    protected int manaMax;

    public Mage(){
        super();
        this.intell = 20;
    }

    public Mage(String name, int life) {
        super(name, life);
        this.intell = 20;
    }

    public Mage(String name, int life, int mana) {
        super(name, life);
        this.intell = 20;
        if(mana < 0)
            mana = 0;
        this.mana = mana + this.intell;
        this.manaMax = mana + this.intell/2;
    }

    public void presentation(){
        super.presentation();
        String pres = "J'ai " + mana + " point de mana.";
        System.out.println(pres);
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
}
