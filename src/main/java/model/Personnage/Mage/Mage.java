package model.personnage.mage;

import model.personnage.Personnage;

import java.util.Scanner;

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

            1.1 : 16/03/2019
                Ajout attribut:
                * mana: le mana actuel du mage
                * manaMax: le mana maximal du mage
                * activeSurcharge: quand activé paie des pv pour lancer des sorts

                //pas encore ajouter
                Ajout d'un objet inventaire
                    *Mage(string nom, int mana, int vie, Objet): constructeur 2
                Ajout d'une méthode d'attaque
                    *TraitDeFeu(Personnages &cible, double rapport), sort de feu standart
*/
public class Mage extends Personnage {

    protected int mana;
    protected int manaMax;
    protected boolean activeSurcharge;

    protected int calcMagDmg(){
        double dmg = Math.ceil(this.pui/2.0);
        if(dmg < 0)
            return 0;
        return (int)dmg;
    }

    public int calcPhyDmg(){
        double dmg = Math.ceil(this.streng/10.0);
        if(dmg < 0)
            return 0;
        return (int)dmg;
    }

    void traitMagique(Personnage cible){
        int COUT = 10;

        if (mana > COUT){
            mana -= COUT;
            cible.takeDmg(this.calcMagDmg());
        }else if (this.surchargeMagique(COUT)){
            cible.takeDmg(this.calcMagDmg());
        }else{
            System.out.println("Pas assez de mana");
        }
    }

    public boolean surchargeMagique(int overMana){
        int manaManquant = overMana - mana;
        if (activeSurcharge){
            mana = 0;
            this.setLife(life - manaManquant*2);
            return true;
        }else{
            return false;
        }
    }

    /*
    Déclaration des getters setters
     */

    public int getManaMax() {
        return manaMax;
    }

    public void setManaMax(int manaMax) {
        this.manaMax = manaMax;
    }

    public boolean isActiveSurcharge() {
        return activeSurcharge;
    }

    public void setActiveSurcharge(boolean activeSurcharge) {
        this.activeSurcharge = activeSurcharge;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana > manaMax ? manaMax : mana;
    }

    public void setIntell(int intell) {
        if (intell < 0)
            intell = 0;
        int manaBonus = this.intell/2;
        manaMax = manaMax - manaBonus + intell/2;
        super.setIntell(intell);
    }

    /*
    Déclaration des constructeurs
     */
    public Mage(){
        super();
        this.intell = 20;
    }

    public Mage(String name, int life) {
        super(name, life);
    }

    public Mage(String name, int life, int mana) {
        super(name, life);
        this.intell = 15;
        this.pui = 40;
        this.activeSurcharge = true;
        if(mana < 0)
            mana = 0;
        this.manaMax = mana + this.intell/2;
        this.mana = this.manaMax;
    }

    //TODO à virer V1 finit
    public void presentation(){
        super.presentation();
        String pres = "J'ai " + mana + " point de mana.";
        System.out.println(pres);
    }
}
