package UI.components.game_view.statistics_view;

import UI.views.GameView;
import domain.models.game.Game;
import domain.models.player.Player;

import javax.swing.*;
import java.awt.*;

public class AtomStatisticsPanel extends JPanel {
    private static JLabel alphaAtomValueLabel = new JLabel("");
    private static JLabel gammaAtomValueLabel = new JLabel("");
    private static JLabel sigmaAtomValueLabel = new JLabel("");
    private static JLabel betaAtomValueLabel = new JLabel("");
    private final JLabel blenderIconLabel = new JLabel("");
    private final JLabel alphaAtomIconLabel = new JLabel("");
    private final JLabel gammaAtomIconLabel = new JLabel("");
    private final JLabel sigmaAtomIconLabel = new JLabel("");
    private final JLabel betaAtomIconLabel = new JLabel("");

    public AtomStatisticsPanel() {
        this.setOpaque(false);
        this.setBounds(0, 453, 287, 308);
        this.setLayout(null);
        setBlenderIconLabel();
        setAlphaAtomIconLabel();
        setGammaAtomIconLabel();
        setSigmaAtomIconLabel();
        setBetaAtomIconLabel();
        setAlphaAtomValueLabel();
        setGammaAtomValueLabel();
        setSigmaAtomValueLabel();
        setBetaAtomValueLabel();
        updateLabels();
    }

    public static String getTextOfAlphaAtomValueLabel() {
        return alphaAtomValueLabel.getText();
    }

    public static String getTextOfBetaAtomValueLabel() {
        return betaAtomValueLabel.getText();
    }

    public static String getTextOfGammaAtomValueLabel() {
        return gammaAtomValueLabel.getText();
    }

    public static String getTextOfSigmaAtomValueLabel() {
        return sigmaAtomValueLabel.getText();
    }

    public static void updateLabels() {
        Player player = Game.getInstance().getPlayer();
        alphaAtomValueLabel.setText(String.valueOf(player.getNumberOfAlphaAtoms()));
        betaAtomValueLabel.setText(String.valueOf(player.getNumberOfBetaAtoms()));
        gammaAtomValueLabel.setText(String.valueOf(player.getNumberOfGammaAtoms()));
        sigmaAtomValueLabel.setText(String.valueOf(player.getNumberOfSigmaAtoms()));
    }

    private void setBlenderIconLabel() {
        ImageIcon blenderIcon = new ImageIcon(GameView.class.getResource("/blender.png"));
        Image blenderIconImage = blenderIcon.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
        blenderIcon = new ImageIcon(blenderIconImage);
        blenderIconLabel.setIcon(blenderIcon);
        blenderIconLabel.setBounds(120, 11, 100, 54);
        this.add(blenderIconLabel);
    }

    private void setAlphaAtomIconLabel() {
        ImageIcon alphaAtomIcon = new ImageIcon(GameView.class.getResource("/alpha_atom.png"));
        Image alphaAtomIconImage = alphaAtomIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        alphaAtomIcon = new ImageIcon(alphaAtomIconImage);
        alphaAtomIconLabel.setIcon(alphaAtomIcon);
        alphaAtomIconLabel.setBounds(15, 79, 100, 54);
        this.add(alphaAtomIconLabel);
    }

    private void setGammaAtomIconLabel() {
        ImageIcon gammaAtomIcon = new ImageIcon(GameView.class.getResource("/gamma_atom.png"));
        Image gammaAtomIconImage = gammaAtomIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        gammaAtomIcon = new ImageIcon(gammaAtomIconImage);
        gammaAtomIconLabel.setIcon(gammaAtomIcon);
        gammaAtomIconLabel.setBounds(15, 132, 100, 54);
        this.add(gammaAtomIconLabel);
    }

    private void setSigmaAtomIconLabel() {
        ImageIcon sigmaAtomIcon = new ImageIcon(GameView.class.getResource("/sigma_atom.png"));
        Image sigmaAtomIconImage = sigmaAtomIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        sigmaAtomIcon = new ImageIcon(sigmaAtomIconImage);
        sigmaAtomIconLabel.setIcon(sigmaAtomIcon);
        sigmaAtomIconLabel.setBounds(15, 186, 100, 54);
        this.add(sigmaAtomIconLabel);
    }

    private void setBetaAtomIconLabel() {
        ImageIcon betaAtomIcon = new ImageIcon(GameView.class.getResource("/beta_atom.png"));
        Image betaAtomIconImage = betaAtomIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        betaAtomIcon = new ImageIcon(betaAtomIconImage);
        betaAtomIconLabel.setIcon(betaAtomIcon);
        betaAtomIconLabel.setBounds(15, 243, 100, 54);
        this.add(betaAtomIconLabel);
    }

    private void setAlphaAtomValueLabel() {
        alphaAtomValueLabel.setFont(new Font("Open Sans", Font.PLAIN, 22));
        alphaAtomValueLabel.setBounds(120, 76, 165, 54);
        this.add(alphaAtomValueLabel);
    }

    private void setGammaAtomValueLabel() {
        gammaAtomValueLabel.setFont(new Font("Open Sans", Font.PLAIN, 22));
        gammaAtomValueLabel.setBounds(120, 132, 165, 54);
        this.add(gammaAtomValueLabel);
    }

    private void setSigmaAtomValueLabel() {
        sigmaAtomValueLabel.setFont(new Font("Open Sans", Font.PLAIN, 22));
        sigmaAtomValueLabel.setBounds(120, 186, 165, 54);
        this.add(sigmaAtomValueLabel);
    }

    private void setBetaAtomValueLabel() {
        betaAtomValueLabel.setFont(new Font("Open Sans", Font.PLAIN, 22));
        betaAtomValueLabel.setBounds(120, 243, 165, 54);
        this.add(betaAtomValueLabel);
    }
}
