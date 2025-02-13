package carte;

//Classe abstraite pour une carte
abstract class Carte {
 protected String nom;

 public String getNom() {
     return nom;
 }

 // M�thode � d�finir pour savoir ce que la carte fait lorsqu'elle est jou�e
 public abstract void jouer(Joueur joueur, Joueur adversaire);
}

//Carte de popularit�
class CartePopularite extends Carte {
 private int pointsPopularite;

 public CartePopularite(String nom, int pointsPopularite) {
     this.nom = nom;
     this.pointsPopularite = pointsPopularite;
 }

 @Override
 public void jouer(Joueur joueur, Joueur adversaire) {
     joueur.ajouterPopularite(pointsPopularite);
 }
}

//Carte d'attaque
class CarteAttaque extends Carte {
 private int degats;

 public CarteAttaque(String nom, int degats) {
     this.nom = nom;
     this.degats = degats;
 }

 @Override
 public void jouer(Joueur joueur, Joueur adversaire) {
     adversaire.recevoirDegats(degats);
 }
}
