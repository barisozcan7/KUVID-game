package UI.components.game_view.objects_view;

import domain.enums.MoleculeStructure;
import domain.enums.Type;
import domain.models.game.Game;
import domain.models.objects.molecule.Molecule;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

import static configs.ObjectConstants.*;

public class MoleculeView extends JPanel {
    private ImageIcon icon;

    public MoleculeView() {
        this.setOpaque(false);
    }

    public void drawMolecules(Graphics2D g2d) {
        for (Molecule molecule : Game.getInstance().getMoleculeList()) {
            icon = new ImageIcon(getClass().getClassLoader().getResource(molecule.getIconName()));
            Image newImage;
            if (MoleculeStructure.LINEAR.equals(molecule.getMoleculeStructure()) &&
                    Type.BETA.equals(molecule.getType())) {
                newImage = icon.getImage().getScaledInstance((int) betaLinearMoleculeWidth,
                        (int) betaLinearMoleculeHeight, Image.SCALE_SMOOTH);
            } else if (Type.ALPHA.equals(molecule.getType())) {
                if (MoleculeStructure.LINEAR.equals(molecule.getMoleculeStructure())) {
                    newImage = icon.getImage().getScaledInstance((int) alphaLinearMoleculeWidth,
                            (int) alphaLinearMoleculeHeight, Image.SCALE_SMOOTH);
                } else {
                    newImage = icon.getImage().getScaledInstance((int) alphaComplexMoleculeWidth,
                            (int) alphaComplexMoleculeHeight, Image.SCALE_SMOOTH);
                }
            } else if (Type.SIGMA.equals(molecule.getType())) {
                newImage = icon.getImage().getScaledInstance((int) sigmaMoleculeWidth,
                        (int) sigmaMoleculeHeight, Image.SCALE_SMOOTH);
            } else {
                newImage = icon.getImage().getScaledInstance((int) defaultMoleculeWidth,
                        (int) defaultMoleculeHeight, Image.SCALE_SMOOTH);
            }
            icon = new ImageIcon(newImage);
            AffineTransform tr = new AffineTransform();
            tr.translate((int) molecule.getxCoordinate(), (int) molecule.getyCoordinate());
            tr.rotate(molecule.getRotation(),
                    icon.getIconWidth() / 2,
                    icon.getIconHeight() / 2);
            g2d.drawImage(icon.getImage(), tr, null);

            /*
            g2d.setColor(Color.red);
            g2d.drawLine((int) molecule.getxCoordinate(),
                    (int) molecule.getyCoordinate(),
                    (int) molecule.getxCoordinate() + icon.getIconWidth(),
                    (int) molecule.getyCoordinate());
            g2d.drawLine((int) molecule.getxCoordinate(),
                    (int) molecule.getyCoordinate(),
                    (int) molecule.getxCoordinate(),
                    (int) molecule.getyCoordinate() + icon.getIconHeight());
            g2d.drawLine((int) molecule.getxCoordinate(),
                    (int) molecule.getyCoordinate() + icon.getIconHeight(),
                    (int) molecule.getxCoordinate() + icon.getIconWidth(),
                    (int) molecule.getyCoordinate() + icon.getIconHeight());
            g2d.drawLine((int) molecule.getxCoordinate() + icon.getIconWidth(),
                    (int) molecule.getyCoordinate(),
                    (int) molecule.getxCoordinate() + icon.getIconWidth(),
                    (int) molecule.getyCoordinate() + icon.getIconHeight());
            g2d.drawOval((int) molecule.getxCoordinate() + icon.getIconWidth()/2,
                    (int) molecule.getyCoordinate() + icon.getIconHeight()/2,
            3,3);
             */

        }
    }
}
