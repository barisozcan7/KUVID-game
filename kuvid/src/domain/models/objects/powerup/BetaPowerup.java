package domain.models.objects.powerup;

import domain.enums.Type;

public class BetaPowerup extends Powerup {
    public BetaPowerup(double xCoordinate, double yCoordinate) {
        super("beta_powerup.png", xCoordinate, yCoordinate, Type.BETA);
    }
}
