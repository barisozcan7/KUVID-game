package UI.components.game_view.objects_view;

import domain.models.game.Game;
import domain.models.objects.AtomShooter;
import domain.models.objects.powerup.Powerup;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

import static configs.ObjectConstants.powerupEdge;
import static configs.ObjectConstants.shooterHeight;

public class PowerupView extends JPanel {
    private ImageIcon icon;

    public PowerupView() {
        this.setOpaque(false);
    }

    public void drawSelectedPowerup(Graphics2D g2d) {
        Powerup powerup = AtomShooter.getInstance().getCurrentSelectedPowerup();
        if (powerup != null) {
            icon = new ImageIcon(getClass().getClassLoader().getResource(powerup.getIconName()));
            Image newImage = icon.getImage().getScaledInstance((int) powerupEdge,
                    (int) powerupEdge, Image.SCALE_SMOOTH);
            icon = new ImageIcon(newImage);
            AffineTransform tr = new AffineTransform();
            tr.translate((int) powerup.getxCoordinate(), (int) powerup.getyCoordinate());
            tr.rotate(
                    Math.toRadians(powerup.getRotation()),
                    (double) icon.getImage().getWidth(null) / 2,
                    (double) shooterHeight * 9 / 10 +
                            icon.getImage().getHeight(null)
            );
            g2d.drawImage(icon.getImage(), tr, null);
        }
    }

    public void drawShotPowerup(Graphics2D g2d) {
        for (Powerup powerup : Game.getInstance().getShootedPowerupList()) {
            icon = new ImageIcon(getClass().getClassLoader().getResource(powerup.getIconName()));
            Image newImage = icon.getImage().getScaledInstance((int) powerupEdge,
                    (int) powerupEdge, Image.SCALE_SMOOTH);
            icon = new ImageIcon(newImage);
            AffineTransform tr = new AffineTransform();
            tr.translate((int) powerup.getxCoordinate(), (int) powerup.getyCoordinate());
            g2d.drawImage(icon.getImage(), tr, null);
        }
    }

    public void drawFallingPowerups(Graphics2D g2d) {
        for (Powerup powerup : Game.getInstance().getFallingPowerupList()) {
            icon = new ImageIcon(getClass().getClassLoader().getResource(powerup.getIconName()));
            Image newImage = icon.getImage().getScaledInstance((int) powerupEdge,
                    (int) powerupEdge, Image.SCALE_SMOOTH);
            icon = new ImageIcon(newImage);
            AffineTransform tr = new AffineTransform();
            tr.translate((int) powerup.getxCoordinate(), (int) powerup.getyCoordinate());
            g2d.drawImage(icon.getImage(), tr, null);
        }
    }
}
