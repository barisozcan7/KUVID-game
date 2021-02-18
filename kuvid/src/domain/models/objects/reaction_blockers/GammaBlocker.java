package domain.models.objects.reaction_blockers;

import domain.enums.Type;

public class GammaBlocker extends ReactionBlocker {
    public GammaBlocker(double xCoordinate, double yCoordinate) {
        super("gamma_blocker.png", xCoordinate, yCoordinate, Type.GAMMA);
    }
}
