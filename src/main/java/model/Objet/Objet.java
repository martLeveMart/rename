package model.Objet;

abstract public class Objet {
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
