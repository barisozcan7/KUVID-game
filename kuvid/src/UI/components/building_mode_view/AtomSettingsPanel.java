package UI.components.building_mode_view;

import domain.controller.building_mode.AtomSettingsPanelController;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class AtomSettingsPanel extends JPanel {
    private JPanel alphaAtomPanel;
    private JLabel numAlphaAtomLabel;
    private JSlider alphaAtomSlider;
    private JLabel alphaAtomSliderValueLabel;
    private JPanel betaAtomPanel;
    private JLabel numBetaAtomLabel;
    private JSlider betaAtomSlider;
    private JLabel betaAtomSliderValueLabel;
    private JPanel sigmaAtomPanel;
    private JLabel numSigmaAtomLabel;
    private JSlider sigmaAtomSlider;
    private JLabel sigmaAtomSliderValueLabel;
    private JPanel gammaAtomPanel;
    private JLabel numGammaAtomLabel;
    private JSlider gammaAtomSlider;
    private JLabel gammaAtomSliderValueLabel;
    private JLabel atomSettingsLabel;
    private AtomSettingsPanelController controller;

    public AtomSettingsPanel() {
        this.setLayout(null);
        this.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        setAlphaAtomPanel();
        setBetaAtomPanel();
        setSigmaAtomPanel();
        setGammaAtomPanel();
        setAtomSettingsLabel();
        controller = new AtomSettingsPanelController(alphaAtomSliderValueLabel, betaAtomSliderValueLabel,
                sigmaAtomSliderValueLabel, gammaAtomSliderValueLabel,
                alphaAtomSlider, betaAtomSlider, sigmaAtomSlider, gammaAtomSlider);
        addChangeListeners();
    }

    private void addChangeListeners() {
        alphaAtomSlider.addChangeListener(controller);
        betaAtomSlider.addChangeListener(controller);
        gammaAtomSlider.addChangeListener(controller);
        sigmaAtomSlider.addChangeListener(controller);
    }

    private void setAtomSettingsLabel() {
        atomSettingsLabel = new JLabel("Atom Settings");
        atomSettingsLabel.setFont(new Font("Open Sans", Font.BOLD, 14));
        atomSettingsLabel.setBounds(10, 15, 142, 30);
        this.add(atomSettingsLabel);
    }

    private void setGammaAtomPanel() {
        gammaAtomPanel = new JPanel();
        gammaAtomPanel.setLayout(null);
        gammaAtomPanel.setBounds(10, 222, 394, 58);
        this.add(gammaAtomPanel);

        numGammaAtomLabel = new JLabel("Number of Gamma:");
        numGammaAtomLabel.setBounds(0, 21, 188, 14);
        gammaAtomPanel.add(numGammaAtomLabel);

        gammaAtomSlider = new JSlider(25, 400, 100);
        gammaAtomSlider.setPaintTrack(true);
        gammaAtomSlider.setPaintTicks(true);
        gammaAtomSlider.setPaintLabels(true);
        gammaAtomSlider.setMinorTickSpacing(25);
        gammaAtomSlider.setMajorTickSpacing(75);
        gammaAtomSlider.setBounds(150, 11, 200, 45);
        gammaAtomPanel.add(gammaAtomSlider);

        gammaAtomSliderValueLabel = new JLabel("100");
        gammaAtomSliderValueLabel.setBounds(360, 21, 55, 14);
        gammaAtomPanel.add(gammaAtomSliderValueLabel);
    }

    private void setSigmaAtomPanel() {
        sigmaAtomPanel = new JPanel();
        sigmaAtomPanel.setLayout(null);
        sigmaAtomPanel.setBounds(10, 163, 394, 58);
        this.add(sigmaAtomPanel);

        numSigmaAtomLabel = new JLabel("Number of Sigma:");
        numSigmaAtomLabel.setBounds(0, 21, 188, 14);
        sigmaAtomPanel.add(numSigmaAtomLabel);

        sigmaAtomSlider = new JSlider(25, 400, 100);
        sigmaAtomSlider.setPaintTrack(true);
        sigmaAtomSlider.setPaintTicks(true);
        sigmaAtomSlider.setPaintLabels(true);
        sigmaAtomSlider.setMinorTickSpacing(25);
        sigmaAtomSlider.setMajorTickSpacing(75);
        sigmaAtomSlider.setBounds(150, 11, 200, 45);
        sigmaAtomPanel.add(sigmaAtomSlider);

        sigmaAtomSliderValueLabel = new JLabel("100");
        sigmaAtomSliderValueLabel.setBounds(360, 21, 53, 14);
        sigmaAtomPanel.add(sigmaAtomSliderValueLabel);
    }

    private void setBetaAtomPanel() {
        betaAtomPanel = new JPanel();
        betaAtomPanel.setLayout(null);
        betaAtomPanel.setBounds(10, 106, 394, 58);
        this.add(betaAtomPanel);

        numBetaAtomLabel = new JLabel("Number of Beta:");
        numBetaAtomLabel.setBounds(0, 21, 188, 14);
        betaAtomPanel.add(numBetaAtomLabel);

        betaAtomSlider = new JSlider(25, 400, 100);
        betaAtomSlider.setPaintTrack(true);
        betaAtomSlider.setPaintTicks(true);
        betaAtomSlider.setPaintLabels(true);
        betaAtomSlider.setMinorTickSpacing(25);
        betaAtomSlider.setMajorTickSpacing(75);
        betaAtomSlider.setBounds(150, 11, 200, 45);
        betaAtomPanel.add(betaAtomSlider);

        betaAtomSliderValueLabel = new JLabel("100");
        betaAtomSliderValueLabel.setBounds(360, 21, 51, 14);
        betaAtomPanel.add(betaAtomSliderValueLabel);
    }

    private void setAlphaAtomPanel() {
        alphaAtomPanel = new JPanel();
        alphaAtomPanel.setLayout(null);
        alphaAtomPanel.setBorder(UIManager.getBorder("MenuItem.border"));
        alphaAtomPanel.setBounds(10, 48, 394, 58);
        this.add(alphaAtomPanel);

        numAlphaAtomLabel = new JLabel("Number of Alpha:");
        numAlphaAtomLabel.setBounds(0, 21, 188, 14);
        alphaAtomPanel.add(numAlphaAtomLabel);

        alphaAtomSlider = new JSlider(25, 400, 100);
        alphaAtomSlider.setMinorTickSpacing(25);
        alphaAtomSlider.setPaintTrack(true);
        alphaAtomSlider.setPaintTicks(true);
        alphaAtomSlider.setPaintLabels(true);
        alphaAtomSlider.setMajorTickSpacing(75);
        alphaAtomSlider.setBounds(150, 11, 200, 45);
        alphaAtomPanel.add(alphaAtomSlider);

        alphaAtomSliderValueLabel = new JLabel("100");
        alphaAtomSliderValueLabel.setBounds(360, 21, 53, 14);
        alphaAtomPanel.add(alphaAtomSliderValueLabel);
    }
}
