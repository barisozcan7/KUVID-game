package service.workers;

import domain.controller.game.ReactionBlockerController;
import domain.models.game.Game;
import domain.models.objects.reaction_blockers.ReactionBlocker;

import javax.swing.*;
import java.util.ConcurrentModificationException;

import static configs.UIConstants.DELAY;

public class ReactionBlockerWorker extends SwingWorker<Void, Void> {

    private ReactionBlockerController blockerController = new ReactionBlockerController();

    @Override
    protected Void doInBackground() throws Exception {
        while (!this.isCancelled()) {
            Thread.sleep(DELAY);
            try {
                for (ReactionBlocker blocker : Game.getInstance().getReactionBlockerList()) {
                    blockerController.move(blocker);
                }
            } catch (ConcurrentModificationException e) {
            }

        }

        return null;
    }
}
