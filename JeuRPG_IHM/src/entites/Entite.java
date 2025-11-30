package entites;

import joueur.Joueur;

public abstract class Entite {
	
	protected String nom;
	protected int x, y;

	public Entite(String nom, int x, int y) {
		this.nom = nom;
		this.x = x;
		this.y = y;
	}

	public abstract void interagir(Joueur joueur);
	
}
