package service.workers;

import domain.controller.game.PowerupController;
import domain.models.game.Game;
import domain.models.objects.powerup.Powerup;

import javax.swing.*;
import java.util.ConcurrentModificationException;

import static configs.UIConstants.DELAY;

public class PowerupWorker extends SwingWorker<Void, Void> {

    private PowerupController powerupController = new PowerupController();

    @Override
    protected Void doInBackground() throws Exception {
        while (!this.isCancelled()) {
            Thread.sleep(DELAY);
            try {
                for (Powerup powerup : Game.getInstance().getFallingPowerupList()) {
                    powerupController.fall(powerup);
                }
                for (Powerup powerup : Game.getInstance().getShootedPowerupList()) {
                    powerupController.move(powerup);
                }
            } catch (ConcurrentModificationException e) {
            }

        }
        return null;
    }
}
