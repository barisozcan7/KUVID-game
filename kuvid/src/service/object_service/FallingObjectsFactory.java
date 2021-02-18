package service.object_service;

import domain.models.game.Game;

import java.util.Random;

import static service.object_service.MoleculeFactory.generateMoleculeRandomly;
import static service.object_service.MoleculeFactory.getTotalNumberOfMolecules;
import static service.object_service.PowerupFactory.generateFallingPowerupRandomly;
import static service.object_service.PowerupFactory.getTotalNumberOfPowerups;
import static service.object_service.ReactionBlockerFactory.generateBlockerRandomly;
import static service.object_service.ReactionBlockerFactory.getTotalNumberOfBlockers;

public final class FallingObjectsFactory {

    private FallingObjectsFactory() {
    }

    public static void generateFallingObjects() {
        int numberOfFallingObjectsPerSecond = Game.getInstance().getNumberOfFallingObjectsPerSecond();
        for (int i = 0; i < numberOfFallingObjectsPerSecond; i++) {
            int numberOfRemainingMolecules = getTotalNumberOfMolecules();
            int numberOfRemainingBlockers = getTotalNumberOfBlockers();
            int numberOfRemainingPowerups = getTotalNumberOfPowerups();

            int totalNumberOfRemainingFallingObjects = getTotalNumberOfRemainingFallingObjects();
            if (totalNumberOfRemainingFallingObjects > 0) {
                int randomNumber = new Random().nextInt(totalNumberOfRemainingFallingObjects);

                if (randomNumber < numberOfRemainingMolecules) {
                    Game.getInstance().insertIntoMoleculeList(generateMoleculeRandomly());
                } else if (randomNumber < numberOfRemainingMolecules + numberOfRemainingBlockers) {
                    Game.getInstance().insertIntoReactionBlockerList(generateBlockerRandomly());
                } else if (randomNumber < numberOfRemainingMolecules + numberOfRemainingBlockers + numberOfRemainingPowerups) {
                    Game.getInstance().insertIntoFallingPowerupList(generateFallingPowerupRandomly());
                }
            }
        }
    }

    public static int getTotalNumberOfRemainingFallingObjects() {
        return getTotalNumberOfBlockers() + getTotalNumberOfMolecules() + getTotalNumberOfPowerups();
    }
}
