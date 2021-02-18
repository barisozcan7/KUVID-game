package service.workers;

import domain.controller.game.MoleculeController;
import domain.models.game.Game;
import domain.models.objects.molecule.Molecule;

import javax.swing.*;
import java.util.ConcurrentModificationException;

import static configs.UIConstants.DELAY;

public class MoleculeWorker extends SwingWorker<Void, Void> {

    private MoleculeController moleculeController = new MoleculeController();

    @Override
    protected Void doInBackground() throws Exception {
        while (!this.isCancelled()) {
            Thread.sleep(DELAY);
            try {
                for (Molecule molecule : Game.getInstance().getMoleculeList()) {
                    moleculeController.move(molecule);
                }
            } catch (ConcurrentModificationException e) {
            }

        }

        return null;
    }
}
