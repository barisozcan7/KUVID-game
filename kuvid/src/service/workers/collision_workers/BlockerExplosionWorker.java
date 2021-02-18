package service.workers.collision_workers;

import javax.swing.*;
import java.util.ConcurrentModificationException;

import static configs.UIConstants.DELAY;
import static domain.controller.game.CollisionController.blockerExplosion;

public class BlockerExplosionWorker extends SwingWorker<Void, Void> {

    @Override
    protected Void doInBackground() throws Exception {
        while (!this.isCancelled()) {
            Thread.sleep(DELAY);
            try {
                blockerExplosion();
            } catch (ConcurrentModificationException e) {
            }
        }

        return null;
    }
}
