package domain.controller.game;

import configs.UIConstants;
import domain.models.game.Game;
import domain.models.objects.powerup.Powerup;

import static configs.ObjectConstants.powerupEdge;

public class PowerupController {
    public void move(Powerup powerup) {
        removePowerupOutOfBounds(powerup);
        double rotation = powerup.getRotation();
        powerup.setxCoordinate(powerup.getxCoordinate() + Math.cos(Math.toRadians(90 - rotation)) * powerup.getSpeed());
        powerup.setyCoordinate(powerup.getyCoordinate() - Math.sin(Math.toRadians(90 - rotation)) * powerup.getSpeed());
        hitWall(powerup);
    }

    public void fall(Powerup powerup) {
        powerup.setyCoordinate(powerup.getyCoordinate() + powerup.getSpeed());
        hitGround(powerup);
    }

    private void hitGround(Powerup powerup) {
        if (powerup.getyCoordinate() > 750) {
            Game.getInstance().removeFromFallingPowerupList(powerup);
        }
    }

    private void removePowerupOutOfBounds(Powerup powerup) {
        if (powerup.getyCoordinate() < -40) {
            Game.getInstance().removeFromShootedPowerupList(powerup);
        }
    }

    private void hitWall(Powerup powerup) {
        if (powerup.getxCoordinate() < 0 ||
                powerup.getxCoordinate() > UIConstants.GAME_PANEL_WIDTH - powerupEdge) {
            powerup.setRotation(powerup.getRotation() * -1);
        }
    }
}
