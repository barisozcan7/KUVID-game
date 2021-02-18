package domain.controller.game;

import UI.components.game_view.statistics_view.AtomStatisticsPanel;
import UI.components.game_view.statistics_view.PowerupAndShieldStatisticsPanel;
import domain.enums.GameMode;
import domain.enums.Type;
import domain.models.game.Game;
import domain.models.objects.AtomShooter;
import domain.models.objects.atom.Atom;
import domain.models.objects.powerup.Powerup;
import service.audio_service.AudioService;
import service.object_service.AtomFactory;
import service.view_service.ViewFactory;

import static configs.ObjectConstants.*;
import static service.object_service.PowerupFactory.createPowerup;
import static service.object_service.PowerupFactory.removePowerupFromPlayer;

public class AtomShooterController {
    private static AtomShooterController controller;
    private boolean reloading;

    private AtomShooterController() {
        pickAtom();
    }

    public static AtomShooterController getInstance() {
        if (controller == null) {
            controller = new AtomShooterController();
        }
        return controller;
    }

    public static void resetController() {
        controller = null;
    }

    public void moveLeft() {
        AtomShooter shooter = AtomShooter.getInstance();
        if (shooter.getCurrentSelectedAtom() != null) {
            double atomXCoordinate = getXOfRotatedObject(shooter.getRotation());

            if (atomXCoordinate > leftMax && shooter.getxCoordinate() - (atomEdge - shooterWidth) / 2 > leftMax) {
                shooter.setxCoordinate(shooter.getxCoordinate() - transformSpeed);
            }
        } else {
            double powerupXCoordinate = getXOfRotatedObject(shooter.getRotation());

            if (powerupXCoordinate > leftMax && shooter.getxCoordinate() - (atomEdge - shooterWidth) / 2 > leftMax) {
                shooter.setxCoordinate(shooter.getxCoordinate() - transformSpeed);
            }
        }

        shooter.updateBarrel();
    }

    public void moveRight() {
        AtomShooter shooter = AtomShooter.getInstance();
        if (shooter.getCurrentSelectedAtom() != null) {
            double atomXCoordinate = getXOfRotatedObject(shooter.getRotation());

            if (atomXCoordinate < rightMax && shooter.getxCoordinate() < rightMax) {
                shooter.setxCoordinate(shooter.getxCoordinate() + transformSpeed);
            }
        } else {
            double powerupXCoordinate = getXOfRotatedObject(shooter.getRotation());

            if (powerupXCoordinate < rightMax && shooter.getxCoordinate() < rightMax) {
                shooter.setxCoordinate(shooter.getxCoordinate() + transformSpeed);
            }
        }

        shooter.updateBarrel();
    }

    public void pickAtom() {
        //MODIFIES: AtomShooter's current selected atom, AtomShooter's current selected powerup and Game's atom inventory list.
        //EFFECTS: Creates a random atom using AtomFactory's createAtom() method.
        //         AtomFactory's createAtom() might return null if there is no atom's left.
        //         AtomFactor's createAtom() might return one of the atoms in the inventory instead of creating a new one.
        //         If the picked atom is not already in the inventory, it adds the selected atom into inventory.
        //         Then, it sets the rotation of the atom equal to the AtomShooter's rotation.
        //         In the end, sets the current selected powerup to null.
        //REQUIRES: Game should not be in the pause mode.

        AtomShooter shooter = AtomShooter.getInstance();
        shooter.setCurrentSelectedAtom(AtomFactory.getInstance().
                createAtom(shooter.getxCoordinate(),
                        shooter.getyCoordinate() - atomEdge));
        if (!Game.getInstance().getAtomInventoryList().contains(shooter.getCurrentSelectedAtom())) {
            Game.getInstance().insertToAtomInventoryList(shooter.getCurrentSelectedAtom());
        }
        if (shooter.getCurrentSelectedAtom() != null) {
            shooter.getCurrentSelectedAtom().setRotation(shooter.getRotation());
        }
        shooter.setCurrentSelectedPowerup(null);
    }

    public void pickPowerup(Type powerupType) {
        AtomShooter shooter = AtomShooter.getInstance();
        Powerup newPowerup = createPowerup(powerupType,
                shooter.getxCoordinate(),
                shooter.getyCoordinate() - powerupEdge);
        if (newPowerup != null) {
            newPowerup.setSpeed(speedConstant);
            shooter.setCurrentSelectedPowerup(newPowerup);
            shooter.getCurrentSelectedPowerup().setRotation(shooter.getRotation());
            shooter.setCurrentSelectedAtom(null);
        }
    }

    public void shoot() {
        //MODIFIES: 1) AtomShooter's reloading field. This field is a variable we use to prevent continuous shooting.
        //             After shooter shoots an atom, we make it true. To shoot again, player should wait for a second.
        //             After 1 second, GameController makes it false using TimerTask's run method.
        //          If an atom is selected currently, it modifies the following:
        //             2) Game's atom list.
        //             3) Game's inventory list.
        //             4) Player's number of atoms variables.
        //             5) AtomStatisticPanel's atom labels.
        //             6) AtomShooter's current selected atom.
        //          Else if a powerup is selected currently, it modifies the following:
        //             1) Game's powerup list.
        //             2) Game's number of powerup variables.
        //             3) PowerupStatisticsPanel's powerup labels.
        //             4) AtomShooter's current selected powerup.
        //EFFECTS: If an atom is selected currently, it has the following effects:
        //             1) Calls AudioService's shootAtomSound() method to make a sound.
        //             2) Adds current selected atom into Game's atom list. This is the list we have to keep track of the thrown atoms.
        //                When the atoms leaves the screen or hits a molecule, we remove them from this list.
        //             3) If the atom is not in the inventory, it removes the selected atom from the inventory list.
        //             4) It decreases the number of atoms of the Player object by using AtomFactory's removeAtomByType() method.
        //             5) It updates AtomStatisticPanel's labels by calling its updateLabels() method.
        //             6) It modifies the current selected atom's coordinates.
        //             7) It picks an atom again.
        //        If a powerup is selected currently, it has the following effects:
        //             1) Calls AudioService's shootPowerupSound() method to make a sound.
        //             2) Adds current selected powerup into Game's powerup list.
        //                This is the list we have to keep track of the thrown powerups.
        //                When the powerup leaves the screen or hits a reaction blocker, we remove them from this list.
        //             3) It decreases the number of powerup of the Player object by using PowerupFactory's removePowerupFromPlayer() method.
        //             4) It updates PowerupStatisticPanels's labels by calling its updateLabels() method.
        //             5) It modifies the current selected powerups's coordinates.
        //             6) It picks an atom.
        //REQUIRES: 1) Game should not be in the pause mode.
        //          2) Reloading should be false.

        AtomShooter shooter = AtomShooter.getInstance();
        if (!reloading) {
            Atom currentSelectedAtom = shooter.getCurrentSelectedAtom();
            Powerup currentSelectedPowerup = shooter.getCurrentSelectedPowerup();
            if (currentSelectedAtom != null) {
                shootAtom(currentSelectedAtom);
            } else if (currentSelectedPowerup != null) {
                shootPowerup(currentSelectedPowerup);
            }
            reloading = true;
        }
    }

    private void shootAtom(Atom currentSelectedAtom) {
        AudioService.shootAtomSound();
        AtomShooter shooter = AtomShooter.getInstance();
        double rotation = shooter.getRotation();
        Game.getInstance().insertIntoAtomList(currentSelectedAtom);
        if (Game.getInstance().getAtomInventoryList().contains(currentSelectedAtom)) {
            Game.getInstance().removeFromAtomInventoryList(currentSelectedAtom);
        }
        AtomFactory.getInstance().removeAtomByType(currentSelectedAtom.getType(), 1);
        AtomStatisticsPanel.updateLabels();
        currentSelectedAtom.setxCoordinate(getXOfRotatedObject(rotation));
        currentSelectedAtom.setyCoordinate(getYOfRotatedObject(rotation));
        pickAtom();
    }

    private void shootPowerup(Powerup currentSelectedPowerup) {
        AudioService.shootPowerupSound();
        AtomShooter shooter = AtomShooter.getInstance();
        double rotation = shooter.getRotation();
        Game.getInstance().insertIntoShootedPowerupList(currentSelectedPowerup);
        removePowerupFromPlayer(currentSelectedPowerup.getType());
        PowerupAndShieldStatisticsPanel.updatePowerupLabels();
        shooter.getCurrentSelectedPowerup().setxCoordinate(getXOfRotatedObject(rotation));
        shooter.getCurrentSelectedPowerup().setyCoordinate(getYOfRotatedObject(rotation));
        shooter.setCurrentSelectedPowerup(null);
        pickAtom();
    }

    public void rotateClockwise() {
        AtomShooter shooter = AtomShooter.getInstance();
        double rotation = shooter.getRotation();
        if (shooter.getCurrentSelectedAtom() != null) {
            double getXAfterRotation = getXOfRotatedObject(rotation + rotateSpeed);

            if (getXAfterRotation - 10 < rightMax) {
                if (rotation < maxRotation) {
                    shooter.setRotation(rotation + rotateSpeed);
                    shooter.getCurrentSelectedAtom().setRotation(rotation + rotateSpeed);
                }
            }
        } else if (shooter.getCurrentSelectedPowerup() != null) {
            double getXAfterRotation = getXOfRotatedObject(rotation + rotateSpeed);

            if (getXAfterRotation - 10 < rightMax) {
                if (rotation < maxRotation) {
                    shooter.setRotation(rotation + rotateSpeed);
                    shooter.getCurrentSelectedPowerup().setRotation(rotation + rotateSpeed);
                }
            }
        }
        shooter.updateBarrel();
    }

    public void rotateCounterclockwise() {
        AtomShooter shooter = AtomShooter.getInstance();
        double rotation = shooter.getRotation();
        if (shooter.getCurrentSelectedAtom() != null) {
            double getXAfterRotation = getXOfRotatedObject(rotation - rotateSpeed);

            if (getXAfterRotation + 10 > leftMax) {
                if (rotation > -maxRotation) {
                    shooter.setRotation(rotation - rotateSpeed);
                    shooter.getCurrentSelectedAtom().setRotation(rotation - rotateSpeed);
                }
            }
        } else if (shooter.getCurrentSelectedPowerup() != null) {
            double getXAfterRotation = getXOfRotatedObject(rotation - rotateSpeed);

            if (getXAfterRotation + 10 > leftMax) {
                if (rotation > -maxRotation) {
                    shooter.setRotation(rotation - rotateSpeed);
                    shooter.getCurrentSelectedPowerup().setRotation(rotation - rotateSpeed);
                }
            }
        }
        shooter.updateBarrel();
    }

    private double getXOfRotatedObject(double rotateDegree) {
        AtomShooter shooter = AtomShooter.getInstance();
        double xCoordinate;
        double x = Math.cos(Math.toRadians(90 - rotateDegree));
        if (shooter.getCurrentSelectedAtom() != null) {
            xCoordinate = shooter.getCurrentSelectedAtom().getxCoordinate()
                    + rotationLength * x;
        } else {
            xCoordinate = shooter.getCurrentSelectedPowerup().getxCoordinate()
                    + rotationLength * x;
        }
        return xCoordinate;
    }

    private double getYOfRotatedObject(double rotateDegree) {
        AtomShooter shooter = AtomShooter.getInstance();
        double yCoordinate;
        double y = 1 - Math.sin(Math.toRadians(90 - rotateDegree));
        if (shooter.getCurrentSelectedAtom() != null) {
            yCoordinate = shooter.getCurrentSelectedAtom().getyCoordinate()
                    + rotationLength * y;
        } else {
            yCoordinate = shooter.getCurrentSelectedPowerup().getyCoordinate()
                    + rotationLength * y;
        }
        return yCoordinate;
    }

    public void openBlendingMode() {
        ViewFactory.getInstance().getView(GameMode.BLENDER_MODE);
    }

    public void finishReloading() {
        this.reloading = false;
    }
}
