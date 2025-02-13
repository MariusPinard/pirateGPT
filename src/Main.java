public class Main {
    public static void main(String[] args) {
        // Création des joueurs
        Joueur joueur1 = new Joueur("Jack le Borgne");
        Joueur joueur2 = new Joueur("Bill Jambe-de-Bois");

        // Création du jeu
        Jeu jeu = new Jeu(joueur1, joueur2);

        // Démarrer la partie
        jeu.demarrer();
    }
}
