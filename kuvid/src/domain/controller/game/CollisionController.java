package domain.controller.game;

import UI.components.game_view.statistics_view.PlayerStatisticsPanel;
import UI.components.game_view.statistics_view.PowerupAndShieldStatisticsPanel;
import domain.models.game.Game;
import domain.models.objects.AtomShooter;
import domain.models.objects.Drawable;
import domain.models.objects.atom.Atom;
import domain.models.objects.molecule.Molecule;
import domain.models.objects.powerup.Powerup;
import domain.models.objects.reaction_blockers.ReactionBlocker;
import service.audio_service.AudioService;

import static configs.ObjectConstants.*;
import static configs.UIConstants.GAME_PANEL_WIDTH;
import static configs.UIConstants.GAME_WINDOW_HEIGHT;
import static service.object_service.PowerupFactory.addPowerupToPlayer;

public final class CollisionController {
    public CollisionController() {
    }


    /**
     * Checks if given same type blockers and powerups have an intersection
     * @see CollisionController
     */
    public static void blockerAndPowerupCollision() {
        //MODIFIES: None as parameter(PowerupList and BlockerList from Game),
        //EFFECTS: powerup and blocker lists,
        //RETURNS: void,
        //REQUIRES: - Game should not be in the pause mode.
        //          - Game should not be in the blender mode.
        for (Powerup powerup : Game.getInstance().getShootedPowerupList()) {
            for (ReactionBlocker blocker : Game.getInstance().getReactionBlockerList()) {
                if (isPowerupAndBlockerCollided(powerup, blocker)) {
                    removePowerupAndBlocker(powerup, blocker);
                }
            }
        }
    }

    /**
     * Checks if given a blocker from blockerList and ground or AtomShooter collided
     * @see CollisionController
     */
    public static void blockerExplosion() {
        //MODIFIES: none as parameter(uses BlockerList from Game),
        //EFFECTS:  Given the blocker, inside explodeBlocker():
        //              1) Check if explosion gives damage to player,
        //                  1.a) If AtomShooter is closer than blockerExplodeRange:
        //                      Decrease health
        //              2) Check if there are surrounding objects to be destroyed:
        //                  2.a) If Atom in AtomList is closer than BlockerExplodeRange:
        //                      Destroy Atom
        //                  2.b) If Molecule is closer than BlockerExplodeRange:
        //                      Destroy Molecule
        //REQUIRES: - Game should not be in the pause mode.
        //          - Game should not be in the blender mode.
        for (ReactionBlocker blocker : Game.getInstance().getReactionBlockerList()) {
            if (didBlockerHitGround(blocker) || isShooterAndBlockerCollided(blocker)) {
                AudioService.blockerExplosionSound();
                explodeBlocker(blocker);
            }
        }
    }

    /**
     * Checks if blocker hit the ground
     * @param blocker falling blocker
     * @return blocker touched the ground
     * @see CollisionController
     */
    public static boolean didBlockerHitGround(ReactionBlocker blocker) {
        //MODIFIES: blocker to be checked are given as parameter,
        //EFFECTS:  Given the blocker to be checked;
        //              1) Get blocker instance and its bounding box,
        //              2) Get ground limits,
        //              3) If they have an intersection:
        //                      return true
        //REQUIRES: - Game should not be in the pause mode.
        //          - Game should not be in the blender mode.
        return blocker.getyCoordinate() > GAME_WINDOW_HEIGHT - blockerHeight - 25;
    }

    private static boolean isShooterAndBlockerCollided(ReactionBlocker blocker) {
        AtomShooter shooter = AtomShooter.getInstance();

        if (shooter.getRotation() == 0) {
            return blocker.getxCoordinate() > shooter.getxCoordinate() - blockerWidth &&
                    blocker.getxCoordinate() < shooter.getxCoordinate() + shooterWidth &&
                    blocker.getyCoordinate() > shooter.getyCoordinate() - blockerHeight &&
                    blocker.getyCoordinate() < shooter.getyCoordinate() + shooterHeight;
        } else if (shooter.getRotation() > 0) {
            return blocker.getxCoordinate() > shooter.getEndX() - blockerWidth &&
                    blocker.getxCoordinate() < shooter.getBarrelX() &&
                    blocker.getyCoordinate() > shooter.getBarrelY() - blockerHeight &&
                    blocker.getyCoordinate() < shooter.getEndY();
        } else {
            return blocker.getxCoordinate() > shooter.getBarrelX() - blockerWidth &&
                    blocker.getxCoordinate() < shooter.getEndX() &&
                    blocker.getyCoordinate() > shooter.getBarrelY() - blockerHeight &&
                    blocker.getyCoordinate() < shooter.getEndY();
        }
    }

    public static void shooterAndPowerupCollision() {
        for (Powerup powerup : Game.getInstance().getFallingPowerupList()) {
            if (isShooterAndPowerupCollided(powerup)) {
                removePowerup(powerup);
            }
        }
    }

    /**
     * Checks if given user collected powerup
     * @param powerup powerup from list of falling powerups
     * @return AtomShooter collided with falling powerup
     * @see CollisionController
     */
    private static boolean isShooterAndPowerupCollided(Powerup powerup) {
        //MODIFIES: powerup to be checked are given as parameters,
        //EFFECTS:  Given the powerup to be checked;
        //              1) Get AtomShooter instance and its bounding box,
        //              2) Get powerup and its bounding box,
        //              3) If they have an intersection:
        //                      return true
        //REQUIRES: - Game should not be in the pause mode.
        //          - Game should not be in the blender mode.
        AtomShooter shooter = AtomShooter.getInstance();

        if (shooter.getRotation() == 0) {
            return powerup.getxCoordinate() > shooter.getxCoordinate() - powerupEdge &&
                    powerup.getxCoordinate() < shooter.getxCoordinate() + shooterWidth &&
                    powerup.getyCoordinate() > shooter.getyCoordinate() - powerupEdge &&
                    powerup.getyCoordinate() < shooter.getyCoordinate() + shooterHeight;
        } else if (shooter.getRotation() > 0) {
            return powerup.getxCoordinate() > shooter.getEndX() - powerupEdge &&
                    powerup.getxCoordinate() < shooter.getBarrelX() &&
                    powerup.getyCoordinate() > shooter.getBarrelY() - powerupEdge &&
                    powerup.getyCoordinate() < shooter.getEndY();
        } else {
            return powerup.getxCoordinate() > shooter.getBarrelX() - powerupEdge &&
                    powerup.getxCoordinate() < shooter.getEndX() &&
                    powerup.getyCoordinate() > shooter.getBarrelY() - powerupEdge &&
                    powerup.getyCoordinate() < shooter.getEndY();
        }
    }
    /**
     * Runs continuously on AtomList to find shot atoms colliding with same type molecules
     * @see CollisionController
     */
    public static void atomAndMoleculeCollision() {
        //MODIFIES: Game instances AtomList, MoleculeList, Player Atom Counts and Score,
        //EFFECTS:  Given the powerup to be checked;
        //              1) Get AtomList,
        //              2) Get MoleculeList,
        //              3) If they collided:
        //                  3.b) If they are the same type:
        //                      play MoleculeSound
        //                      remove Atom from AtomList, molecule from MoleculeList
        //REQUIRES: - Game should not be in the pause mode.
        //          - Game should not be in the blender mode.
        for (Atom atom : Game.getInstance().getAtomList()) {
            for (Molecule molecule : Game.getInstance().getMoleculeList()) {
                if (isAtomAndMoleculeCollided(atom, molecule)) {
                    AudioService.hitMoleculeSound();
                    removeAtomAndMolecule(atom, molecule);
                }
            }
        }
    }

    /**
     * Checks if given same type atom and molecule have an intersection
     * @param atom atom from list of shootedAtoms
     * @param molecule molecule from list of falling molecules
     * @return same type atom and molecule collided
     * @see CollisionController
     */
    private static boolean isAtomAndMoleculeCollided(Atom atom, Molecule molecule) {
        //MODIFIES: atom and molecule to be checked are given as parameters,
        //EFFECTS:  Given the atom and corresponding molecule to be checked;
        //              1) Get atom and its bounding box,
        //              2) Get molecule and its bounding box,
        //              3) If they have an intersection:
        //                  3.a) If their types are correct (Ex. Alpha - Alpha-):
        //                      return true
        //REQUIRES: - Game should not be in the pause mode.
        //          - Game should not be in the blender mode.
        double moleculeWidth = getMoleculeSize(molecule).get(0);
        double moleculeHeight = getMoleculeSize(molecule).get(1);

        return atom.getType().equals(molecule.getType()) &&
                atom.getxCoordinate() > molecule.getxCoordinate() - atomEdge &&
                atom.getxCoordinate() < molecule.getxCoordinate() + moleculeWidth &&
                atom.getyCoordinate() > molecule.getyCoordinate() - atomEdge &&
                atom.getyCoordinate() < molecule.getyCoordinate() + moleculeHeight;
    }
    /**
     * Checks if given same type powerup and blocker have an intersection
     * @param powerup powerup from list of shooted powerups
     * @param blocker blocker from list of blockers
     * @return same type powerup and blocker collided
     * @see CollisionController
     */
    public static boolean isPowerupAndBlockerCollided(Powerup powerup, ReactionBlocker blocker) {
        //MODIFIES: powerup and blocker to be checked are given as parameters,
        //EFFECTS:  Given the powerup and corresponding blocker to be checked;
        //              1) Get powerup and its bounding box,
        //              2) Get blocker and its bounding box,
        //              3) If they have an intersection:
        //                  3.a) If their types are correct (Ex. +Alpha-b - Alpha-b):
        //                      return true
        //REQUIRES: - Game should not be in the pause mode.
        //          - Game should not be in the blender mode.
        return powerup.getType().equals(blocker.getType()) &&
                powerup.getxCoordinate() > blocker.getxCoordinate() - powerupEdge &&
                powerup.getxCoordinate() < blocker.getxCoordinate() + blockerWidth &&
                powerup.getyCoordinate() > blocker.getyCoordinate() - powerupEdge &&
                powerup.getyCoordinate() < blocker.getyCoordinate() + blockerHeight;
    }

    private static void removeAtomAndMolecule(Atom atom, Molecule molecule) {
        Game.getInstance().removeFromAtomlist(atom);
        Game.getInstance().removeFromMoleculeList(molecule);
        if (!isAnyBlockerInRange(molecule)) {
            PlayerController.getInstance().increaseScore(atom.getEfficiency());
            PlayerStatisticsPanel.updateLabels();
        }
    }

    private static boolean isAnyBlockerInRange(Molecule molecule) {
        for (ReactionBlocker blocker : Game.getInstance().getReactionBlockerList()) {
            if (isObjectInRange(blocker, molecule, false) && blocker.getType().equals(molecule.getType())) {
                return true;
            }
        }
        return false;
    }

    private static void removePowerupAndBlocker(Powerup powerup, ReactionBlocker blocker) {
        Game.getInstance().removeFromShootedPowerupList(powerup);
        Game.getInstance().removeFromReactionBlockerList(blocker);
    }

    private static void removePowerup(Powerup powerup) {
        Game.getInstance().removeFromFallingPowerupList(powerup);
        addPowerupToPlayer(powerup.getType());
        PowerupAndShieldStatisticsPanel.updatePowerupLabels();
    }


    /**
     * Messages corresponding functions to update player health, destroy
     * surroundings and remove blocker from blocker list.
     * @param blocker blocker that hit the ground
     * @see CollisionController
     */
    public static void explodeBlocker(ReactionBlocker blocker) {
        //MODIFIES: Blocker given as parameter,
        //          If AtomShooter closer than blockerExplodeRange:
        //              1) Player Health,
        //              2) Surrounding atoms
        //EFFECTS:  Given the blocker;
        //              1) Check if explosion gives damage to player,
        //                  1.a) If AtomShooter is closer than blockerExplodeRange:
        //                      Decrease health
        //              2) Check if there are surrounding objects to be destroyed:
        //                  2.a) If Atom in AtomList is closer than BlockerExplodeRange:
        //                      Destroy Atom
        //                  2.b) If Molecule is closer than BlockerExplodeRange:
        //                      Destroy Molecule
        //              3) Destroy given blocker
        //              4) Message UI to update
        //REQUIRES: - Game should not be in the pause mode.
        //          - Game should not be in the blender mode.
        giveDamageToPlayer(blocker);
        destroySurroundings(blocker);
        Game.getInstance().removeFromReactionBlockerList(blocker);
        PlayerStatisticsPanel.updateLabels();
    }

    private static void giveDamageToPlayer(ReactionBlocker blocker) {
        AtomShooter shooter = AtomShooter.getInstance();
        double shooterCenterX = (shooter.getBarrelX() + shooter.getEndX()) / 2;
        double blockerCenterX = blocker.getxCoordinate() + blockerWidth / 2;
        double distanceBetweenShooterAndBlocker = Math.abs(shooterCenterX - blockerCenterX);
        if (distanceBetweenShooterAndBlocker <= blockerExplodeRange) {
            double damage = GAME_PANEL_WIDTH / distanceBetweenShooterAndBlocker;
            Game.getInstance().getPlayer().setHealth(Game.getInstance().getPlayer().getHealth() - (int) damage);
        }
    }

    private static void destroySurroundings(ReactionBlocker blocker) {

        for (Atom atom : Game.getInstance().getAtomList()) {
            if (isObjectInRange(blocker, atom, true)) {
                Game.getInstance().removeFromAtomlist(atom);
            }
        }
        for (Molecule molecule : Game.getInstance().getMoleculeList()) {
            if (isObjectInRange(blocker, molecule, true)) {
                Game.getInstance().removeFromMoleculeList(molecule);
            }
        }

    }

    private static boolean isObjectInRange(ReactionBlocker blocker, Drawable obj, boolean isBlockerExplodeRange) {
        double objWidth = 0;
        double objHeight = 0;
        if (obj instanceof Atom) {
            objWidth = atomEdge;
            objHeight = atomEdge;
        } else {
            objWidth = getMoleculeSize((Molecule) obj).get(0);
            objHeight = getMoleculeSize((Molecule) obj).get(1);
        }

        double range = isBlockerExplodeRange ? blockerExplodeRange : blockerRange;

        double blockerCenterX = blocker.getxCoordinate() + blockerWidth / 2;
        double blockerCenterY = blocker.getyCoordinate() + blockerHeight / 2;

        double circleDistanceX = Math.abs(blockerCenterX - (obj.getxCoordinate() + objWidth / 2));
        double circleDistanceY = Math.abs(blockerCenterY - (obj.getyCoordinate() + objHeight / 2));

        if (circleDistanceX > (objWidth / 2 + range)) {
            return false;
        }
        if (circleDistanceY > (objHeight / 2 + range)) {
            return false;
        }
        if (circleDistanceX <= (objWidth / 2)) {
            return true;
        }
        if (circleDistanceY <= (objHeight / 2)) {
            return true;
        }

        double cornerDistance = Math.pow(circleDistanceX - objWidth / 2, 2)
                + Math.pow(circleDistanceY - objHeight / 2, 2);

        return (cornerDistance <= Math.pow(range, 2));
    }

}
