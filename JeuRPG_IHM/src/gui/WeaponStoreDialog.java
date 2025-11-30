package gui;

import armes.*;
import joueur.Joueur;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class WeaponStoreDialog extends JDialog {

    public WeaponStoreDialog(JFrame parent, Joueur joueur) {
        super(parent, "Magasin d'armes", true);

        setLayout(new GridLayout(4, 1));

        JButton epee = new JButton("Épée (50)");
        JButton baguette = new JButton("Baguette (70)");
        JButton arc = new JButton("Arc (40)");

        epee.addActionListener(e -> joueur.acheter(new Epee()));
        baguette.addActionListener(e -> joueur.acheter(new Baguette()));
        arc.addActionListener(e -> joueur.acheter(new Arc()));

        add(epee);
        add(baguette);
        add(arc);

        setSize(200, 200);
        setLocationRelativeTo(parent);
        setVisible(true);
    }
}
