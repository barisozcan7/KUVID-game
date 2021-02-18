package domain.controller.building_mode;

import domain.enums.MoleculeAnimation;
import domain.enums.MoleculeStructure;
import domain.models.building_mode.BuildingMode;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoleculeSettingsPanelController implements ChangeListener, ActionListener {

    JRadioButton alphaMoleculeLinearButton;
    JRadioButton alphaMoleculeComplexButton;
    JRadioButton alphaMoleculeStationaryButton;
    JRadioButton alphaMoleculeSpinningButton;
    JRadioButton betaMoleculeLinearButton;
    JRadioButton betaMoleculeComplexButton;
    JRadioButton betaMoleculeStationaryButton;
    JRadioButton betaMoleculeSpinningButton;
    private JLabel alphaValueLabel;
    private JLabel betaValueLabel;
    private JLabel sigmaValueLabel;
    private JLabel gammaValueLabel;
    private JSlider alphaSlider;
    private JSlider betaSlider;
    private JSlider sigmaSlider;
    private JSlider gammaSlider;

    public MoleculeSettingsPanelController(JLabel alphaValueLabel, JLabel betaValueLabel,
                                           JLabel sigmaValueLabel, JLabel gammaValueLabel,
                                           JSlider alphaSlider, JSlider betaSlider,
                                           JSlider sigmaSlider, JSlider gammaSlider,
                                           JRadioButton alphaMoleculeLinearButton, JRadioButton alphaMoleculeComplexButton,
                                           JRadioButton alphaMoleculeStationaryButton, JRadioButton alphaMoleculeSpinningButton,
                                           JRadioButton betaMoleculeLinearButton, JRadioButton betaMoleculeComplexButton,
                                           JRadioButton betaMoleculeStationaryButton, JRadioButton betaMoleculeSpinningButton) {
        this.alphaValueLabel = alphaValueLabel;
        this.betaValueLabel = betaValueLabel;
        this.sigmaValueLabel = sigmaValueLabel;
        this.gammaValueLabel = gammaValueLabel;
        this.alphaSlider = alphaSlider;
        this.betaSlider = betaSlider;
        this.sigmaSlider = sigmaSlider;
        this.gammaSlider = gammaSlider;
        this.alphaMoleculeLinearButton = alphaMoleculeLinearButton;
        this.alphaMoleculeComplexButton = alphaMoleculeComplexButton;
        this.alphaMoleculeStationaryButton = alphaMoleculeStationaryButton;
        this.alphaMoleculeSpinningButton = alphaMoleculeSpinningButton;
        this.betaMoleculeLinearButton = betaMoleculeLinearButton;
        this.betaMoleculeComplexButton = betaMoleculeComplexButton;
        this.betaMoleculeStationaryButton = betaMoleculeStationaryButton;
        this.betaMoleculeSpinningButton = betaMoleculeSpinningButton;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (alphaSlider == e.getSource()) {
            alphaValueLabel.setText(String.valueOf(alphaSlider.getValue()));
            BuildingMode.getInstance().setNumberOfAlphaMolecules(alphaSlider.getValue());
        } else if (betaSlider == e.getSource()) {
            betaValueLabel.setText(String.valueOf(betaSlider.getValue()));
            BuildingMode.getInstance().setNumberOfBetaMolecules(betaSlider.getValue());
        } else if (sigmaSlider == e.getSource()) {
            sigmaValueLabel.setText(String.valueOf(sigmaSlider.getValue()));
            BuildingMode.getInstance().setNumberOfSigmaMolecules(sigmaSlider.getValue());
        } else if (gammaSlider == e.getSource()) {
            gammaValueLabel.setText(String.valueOf(gammaSlider.getValue()));
            BuildingMode.getInstance().setNumberOfGammaMolecules(gammaSlider.getValue());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (alphaMoleculeLinearButton == e.getSource()) {
            BuildingMode.getInstance().setAlphaMoleculeStructure(MoleculeStructure.LINEAR);
            alphaMoleculeSpinningButton.setEnabled(true);
        } else if (alphaMoleculeComplexButton == e.getSource()) {
            BuildingMode.getInstance().setAlphaMoleculeStructure(MoleculeStructure.COMPLEX);
            alphaMoleculeStationaryButton.setSelected(true);
            alphaMoleculeSpinningButton.setEnabled(false);
            BuildingMode.getInstance().setAlphaMoleculeAnimation(MoleculeAnimation.STATIONARY);
        } else if (betaMoleculeLinearButton == e.getSource()) {
            BuildingMode.getInstance().setBetaMoleculeStructure(MoleculeStructure.LINEAR);
            betaMoleculeSpinningButton.setEnabled(true);
        } else if (betaMoleculeComplexButton == e.getSource()) {
            BuildingMode.getInstance().setBetaMoleculeStructure(MoleculeStructure.COMPLEX);
            betaMoleculeStationaryButton.setSelected(true);
            betaMoleculeSpinningButton.setEnabled(false);
            BuildingMode.getInstance().setBetaMoleculeAnimation(MoleculeAnimation.STATIONARY);
        } else if (alphaMoleculeSpinningButton == e.getSource()) {
            BuildingMode.getInstance().setAlphaMoleculeAnimation(MoleculeAnimation.SPINNING);
        } else if (alphaMoleculeStationaryButton == e.getSource()) {
            BuildingMode.getInstance().setAlphaMoleculeAnimation(MoleculeAnimation.STATIONARY);
        } else if (betaMoleculeSpinningButton == e.getSource()) {
            BuildingMode.getInstance().setBetaMoleculeAnimation(MoleculeAnimation.SPINNING);
        } else if (betaMoleculeStationaryButton == e.getSource()) {
            BuildingMode.getInstance().setBetaMoleculeAnimation(MoleculeAnimation.STATIONARY);
        }
    }
}
