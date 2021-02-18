package domain.models.objects.reaction_blockers;

import domain.enums.Type;

public class BetaBlocker extends ReactionBlocker {
    public BetaBlocker(double xCoordinate, double yCoordinate) {
        super("beta_blocker.png", xCoordinate, yCoordinate, Type.BETA);
    }
}
