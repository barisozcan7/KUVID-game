package service.object_service;

import domain.controller.game.AtomShooterController;
import domain.enums.Type;
import domain.models.game.Game;
import domain.models.objects.AtomShooter;
import domain.models.objects.atom.*;
import domain.models.player.Player;

import java.util.Random;

public class AtomFactory {
    private static AtomFactory atomFactory;


    private AtomFactory() {
    }

    public static AtomFactory getInstance() {
        if (atomFactory == null) {
            atomFactory = new AtomFactory();
        }
        return atomFactory;
    }

    public static int getTotalNumberOfAtoms() {
        Player player = Game.getInstance().getPlayer();
        return player.getNumberOfAlphaAtoms() + player.getNumberOfBetaAtoms() + player.getNumberOfGammaAtoms() + player.getNumberOfSigmaAtoms();
    }

    public static Atom createAtom(double xCoordinate, double yCoordinate) {
        int numberOfAlphaAtoms = Game.getInstance().getPlayer().getNumberOfAlphaAtoms();
        int numberOfBetaAtoms = Game.getInstance().getPlayer().getNumberOfBetaAtoms();
        int numberOfGammaAtoms = Game.getInstance().getPlayer().getNumberOfGammaAtoms();
        int totalNumberOfAtoms = getTotalNumberOfAtoms();
        if (totalNumberOfAtoms == 0) {
            return null;
        }
        int randomNumber = new Random().nextInt(totalNumberOfAtoms);
        if (randomNumber < numberOfAlphaAtoms) {
            for (Atom atom : Game.getInstance().getAtomInventoryList()) {
                if (Type.ALPHA.equals(atom.getType())) {
                    return atom;
                }
            }
            return new AlphaAtom(xCoordinate, yCoordinate);
        } else if (randomNumber < numberOfAlphaAtoms + numberOfBetaAtoms) {
            for (Atom atom : Game.getInstance().getAtomInventoryList()) {
                if (Type.BETA.equals(atom.getType())) {
                    return atom;
                }
            }
            return new BetaAtom(xCoordinate, yCoordinate);
        } else if (randomNumber < numberOfAlphaAtoms + numberOfBetaAtoms + numberOfGammaAtoms) {
            for (Atom atom : Game.getInstance().getAtomInventoryList()) {
                if (Type.GAMMA.equals(atom.getType())) {
                    return atom;
                }
            }
            return new GammaAtom(xCoordinate, yCoordinate);
        } else {
            for (Atom atom : Game.getInstance().getAtomInventoryList()) {
                if (Type.SIGMA.equals(atom.getType())) {
                    return atom;
                }
            }
            return new SigmaAtom(xCoordinate, yCoordinate);
        }
    }

    public static boolean removeAtomByType(Type type, int count) {
        Player player = Game.getInstance().getPlayer();
        switch (type) {
            case ALPHA -> {
                if (player.getNumberOfAlphaAtoms() < count) return false;
                player.setNumberOfAlphaAtoms(player.getNumberOfAlphaAtoms() - count);
            }
            case BETA -> {
                if (player.getNumberOfBetaAtoms() < count) return false;
                player.setNumberOfBetaAtoms(player.getNumberOfBetaAtoms() - count);
            }
            case SIGMA -> {
                if (player.getNumberOfSigmaAtoms() < count) return false;
                player.setNumberOfSigmaAtoms(player.getNumberOfSigmaAtoms() - count);
            }
            case GAMMA -> {
                if (player.getNumberOfGammaAtoms() < count) return false;
                player.setNumberOfGammaAtoms(player.getNumberOfGammaAtoms() - count);
            }
        }
        return true;
    }

    public static void createAtomByType(Type type, int count) {
        Player player = Game.getInstance().getPlayer();
        switch (type) {
            case ALPHA -> player.setNumberOfAlphaAtoms(player.getNumberOfAlphaAtoms() + count);
            case BETA -> player.setNumberOfBetaAtoms(player.getNumberOfBetaAtoms() + count);
            case GAMMA -> player.setNumberOfGammaAtoms(player.getNumberOfGammaAtoms() + count);
            case SIGMA -> player.setNumberOfSigmaAtoms(player.getNumberOfSigmaAtoms() + count);
        }
    }

}
