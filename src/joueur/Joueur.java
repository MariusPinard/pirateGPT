package joueur;

import java.util.ArrayList;
import java.util.List;

class Joueur {
    private String nom;
    private int pointsVie;
    private int pointsPopularite;
    private List<Carte> main;

    public Joueur(String nom) {
        this.nom = nom;
        this.pointsVie = 5; // commence avec 5 points de vie
        this.pointsPopularite = 0;
        this.main = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public int getPointsVie() {
        return pointsVie;
    }

    public int getPointsPopularite() {
        return pointsPopularite;
    }

    public List<Carte> getMain() {
        return main;
    }

    public void ajouterCarte(Carte carte) {
        main.add(carte);
    }

    public void ajouterPopularite(int points) {
        this.pointsPopularite += points;
    }

    public void recevoirDegats(int degats) {
        this.pointsVie -= degats;
        if (pointsVie < 0) pointsVie = 0; // La vie ne peut pas être négative
    }

    public boolean estVivant() {
        return pointsVie > 0;
    }

    public boolean aGagne() {
        return pointsPopularite >= 5;
    }
}
