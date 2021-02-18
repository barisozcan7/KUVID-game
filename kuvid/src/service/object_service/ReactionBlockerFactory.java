package service.object_service;

import domain.models.game.Game;
import domain.models.objects.reaction_blockers.*;

import java.util.Random;

public final class ReactionBlockerFactory {

    private ReactionBlockerFactory() {
    }

    public static ReactionBlocker generateBlockerRandomly() {
        int numberOfAlphaBlockers = Game.getInstance().getNumberOfAlphaBlockers();
        int numberOfBetaBlockers = Game.getInstance().getNumberOfBetaBlockers();
        int numberOfGammaBlockers = Game.getInstance().getNumberOfGammaBlockers();
        int numberOfSigmaBlockers = Game.getInstance().getNumberOfSigmaBlockers();
        int totalNumberOfBlockers = getTotalNumberOfBlockers();
        if (totalNumberOfBlockers == 0) {
            return null;
        }
        int randomNumber = new Random().nextInt(totalNumberOfBlockers);
        int randomXCoordinate = new Random().nextInt(760) + 15;
        if (randomNumber < numberOfAlphaBlockers) {
            Game.getInstance().setNumberOfAlphaBlockers(numberOfAlphaBlockers - 1);
            return new AlphaBlocker(randomXCoordinate, 0);
        } else if (randomNumber < numberOfAlphaBlockers + numberOfBetaBlockers) {
            Game.getInstance().setNumberOfBetaBlockers(numberOfBetaBlockers - 1);
            return new BetaBlocker(randomXCoordinate, 0);
        } else if (randomNumber < numberOfAlphaBlockers + numberOfBetaBlockers + numberOfGammaBlockers) {
            Game.getInstance().setNumberOfGammaBlockers(numberOfGammaBlockers - 1);
            return new GammaBlocker(randomXCoordinate, 0);
        } else {
            Game.getInstance().setNumberOfSigmaBlockers(numberOfSigmaBlockers - 1);
            return new SigmaBlocker(randomXCoordinate, 0);
        }
    }

    public static int getTotalNumberOfBlockers() {
        return Game.getInstance().getNumberOfAlphaBlockers() + Game.getInstance().getNumberOfBetaBlockers() + Game.getInstance().getNumberOfGammaBlockers() + Game.getInstance().getNumberOfSigmaBlockers();
    }
}
