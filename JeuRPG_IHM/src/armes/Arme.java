package armes;

public abstract class Arme {
	
	protected String nom;
	protected int puissance;
	protected int prix;


	public Arme(String nom, int puissance, int prix) {
		this.nom = nom;
		this.puissance = puissance;
		this.prix = prix;
	}

	public String getNom() {
		return nom; 
	
	}
	public int getPuissance() {
		return puissance; 
	}
	public int getPrix() { 
		return prix;
	}

	public abstract void effetSpecial();
	
}

