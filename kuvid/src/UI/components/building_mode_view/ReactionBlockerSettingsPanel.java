package UI.components.building_mode_view;

import domain.controller.building_mode.ReactionBlockerSettingsPanelController;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ReactionBlockerSettingsPanel extends JPanel {
    private JPanel alphaBlockerPanel;
    private JLabel numAlphaBlockerLabel;
    private JSlider alphaBlockerSlider;
    private JLabel alphaBlockerSliderValueLabel;
    private JPanel betaBlockerPanel;
    private JLabel numBetaBlockerLabel;
    private JSlider betaBlockerSlider;
    private JLabel betaBlockerSliderValueLabel;
    private JPanel sigmaBlockerPanel;
    private JLabel numSigmaBlockerLabel;
    private JSlider sigmaBlockerSlider;
    private JLabel sigmaBlockerSliderValueLabel;
    private JPanel gammaBlockerPanel;
    private JLabel numGammaBlockerLabel;
    private JSlider gammaBlockerSlider;
    private JLabel gammaBlockerSliderValueLabel;
    private JLabel reactionBlockerSettingsLabel;
    private ReactionBlockerSettingsPanelController controller;

    public ReactionBlockerSettingsPanel() {
        this.setLayout(null);
        this.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        setAlphaBlockerPanel();
        setBetaBlockerPanel();
        setSigmaBlockerPanel();
        setGammaBlockerPanel();
        setReactionBlockerSettingsLabel();
        controller = new ReactionBlockerSettingsPanelController(alphaBlockerSliderValueLabel,
                betaBlockerSliderValueLabel, sigmaBlockerSliderValueLabel,
                gammaBlockerSliderValueLabel, alphaBlockerSlider, betaBlockerSlider,
                sigmaBlockerSlider, gammaBlockerSlider);
        addChangeListeners();
    }

    private void addChangeListeners() {
        alphaBlockerSlider.addChangeListener(controller);
        betaBlockerSlider.addChangeListener(controller);
        gammaBlockerSlider.addChangeListener(controller);
        sigmaBlockerSlider.addChangeListener(controller);
    }

    private void setReactionBlockerSettingsLabel() {
        reactionBlockerSettingsLabel = new JLabel("Reaction Blocker Settings");
        reactionBlockerSettingsLabel.setFont(new Font("Open Sans", Font.BOLD, 14));
        reactionBlockerSettingsLabel.setBounds(10, 15, 185, 30);
        this.add(reactionBlockerSettingsLabel);
    }

    private void setGammaBlockerPanel() {
        gammaBlockerPanel = new JPanel();
        gammaBlockerPanel.setLayout(null);
        gammaBlockerPanel.setBounds(10, 222, 385, 58);
        this.add(gammaBlockerPanel);

        numGammaBlockerLabel = new JLabel("Number of Gamma-b:");
        numGammaBlockerLabel.setBounds(0, 21, 188, 14);
        gammaBlockerPanel.add(numGammaBlockerLabel);

        gammaBlockerSlider = new JSlider(0, 100, 10);
        gammaBlockerSlider.setPaintTrack(true);
        gammaBlockerSlider.setPaintTicks(true);
        gammaBlockerSlider.setPaintLabels(true);
        gammaBlockerSlider.setMinorTickSpacing(10);
        gammaBlockerSlider.setMajorTickSpacing(25);
        gammaBlockerSlider.setBounds(150, 11, 200, 45);
        gammaBlockerPanel.add(gammaBlockerSlider);

        gammaBlockerSliderValueLabel = new JLabel("10");
        gammaBlockerSliderValueLabel.setBounds(360, 21, 55, 14);
        gammaBlockerPanel.add(gammaBlockerSliderValueLabel);
    }

    private void setSigmaBlockerPanel() {
        sigmaBlockerPanel = new JPanel();
        sigmaBlockerPanel.setLayout(null);
        sigmaBlockerPanel.setBounds(10, 163, 385, 58);
        this.add(sigmaBlockerPanel);

        numSigmaBlockerLabel = new JLabel("Number of Sigma-b:");
        numSigmaBlockerLabel.setBounds(0, 21, 188, 14);
        sigmaBlockerPanel.add(numSigmaBlockerLabel);

        sigmaBlockerSlider = new JSlider(0, 100, 10);
        sigmaBlockerSlider.setPaintTrack(true);
        sigmaBlockerSlider.setPaintTicks(true);
        sigmaBlockerSlider.setPaintLabels(true);
        sigmaBlockerSlider.setMinorTickSpacing(10);
        sigmaBlockerSlider.setMajorTickSpacing(25);
        sigmaBlockerSlider.setBounds(150, 11, 200, 45);
        sigmaBlockerPanel.add(sigmaBlockerSlider);

        sigmaBlockerSliderValueLabel = new JLabel("10");
        sigmaBlockerSliderValueLabel.setBounds(360, 21, 52, 14);
        sigmaBlockerPanel.add(sigmaBlockerSliderValueLabel);
    }

    private void setBetaBlockerPanel() {
        betaBlockerPanel = new JPanel();
        betaBlockerPanel.setLayout(null);
        betaBlockerPanel.setBounds(10, 106, 385, 58);
        this.add(betaBlockerPanel);

        numBetaBlockerLabel = new JLabel("Number of Beta-b:");
        numBetaBlockerLabel.setBounds(0, 21, 188, 14);
        betaBlockerPanel.add(numBetaBlockerLabel);

        betaBlockerSlider = new JSlider(0, 100, 10);
        betaBlockerSlider.setPaintTrack(true);
        betaBlockerSlider.setPaintTicks(true);
        betaBlockerSlider.setPaintLabels(true);
        betaBlockerSlider.setMinorTickSpacing(10);
        betaBlockerSlider.setMajorTickSpacing(25);
        betaBlockerSlider.setBounds(150, 11, 200, 45);
        betaBlockerPanel.add(betaBlockerSlider);

        betaBlockerSliderValueLabel = new JLabel("10");
        betaBlockerSliderValueLabel.setBounds(360, 21, 52, 14);
        betaBlockerPanel.add(betaBlockerSliderValueLabel);
    }

    private void setAlphaBlockerPanel() {
        alphaBlockerPanel = new JPanel();
        alphaBlockerPanel.setLayout(null);
        alphaBlockerPanel.setBorder(UIManager.getBorder("MenuItem.border"));
        alphaBlockerPanel.setBounds(10, 48, 385, 58);
        this.add(alphaBlockerPanel);

        numAlphaBlockerLabel = new JLabel("Number of Alpha-b:");
        numAlphaBlockerLabel.setBounds(0, 21, 188, 14);
        alphaBlockerPanel.add(numAlphaBlockerLabel);

        alphaBlockerSlider = new JSlider(0, 100, 10);
        alphaBlockerSlider.setPaintTrack(true);
        alphaBlockerSlider.setPaintTicks(true);
        alphaBlockerSlider.setPaintLabels(true);
        alphaBlockerSlider.setMinorTickSpacing(10);
        alphaBlockerSlider.setMajorTickSpacing(25);
        alphaBlockerSlider.setBounds(150, 11, 200, 45);
        alphaBlockerPanel.add(alphaBlockerSlider);

        alphaBlockerSliderValueLabel = new JLabel("10");
        alphaBlockerSliderValueLabel.setBounds(360, 21, 50, 14);
        alphaBlockerPanel.add(alphaBlockerSliderValueLabel);
    }
}
