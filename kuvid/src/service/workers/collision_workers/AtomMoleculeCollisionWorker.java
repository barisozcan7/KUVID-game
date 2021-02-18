package service.workers.collision_workers;

import javax.swing.*;
import java.util.ConcurrentModificationException;

import static configs.UIConstants.DELAY;
import static domain.controller.game.CollisionController.atomAndMoleculeCollision;

public class AtomMoleculeCollisionWorker extends SwingWorker<Void, Void> {

    @Override
    protected Void doInBackground() throws Exception {
        while (!this.isCancelled()) {
            Thread.sleep(DELAY);
            try {
                atomAndMoleculeCollision();
            } catch (ConcurrentModificationException e) {
            }
        }

        return null;
    }
}
