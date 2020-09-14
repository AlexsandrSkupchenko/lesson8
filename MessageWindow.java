package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowListener;

import static java.awt.BorderLayout.SOUTH;

public class MessageWindow extends JFrame {

    private GameWindow gameWindow;
    private SettingWindow settingWindow;
    static final int WINDOW_X = GameWindow.WINDOW_X + 50;
    static final int WINDOW_Y = GameWindow.WINDOW_Y + 50;
    static final int WINDOW_WIDTH = 405;
    static final int WINDOW_HEIGHT = 400;


    public MessageWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        this.settingWindow = settingWindow;
        setBounds(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Message");


        JTextArea textArea = new JTextArea(Logic.isWin);
        add(textArea, BorderLayout.CENTER);
        textArea.setVisible(true);

        JPanel jPanel = new JPanel(new GridLayout(1, 2));
        JButton buttonNewGame = new JButton("Start new game");
        JButton buttonExit = new JButton("Exit");

        jPanel.add(buttonNewGame);
        jPanel.add(buttonExit);
        add(jPanel, BorderLayout.SOUTH);

        settingWindow = new SettingWindow(gameWindow);
        buttonNewGame.addActionListener(e -> {
            settingWindow.setVisible(true);
            setVisible(false);
        });


        buttonExit.addActionListener(e -> {
            System.exit(0);
        });
        setVisible(false);

    }

}
