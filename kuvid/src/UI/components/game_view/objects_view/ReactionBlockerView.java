package UI.components.game_view.objects_view;

import domain.models.game.Game;
import domain.models.objects.reaction_blockers.ReactionBlocker;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

import static configs.ObjectConstants.blockerHeight;
import static configs.ObjectConstants.blockerWidth;

public class ReactionBlockerView extends JPanel {
    private ImageIcon icon;

    public ReactionBlockerView() {
        this.setOpaque(false);
    }

    public void drawBlockers(Graphics2D g2d) {
        for (ReactionBlocker blocker : Game.getInstance().getReactionBlockerList()) {
            icon = new ImageIcon(getClass().getClassLoader().getResource(blocker.getIconName()));
            Image newImage = icon.getImage().getScaledInstance((int) blockerWidth,
                    (int) blockerHeight, Image.SCALE_SMOOTH);
            icon = new ImageIcon(newImage);
            AffineTransform tr = new AffineTransform();
            tr.translate((int) blocker.getxCoordinate(), (int) blocker.getyCoordinate());
            g2d.drawImage(icon.getImage(), tr, null);

            /*
            int blockerCenterX = (int) blocker.getxCoordinate() + icon.getIconWidth()/2;
            int blockerCenterY = (int) blocker.getyCoordinate() + icon.getIconHeight()/2;
            int range = 200;

            g2d.setColor(Color.red);
            g2d.drawOval(blockerCenterX - range,
                    blockerCenterY - range,
                    range * 2,
                    range * 2);

             */

        }
    }
}
