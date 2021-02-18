package service.workers;

import domain.controller.game.AtomController;
import domain.models.game.Game;
import domain.models.objects.atom.Atom;

import javax.swing.*;
import java.util.ConcurrentModificationException;

import static configs.UIConstants.DELAY;

public class AtomWorker extends SwingWorker<Void, Void> {

    private AtomController atomController = new AtomController();

    @Override
    protected Void doInBackground() throws Exception {
        while (!this.isCancelled()) {
            Thread.sleep(DELAY);
            try {
                for (Atom atom : Game.getInstance().getAtomList()) {
                    atomController.move(atom);
                }
            } catch (ConcurrentModificationException e) {
            }
        }

        return null;
    }
}
