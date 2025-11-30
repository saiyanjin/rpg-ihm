package gui;

import joueur.Joueur;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class PlayerInfoPanel extends JPanel {

    private Joueur joueur;
    private JLabel vie, mana, argent, xp;

    public PlayerInfoPanel(Joueur joueur) {
        this.joueur = joueur;

        setLayout(new GridLayout(6, 1));
        add(new JLabel("Informations joueur"));
        vie = new JLabel();
        mana = new JLabel();
        xp = new JLabel();
        argent = new JLabel();

        add(vie);
        add(mana);
        add(xp);
        add(argent);

        update();
    }

    public void update() {
    	vie.setText("Vie : " + joueur.getVie());
        mana.setText("Mana : " + joueur.getMana());
        xp.setText("XP : " + joueur.getXp());
        argent.setText("Argent : " + joueur.getArgent());
    }
}
