package entites;

import java.util.Random;

import joueur.Joueur;

public class Monstre extends Entite {
	
	private int force;
	//private int vie; -> je l'utilise pas dans cette version du jeu car pas de système de combat

	public Monstre(String nom, int x, int y, int force, int vie) {
		super(nom, x, y);
		this.force = force;
		//this.vie = vie; -> je l'utilise pas dans cette version du jeu car pas de système de combat
	}

	public void interagir(Joueur joueur) {
		System.out.println("Un monstre apparaît : " + nom);
		int degats = new Random().nextInt(force);
		joueur.subirDegats(degats);
		joueur.gagnerXP(10);
		System.out.println(nom + " inflige " + degats + " dégâts !");
	}
	
}
