package UI.views;

import domain.controller.end_game.EndGameController;
import domain.enums.EndGameReason;
import domain.models.game.Game;
import utils.Utils;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndGameView extends JPanel implements ActionListener {

    private static JFrame window;
    private JPanel mainPanel;
    private EndGameController controller;

    private JPanel gameStatisticsPanel;
    private JLabel scoreLabel;
    private JLabel scoreValueLabel;
    private JLabel healthLabel;
    private JLabel healthValueLabel;
    private JLabel timeLabel;
    private JLabel timeValueLabel;
    private JLabel gameOverLabel;
    private JLabel endReasonLabel;
    private JButton restartGameButton;
    private JButton backButton;

    public EndGameView() {
        window = new JFrame();
        mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 484, 461);
        controller = new EndGameController();
        gameStatisticsPanel = new JPanel();

        setEndGameWindow();
        setGameOverLabel();
        setEndReasonLabel();
        setTimeLabel();
        setTimeValueLabel();
        setScoreLabel();
        setScoreValueLabel();
        setHealthLabel();
        setHealthValueLabel();
        setButtons();

        setLayoutStatisticsPanel();
        setLayoutMainPanel();
    }

    private void setEndGameWindow() {
        window.setSize(500, 500);
        window.getContentPane().setLayout(null);
        window.setVisible(true);
        window.setResizable(false);
        window.setTitle("GAME OVER");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.getContentPane().add(mainPanel);
    }

    private void setGameOverLabel() {
        gameOverLabel = new JLabel("GAME OVER!");
        gameOverLabel.setFont(new Font("Open Sans", Font.BOLD, 40));
        gameOverLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void setEndReasonLabel() {
        endReasonLabel = setReasonLabel(Game.getInstance().getEndGameReason());
        endReasonLabel.setHorizontalAlignment(SwingConstants.CENTER);
        endReasonLabel.setFont(new Font("Open Sans", Font.BOLD, 22));
    }

    private void setTimeLabel() {
        timeLabel = new JLabel("Time Left:");
        timeLabel.setFont(new Font("Open Sans", Font.BOLD, 18));
    }

    private void setTimeValueLabel() {
        timeValueLabel = new JLabel(Utils.secondsToMMSS(Game.getInstance().getRemainingTime()));
        timeValueLabel.setFont(new Font("Open Sans", Font.PLAIN, 18));
    }

    private void setScoreLabel() {
        scoreLabel = new JLabel("Score:");
        scoreLabel.setFont(new Font("Open Sans", Font.BOLD, 18));
    }

    private void setScoreValueLabel() {
        scoreValueLabel = new JLabel(String.valueOf(Game.getInstance().getPlayer().getScore()));
        scoreValueLabel.setFont(new Font("Open Sans", Font.PLAIN, 18));
    }

    private void setHealthLabel() {
        healthLabel = new JLabel("Remaining Health:");
        healthLabel.setFont(new Font("Open Sans", Font.BOLD, 18));
    }

    private void setHealthValueLabel() {
        healthValueLabel = new JLabel(String.valueOf(Game.getInstance().getPlayer().getHealth()));
        healthValueLabel.setFont(new Font("Open Sans", Font.PLAIN, 18));
    }

    private void setButtons() {
        backButton = new JButton("Back to Main Menu");
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setFont(new Font("Open Sans", Font.BOLD, 14));
        backButton.addActionListener(this);

        restartGameButton = new JButton("Restart Game");
        restartGameButton.setFont(new Font("Open Sans", Font.BOLD, 14));
        restartGameButton.addActionListener(this);
    }

    private void setLayoutStatisticsPanel() {
        GroupLayout gl_gameStatisticsPanel = new GroupLayout(gameStatisticsPanel);
        gl_gameStatisticsPanel.setHorizontalGroup(
                gl_gameStatisticsPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_gameStatisticsPanel.createSequentialGroup()
                                .addGap(25)
                                .addGroup(gl_gameStatisticsPanel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_gameStatisticsPanel.createSequentialGroup()
                                                .addComponent(scoreLabel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                                .addGap(2)
                                                .addComponent(scoreValueLabel, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(healthLabel, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_gameStatisticsPanel.createSequentialGroup()
                                                .addGap(181)
                                                .addComponent(healthValueLabel, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_gameStatisticsPanel.createSequentialGroup()
                                                .addComponent(timeLabel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                                .addGap(10)
                                                .addComponent(timeValueLabel, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE))))
        );
        gl_gameStatisticsPanel.setVerticalGroup(
                gl_gameStatisticsPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_gameStatisticsPanel.createSequentialGroup()
                                .addGap(30)
                                .addGroup(gl_gameStatisticsPanel.createParallelGroup(Alignment.LEADING)
                                        .addComponent(scoreLabel)
                                        .addComponent(scoreValueLabel))
                                .addGap(24)
                                .addGroup(gl_gameStatisticsPanel.createParallelGroup(Alignment.LEADING)
                                        .addComponent(healthLabel)
                                        .addComponent(healthValueLabel))
                                .addGap(24)
                                .addGroup(gl_gameStatisticsPanel.createParallelGroup(Alignment.LEADING)
                                        .addComponent(timeLabel)
                                        .addComponent(timeValueLabel)))
        );
        gameStatisticsPanel.setLayout(gl_gameStatisticsPanel);
    }

    private void setLayoutMainPanel() {
        GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
        gl_mainPanel.setHorizontalGroup(
                gl_mainPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addGap(10)
                                .addComponent(gameOverLabel, GroupLayout.PREFERRED_SIZE, 464, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addGap(10)
                                .addComponent(endReasonLabel, GroupLayout.PREFERRED_SIZE, 464, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addGap(10)
                                .addComponent(gameStatisticsPanel, GroupLayout.PREFERRED_SIZE, 464, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addGap(53)
                                .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                .addGap(27)
                                .addComponent(restartGameButton, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
        );
        gl_mainPanel.setVerticalGroup(
                gl_mainPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addGap(45)
                                .addComponent(gameOverLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(14)
                                .addComponent(endReasonLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addGap(11)
                                .addComponent(gameStatisticsPanel, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
                                .addGap(25)
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
                                        .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(restartGameButton, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
        );
        mainPanel.setLayout(gl_mainPanel);
    }

    private JLabel setReasonLabel(EndGameReason endGameReason) {
        switch (endGameReason) {
            case DIE -> {
                return new JLabel("You died!");
            }
            case OUT_OF_ATOMS -> {
                return new JLabel("You are out of atoms!");
            }
            case TIME_IS_OVER -> {
                return new JLabel("Time is over!");
            }
            case OUT_OF_FALLING_OBJECTS -> {
                return new JLabel("There is no falling objects left!");
            }
        }
        return new JLabel("");
    }

    public void disposeWindow() {
        window.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == restartGameButton) {
            controller.restartGame();
        }
        if (e.getSource() == backButton) {
            controller.returnMainMenu();
        }
    }
}
