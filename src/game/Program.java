package game;

import game.GamePanel;
import game.GameWindow;

import javax.swing.*;
import java.awt.*;

/**
 * Created by huynq on 7/4/17.
 */

public class Program {
    public static void main(String[] args) {
        GameWindow window = new GameWindow();
        window.setTitle("Touhou");
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GamePanel panel = new GamePanel();
        panel.setPreferredSize(new Dimension(Setting.GAME_WIDTH, Setting.GAME_HEIGHT));
        panel.setBackground(Color.CYAN);

        window.add(panel);
        window.pack();
        window.setVisible(true);

        panel.gameLoop();
    }
}
