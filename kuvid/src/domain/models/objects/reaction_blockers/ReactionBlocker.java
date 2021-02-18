package domain.models.objects.reaction_blockers;

import domain.enums.Type;
import domain.models.game.Game;
import domain.models.objects.Drawable;

import static configs.ObjectConstants.speedConstant;

public class ReactionBlocker extends Drawable {
    public ReactionBlocker() {
    }

    public ReactionBlocker(String iconName, double xCoordinate, double yCoordinate, Type type) {
        super(iconName, xCoordinate, yCoordinate, type);
        this.setSpeed(speedConstant / 2);
    }
}
