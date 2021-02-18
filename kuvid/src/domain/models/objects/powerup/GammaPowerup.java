package domain.models.objects.powerup;

import domain.enums.Type;

public class GammaPowerup extends Powerup {
    public GammaPowerup(double xCoordinate, double yCoordinate) {
        super("gamma_powerup.png", xCoordinate, yCoordinate, Type.GAMMA);
    }
}
