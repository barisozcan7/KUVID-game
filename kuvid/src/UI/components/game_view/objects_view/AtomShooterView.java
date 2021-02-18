package UI.components.game_view.objects_view;

import domain.controller.game.AtomShooterController;
import domain.controller.game.GameController;
import domain.models.game.Game;
import domain.models.objects.AtomShooter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;

import static configs.ObjectConstants.shooterHeight;
import static configs.ObjectConstants.shooterWidth;

public class AtomShooterView extends JPanel implements KeyListener {
    private static final int C_KEY_CODE = 67;
    private static final int LEFT_KEY_CODE = KeyEvent.VK_LEFT;
    private static final int RIGHT_KEY_CODE = KeyEvent.VK_RIGHT;
    private static final int UP_KEY_CODE = KeyEvent.VK_UP;
    private static final int A_KEY_CODE = KeyEvent.VK_A;
    private static final int D_KEY_CODE = KeyEvent.VK_D;
    private static final int B_KEY_CODE = KeyEvent.VK_B;
    private static final int P_KEY_CODE = KeyEvent.VK_P;
    private static final int R_KEY_CODE = KeyEvent.VK_R;
    private static final int S_KEY_CODE = KeyEvent.VK_S;
    private static final int L_KEY_CODE = KeyEvent.VK_L;

    private AtomShooterController atomShooterController = AtomShooterController.getInstance();
    private GameController gameController = GameController.getInstance();
    private ImageIcon icon;

    public AtomShooterView() {
        this.setOpaque(false);
        addKeyListener(this);
        setFocusable(true);
    }

    public void draw(Graphics2D g2d) {
        icon = new ImageIcon(getClass().getClassLoader().getResource(AtomShooter.getInstance().getIconName()));
        Image newImage = icon.getImage().getScaledInstance((int) shooterWidth,
                (int) shooterHeight, Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        AffineTransform tr = new AffineTransform();
        tr.translate(AtomShooter.getInstance().getxCoordinate(), AtomShooter.getInstance().getyCoordinate());
        tr.rotate(
                Math.toRadians(AtomShooter.getInstance().getRotation()),
                (double) icon.getImage().getWidth(null) / 2,
                (double) icon.getImage().getHeight(null) * 9 / 10
        );


        g2d.drawImage(icon.getImage(), tr, null);
        //For debugging, creates two circles, one at the barrel, one at the end of the shooter
        /*
        g2d.setColor(Color.red);
        g2d.drawOval(AtomShooter.getInstance().getBarrelX(),
                AtomShooter.getInstance().getBarrelY(),
                3,
                3);
        g2d.drawOval(AtomShooter.getInstance().getEndX(),
                AtomShooter.getInstance().getEndY(),
                3,
                3);
        g2d.drawOval(AtomShooter.getInstance().getBarrelX(),
                AtomShooter.getInstance().getEndY(),
                3,
                3);
        g2d.drawOval(AtomShooter.getInstance().getEndX(),
                AtomShooter.getInstance().getBarrelY(),
                3,
                3);
        g2d.drawOval((AtomShooter.getInstance().getEndX() + AtomShooter.getInstance().getBarrelX())/2,
                (AtomShooter.getInstance().getEndY() + AtomShooter.getInstance().getBarrelY())/2,
                5,
                5);
         */
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (!Game.getInstance().isPaused()) {
            switch (key) {
                case LEFT_KEY_CODE -> atomShooterController.moveLeft();
                case RIGHT_KEY_CODE -> atomShooterController.moveRight();

                case UP_KEY_CODE -> atomShooterController.shoot();
                case C_KEY_CODE -> atomShooterController.pickAtom();

                case D_KEY_CODE -> atomShooterController.rotateClockwise();
                case A_KEY_CODE -> atomShooterController.rotateCounterclockwise();
                case B_KEY_CODE -> {
                    atomShooterController.openBlendingMode();
                    gameController.pauseGame();
                }

                case P_KEY_CODE -> gameController.pauseGame();
            }
        } else if (key == R_KEY_CODE) {
            gameController.returnGame();
        } else if (key == S_KEY_CODE) {
            GameController.getInstance().getSaveGameView();
        } else if (key == L_KEY_CODE) {
            GameController.getInstance().getLoadGameView();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
