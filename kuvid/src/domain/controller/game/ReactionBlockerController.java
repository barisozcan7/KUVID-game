package domain.controller.game;

import domain.models.objects.reaction_blockers.ReactionBlocker;

public class ReactionBlockerController {
    public void move(ReactionBlocker blocker) {
        blocker.setyCoordinate(blocker.getyCoordinate() + blocker.getSpeed());
    }
}
