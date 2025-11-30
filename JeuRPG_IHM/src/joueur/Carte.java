package joueur;

import java.util.*;

import entites.Entite;
import entites.Monstre;
import entites.Obstacle;

public class Carte {
	
	private String[][] grille;
	private Entite[][] entites;
	private int taille;

	public Carte(int taille) {
		this.taille = taille;
		grille = new String[taille][taille];
		entites = new Entite[taille][taille];
		initialiser();
	}

	public void initialiser() {
		Random rand = new Random();
		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
				int r = rand.nextInt(10);
				if (r < 2) {
					grille[i][j] = "M";
					entites[i][j] = new Monstre("Gobelin", i, j, 15, 30);
				} else if (r < 4) {
					grille[i][j] = "O";
					entites[i][j] = new Obstacle("Mur", i, j, 8);
				} else {
					grille[i][j] = ".";
				}
			}
		}
		grille[0][0] = "J";
		grille[taille - 1][taille - 1] = "S";
	}

	public void afficherCarte(int x, int y) {
		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
				if (i == x && j == y) System.out.print("J ");
				else System.out.print(grille[i][j] + " ");
			}
			System.out.println();
		}
	}

	public Entite getEntite(int x, int y) {
		return entites[x][y];
	}

	public void viderCase(int x, int y) {
		grille[x][y] = ".";
		entites[x][y] = null;
	}

	public String getCase(int x, int y) {
		return grille[x][y];
	}
	
}
