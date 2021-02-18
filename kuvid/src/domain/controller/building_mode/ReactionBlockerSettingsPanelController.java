package domain.controller.building_mode;

import domain.models.building_mode.BuildingMode;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ReactionBlockerSettingsPanelController implements ChangeListener {
    private JLabel alphaValueLabel;
    private JLabel betaValueLabel;
    private JLabel sigmaValueLabel;
    private JLabel gammaValueLabel;
    private JSlider alphaSlider;
    private JSlider betaSlider;
    private JSlider sigmaSlider;
    private JSlider gammaSlider;

    public ReactionBlockerSettingsPanelController(JLabel alphaValueLabel, JLabel betaValueLabel,
                                                  JLabel sigmaValueLabel, JLabel gammaValueLabel,
                                                  JSlider alphaSlider, JSlider betaSlider,
                                                  JSlider sigmaSlider, JSlider gammaSlider) {
        this.alphaValueLabel = alphaValueLabel;
        this.betaValueLabel = betaValueLabel;
        this.sigmaValueLabel = sigmaValueLabel;
        this.gammaValueLabel = gammaValueLabel;
        this.alphaSlider = alphaSlider;
        this.betaSlider = betaSlider;
        this.sigmaSlider = sigmaSlider;
        this.gammaSlider = gammaSlider;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (alphaSlider == e.getSource()) {
            alphaValueLabel.setText(String.valueOf(alphaSlider.getValue()));
            BuildingMode.getInstance().setNumberOfAlphaBlockers(alphaSlider.getValue());
        } else if (betaSlider == e.getSource()) {
            betaValueLabel.setText(String.valueOf(betaSlider.getValue()));
            BuildingMode.getInstance().setNumberOfBetaBlockers(betaSlider.getValue());
        } else if (sigmaSlider == e.getSource()) {
            sigmaValueLabel.setText(String.valueOf(sigmaSlider.getValue()));
            BuildingMode.getInstance().setNumberOfSigmaBlockers(sigmaSlider.getValue());
        } else if (gammaSlider == e.getSource()) {
            gammaValueLabel.setText(String.valueOf(gammaSlider.getValue()));
            BuildingMode.getInstance().setNumberOfGammaBlockers(gammaSlider.getValue());
        }
    }
}
