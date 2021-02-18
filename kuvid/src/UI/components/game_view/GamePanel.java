package UI.components.game_view;

import UI.components.game_view.objects_view.*;
import domain.controller.game.GameController;

import javax.swing.*;
import java.awt.*;
import java.util.ConcurrentModificationException;

import static configs.UIConstants.DELAY;

public class GamePanel extends JPanel {
    private AtomShooterView atomShooterView = new AtomShooterView();
    private GameController gameController = GameController.getInstance();
    private AtomView atomView = new AtomView();
    private MoleculeView moleculeView = new MoleculeView();
    private PowerupView powerupView = new PowerupView();
    private ReactionBlockerView blockerView = new ReactionBlockerView();

    public GamePanel() {
        this.setBackground(new Color(0, 0, 0, 0));
        this.setOpaque(false);
        this.setBounds(0, 0, 898, 761);
        this.add(atomShooterView);
        this.add(atomView);
        this.add(moleculeView);
        this.add(powerupView);
        this.add(blockerView);
        gameController.setUiTimer(new Timer(DELAY, e -> {
            repaint();
        }));
    }

    public void paintComponent(Graphics g) {
        try {
            atomShooterView.draw((Graphics2D) g);
            atomView.drawSelectedAtom((Graphics2D) g);
            moleculeView.drawMolecules((Graphics2D) g);
            atomView.drawShotAtom((Graphics2D) g);
            powerupView.drawSelectedPowerup((Graphics2D) g);
            powerupView.drawFallingPowerups((Graphics2D) g);
            powerupView.drawShotPowerup((Graphics2D) g);
            blockerView.drawBlockers((Graphics2D) g);
        } catch (ConcurrentModificationException e) {
        }
    }
}
