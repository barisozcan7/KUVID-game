package UI.views;

import configs.UIConstants;
import domain.controller.game.GameController;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseModeView extends JPanel implements ActionListener {
    private JButton resumeButton;
    private JButton loadGameButton;
    private JButton saveGameButton;
    private JButton exitButton;
    private JLabel pausedLabel;

    public PauseModeView() {
        setWindow();
        setLabel();
        setButtons();
        setLayout();
        this.setVisible(true);
    }

    private void setLabel() {
        pausedLabel = new JLabel("Paused");
        pausedLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pausedLabel.setFont(new Font("Open Sans", Font.BOLD, 40));
        pausedLabel.setForeground(Color.WHITE);
    }

    private void setWindow() {
        this.setLocation(0, 0);
        this.setSize(UIConstants.GAME_WINDOW_WIDTH, UIConstants.GAME_WINDOW_HEIGHT);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setBackground(new Color(0, 0, 0, 180));
        this.setFocusable(true);
    }

    private void setButtons() {
        resumeButton = new JButton("Resume");
        resumeButton.setFont(new Font("Open Sans", Font.PLAIN, 16));
        resumeButton.addActionListener(this);

        loadGameButton = new JButton("Load game");
        loadGameButton.setFont(new Font("Open Sans", Font.PLAIN, 16));
        loadGameButton.addActionListener(this);

        saveGameButton = new JButton("Save game");
        saveGameButton.setFont(new Font("Open Sans", Font.PLAIN, 16));
        saveGameButton.addActionListener(this);

        exitButton = new JButton("Quit to Main Menu");
        exitButton.setFont(new Font("Open Sans", Font.PLAIN, 16));
        exitButton.addActionListener(this);

    }

    private void setLayout() {
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(pausedLabel, GroupLayout.PREFERRED_SIZE, 1114, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(432)
                                                .addComponent(resumeButton, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(432)
                                                .addComponent(loadGameButton, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(432)
                                                .addComponent(saveGameButton, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(432)
                                                .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(123)
                                .addComponent(pausedLabel)
                                .addGap(34)
                                .addComponent(resumeButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(50)
                                .addComponent(loadGameButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(50)
                                .addComponent(saveGameButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(50)
                                .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(164, Short.MAX_VALUE))
        );
        groupLayout.linkSize(SwingConstants.VERTICAL, new Component[]{pausedLabel, resumeButton, loadGameButton, saveGameButton, exitButton});
        setLayout(groupLayout);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resumeButton) {
            GameController.getInstance().returnGame();
        }
        if (e.getSource() == exitButton) {
            GameController.getInstance().returnMainMenu();
        }
        if (e.getSource() == saveGameButton) {
            GameController.getInstance().getSaveGameView();
        }
        if (e.getSource() == loadGameButton) {
            GameController.getInstance().getLoadGameView();
        }
    }
}
