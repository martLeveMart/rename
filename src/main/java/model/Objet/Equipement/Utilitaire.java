package model.Objet.Equipement;

import model.Objet.Objet;
import model.Personnage.Personnage;

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
