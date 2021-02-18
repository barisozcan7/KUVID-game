package UI.components.game_view.statistics_view;

import configs.UIConstants;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class StatisticsPanel extends JPanel {
    private final JPanel playerStatisticsPanel;
    private final JPanel powerupPanel;
    private final JPanel atomPanel;

    public StatisticsPanel() {
        this.setBorder(new MatteBorder(0, 3, 0, 0, (Color) Color.DARK_GRAY));
        this.setOpaque(false);
        this.setBounds(UIConstants.GAME_PANEL_WIDTH, 0, 287, 761);
        this.setLayout(null);
        playerStatisticsPanel = new PlayerStatisticsPanel();
        powerupPanel = new PowerupAndShieldStatisticsPanel();
        atomPanel = new AtomStatisticsPanel();
        this.add(playerStatisticsPanel);
        this.add(powerupPanel);
        this.add(atomPanel);
    }

    public static void updateAllLabels() {
        AtomStatisticsPanel.updateLabels();
        PlayerStatisticsPanel.updateLabels();
        PowerupAndShieldStatisticsPanel.updatePowerupLabels();
    }
}
