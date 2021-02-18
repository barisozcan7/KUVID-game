package UI.components.building_mode_view;

import domain.controller.building_mode.GamePlaySettingsPanelController;
import domain.enums.DifficultyLevel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.stream.Stream;

public class GamePlaySettingsPanel extends JPanel {
    private JPanel difficultyLevelPanel;
    private JList difficultyList;
    private JLabel difficultyLevelLabel;
    private JButton playButton;
    private JPanel valueOfLPanel;
    private JLabel valueOfLLabel;
    private JSlider lSlider;
    private JLabel lSliderValueLabel;
    private JLabel gameplaySettingsLabel;
    private GamePlaySettingsPanelController controller;
    private JButton backButton;

    public GamePlaySettingsPanel() {
        this.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        setLSettingsPanel();
        setDifficultyLevelPanel();
        setButtons();
        setGamePlaySettingsLabel();
        controller = new GamePlaySettingsPanelController(lSliderValueLabel, lSlider, difficultyList, playButton, backButton);
        addListeners();
    }

    private static String[] getDifficultyLevels() {
        return Stream.of(DifficultyLevel.values()).map(DifficultyLevel::name).toArray(String[]::new);
    }

    private void addListeners() {
        playButton.addActionListener(controller);
        lSlider.addChangeListener(controller);
        difficultyList.addListSelectionListener(controller);
        backButton.addActionListener(controller);
    }

    private void setButtons() {
        backButton = new JButton("Back to Menu");
        backButton.setBounds(764, 40, 150, 52);
        backButton.setForeground(Color.BLACK);
        backButton.setFont(new Font("Open Sans", Font.PLAIN, 14));
        backButton.setBackground(Color.LIGHT_GRAY);
        add(backButton);

        playButton = new JButton("Play");
        playButton.setBounds(972, 40, 150, 52);
        playButton.setForeground(Color.BLACK);
        playButton.setBackground(Color.WHITE);
        playButton.setFont(new Font("Open Sans", Font.PLAIN, 14));
        add(playButton);
    }

    private void setGamePlaySettingsLabel() {
        gameplaySettingsLabel = new JLabel("Gameplay Settings");
        gameplaySettingsLabel.setBounds(10, 15, 139, 30);
        gameplaySettingsLabel.setFont(new Font("Open Sans", Font.BOLD, 14));
        this.add(gameplaySettingsLabel);
    }

    private void setDifficultyLevelPanel() {
        difficultyLevelPanel = new JPanel();
        difficultyLevelPanel.setBounds(425, 40, 287, 66);
        this.add(difficultyLevelPanel);
        difficultyLevelLabel = new JLabel("Difficulty level:");
        difficultyLevelLabel.setBounds(0, 21, 102, 14);
        difficultyList = new JList(getDifficultyLevels());
        difficultyList.setBounds(150, 5, 75, 61);
        difficultyList.setSelectedIndex(0);
        difficultyLevelPanel.setLayout(null);
        difficultyLevelPanel.add(difficultyLevelLabel);
        difficultyLevelPanel.add(difficultyList);
    }

    private void setLSettingsPanel() {
        setLayout(null);
        valueOfLPanel = new JPanel();
        valueOfLPanel.setBounds(10, 40, 405, 58);
        valueOfLPanel.setLayout(null);
        valueOfLPanel.setBorder(UIManager.getBorder("MenuItem.border"));
        this.add(valueOfLPanel);

        valueOfLLabel = new JLabel("Value of L:");
        valueOfLLabel.setBounds(0, 21, 136, 14);
        valueOfLPanel.add(valueOfLLabel);

        lSlider = new JSlider(8, 12, 10);
        lSlider.setPaintTrack(true);
        lSlider.setPaintTicks(true);
        lSlider.setPaintLabels(true);
        lSlider.setMinorTickSpacing(1);
        lSlider.setMajorTickSpacing(4);
        lSlider.setBounds(106, 11, 200, 45);
        valueOfLPanel.add(lSlider);

        lSliderValueLabel = new JLabel("10%");
        lSliderValueLabel.setBounds(316, 21, 55, 14);
        valueOfLPanel.add(lSliderValueLabel);
    }
}
