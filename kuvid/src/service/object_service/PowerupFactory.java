package service.object_service;

import domain.enums.Type;
import domain.models.game.Game;
import domain.models.objects.powerup.*;
import domain.models.player.Player;

import java.util.Random;

public final class PowerupFactory {

    private PowerupFactory() {
    }

    public static Powerup createPowerup(Type type, double xCoordinate, double yCoordinate) {
        switch (type) {
            case ALPHA -> {
                if (Game.getInstance().getPlayer().getNumberOfAlphaPowerups() > 0) {
                    return new AlphaPowerup(xCoordinate, yCoordinate);
                }
            }
            case BETA -> {
                if (Game.getInstance().getPlayer().getNumberOfBetaPowerups() > 0) {
                    return new BetaPowerup(xCoordinate, yCoordinate);
                }
            }
            case SIGMA -> {
                if (Game.getInstance().getPlayer().getNumberOfSigmaPowerups() > 0) {
                    return new SigmaPowerup(xCoordinate, yCoordinate);
                }
            }
            case GAMMA -> {
                if (Game.getInstance().getPlayer().getNumberOfGammaPowerups() > 0) {
                    return new GammaPowerup(xCoordinate, yCoordinate);
                }
            }
        }
        return null;
    }

    public static void removePowerupFromPlayer(Type type) {
        Player player = Game.getInstance().getPlayer();
        switch (type) {
            case ALPHA -> {
                player.setNumberOfAlphaPowerups(player.getNumberOfAlphaPowerups() - 1);
            }
            case BETA -> {
                player.setNumberOfBetaPowerups(player.getNumberOfBetaPowerups() - 1);
            }
            case SIGMA -> {
                player.setNumberOfSigmaPowerups(player.getNumberOfSigmaPowerups() - 1);
            }
            case GAMMA -> {
                player.setNumberOfGammaPowerups(player.getNumberOfGammaPowerups() - 1);
            }
        }
    }

    public static void addPowerupToPlayer(Type type) {
        Player player = Game.getInstance().getPlayer();
        switch (type) {
            case ALPHA -> {
                player.setNumberOfAlphaPowerups(player.getNumberOfAlphaPowerups() + 1);
            }
            case BETA -> {
                player.setNumberOfBetaPowerups(player.getNumberOfBetaPowerups() + 1);
            }
            case SIGMA -> {
                player.setNumberOfSigmaPowerups(player.getNumberOfSigmaPowerups() + 1);
            }
            case GAMMA -> {
                player.setNumberOfGammaPowerups(player.getNumberOfGammaPowerups() + 1);
            }
        }
    }

    public static Powerup generateFallingPowerupRandomly() {
        int numberOfAlphaPowerups = Game.getInstance().getNumberOfAlphaPowerups();
        int numberOfBetaPowerups = Game.getInstance().getNumberOfBetaPowerups();
        int numberOfGammaPowerups = Game.getInstance().getNumberOfGammaPowerups();
        int numberOfSigmaPowerups = Game.getInstance().getNumberOfSigmaPowerups();
        int totalNumberOfPowerups = getTotalNumberOfPowerups();
        if (totalNumberOfPowerups == 0) {
            return null;
        }
        int randomNumber = new Random().nextInt(totalNumberOfPowerups);
        int randomXCoordinate = new Random().nextInt(760) + 15;
        if (randomNumber < numberOfAlphaPowerups) {
            Game.getInstance().setNumberOfAlphaPowerups(numberOfAlphaPowerups - 1);
            return new AlphaPowerup(randomXCoordinate, 0);
        } else if (randomNumber < numberOfAlphaPowerups + numberOfBetaPowerups) {
            Game.getInstance().setNumberOfBetaPowerups(numberOfBetaPowerups - 1);
            return new BetaPowerup(randomXCoordinate, 0);
        } else if (randomNumber < numberOfAlphaPowerups + numberOfBetaPowerups + numberOfGammaPowerups) {
            Game.getInstance().setNumberOfGammaPowerups(numberOfGammaPowerups - 1);
            return new GammaPowerup(randomXCoordinate, 0);
        } else {
            Game.getInstance().setNumberOfSigmaPowerups(numberOfSigmaPowerups - 1);
            return new SigmaPowerup(randomXCoordinate, 0);
        }
    }

    public static int getTotalNumberOfPowerups() {
        return Game.getInstance().getNumberOfAlphaPowerups() + Game.getInstance().getNumberOfBetaPowerups() + Game.getInstance().getNumberOfSigmaPowerups() + Game.getInstance().getNumberOfGammaPowerups();
    }
}
