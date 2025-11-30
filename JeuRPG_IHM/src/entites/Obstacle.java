package entites;

import joueur.Joueur;

public class Obstacle extends Entite {
	
	private int solidite;

	public Obstacle(String nom, int x, int y, int solidite) {
		super(nom, x, y);
		this.solidite = solidite;
	}

	public void interagir(Joueur joueur) {
		System.out.println("Obstacle rencontré : " + nom);
		if (solidite <= 10) {
			System.out.println("Obstacle détruit !");
			joueur.gagnerXP(5);
		} else {
			System.out.println("Obstacle trop solide !");
		}
	}
	
}
