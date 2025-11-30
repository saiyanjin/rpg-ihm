package joueur;

import java.util.*;

import armes.Arme;

public class Joueur {
	
	private String nom, caste;
	private int argent = 100, xp = 0, mana = 50, vie = 100;
	private ArrayList<Arme> inventaire = new ArrayList<>();

	public Joueur(String nom, String caste) {
		this.nom = nom;
		this.caste = caste;
		this.argent = 100;
		this.xp = 0;
		this.inventaire = new ArrayList<>();

		switch (caste) {
			case "Sorcier" -> {
				this.mana = 100;
				this.vie = 70;
			}
			case "Elfe" -> {
				this.mana = 60;
				this.vie = 90;
			}
			case "Guerrier" -> {
				this.mana = 30;
				this.vie = 120;
			}
			default -> {
				this.mana = 50;
				this.vie = 100;
			}
		}
	}
	
	public ArrayList<Arme> getInventaire() {
	    return inventaire;
	}
	
	public int getVie() { 
		return vie; 
	}

	public void ajouterArme(Arme arme) {
		inventaire.add(arme); 
	}
	
	public boolean acheter(Arme arme) {
		if (argent >= arme.getPrix()) {
			argent -= arme.getPrix();
			ajouterArme(arme);
			System.out.println("Achat réussi !");
			return true;
		} else {
			System.out.println("Pas assez d'argent !");
			return false;
		}
	}

	public void afficherInventaire() {
		System.out.println("Inventaire :");
		for (Arme a : inventaire)
			System.out.println("-- " + a.getNom());
		System.out.println("-- Pseudo : " + nom + "\n-- Caste: " + caste + "\n-- Argent: " + argent + "\n-- XP: " + xp + "\n-- Mana: " + mana + "\n-- Vie: " + vie + "\n");
	}

	public void gagnerXP(int points) {
		xp += points; 
	}
	
	public void subirDegats(int degats) {
    	vie -= degats; 
	}
    
	public boolean estVivant() { 
    	return vie > 0; 
	}
	
	public int getMana() {
		return mana;
	}


	public int getXp() {
		return xp;
	}


	public int getArgent() {
		return argent;
	}
    
}
