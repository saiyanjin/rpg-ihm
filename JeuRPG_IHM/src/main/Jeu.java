package main;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import joueur.*;
import armes.*;
import entites.*;

public class Jeu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------- Bienvenue dans le Donjon ! ----------");
        System.out.print("-> Nom du personnage : ");
        String nom = sc.nextLine();
        
        List<String> castesValides = Arrays.asList("Sorcier", "Elfe", "Guerrier");
        String caste = "";
        while (true) {
            System.out.print("-> Choisis ta caste (Sorcier, Elfe, Guerrier) : ");
            caste = sc.nextLine();
            if (castesValides.contains(caste)) break;
            System.out.println("Caste invalide. Choisis parmi : Sorcier, Elfe, Guerrier");
        }

        Joueur joueur = new Joueur(nom, caste);
        Carte carte = new Carte(5);
        int x = 0, y = 0;

        while (joueur.estVivant()) {
            carte.afficherCarte(x, y);
            System.out.println("\nActions disponibles :");
            System.out.println("1. Acheter une arme");
            System.out.println("2. Voir l'inventaire");
            System.out.println("3. Se déplacer \n");

            System.out.print("-> Ton choix : ");
            int choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1 -> {
                    System.out.println("Magasin :");
                    System.out.println("1. Épée (50) | 2. Baguette (70) | 3. Arc (40)");
                    System.out.print("-> Choix de l'arme : ");
                    int a = sc.nextInt();
                    sc.nextLine();
                    Arme arme = switch (a) {
                        case 1 -> new Epee();
                        case 2 -> new Baguette();
                        case 3 -> new Arc();
                        default -> null;
                    };
                    if (arme != null) joueur.acheter(arme);
                }
                case 2 -> joueur.afficherInventaire();
                case 3 -> {
                    System.out.print("Direction (haut, bas, gauche, droite) : ");
                    String dir = sc.nextLine();
                    int nx = x, ny = y;
                    switch (dir) {
                        case "haut" -> nx--;
                        case "bas" -> nx++;
                        case "gauche" -> ny--;
                        case "droite" -> ny++;
                        default -> {
                            System.out.println("Direction invalide !");
                            continue;
                        }
                    }

                    if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
                        x = nx;
                        y = ny;
                        String caseActuelle = carte.getCase(x, y);

                        if (caseActuelle.equals("S")) {
                            System.out.println("🎉 Tu as trouvé la sortie du donjon ! Victoire !");
                            return;
                        }

                        Entite e = carte.getEntite(x, y);
                        if (e != null) {
                            System.out.println("Tu rencontres un(e) " + e.getClass().getSimpleName() + " !");
                            System.out.print("Souhaites-tu interagir (oui/non) ? ");
                            String action = sc.nextLine();
                            if (action.equalsIgnoreCase("oui")) {
                                e.interagir(joueur);
                                carte.viderCase(x, y);
                            } else {
                                System.out.println("Tu choisis d'ignorer l'entité.");
                            }
                        } else {
                            System.out.println("Tu avances prudemment...");
                        }
                    } else {
                        System.out.println("Déplacement impossible !");
                    }
                }
                default -> System.out.println("Choix invalide !");
            }

            if (!joueur.estVivant()) {
                System.out.println("💀 Tu es mort dans le donjon... Game Over !");
            }
        }

        sc.close();
    }
}
