package domain.models.objects.powerup;

import domain.enums.Type;
import domain.models.game.Game;
import domain.models.objects.Drawable;

import static configs.ObjectConstants.speedConstant;

public class Powerup extends Drawable {

    public Powerup() {
    }

    public Powerup(String iconName, double xCoordinate, double yCoordinate, Type type) {
        super(iconName, xCoordinate, yCoordinate, type);
        this.setSpeed(speedConstant / 2);
    }
}
