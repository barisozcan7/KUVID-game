package domain.models.objects;

import configs.UIConstants;
import domain.models.game.Game;
import domain.models.objects.atom.Atom;
import domain.models.objects.powerup.Powerup;

import static configs.ObjectConstants.*;

public class AtomShooter extends Drawable {
    private static AtomShooter atomShooter;
    private Atom currentSelectedAtom;
    private Powerup currentSelectedPowerup;
    private int barrelX, barrelY, endX, endY;

    private AtomShooter() {
        super("shooter.png", UIConstants.GAME_PANEL_WIDTH / 2,
                UIConstants.GAME_WINDOW_HEIGHT - shooterHeight - 24, null);
    }

    public static AtomShooter getInstance() {
        if (atomShooter == null) {
            atomShooter = new AtomShooter();
        }
        return atomShooter;
    }

    public static void resetShooter() {
        atomShooter = null;
    }

    public void updateBarrel() {
        this.barrelX = (int) (atomShooter.getxCoordinate() + shooterWidth / 2 + shooterHeight * 9 / 10 * Math.cos(Math.toRadians(90 - atomShooter.getRotation())));
        this.barrelY = (int) (atomShooter.getyCoordinate() + shooterHeight * 9 / 10 - Math.abs(shooterHeight * 9 / 10 * Math.sin(Math.toRadians(90 - atomShooter.getRotation()))));
        this.endX = (int) (atomShooter.getxCoordinate() + shooterWidth / 2 - shooterHeight / 10 * Math.cos(Math.toRadians(90 - atomShooter.getRotation())));
        this.endY = (int) (atomShooter.getyCoordinate() + shooterHeight * 9 / 10 + Math.abs(shooterHeight / 10 * Math.sin(Math.toRadians(90 - atomShooter.getRotation()))));
    }

    public void setxCoordinate(double xCoordinate) {
        super.setxCoordinate(xCoordinate);
        if (currentSelectedAtom != null) {
            currentSelectedAtom.setxCoordinate(xCoordinate - (atomEdge - shooterWidth) / 2);
        }
        if (currentSelectedPowerup != null) {
            currentSelectedPowerup.setxCoordinate(xCoordinate - (powerupEdge - shooterWidth) / 2);
        }
    }

    public Atom getCurrentSelectedAtom() {
        return currentSelectedAtom;
    }

    public void setCurrentSelectedAtom(Atom currentSelectedAtom) {
        this.currentSelectedAtom = currentSelectedAtom;
        if (currentSelectedAtom != null) {
            currentSelectedAtom.setxCoordinate(getxCoordinate() - (atomEdge - shooterWidth) / 2);
        }
        if (currentSelectedPowerup != null) {
            currentSelectedPowerup.setxCoordinate(getxCoordinate() - (powerupEdge - shooterWidth) / 2);
        }
    }

    public Powerup getCurrentSelectedPowerup() {
        return currentSelectedPowerup;
    }

    public void setCurrentSelectedPowerup(Powerup currentSelectedPowerup) {
        this.currentSelectedPowerup = currentSelectedPowerup;
    }

    public int getBarrelY() {
        return barrelY;
    }

    public int getBarrelX() {
        return barrelX;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    public void loadAtomShooter(AtomShooter atomShooter) {
        this.atomShooter = atomShooter;
    }
}
