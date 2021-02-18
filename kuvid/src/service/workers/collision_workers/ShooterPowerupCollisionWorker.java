package service.workers.collision_workers;

import javax.swing.*;
import java.util.ConcurrentModificationException;

import static configs.UIConstants.DELAY;
import static domain.controller.game.CollisionController.shooterAndPowerupCollision;

public class ShooterPowerupCollisionWorker extends SwingWorker<Void, Void> {

    @Override
    protected Void doInBackground() throws Exception {
        while (!this.isCancelled()) {
            Thread.sleep(DELAY);
            try {
                shooterAndPowerupCollision();
            } catch (ConcurrentModificationException e) {
            }
        }

        return null;
    }
}
