package UI.views;

import UI.components.game_view.statistics_view.StatisticsPanel;
import domain.controller.save_load.SaveLoadController;
import domain.enums.SaveMode;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveGameView extends JPanel implements ActionListener, DocumentListener {

    private static JFrame window;
    private JTextField usernameInput;
    private JButton saveButton;
    private JLabel usernameLabel;
    private JLabel dbConnectionErrorLabel;
    private JLabel inputErrorLabel;
    private JRadioButton fileSaveButton;
    private JRadioButton dbSaveButton;
    private ButtonGroup saveOptionButtonGroup;
    private SaveMode saveMode = SaveMode.FILE;
    private final SaveLoadController controller;

    public SaveGameView() {
        controller = new SaveLoadController();
        setWindow();
        setInput();
        setLabel();
        setButton();
        setRadioButtons();
        setLayout();
    }

    private void setWindow() {
        window = new JFrame();
        window.getContentPane().add(this);
        window.setSize(250, 350);
        window.setTitle("Save Game");
        window.setVisible(true);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setFocusable(true);
    }

    private void setInput() {
        usernameInput = new JTextField();
        usernameInput.getDocument().addDocumentListener(this);
        usernameInput.setFont(new Font("Open Sans", Font.PLAIN, 14));
        usernameInput.setColumns(10);
    }

    private void setButton() {
        saveButton = new JButton("Save");
        saveButton.addActionListener(this);
        saveButton.setEnabled(false);
        saveButton.setFont(new Font("Open Sans", Font.PLAIN, 14));
    }

    private void setRadioButtons() {
        saveOptionButtonGroup = new ButtonGroup();
        fileSaveButton = new JRadioButton("File");
        fileSaveButton.setSelected(true);
        fileSaveButton.addActionListener(this);
        dbSaveButton = new JRadioButton("Database");
        dbSaveButton.addActionListener(this);
        if (!controller.isDbAvailable()) {
            dbSaveButton.setEnabled(false);
        }
        saveOptionButtonGroup.add(fileSaveButton);
        saveOptionButtonGroup.add(dbSaveButton);
    }

    private void setLabel() {
        dbConnectionErrorLabel = new JLabel("Could not connect to the Database.");
        dbConnectionErrorLabel.setVisible(!controller.isDbAvailable());
        usernameLabel = new JLabel("Enter your name:");
        usernameLabel.setFont(new Font("Open Sans", Font.PLAIN, 14));
        inputErrorLabel = new JLabel("");
        inputErrorLabel.setForeground(Color.RED);
    }

    private void setLayout() {

        dbConnectionErrorLabel.setForeground(Color.RED);

        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(15)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
        				.addComponent(usernameInput, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
        				.addComponent(inputErrorLabel, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(fileSaveButton, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
        					.addGap(2)
        					.addComponent(dbSaveButton, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
        				.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
        				.addComponent(dbConnectionErrorLabel, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(56)
        			.addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
        			.addGap(11)
        			.addComponent(usernameInput, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        			.addGap(11)
        			.addComponent(inputErrorLabel)
        			.addGap(13)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(fileSaveButton)
        				.addComponent(dbSaveButton))
        			.addGap(18)
        			.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        			.addGap(33)
        			.addComponent(dbConnectionErrorLabel))
        );
        setLayout(groupLayout);
    }

    public void disposeWindow() {
        window.dispose();
    }

    public SaveMode getSaveMode() {
        return saveMode;
    }

    public void setSaveMode(SaveMode saveMode) {
        this.saveMode = saveMode;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fileSaveButton) {
            setSaveMode(SaveMode.FILE);
        }
        if (e.getSource() == dbSaveButton) {
            setSaveMode(SaveMode.DATABASE);
        }
        if (e.getSource() == saveButton) {
            if (getSaveMode().equals(SaveMode.FILE)) {
                controller.save(SaveMode.FILE, usernameInput.getText());
            } else {
                controller.save(SaveMode.DATABASE, usernameInput.getText());
            }
            disposeWindow();
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        checkInputValidity();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        checkInputValidity();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        checkInputValidity();
    }

    public void checkInputValidity() {
        if (usernameInput.getText().length() == 0) {
            saveButton.setEnabled(false);
            inputErrorLabel.setText("Name can't be empty.");
            return;
        } else {
            inputErrorLabel.setText("");
            saveButton.setEnabled(true);
        }
    }
}
