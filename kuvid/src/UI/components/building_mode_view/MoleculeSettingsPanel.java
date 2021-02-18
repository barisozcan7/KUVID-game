package UI.components.building_mode_view;

import domain.controller.building_mode.MoleculeSettingsPanelController;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoleculeSettingsPanel extends JPanel implements ActionListener {
    private JPanel alphaMoleculePanel;
    private JLabel numAlphaMoleculeLabel;
    private JSlider alphaMoleculeSlider;
    private JLabel alphaMoleculeSliderValueLabel;
    private JPanel betaMoleculePanel;
    private JLabel numBetaMoleculeLabel;
    private JSlider betaMoleculeSlider;
    private JLabel betaMoleculeSliderValueLabel;
    private JPanel sigmaMoleculePanel;
    private JLabel numSigmaMoleculeLabel;
    private JSlider sigmaMoleculeSlider;
    private JLabel sigmaMoleculeSliderValueLabel;
    private JPanel gammaMoleculePanel;
    private JLabel numGammaMoleculeLabel;
    private JSlider gammaMoleculeSlider;
    private JLabel gammaMoleculeSliderValueLabel;
    private JPanel alphaMoleculeStructurePanel;
    private JLabel structureAlphaLabel;
    private JLabel moleculeSettingsLabel;
    private ButtonGroup alphaStructureButtonGroup;
    private ButtonGroup betaStructureButtonGroup;
    private ButtonGroup alphaAnimationButtonGroup;
    private ButtonGroup betaAnimationButtonGroup;
    private JRadioButton alphaMoleculeLinearButton;
    private JRadioButton alphaMoleculeComplexButton;
    private JRadioButton alphaMoleculeStationaryButton;
    private JRadioButton alphaMoleculeSpinningButton;
    private JRadioButton betaMoleculeLinearButton;
    private JRadioButton betaMoleculeComplexButton;
    private JRadioButton betaMoleculeStationaryButton;
    private JRadioButton betaMoleculeSpinningButton;

    private MoleculeSettingsPanelController controller;

    public MoleculeSettingsPanel() {
        this.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        this.setLayout(null);
        setAlphaMoleculePanel();
        setBetaMoleculePanel();
        setSigmaMoleculePanel();
        setGammaMoleculePanel();
        setMoleculeSettingsLabel();
        setRadioButtons();
        controller = new MoleculeSettingsPanelController(alphaMoleculeSliderValueLabel, betaMoleculeSliderValueLabel,
                sigmaMoleculeSliderValueLabel, gammaMoleculeSliderValueLabel,
                alphaMoleculeSlider, betaMoleculeSlider, sigmaMoleculeSlider, gammaMoleculeSlider,
                alphaMoleculeLinearButton, alphaMoleculeComplexButton, alphaMoleculeStationaryButton, alphaMoleculeSpinningButton,
                betaMoleculeLinearButton, betaMoleculeComplexButton, betaMoleculeStationaryButton, betaMoleculeSpinningButton);
        addChangeListeners();
    }

    private void addChangeListeners() {
        alphaMoleculeSlider.addChangeListener(controller);
        betaMoleculeSlider.addChangeListener(controller);
        gammaMoleculeSlider.addChangeListener(controller);
        sigmaMoleculeSlider.addChangeListener(controller);
        alphaMoleculeLinearButton.addActionListener(controller);
        alphaMoleculeComplexButton.addActionListener(controller);
        alphaMoleculeStationaryButton.addActionListener(controller);
        alphaMoleculeSpinningButton.addActionListener(controller);
        betaMoleculeLinearButton.addActionListener(controller);
        betaMoleculeComplexButton.addActionListener(controller);
        betaMoleculeStationaryButton.addActionListener(controller);
        betaMoleculeSpinningButton.addActionListener(controller);
    }

    private void setRadioButtons() {
        alphaStructureButtonGroup = new ButtonGroup();
        alphaAnimationButtonGroup = new ButtonGroup();
        betaStructureButtonGroup = new ButtonGroup();
        betaAnimationButtonGroup = new ButtonGroup();

        alphaStructureButtonGroup.add(alphaMoleculeLinearButton);
        alphaStructureButtonGroup.add(alphaMoleculeComplexButton);
        alphaAnimationButtonGroup.add(alphaMoleculeSpinningButton);
        alphaAnimationButtonGroup.add(alphaMoleculeStationaryButton);

        betaStructureButtonGroup.add(betaMoleculeLinearButton);
        betaStructureButtonGroup.add(betaMoleculeComplexButton);
        betaAnimationButtonGroup.add(betaMoleculeSpinningButton);
        betaAnimationButtonGroup.add(betaMoleculeStationaryButton);

    }

    private void setMoleculeSettingsLabel() {
        moleculeSettingsLabel = new JLabel("Molecule Settings");
        moleculeSettingsLabel.setFont(new Font("Open Sans", Font.BOLD, 14));
        moleculeSettingsLabel.setBounds(10, 15, 142, 30);
        this.add(moleculeSettingsLabel);
    }

    private void setGammaMoleculePanel() {
        gammaMoleculePanel = new JPanel();
        gammaMoleculePanel.setLayout(null);
        gammaMoleculePanel.setBounds(10, 222, 402, 58);
        this.add(gammaMoleculePanel);

        numGammaMoleculeLabel = new JLabel("Number of Gamma-:");
        numGammaMoleculeLabel.setBounds(0, 21, 188, 14);
        gammaMoleculePanel.add(numGammaMoleculeLabel);

        gammaMoleculeSlider = new JSlider(25, 150, 100);
        gammaMoleculeSlider.setPaintTrack(true);
        gammaMoleculeSlider.setPaintTicks(true);
        gammaMoleculeSlider.setPaintLabels(true);
        gammaMoleculeSlider.setMinorTickSpacing(10);
        gammaMoleculeSlider.setMajorTickSpacing(25);
        gammaMoleculeSlider.setBounds(150, 11, 200, 45);
        gammaMoleculePanel.add(gammaMoleculeSlider);

        gammaMoleculeSliderValueLabel = new JLabel("100");
        gammaMoleculeSliderValueLabel.setBounds(360, 21, 43, 14);
        gammaMoleculePanel.add(gammaMoleculeSliderValueLabel);
    }

    private void setSigmaMoleculePanel() {
        sigmaMoleculePanel = new JPanel();
        sigmaMoleculePanel.setLayout(null);
        sigmaMoleculePanel.setBounds(10, 163, 402, 58);
        this.add(sigmaMoleculePanel);

        numSigmaMoleculeLabel = new JLabel("Number of Sigma-:");
        numSigmaMoleculeLabel.setBounds(0, 21, 188, 14);
        sigmaMoleculePanel.add(numSigmaMoleculeLabel);

        sigmaMoleculeSlider = new JSlider(25, 150, 100);
        sigmaMoleculeSlider.setPaintTrack(true);
        sigmaMoleculeSlider.setPaintTicks(true);
        sigmaMoleculeSlider.setPaintLabels(true);
        sigmaMoleculeSlider.setMinorTickSpacing(10);
        sigmaMoleculeSlider.setMajorTickSpacing(25);
        sigmaMoleculeSlider.setBounds(150, 11, 200, 45);
        sigmaMoleculePanel.add(sigmaMoleculeSlider);

        sigmaMoleculeSliderValueLabel = new JLabel("100");
        sigmaMoleculeSliderValueLabel.setBounds(360, 21, 39, 14);
        sigmaMoleculePanel.add(sigmaMoleculeSliderValueLabel);
    }

    private void setBetaMoleculePanel() {
        betaMoleculePanel = new JPanel();
        betaMoleculePanel.setLayout(null);
        betaMoleculePanel.setBounds(10, 106, 402, 58);
        this.add(betaMoleculePanel);

        numBetaMoleculeLabel = new JLabel("Number of Beta-:");
        numBetaMoleculeLabel.setBounds(0, 21, 188, 14);
        betaMoleculePanel.add(numBetaMoleculeLabel);

        betaMoleculeSlider = new JSlider(25, 150, 100);
        betaMoleculeSlider.setPaintTrack(true);
        betaMoleculeSlider.setPaintTicks(true);
        betaMoleculeSlider.setPaintLabels(true);
        betaMoleculeSlider.setMinorTickSpacing(10);
        betaMoleculeSlider.setMajorTickSpacing(25);
        betaMoleculeSlider.setBounds(150, 11, 200, 45);
        betaMoleculePanel.add(betaMoleculeSlider);

        betaMoleculeSliderValueLabel = new JLabel("100");
        betaMoleculeSliderValueLabel.setBounds(360, 21, 40, 14);
        betaMoleculePanel.add(betaMoleculeSliderValueLabel);

        JPanel betaMoleculeStructurePanel = new JPanel();
        betaMoleculeStructurePanel.setLayout(null);
        betaMoleculeStructurePanel.setBounds(422, 106, 380, 58);
        this.add(betaMoleculeStructurePanel);

        JLabel structureBetaLabel = new JLabel("Structure of Beta-:");
        structureBetaLabel.setBounds(0, 21, 141, 14);
        betaMoleculeStructurePanel.add(structureBetaLabel);

        betaMoleculeLinearButton = new JRadioButton("Linear");
        betaMoleculeLinearButton.setSelected(true);
        betaMoleculeLinearButton.setBounds(150, 17, 74, 23);
        betaMoleculeStructurePanel.add(betaMoleculeLinearButton);

        betaMoleculeComplexButton = new JRadioButton("Complex");
        betaMoleculeComplexButton.setBounds(260, 17, 124, 23);
        betaMoleculeStructurePanel.add(betaMoleculeComplexButton);

        JPanel betaMoleculeAnimationPanel = new JPanel();
        betaMoleculeAnimationPanel.setLayout(null);
        betaMoleculeAnimationPanel.setBounds(422, 222, 380, 58);
        this.add(betaMoleculeAnimationPanel);

        JLabel animationBetaLabel = new JLabel("Animation of Beta-:");
        animationBetaLabel.setBounds(0, 21, 145, 14);
        betaMoleculeAnimationPanel.add(animationBetaLabel);

        betaMoleculeStationaryButton = new JRadioButton("Stationary");
        betaMoleculeStationaryButton.setSelected(true);
        betaMoleculeStationaryButton.setBounds(151, 17, 104, 23);
        betaMoleculeAnimationPanel.add(betaMoleculeStationaryButton);

        betaMoleculeSpinningButton = new JRadioButton("Spinning");
        betaMoleculeSpinningButton.setBounds(260, 17, 104, 23);
        betaMoleculeAnimationPanel.add(betaMoleculeSpinningButton);
    }

    private void setAlphaMoleculePanel() {
        alphaMoleculePanel = new JPanel();
        alphaMoleculePanel.setBorder(UIManager.getBorder("MenuItem.border"));
        alphaMoleculePanel.setBounds(10, 48, 402, 58);
        this.add(alphaMoleculePanel);
        alphaMoleculePanel.setLayout(null);

        numAlphaMoleculeLabel = new JLabel("Number of Alpha-:");
        numAlphaMoleculeLabel.setBounds(0, 21, 188, 14);
        alphaMoleculePanel.add(numAlphaMoleculeLabel);

        alphaMoleculeSlider = new JSlider(25, 150, 100);
        alphaMoleculeSlider.setPaintTrack(true);
        alphaMoleculeSlider.setPaintTicks(true);
        alphaMoleculeSlider.setPaintLabels(true);
        alphaMoleculeSlider.setMinorTickSpacing(10);
        alphaMoleculeSlider.setMajorTickSpacing(25);
        alphaMoleculeSlider.setBounds(150, 11, 200, 45);
        alphaMoleculePanel.add(alphaMoleculeSlider);

        alphaMoleculeSliderValueLabel = new JLabel("100");
        alphaMoleculeSliderValueLabel.setBounds(360, 21, 42, 14);
        alphaMoleculePanel.add(alphaMoleculeSliderValueLabel);

        alphaMoleculeStructurePanel = new JPanel();
        alphaMoleculeStructurePanel.setLayout(null);
        alphaMoleculeStructurePanel.setBounds(422, 48, 380, 58);
        this.add(alphaMoleculeStructurePanel);

        structureAlphaLabel = new JLabel("Structure of Alpha-:");
        structureAlphaLabel.setBounds(0, 21, 154, 14);
        alphaMoleculeStructurePanel.add(structureAlphaLabel);

        alphaMoleculeLinearButton = new JRadioButton("Linear");
        alphaMoleculeLinearButton.setSelected(true);
        alphaMoleculeLinearButton.setBounds(150, 17, 74, 23);
        alphaMoleculeStructurePanel.add(alphaMoleculeLinearButton);

        alphaMoleculeComplexButton = new JRadioButton("Complex");
        alphaMoleculeComplexButton.setBounds(260, 17, 124, 23);
        alphaMoleculeStructurePanel.add(alphaMoleculeComplexButton);

        JPanel alphaMoleculeAnimationPanel = new JPanel();
        alphaMoleculeAnimationPanel.setLayout(null);
        alphaMoleculeAnimationPanel.setBounds(422, 163, 380, 58);
        this.add(alphaMoleculeAnimationPanel);

        JLabel animationAlphaLabel = new JLabel("Animation of Alpha-:");
        animationAlphaLabel.setBounds(0, 21, 144, 14);
        alphaMoleculeAnimationPanel.add(animationAlphaLabel);

        alphaMoleculeStationaryButton = new JRadioButton("Stationary");
        alphaMoleculeStationaryButton.setSelected(true);
        alphaMoleculeStationaryButton.setBounds(150, 17, 104, 23);
        alphaMoleculeAnimationPanel.add(alphaMoleculeStationaryButton);

        alphaMoleculeSpinningButton = new JRadioButton("Spinning");
        alphaMoleculeSpinningButton.setBounds(260, 17, 124, 23);
        alphaMoleculeAnimationPanel.add(alphaMoleculeSpinningButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
