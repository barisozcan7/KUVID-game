package UI.components.game_view.objects_view;

import domain.models.game.Game;
import domain.models.objects.AtomShooter;
import domain.models.objects.atom.Atom;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

import static configs.ObjectConstants.atomEdge;
import static configs.ObjectConstants.shooterHeight;

public class AtomView extends JPanel {
    private Atom atom;
    private ImageIcon icon;

    public AtomView() {
        this.setOpaque(false);
    }

    public void drawSelectedAtom(Graphics2D g2d) {
        atom = AtomShooter.getInstance().getCurrentSelectedAtom();
        if (atom != null) {
            icon = new ImageIcon(getClass().getClassLoader().getResource(atom.getIconName()));
            Image newImage = icon.getImage().getScaledInstance((int) atomEdge,
                    (int) atomEdge, Image.SCALE_SMOOTH);
            icon = new ImageIcon(newImage);
            AffineTransform tr = new AffineTransform();
            tr.translate((int) atom.getxCoordinate(), (int) atom.getyCoordinate());
            tr.rotate(
                    Math.toRadians(atom.getRotation()),
                    (double) icon.getImage().getWidth(null) / 2,
                    shooterHeight * 9 / 10 + icon.getImage().getHeight(null)
            );
            g2d.drawImage(icon.getImage(), tr, null);
        }
    }

    public void drawShotAtom(Graphics2D g2d) {
        for (Atom atom : Game.getInstance().getAtomList()) {
            icon = new ImageIcon(getClass().getClassLoader().getResource(atom.getIconName()));
            Image newImage = icon.getImage().getScaledInstance((int) atomEdge,
                    (int) atomEdge, Image.SCALE_SMOOTH);
            icon = new ImageIcon(newImage);
            AffineTransform tr = new AffineTransform();
            tr.translate((int) atom.getxCoordinate(), (int) atom.getyCoordinate());
            g2d.drawImage(icon.getImage(), tr, null);
        }
    }
}
