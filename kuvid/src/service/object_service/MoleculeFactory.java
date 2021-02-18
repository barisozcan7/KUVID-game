package service.object_service;

import configs.ObjectConstants;
import configs.UIConstants;
import domain.models.game.Game;
import domain.models.objects.molecule.*;

import java.util.Random;

public final class MoleculeFactory {
    private MoleculeFactory() {
    }

    public static Molecule generateMoleculeRandomly() {
        int numberOfAlphaMolecules = Game.getInstance().getNumberOfAlphaMolecules();
        int numberOfBetaMolecules = Game.getInstance().getNumberOfBetaMolecules();
        int numberOfGammaMolecules = Game.getInstance().getNumberOfGammaMolecules();
        int numberOfSigmaMolecules = Game.getInstance().getNumberOfSigmaMolecules();
        int totalNumberOfMolecules = getTotalNumberOfMolecules();
        if (totalNumberOfMolecules == 0) {
            return null;
        }
        int randomNumber = new Random().nextInt(totalNumberOfMolecules);
        int randomXCoordinate = new Random().nextInt(UIConstants.GAME_PANEL_WIDTH
                - (int) ObjectConstants.betaLinearMoleculeWidth);
        if (randomNumber < numberOfAlphaMolecules) {
            Game.getInstance().setNumberOfAlphaMolecules(numberOfAlphaMolecules - 1);
            return new AlphaMolecule(randomXCoordinate, 0);
        } else if (randomNumber < numberOfAlphaMolecules + numberOfBetaMolecules) {
            Game.getInstance().setNumberOfBetaMolecules(numberOfBetaMolecules - 1);
            return new BetaMolecule(randomXCoordinate, 0);
        } else if (randomNumber < numberOfAlphaMolecules + numberOfBetaMolecules + numberOfGammaMolecules) {
            Game.getInstance().setNumberOfGammaMolecules(numberOfGammaMolecules - 1);
            return new GammaMolecule(randomXCoordinate, 0);
        } else {
            Game.getInstance().setNumberOfSigmaMolecules(numberOfSigmaMolecules - 1);
            return new SigmaMolecule(randomXCoordinate, 0);
        }
    }

    public static int getTotalNumberOfMolecules() {
        return Game.getInstance().getNumberOfAlphaMolecules() + Game.getInstance().getNumberOfBetaMolecules() + Game.getInstance().getNumberOfGammaMolecules() + Game.getInstance().getNumberOfSigmaMolecules();
    }
}
