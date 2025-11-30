package gui;

import joueur.*;
import entites.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {

    private Joueur joueur;
    private Carte carte;
    private int x = 0, y = 0;

    private PlayerInfoPanel infoPanel;
    private MapPanel mapPanel;

    public GameFrame(Joueur joueur) {
        this.joueur = joueur;
        this.carte = new Carte(10);

        setTitle("RPG - Donjon graphique");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        infoPanel = new PlayerInfoPanel(joueur);
        mapPanel = new MapPanel(carte, x, y);

        add(infoPanel, BorderLayout.EAST);
        add(mapPanel, BorderLayout.CENTER);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                gererDeplacement(e.getKeyCode());
            }
        });

        setFocusable(true);
        
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3, 1));

        JButton boutonBoutique = new JButton("Boutique");
        JButton boutonInventaire = new JButton("Inventaire");

        controlPanel.add(boutonBoutique);
        controlPanel.add(boutonInventaire);

        add(controlPanel, BorderLayout.WEST);

        boutonBoutique.addActionListener(e -> {
            new WeaponStoreDialog(this, joueur);
            infoPanel.update();
            reprendreFocus();
        });

        boutonInventaire.addActionListener(e -> {
            StringBuilder sb = new StringBuilder("Ton inventaire :\n\n");

            if (joueur.getInventaire().isEmpty()) {
                sb.append("Tu n'as aucune arme.");
            } else {
                joueur.getInventaire().forEach(a -> 
                    sb.append("- ").append(a.getNom())
                      .append(" (").append(a.getPuissance()).append(" dmg)\n")
                );
            }

            JOptionPane.showMessageDialog(this, sb.toString());
            reprendreFocus();
        });

        
        setVisible(true);
    }

    private void gererDeplacement(int code) {
        int nx = x, ny = y;

        switch (code) {
            case KeyEvent.VK_UP -> nx--;
            case KeyEvent.VK_DOWN -> nx++;
            case KeyEvent.VK_LEFT -> ny--;
            case KeyEvent.VK_RIGHT -> ny++;
        }

        if (nx < 0 || ny < 0 || nx >= 10 || ny >= 10)
            return;

        String caseActuelle = carte.getCase(nx, ny);

        if (caseActuelle.equals("O")) {
            JOptionPane.showMessageDialog(this, "Impossible ! Il y a un mur.");
            return;
        }

        x = nx;
        y = ny;

        if (caseActuelle.equals("S")) {
            JOptionPane.showMessageDialog(this, "Victoire ! Tu as atteint la sortie !");
            System.exit(0);
        }

        Entite e = carte.getEntite(x, y);
        if (e != null) {
            int rep = JOptionPane.showConfirmDialog(this,
                    "Tu rencontres : " + e.getClass().getSimpleName() + "\nInteragir ?",
                    "Rencontre",
                    JOptionPane.YES_NO_OPTION);

            if (rep == 0) {
                e.interagir(joueur);
                carte.viderCase(x, y);
            }
            
            if (!joueur.estVivant()) {
                JOptionPane.showMessageDialog(this,
                        "Tu es mort dans le donjon...\nGame Over !");
                System.exit(0);
            }
        }

        infoPanel.update();
        mapPanel.updatePosition(x, y);
        reprendreFocus();
    }
    
    
    
    private void reprendreFocus() {
        this.requestFocusInWindow();
    }


}
