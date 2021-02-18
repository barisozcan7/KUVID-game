package domain.models.objects.reaction_blockers;

import domain.enums.Type;

public class SigmaBlocker extends ReactionBlocker {
    public SigmaBlocker(double xCoordinate, double yCoordinate) {
        super("sigma_blocker.png", xCoordinate, yCoordinate, Type.SIGMA);
    }
}
