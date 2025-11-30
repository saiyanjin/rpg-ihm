package gui;

import joueur.Joueur;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class MenuStartPanel extends JPanel {

    public interface StartListener {
        void startGame(Joueur joueur);
    }

    public MenuStartPanel(StartListener listener) {

        setLayout(new GridLayout(5, 1));

        JTextField nomField = new JTextField();
        JComboBox<String> casteBox = new JComboBox<>(new String[]{
                "Sorcier", "Elfe", "Guerrier"
        });

        JButton start = new JButton("Démarrer");

        add(new JLabel("Nom du joueur :"));
        add(nomField);
        add(new JLabel("Choix de la caste :"));
        add(casteBox);
        add(start);

        start.addActionListener(e -> {
            String nom = nomField.getText();
            String caste = (String) casteBox.getSelectedItem();
            listener.startGame(new Joueur(nom, caste));
        });
    }
}
