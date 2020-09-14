package lesson8;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    static final int WINDOW_X = 500;
    static final int WINDOW_Y = 500;
    static final int WINDOW_WIDTH = 505;
    static final int WINDOW_HEIGHT = 555;

    private BattleField battleField;
    private SettingWindow settingWindow;
    public MessageWindow messageWindow;

    public GameWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("TicTacToe");

        battleField = new BattleField(this);
        add(battleField, BorderLayout.CENTER);


        settingWindow = new SettingWindow(this);

        messageWindow = new MessageWindow(this);

        JPanel jPanel = new JPanel(new GridLayout(1, 2));
        JButton buttonNewGame = new JButton("Start new game");
        JButton buttonExit = new JButton("Exit");

        jPanel.add(buttonNewGame);
        jPanel.add(buttonExit);
        add(jPanel, BorderLayout.SOUTH);

        buttonNewGame.addActionListener(e -> {
            settingWindow.setVisible(true);
        });

        buttonExit.addActionListener(e -> {
            System.exit(0);
        });
        setVisible(true);
    }

    public void startNewGame(int mode, int fieldSize, int winningLength){
        battleField.startNewGame(mode, fieldSize, winningLength);
    }
}
