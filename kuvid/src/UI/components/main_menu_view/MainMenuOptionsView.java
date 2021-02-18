package UI.components.main_menu_view;

import domain.controller.main_menu.MainMenuController;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuOptionsView extends JPanel implements ActionListener {

    private JButton playButton;
    private JButton loadGameButton;
    private JButton quitButton;
    private JButton buildingModeButton;
    private MainMenuController mainMenuController;

    public MainMenuOptionsView() {
        setPanel();
        setButtons();
        setLayout();
        mainMenuController = new MainMenuController();
    }

    private void setPanel() {
        setBackground(Color.BLACK);
        this.setSize(550, 350);
    }

    private void setButtons() {
        playButton = new JButton("Play");
        playButton.setForeground(Color.BLACK);
        playButton.setFont(new Font("Open Sans", Font.BOLD, 16));
        playButton.setBackground(Color.DARK_GRAY);
        playButton.addActionListener(this);

        loadGameButton = new JButton("Load Game");
        loadGameButton.setForeground(Color.BLACK);
        loadGameButton.setFont(new Font("Open Sans", Font.BOLD, 16));
        loadGameButton.setBackground(Color.DARK_GRAY);
        loadGameButton.addActionListener(this);

        buildingModeButton = new JButton("Building Mode");
        buildingModeButton.setForeground(Color.BLACK);
        buildingModeButton.setFont(new Font("Open Sans", Font.BOLD, 16));
        buildingModeButton.setBackground(Color.DARK_GRAY);
        buildingModeButton.addActionListener(this);

        quitButton = new JButton("Quit Game");
        quitButton.setForeground(Color.BLACK);
        quitButton.setFont(new Font("Open Sans", Font.BOLD, 16));
        quitButton.setBackground(Color.DARK_GRAY);
        quitButton.addActionListener(this);

    }

    private void setLayout() {
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(10)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(playButton, GroupLayout.PREFERRED_SIZE, 530, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buildingModeButton, GroupLayout.PREFERRED_SIZE, 530, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(loadGameButton, GroupLayout.PREFERRED_SIZE, 530, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(quitButton, GroupLayout.PREFERRED_SIZE, 530, GroupLayout.PREFERRED_SIZE)))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(50)
                                .addComponent(playButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                .addGap(12)
                                .addComponent(buildingModeButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                .addGap(12)
                                .addComponent(loadGameButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                .addGap(12)
                                .addComponent(quitButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
        );
        setLayout(groupLayout);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buildingModeButton) {
            mainMenuController.enterBuildingMode();
        }
        if (e.getSource() == playButton) {
            mainMenuController.playGame();
        }
        if (e.getSource() == loadGameButton) {
            mainMenuController.getLoadGameView();
        }
        if (e.getSource() == quitButton) {
            mainMenuController.exitGame();
        }
    }
}
