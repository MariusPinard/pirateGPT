public class Main {
    public static void main(String[] args) {
        // Cr�ation des joueurs
        Joueur joueur1 = new Joueur("Jack le Borgne");
        Joueur joueur2 = new Joueur("Bill Jambe-de-Bois");

        // Cr�ation du jeu
        Jeu jeu = new Jeu(joueur1, joueur2);

        // D�marrer la partie
        jeu.demarrer();
    }
}
