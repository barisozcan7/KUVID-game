package domain.models.objects.powerup;

import domain.enums.Type;

public class AlphaPowerup extends Powerup {
    public AlphaPowerup(double xCoordinate, double yCoordinate) {
        super("alpha_powerup.png", xCoordinate, yCoordinate, Type.ALPHA);
    }
}
