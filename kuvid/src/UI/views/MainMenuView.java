package UI.views;

import UI.components.main_menu_view.MainMenuOptionsView;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.*;

public class MainMenuView extends JPanel {

    private static MainMenuOptionsView mainMenuOptionsView;
    private JFrame window;
    private JLabel subtitleLabel;
    private JLabel titleLabel;
    private JLabel titleShadowLabel;
    private JLabel teamLabel;

    public MainMenuView() {
        setWindow();
        setLabels();
        setOptions();
        setLayout();
    }

    private void setWindow() {
        setBackground(Color.BLACK);
        window = new JFrame();
        window.getContentPane().add(this);
        window.setSize(1280, 670);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Main Menu");
        window.setLocationRelativeTo(null);
        window.setFocusable(true);
        window.setVisible(true);
    }

    private void setOptions() {
        mainMenuOptionsView = new MainMenuOptionsView();
        mainMenuOptionsView.setBounds(357, 206, 550, 350);
        mainMenuOptionsView.setVisible(true);
        add(mainMenuOptionsView);
    }

    private void setLayout() {
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(10)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 1244, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(titleShadowLabel, GroupLayout.PREFERRED_SIZE, 1244, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(subtitleLabel, GroupLayout.PREFERRED_SIZE, 1244, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(teamLabel, GroupLayout.PREFERRED_SIZE, 1244, GroupLayout.PREFERRED_SIZE)))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(49)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(7)
                                                .addComponent(titleShadowLabel, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(99)
                                                .addComponent(subtitleLabel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
                                .addGap(354)
                                .addComponent(teamLabel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
        );
        setLayout(groupLayout);
    }

    private void setLabels() {
        subtitleLabel = new JLabel("A space adventure!");
        subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        subtitleLabel.setFont(new Font("Open Sans", Font.PLAIN, 22));
        subtitleLabel.setForeground(Color.YELLOW);

        titleLabel = new JLabel("KUVID");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setForeground(Color.LIGHT_GRAY);
        titleLabel.setFont(new Font("Open Sans", Font.BOLD, 96));

        titleShadowLabel = new JLabel("KUVID");
        titleShadowLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleShadowLabel.setForeground(Color.DARK_GRAY);
        titleShadowLabel.setFont(new Font("Open Sans", Font.BOLD, 96));

        teamLabel = new JLabel("Attila Fan Club");
        teamLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        teamLabel.setForeground(Color.WHITE);
        teamLabel.setFont(new Font("Open Sans", Font.PLAIN, 16));
    }

    public void disposeWindow() {
        window.dispose();
    }
}
