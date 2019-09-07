package model.Objet;

/*Déclaration des méthodes
History:
        1.0 : 21/03/2019
            déclaration des méthodes :
                *Objet : Le constructeur par défaut de Objet
                *Objet(string nom) : constructeur
*/
public abstract class Objet {
    protected String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Objet(){}

    public Objet(String nom){
        this.nom = nom;
    }
}
