package UI.components.blender_mode_view;

import domain.controller.blender.BlenderController;
import domain.enums.Type;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class InputPanel extends JPanel implements ItemListener, ActionListener {

    private JLabel sourceAtomLabel;
    private JComboBox sourceAtomComboBox;
    private JComboBox producedAtomComboBox;
    private JLabel producedAtomLabel;
    private JButton blendBreakButton;
    private BlenderController controller;
    private JLabel errorLabel;

    public InputPanel() {
        controller = new BlenderController();
        setFocusable(true);
        setSourceAtomForm();
        setProducedAtomForm();
        setButton();
        setErrorLabel();
        setInputPanelLayout();
    }

    private void setErrorLabel() {
        errorLabel = new JLabel("You can't blend/break selected atoms.");
        errorLabel.setForeground(Color.RED);
        errorLabel.setVisible(false);
    }

    private void changeErrorLabelVisibility(Boolean isVisible) {
        errorLabel.setVisible(isVisible);
    }

    private void setButton() {
        blendBreakButton = new JButton("Blend/Break");
        blendBreakButton.addActionListener(this);
    }

    private void setProducedAtomForm() {
        producedAtomComboBox = new JComboBox();
        producedAtomComboBox.setModel(new DefaultComboBoxModel(Type.values()));
        producedAtomComboBox.setToolTipText("Select an atom to produce");
        producedAtomComboBox.setMaximumRowCount(4);
        producedAtomComboBox.addItemListener(this);
        producedAtomLabel = new JLabel("Produced Atom:");
    }

    private void setSourceAtomForm() {
        sourceAtomLabel = new JLabel("Source Atom:");
        sourceAtomComboBox = new JComboBox();
        sourceAtomComboBox.setModel(new DefaultComboBoxModel(Type.values()));
        sourceAtomComboBox.setMaximumRowCount(4);
        sourceAtomComboBox.setToolTipText("Select a source atom");
        sourceAtomComboBox.addItemListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        changeErrorLabelVisibility(false);
        if (sourceAtomComboBox == e.getSource()) {
            controller.setSourceAtom((Type) sourceAtomComboBox.getSelectedItem());
        }

        if (producedAtomComboBox == e.getSource()) {
            controller.setProducedAtom((Type) producedAtomComboBox.getSelectedItem());
        }
    }

    private void setInputPanelLayout() {

        GroupLayout gl_inputPanel = new GroupLayout(this);
        gl_inputPanel.setHorizontalGroup(
                gl_inputPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_inputPanel.createSequentialGroup()
                                .addGap(20)
                                .addGroup(gl_inputPanel.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(sourceAtomLabel, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(sourceAtomComboBox, 0, 240, Short.MAX_VALUE)
                                        .addComponent(producedAtomLabel, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(producedAtomComboBox, 0, 240, Short.MAX_VALUE)
                                        .addComponent(blendBreakButton, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                        .addComponent(errorLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(190))
        );
        gl_inputPanel.setVerticalGroup(
                gl_inputPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_inputPanel.createSequentialGroup()
                                .addGap(58)
                                .addComponent(errorLabel)
                                .addGap(18)
                                .addComponent(sourceAtomLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                .addGap(13)
                                .addComponent(sourceAtomComboBox, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(30)
                                .addComponent(producedAtomLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                .addGap(13)
                                .addComponent(producedAtomComboBox, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(70)
                                .addComponent(blendBreakButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        );
        this.setLayout(gl_inputPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Boolean isApplied = controller.apply();
        if (!isApplied) {
            changeErrorLabelVisibility(true);
        }
    }
}
