package UI.views;

import UI.components.building_mode_view.*;

import javax.swing.*;

public class BuildingModeView extends JPanel {
    private static JFrame buildingModeWindow;
    private JPanel mainPanel;
    private JPanel moleculeSettingsPanel;
    private JPanel atomSettingsPanel;
    private JPanel powerupSettingsPanel;
    private JPanel reactionBlockerSettingsPanel;
    private JPanel gamePlaySettingsPanel;
    private JPanel shieldSettingsPanel;

    public BuildingModeView() {
        mainPanel = new JPanel();
        mainPanel.setBorder(null);
        buildingModeWindow = createBuildingModeWindow();
        buildingModeWindow.getContentPane().add(mainPanel);
        buildingModeWindow.setVisible(true);

        moleculeSettingsPanel = new MoleculeSettingsPanel();
        moleculeSettingsPanel.setBounds(6, 11, 812, 302);
        atomSettingsPanel = new AtomSettingsPanel();
        atomSettingsPanel.setBounds(824, 11, 430, 302);
        powerupSettingsPanel = new PowerupSettingsPanel();
        powerupSettingsPanel.setBounds(824, 319, 426, 302);
        reactionBlockerSettingsPanel = new ReactionBlockerSettingsPanel();
        reactionBlockerSettingsPanel.setBounds(6, 319, 401, 302);
        gamePlaySettingsPanel = new GamePlaySettingsPanel();
        gamePlaySettingsPanel.setBounds(6, 627, 1244, 123);
        shieldSettingsPanel = new ShieldSettingsPanel();
        shieldSettingsPanel.setBounds(413, 319, 405, 302);
        setLayout();
    }

    private JFrame createBuildingModeWindow() {
        JFrame window = new JFrame();
        window.getContentPane().add(this);
        window.setSize(1280, 800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Building Mode");
        window.setLocationRelativeTo(null);
        window.setFocusable(true);
        return window;
    }

    public void disposeWindow() {
        buildingModeWindow.dispose();
    }

    private void setLayout() {
        mainPanel.setLayout(null);
        mainPanel.add(moleculeSettingsPanel);
        mainPanel.add(reactionBlockerSettingsPanel);
        mainPanel.add(powerupSettingsPanel);
        mainPanel.add(gamePlaySettingsPanel);
        mainPanel.add(atomSettingsPanel);
        mainPanel.add(shieldSettingsPanel);
    }
}
