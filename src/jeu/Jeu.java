package jeu;

import java.util.Random;

class Jeu {
    private Joueur joueur1;
    private Joueur joueur2;
    private Random random;

    public Jeu(Joueur joueur1, Joueur joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.random = new Random();
    }

    public void demarrer() {
        // Le jeu continue tant que les deux joueurs sont en vie et qu'aucun n'a gagné
        while (joueur1.estVivant() && joueur2.estVivant()) {
            jouerTour(joueur1, joueur2);
            if (joueur1.aGagne() || joueur2.aGagne()) break;
            jouerTour(joueur2, joueur1);
            if (joueur1.aGagne() || joueur2.aGagne()) break;
        }

        // Afficher le gagnant
        if (joueur1.aGagne()) {
            System.out.println(joueur1.getNom() + " a gagné !");
        } else if (joueur2.aGagne()) {
            System.out.println(joueur2.getNom() + " a gagné !");
        } else {
            System.out.println("Le jeu est terminé.");
        }
    }

    private void jouerTour(Joueur joueurActuel, Joueur adversaire) {
        // Le joueur pioche une carte aléatoire et l'ajoute à sa main
        Carte cartePiochée = tirerCarte();
        joueurActuel.ajouterCarte(cartePiochée);
        System.out.println(joueurActuel.getNom() + " a pioché une carte : " + cartePiochée.getNom());

        // Le joueur choisit une carte à jouer (dans cet exemple, il joue toujours la première)
        Carte carteJouee = joueurActuel.getMain().get(0);
        System.out.println(joueurActuel.getNom() + " joue " + carteJouee.getNom());

        carteJouee.jouer(joueurActuel, adversaire);

        // Vérifier l'état du jeu après l'action
        System.out.println("Vie de " + joueurActuel.getNom() + " : " + joueurActuel.getPointsVie());
        System.out.println("Popularité de " + joueurActuel.getNom() + " : " + joueurActuel.getPointsPopularite());
        System.out.println("Vie de " + adversaire.getNom() + " : " + adversaire.getPointsVie());
        System.out.println("Popularité de " + adversaire.getNom() + " : " + adversaire.getPointsPopularite());
    }

    private Carte tirerCarte() {
        // Exemple de tirage aléatoire
        if (random.nextBoolean()) {
            return new CartePopularite("Discours Inspirant", 1);
        } else {
            return new CarteAttaque("Coup de Sabre", 2);
        }
    }
}
