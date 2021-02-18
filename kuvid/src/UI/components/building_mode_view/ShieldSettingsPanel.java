package UI.components.building_mode_view;

import domain.controller.building_mode.PowerupSettingsPanelController;
import domain.models.building_mode.BuildingMode;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ShieldSettingsPanel extends JPanel implements ChangeListener {
    private JPanel etaShieldPanel;
    private JLabel numEtaShieldLabel;
    private JSlider etaShieldSlider;
    private JLabel etaShieldSliderValueLabel;
    private JPanel lotaShieldPanel;
    private JLabel numLotaShieldLabel;
    private JSlider lotaShieldSlider;
    private JLabel lotaShieldSliderValueLabel;
    private JPanel thetaShieldPanel;
    private JLabel numThetaShieldLabel;
    private JSlider thetaShieldSlider;
    private JLabel thetaShieldSliderValueLabel;
    private JPanel zetaShieldPanel;
    private JLabel numZetaShieldLabel;
    private JSlider zetaShieldSlider;
    private JLabel zetaShieldSliderValueLabel;
    private JLabel shieldSettingsLabel;
    private PowerupSettingsPanelController controller;

    public ShieldSettingsPanel() {
        this.setLayout(null);
        this.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        setEtaShieldPanel();
        setLotaShieldPanel();
        setThetaShieldPanel();
        setZetaShieldPanel();
        setShieldSettingsLabel();
        addChangeListeners();
    }

    private void addChangeListeners() {
        etaShieldSlider.addChangeListener(this);
        lotaShieldSlider.addChangeListener(this);
        zetaShieldSlider.addChangeListener(this);
        thetaShieldSlider.addChangeListener(this);
    }

    private void setShieldSettingsLabel() {
        shieldSettingsLabel = new JLabel("Shield Settings");
        shieldSettingsLabel.setFont(new Font("Open Sans", Font.BOLD, 14));
        shieldSettingsLabel.setBounds(10, 15, 142, 30);
        this.add(shieldSettingsLabel);
    }

    private void setZetaShieldPanel() {
        zetaShieldPanel = new JPanel();
        zetaShieldPanel.setLayout(null);
        zetaShieldPanel.setBounds(10, 222, 389, 58);
        this.add(zetaShieldPanel);

        numZetaShieldLabel = new JLabel("Number of Zeta:");
        numZetaShieldLabel.setBounds(0, 21, 188, 14);
        zetaShieldPanel.add(numZetaShieldLabel);

        zetaShieldSlider = new JSlider(0, 50, 20);
        zetaShieldSlider.setPaintTrack(true);
        zetaShieldSlider.setPaintTicks(true);
        zetaShieldSlider.setPaintLabels(true);
        zetaShieldSlider.setMinorTickSpacing(10);
        zetaShieldSlider.setMajorTickSpacing(25);
        zetaShieldSlider.setBounds(160, 11, 200, 45);
        zetaShieldPanel.add(zetaShieldSlider);

        zetaShieldSliderValueLabel = new JLabel("20");
        zetaShieldSliderValueLabel.setBounds(360, 21, 54, 14);
        zetaShieldPanel.add(zetaShieldSliderValueLabel);
    }

    private void setThetaShieldPanel() {
        thetaShieldPanel = new JPanel();
        thetaShieldPanel.setLayout(null);
        thetaShieldPanel.setBounds(10, 163, 389, 58);
        this.add(thetaShieldPanel);

        numThetaShieldLabel = new JLabel("Number of Theta:");
        numThetaShieldLabel.setBounds(0, 21, 188, 14);
        thetaShieldPanel.add(numThetaShieldLabel);

        thetaShieldSlider = new JSlider(0, 50, 20);
        thetaShieldSlider.setPaintTrack(true);
        thetaShieldSlider.setPaintTicks(true);
        thetaShieldSlider.setPaintLabels(true);
        thetaShieldSlider.setMinorTickSpacing(10);
        thetaShieldSlider.setMajorTickSpacing(25);
        thetaShieldSlider.setBounds(160, 11, 200, 45);
        thetaShieldPanel.add(thetaShieldSlider);

        thetaShieldSliderValueLabel = new JLabel("20");
        thetaShieldSliderValueLabel.setBounds(360, 21, 56, 14);
        thetaShieldPanel.add(thetaShieldSliderValueLabel);
    }

    private void setLotaShieldPanel() {
        lotaShieldPanel = new JPanel();
        lotaShieldPanel.setLayout(null);
        lotaShieldPanel.setBounds(10, 106, 389, 58);
        this.add(lotaShieldPanel);

        numLotaShieldLabel = new JLabel("Number of Lota:");
        numLotaShieldLabel.setBounds(0, 21, 188, 14);
        lotaShieldPanel.add(numLotaShieldLabel);

        lotaShieldSlider = new JSlider(0, 50, 20);
        lotaShieldSlider.setPaintTrack(true);
        lotaShieldSlider.setPaintTicks(true);
        lotaShieldSlider.setPaintLabels(true);
        lotaShieldSlider.setMinorTickSpacing(10);
        lotaShieldSlider.setMajorTickSpacing(25);
        lotaShieldSlider.setBounds(160, 11, 200, 45);
        lotaShieldPanel.add(lotaShieldSlider);

        lotaShieldSliderValueLabel = new JLabel("20");
        lotaShieldSliderValueLabel.setBounds(360, 21, 61, 14);
        lotaShieldPanel.add(lotaShieldSliderValueLabel);
    }

    private void setEtaShieldPanel() {
        etaShieldPanel = new JPanel();
        etaShieldPanel.setLayout(null);
        etaShieldPanel.setBounds(10, 48, 389, 58);
        this.add(etaShieldPanel);

        numEtaShieldLabel = new JLabel("Number of Eta:");
        numEtaShieldLabel.setBounds(0, 21, 188, 14);
        etaShieldPanel.add(numEtaShieldLabel);

        etaShieldSlider = new JSlider(0, 50, 20);
        etaShieldSlider.setPaintTrack(true);
        etaShieldSlider.setPaintTicks(true);
        etaShieldSlider.setPaintLabels(true);
        etaShieldSlider.setMinorTickSpacing(10);
        etaShieldSlider.setMajorTickSpacing(25);
        etaShieldSlider.setBounds(160, 11, 200, 45);
        etaShieldPanel.add(etaShieldSlider);

        etaShieldSliderValueLabel = new JLabel("20");
        etaShieldSliderValueLabel.setBounds(360, 21, 59, 14);
        etaShieldPanel.add(etaShieldSliderValueLabel);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (etaShieldSlider == e.getSource()) {
            etaShieldSliderValueLabel.setText(String.valueOf(etaShieldSlider.getValue()));
            BuildingMode.getInstance().setNumberOfEtaShields(etaShieldSlider.getValue());
        } else if (zetaShieldSlider == e.getSource()) {
            zetaShieldSliderValueLabel.setText(String.valueOf(zetaShieldSlider.getValue()));
            BuildingMode.getInstance().setNumberOfZetaShields(zetaShieldSlider.getValue());
        } else if (thetaShieldSlider == e.getSource()) {
            thetaShieldSliderValueLabel.setText(String.valueOf(thetaShieldSlider.getValue()));
            BuildingMode.getInstance().setNumberOfThetaShields(thetaShieldSlider.getValue());
        } else if (lotaShieldSlider == e.getSource()) {
            lotaShieldSliderValueLabel.setText(String.valueOf(lotaShieldSlider.getValue()));
            BuildingMode.getInstance().setNumberOfLotaShields(lotaShieldSlider.getValue());
        }
    }
}
