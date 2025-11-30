package gui;

import joueur.Carte;
import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class MapPanel extends JPanel {

    private Carte carte;
    private int px, py;

    public MapPanel(Carte carte, int px, int py) {
        this.carte = carte;
        this.px = px;
        this.py = py;
        setPreferredSize(new Dimension(500, 500));
    }

    public void updatePosition(int x, int y) {
        this.px = x;
        this.py = y;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int taille = 10;
        int cell = 40;

        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {

                if (i == px && j == py)
                    g.setColor(Color.BLUE);
                else
                    switch (carte.getCase(i, j)) {
                        case "M" -> g.setColor(Color.RED);
                        case "O" -> g.setColor(Color.DARK_GRAY);
                        case "S" -> g.setColor(Color.GREEN);
                        default -> g.setColor(Color.LIGHT_GRAY);
                    }

                g.fillRect(j * cell, i * cell, cell, cell);
                g.setColor(Color.BLACK);
                g.drawRect(j * cell, i * cell, cell, cell);
            }
        }
    }
}
