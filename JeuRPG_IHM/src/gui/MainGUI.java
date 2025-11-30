package gui;

import javax.swing.*;

public class MainGUI {
    public static void main(String[] args) {

        JFrame frame = new JFrame("RPG Menu");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MenuStartPanel menu = new MenuStartPanel(joueur -> {
            frame.dispose();
            new GameFrame(joueur);
        });

        frame.add(menu);
        frame.setVisible(true);
    }
}
