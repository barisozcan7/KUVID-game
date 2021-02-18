package UI.components.building_mode_view;

import domain.controller.building_mode.PowerupSettingsPanelController;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PowerupSettingsPanel extends JPanel {
    private JPanel alphaPowerupPanel;
    private JLabel numAlphaPowerupLabel;
    private JSlider alphaPowerupSlider;
    private JLabel alphaPowerupSliderValueLabel;
    private JPanel betaPowerupPanel;
    private JLabel numBetaPowerupLabel;
    private JSlider betaPowerupSlider;
    private JLabel betaPowerupSliderValueLabel;
    private JPanel sigmaPowerupPanel;
    private JLabel numSigmaPowerupLabel;
    private JSlider sigmaPowerupSlider;
    private JLabel sigmaPowerupSliderValueLabel;
    private JPanel gammaPowerupPanel;
    private JLabel numGammaPowerupLabel;
    private JSlider gammaPowerupSlider;
    private JLabel gammaPowerupSliderValueLabel;
    private JLabel powerupSettingsLabel;
    private PowerupSettingsPanelController controller;

    public PowerupSettingsPanel() {
        this.setLayout(null);
        this.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        setAlphaPowerupPanel();
        setBetaPowerupPanel();
        setSigmaPowerupPanel();
        setGammaPowerupPanel();
        setPowerupSettingsLabel();
        controller = new PowerupSettingsPanelController(alphaPowerupSliderValueLabel, betaPowerupSliderValueLabel,
                sigmaPowerupSliderValueLabel, gammaPowerupSliderValueLabel,
                alphaPowerupSlider, betaPowerupSlider, sigmaPowerupSlider, gammaPowerupSlider);
        addChangeListeners();
    }

    private void addChangeListeners() {
        alphaPowerupSlider.addChangeListener(controller);
        betaPowerupSlider.addChangeListener(controller);
        gammaPowerupSlider.addChangeListener(controller);
        sigmaPowerupSlider.addChangeListener(controller);
    }

    private void setPowerupSettingsLabel() {
        powerupSettingsLabel = new JLabel("Powerup Settings");
        powerupSettingsLabel.setFont(new Font("Open Sans", Font.BOLD, 14));
        powerupSettingsLabel.setBounds(10, 15, 142, 30);
        this.add(powerupSettingsLabel);
    }

    private void setGammaPowerupPanel() {
        gammaPowerupPanel = new JPanel();
        gammaPowerupPanel.setLayout(null);
        gammaPowerupPanel.setBounds(10, 222, 389, 58);
        this.add(gammaPowerupPanel);

        numGammaPowerupLabel = new JLabel("Number of +Gamma-b:");
        numGammaPowerupLabel.setBounds(0, 21, 188, 14);
        gammaPowerupPanel.add(numGammaPowerupLabel);

        gammaPowerupSlider = new JSlider(0, 100, 20);
        gammaPowerupSlider.setPaintTrack(true);
        gammaPowerupSlider.setPaintTicks(true);
        gammaPowerupSlider.setPaintLabels(true);
        gammaPowerupSlider.setMinorTickSpacing(10);
        gammaPowerupSlider.setMajorTickSpacing(25);
        gammaPowerupSlider.setBounds(160, 11, 200, 45);
        gammaPowerupPanel.add(gammaPowerupSlider);

        gammaPowerupSliderValueLabel = new JLabel("20");
        gammaPowerupSliderValueLabel.setBounds(360, 21, 54, 14);
        gammaPowerupPanel.add(gammaPowerupSliderValueLabel);
    }

    private void setSigmaPowerupPanel() {
        sigmaPowerupPanel = new JPanel();
        sigmaPowerupPanel.setLayout(null);
        sigmaPowerupPanel.setBounds(10, 163, 389, 58);
        this.add(sigmaPowerupPanel);

        numSigmaPowerupLabel = new JLabel("Number of +Sigma-b:");
        numSigmaPowerupLabel.setBounds(0, 21, 188, 14);
        sigmaPowerupPanel.add(numSigmaPowerupLabel);

        sigmaPowerupSlider = new JSlider(0, 100, 20);
        sigmaPowerupSlider.setPaintTrack(true);
        sigmaPowerupSlider.setPaintTicks(true);
        sigmaPowerupSlider.setPaintLabels(true);
        sigmaPowerupSlider.setMinorTickSpacing(10);
        sigmaPowerupSlider.setMajorTickSpacing(25);
        sigmaPowerupSlider.setBounds(160, 11, 200, 45);
        sigmaPowerupPanel.add(sigmaPowerupSlider);

        sigmaPowerupSliderValueLabel = new JLabel("20");
        sigmaPowerupSliderValueLabel.setBounds(360, 21, 56, 14);
        sigmaPowerupPanel.add(sigmaPowerupSliderValueLabel);
    }

    private void setBetaPowerupPanel() {
        betaPowerupPanel = new JPanel();
        betaPowerupPanel.setLayout(null);
        betaPowerupPanel.setBounds(10, 106, 389, 58);
        this.add(betaPowerupPanel);

        numBetaPowerupLabel = new JLabel("Number of +Beta-b:");
        numBetaPowerupLabel.setBounds(0, 21, 188, 14);
        betaPowerupPanel.add(numBetaPowerupLabel);

        betaPowerupSlider = new JSlider(0, 100, 20);
        betaPowerupSlider.setPaintTrack(true);
        betaPowerupSlider.setPaintTicks(true);
        betaPowerupSlider.setPaintLabels(true);
        betaPowerupSlider.setMinorTickSpacing(10);
        betaPowerupSlider.setMajorTickSpacing(25);
        betaPowerupSlider.setBounds(160, 11, 200, 45);
        betaPowerupPanel.add(betaPowerupSlider);

        betaPowerupSliderValueLabel = new JLabel("20");
        betaPowerupSliderValueLabel.setBounds(360, 21, 61, 14);
        betaPowerupPanel.add(betaPowerupSliderValueLabel);
    }

    private void setAlphaPowerupPanel() {
        alphaPowerupPanel = new JPanel();
        alphaPowerupPanel.setLayout(null);
        alphaPowerupPanel.setBounds(10, 48, 389, 58);
        this.add(alphaPowerupPanel);

        numAlphaPowerupLabel = new JLabel("Number of +Alpha-b:");
        numAlphaPowerupLabel.setBounds(0, 21, 188, 14);
        alphaPowerupPanel.add(numAlphaPowerupLabel);

        alphaPowerupSlider = new JSlider(0, 100, 20);
        alphaPowerupSlider.setPaintTrack(true);
        alphaPowerupSlider.setPaintTicks(true);
        alphaPowerupSlider.setPaintLabels(true);
        alphaPowerupSlider.setMinorTickSpacing(10);
        alphaPowerupSlider.setMajorTickSpacing(25);
        alphaPowerupSlider.setBounds(160, 11, 200, 45);
        alphaPowerupPanel.add(alphaPowerupSlider);

        alphaPowerupSliderValueLabel = new JLabel("20");
        alphaPowerupSliderValueLabel.setBounds(360, 21, 59, 14);
        alphaPowerupPanel.add(alphaPowerupSliderValueLabel);
    }
}
