package domain.models.objects.powerup;

import domain.enums.Type;

public class SigmaPowerup extends Powerup {
    public SigmaPowerup(double xCoordinate, double yCoordinate) {
        super("sigma_powerup.png", xCoordinate, yCoordinate, Type.SIGMA);
    }
}
