package domain.controller.building_mode;

import domain.enums.DifficultyLevel;
import domain.enums.GameMode;
import domain.models.building_mode.BuildingMode;
import service.view_service.ViewFactory;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePlaySettingsPanelController implements ChangeListener, ActionListener, ListSelectionListener {

    private JLabel lengthValueLabel;
    private JSlider lengthSlider;
    private JList difficultyList;
    private JButton playButton;
    private JButton backButton;

    public GamePlaySettingsPanelController(JLabel lengthValueLabel, JSlider lengthSlider, JList difficultyList, JButton playButton, JButton backButton) {
        super();
        this.lengthValueLabel = lengthValueLabel;
        this.lengthSlider = lengthSlider;
        this.difficultyList = difficultyList;
        this.playButton = playButton;
        this.backButton = backButton;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        lengthValueLabel.setText(String.valueOf(lengthSlider.getValue()) + "%");
        BuildingMode.getInstance().setLengthValuePercentage(lengthSlider.getValue());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            ViewFactory.getInstance().getView(GameMode.GAME);
        }
        if (e.getSource() == backButton) {
            ViewFactory.getInstance().removeView(GameMode.BUILDING_MODE);
            ViewFactory.getInstance().getView(GameMode.MAIN_MENU);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        BuildingMode.getInstance().setDifficultyLevel(DifficultyLevel.
                stringToEnum((String) difficultyList.getSelectedValue()));
    }
}
