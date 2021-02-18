package UI.components.game_view.statistics_view;

import UI.views.GameView;
import domain.controller.game.ShieldController;
import domain.models.game.Game;
import domain.models.player.Player;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static domain.enums.ShieldType.*;

public class PowerupAndShieldStatisticsPanel extends JPanel implements ActionListener {
    private static JLabel sigmaPowerupValueLabel = new JLabel("");
    private static JLabel betaPowerupValueLabel = new JLabel("");
    private static JLabel gammaPowerupValueLabel = new JLabel("");
    private static JLabel alphaPowerupValueLabel = new JLabel("");
    private static JLabel zetaShieldLabel;
    private static JLabel etaShieldLabel;
    private static JLabel lotaShieldLabel;
    private static JLabel thetaShieldLabel;
    private final JLabel sigmaPowerupIconLabel = new JLabel("");
    private final JLabel betaPowerupIconLabel = new JLabel("");
    private final JLabel alphaPowerupIconLabel = new JLabel("");
    private final JLabel gammaPowerupIconLabel = new JLabel("");
    private static JButton zetaShieldButton;
    private static JButton etaShieldButton;
    private static JButton lotaShieldButton;
    private static JButton thetaShieldButton;

    public PowerupAndShieldStatisticsPanel() {
        this.setBorder(new MatteBorder(0, 0, 3, 1, (Color) Color.DARK_GRAY));
        this.setBackground(new Color(0, 0, 0, 0));
        this.setBounds(0, 202, 287, 250);
        this.setLayout(null);
        this.setOpaque(false);
        setSigmaPowerupIconLabel();
        setBetaPowerupIconLabel();
        setAlphaPowerupIconLabel();
        setGammaPowerupIconLabel();
        setSigmaPowerupValueLabel();
        setBetaPowerupValueLabel();
        setAlphaPowerupValueLabel();
        setGammaPowerupValueLabel();
        setShieldButtons();
        setShieldLabels();
        updatePowerupLabels();
        updateShieldLabels();
    }

    public static void updatePowerupLabels() {
        Player player = Game.getInstance().getPlayer();
        alphaPowerupValueLabel.setText(String.valueOf(player.getNumberOfAlphaPowerups()));
        betaPowerupValueLabel.setText(String.valueOf(player.getNumberOfBetaPowerups()));
        gammaPowerupValueLabel.setText(String.valueOf(player.getNumberOfGammaPowerups()));
        sigmaPowerupValueLabel.setText(String.valueOf(player.getNumberOfSigmaPowerups()));
    }

    public static void updateShieldLabels() {
        Player player = Game.getInstance().getPlayer();
        etaShieldLabel.setText(String.valueOf(player.getNumberOfEtaShields()));
        lotaShieldLabel.setText(String.valueOf(player.getNumberOfLotaShields()));
        zetaShieldLabel.setText(String.valueOf(player.getNumberOfZetaShields()));
        thetaShieldLabel.setText(String.valueOf(player.getNumberOfThetaShields()));
    }

    private void setSigmaPowerupIconLabel() {
        ImageIcon sigmaPowerupIcon = new ImageIcon(GameView.class.getResource("/sigma_powerup.png"));
        Image sigmaPowerupImage = sigmaPowerupIcon.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
        sigmaPowerupIcon = new ImageIcon(sigmaPowerupImage);
        sigmaPowerupIconLabel.setIcon(sigmaPowerupIcon);
        sigmaPowerupIconLabel.setBounds(20, 11, 70, 54);
        this.add(sigmaPowerupIconLabel);
    }

    private void setBetaPowerupIconLabel() {
        ImageIcon betaPowerupIcon = new ImageIcon(GameView.class.getResource("/beta_powerup.png"));
        Image betaPowerupImage = betaPowerupIcon.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
        betaPowerupIcon = new ImageIcon(betaPowerupImage);
        betaPowerupIconLabel.setIcon(betaPowerupIcon);
        betaPowerupIconLabel.setBounds(20, 66, 70, 54);
        this.add(betaPowerupIconLabel);
    }

    private void setAlphaPowerupIconLabel() {
        ImageIcon alphaPowerupIcon = new ImageIcon(GameView.class.getResource("/alpha_powerup.png"));
        Image alphaPowerupImage = alphaPowerupIcon.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
        alphaPowerupIcon = new ImageIcon(alphaPowerupImage);
        alphaPowerupIconLabel.setIcon(alphaPowerupIcon);
        alphaPowerupIconLabel.setBounds(20, 120, 70, 54);
        this.add(alphaPowerupIconLabel);
    }

    private void setGammaPowerupIconLabel() {
        ImageIcon gammaPowerupIcon = new ImageIcon(GameView.class.getResource("/gamma_powerup.png"));
        Image gammaPowerupImage = gammaPowerupIcon.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
        gammaPowerupIcon = new ImageIcon(gammaPowerupImage);
        gammaPowerupIconLabel.setIcon(gammaPowerupIcon);
        gammaPowerupIconLabel.setBounds(20, 174, 70, 54);
        this.add(gammaPowerupIconLabel);
    }

    private void setSigmaPowerupValueLabel() {
        sigmaPowerupValueLabel.setFont(new Font("Open Sans", Font.PLAIN, 22));
        sigmaPowerupValueLabel.setBounds(100, 11, 30, 54);
        this.add(sigmaPowerupValueLabel);
    }

    private void setBetaPowerupValueLabel() {
        betaPowerupValueLabel.setFont(new Font("Open Sans", Font.PLAIN, 22));
        betaPowerupValueLabel.setBounds(100, 66, 30, 54);
        this.add(betaPowerupValueLabel);
    }

    private void setAlphaPowerupValueLabel() {
        alphaPowerupValueLabel.setFont(new Font("Open Sans", Font.PLAIN, 22));
        alphaPowerupValueLabel.setBounds(100, 120, 30, 54);
        this.add(alphaPowerupValueLabel);
    }

    private void setGammaPowerupValueLabel() {
        gammaPowerupValueLabel.setFont(new Font("Open Sans", Font.PLAIN, 22));
        gammaPowerupValueLabel.setBounds(100, 174, 30, 54);
        this.add(gammaPowerupValueLabel);
    }

    private void setShieldLabels() {
        etaShieldLabel = new JLabel("0");
        etaShieldLabel.setFont(new Font("Open Sans", Font.PLAIN, 22));
        etaShieldLabel.setBounds(236, 11, 30, 54);
        add(etaShieldLabel);

        thetaShieldLabel = new JLabel("0");
        thetaShieldLabel.setFont(new Font("Open Sans", Font.PLAIN, 22));
        thetaShieldLabel.setBounds(236, 66, 30, 54);
        add(thetaShieldLabel);

        lotaShieldLabel = new JLabel("0");
        lotaShieldLabel.setFont(new Font("Open Sans", Font.PLAIN, 22));
        lotaShieldLabel.setBounds(236, 120, 30, 54);
        add(lotaShieldLabel);

        zetaShieldLabel = new JLabel("0");
        zetaShieldLabel.setFont(new Font("Open Sans", Font.PLAIN, 22));
        zetaShieldLabel.setBounds(236, 174, 30, 54);
        add(zetaShieldLabel);
    }

    private void setShieldButtons() {
        etaShieldButton = new JButton("Eta");
        etaShieldButton.setBounds(130, 25, 80, 30);
        etaShieldButton.addActionListener(this);
        etaShieldButton.setFocusable(false);
        add(etaShieldButton);

        thetaShieldButton = new JButton("Theta");
        thetaShieldButton.setBounds(130, 80, 80, 30);
        thetaShieldButton.addActionListener(this);
        thetaShieldButton.setFocusable(false);
        add(thetaShieldButton);

        lotaShieldButton = new JButton("Lota");
        lotaShieldButton.setBounds(130, 135, 80, 30);
        lotaShieldButton.addActionListener(this);
        lotaShieldButton.setFocusable(false);
        add(lotaShieldButton);

        zetaShieldButton = new JButton("Zeta");
        zetaShieldButton.setBounds(130, 190, 80, 30);
        zetaShieldButton.addActionListener(this);
        zetaShieldButton.setFocusable(false);
        add(zetaShieldButton);
    }

    public static void disableShieldButtons() {
        zetaShieldButton.setEnabled(false);
        etaShieldButton.setEnabled(false);
        lotaShieldButton.setEnabled(false);
        thetaShieldButton.setEnabled(false);
    }

    public static void enableShieldButtons() {
        zetaShieldButton.setEnabled(true);
        etaShieldButton.setEnabled(true);
        lotaShieldButton.setEnabled(true);
        thetaShieldButton.setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == etaShieldButton) {
            ShieldController.addShield(ETA);
        }
        if (e.getSource() == thetaShieldButton) {
            ShieldController.addShield(THETA);
        }
        if (e.getSource() == lotaShieldButton) {
            ShieldController.addShield(LOTA);
        }
        if (e.getSource() == zetaShieldButton) {
            ShieldController.addShield(ZETA);
        }
    }
}
