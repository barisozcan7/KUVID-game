package UI.components.game_view.statistics_view;

import UI.views.GameView;
import domain.models.game.Game;
import utils.Utils;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class PlayerStatisticsPanel extends JPanel {
    private static JLabel timerValueLabel = new JLabel("");
    private static JLabel scoreValueLabel = new JLabel("");
    private static JLabel healthPointLabel = new JLabel("");
    private final JLabel scoreTextLabel = new JLabel("Score:");
    private final JLabel timeIconLabel = new JLabel("");
    private final JLabel healthIconLabel = new JLabel("");

    public PlayerStatisticsPanel() {
        this.setBorder(new MatteBorder(0, 0, 3, 1, (Color) Color.DARK_GRAY));
        this.setBounds(0, 0, 287, 200);
        this.setOpaque(false);
        this.setLayout(null);
        setScoreTextLabel();
        setTimerValueLabel();
        setScoreValueLabel();
        setHealthPointLabel();
        setTimeIconLabel();
        setHealthIconLabel();
        updateLabels();
    }

    public static void updateLabels() {
        timerValueLabel.setText(Utils.secondsToMMSS(Game.getInstance().getRemainingTime()));
        scoreValueLabel.setText(String.valueOf(Game.getInstance().getPlayer().getScore()));
        healthPointLabel.setText(String.valueOf(Game.getInstance().getPlayer().getHealth()));
    }

    private void setScoreTextLabel() {
        scoreTextLabel.setFont(new Font("Open Sans", Font.PLAIN, 22));
        scoreTextLabel.setBounds(20, 11, 100, 54);
        this.add(scoreTextLabel);
    }

    private void setTimerValueLabel() {
        timerValueLabel.setFont(new Font("Open Sans", Font.PLAIN, 22));
        timerValueLabel.setBounds(122, 64, 165, 54);
        this.add(timerValueLabel);
    }

    private void setScoreValueLabel() {
        scoreValueLabel.setFont(new Font("Open Sans", Font.PLAIN, 22));
        scoreValueLabel.setBounds(124, 11, 163, 54);
        this.add(scoreValueLabel);
    }

    private void setHealthPointLabel() {
        healthPointLabel.setFont(new Font("Open Sans", Font.PLAIN, 22));
        healthPointLabel.setBounds(122, 117, 165, 54);
        this.add(healthPointLabel);
    }

    private void setTimeIconLabel() {
        ImageIcon timeIcon = new ImageIcon(GameView.class.getResource("/clock.png"));
        Image timeIconImage = timeIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        timeIcon = new ImageIcon(timeIconImage);
        timeIconLabel.setIcon(timeIcon);
        timeIconLabel.setFont(new Font("Open Sans", Font.BOLD, 20));
        timeIconLabel.setBounds(20, 64, 100, 54);
        this.add(timeIconLabel);
    }

    private void setHealthIconLabel() {
        ImageIcon healthIcon = new ImageIcon(GameView.class.getResource("/hearth.png"));
        Image healthIconImage = healthIcon.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);
        healthIcon = new ImageIcon(healthIconImage);
        healthIconLabel.setIcon(healthIcon);
        healthIconLabel.setBounds(12, 117, 100, 54);
        this.add(healthIconLabel);
    }
}
