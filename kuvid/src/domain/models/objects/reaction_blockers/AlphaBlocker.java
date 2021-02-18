package domain.models.objects.reaction_blockers;

import domain.enums.Type;

public class AlphaBlocker extends ReactionBlocker {
    public AlphaBlocker(double xCoordinate, double yCoordinate) {
        super("alpha_blocker.png", xCoordinate, yCoordinate, Type.ALPHA);
    }
}
