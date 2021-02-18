package UI.views;

import UI.components.blender_mode_view.InfoPanel;
import UI.components.blender_mode_view.InputPanel;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

public class BlenderModeView extends JPanel {

    private static JFrame window;
    private InfoPanel infoPanel;
    private InputPanel inputPanel;

    public BlenderModeView() {
        infoPanel = new InfoPanel();
        inputPanel = new InputPanel();
        setWindow();
        setLayout();
    }

    private void setWindow() {
        window = new JFrame();
        window.getContentPane().add(this);
        window.setSize(560, 560);
        window.setTitle("Blending Mode");
        window.setVisible(true);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setFocusable(true);
        window.add(infoPanel);
        window.add(inputPanel);
    }

    public void disposeWindow() {
        window.dispose();
    }

    private void setLayout() {
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addComponent(inputPanel, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
                                .addGap(23)
                                .addComponent(infoPanel, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(inputPanel, GroupLayout.PREFERRED_SIZE, 521, GroupLayout.PREFERRED_SIZE)
                        .addComponent(infoPanel, GroupLayout.PREFERRED_SIZE, 521, GroupLayout.PREFERRED_SIZE)
        );
        this.setLayout(groupLayout);
    }
}
