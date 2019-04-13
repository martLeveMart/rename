package model.objet.equipement;

import model.objet.Objet;
import model.personnage.Personnage;

/*Déclaration des méthodes
History:
        1.0 : 21/03/2019
            déclaration des méthodes :
                * Objet(string nom, int life) : constructeur
                * utiliser: utilise l'objet
*/
public class Utilitaire extends Objet {
    protected int life;

    public void utiliser(Personnage cible){
        if(life < 0)
            life = 0;
        cible.soigner(life);
    }

    public Utilitaire(String name, int life){
        super(name);
        this.life = life;
    }
}
