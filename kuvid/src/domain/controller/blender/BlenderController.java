package domain.controller.blender;

import UI.components.game_view.statistics_view.AtomStatisticsPanel;
import domain.controller.game.AtomShooterController;
import domain.controller.game.GameController;
import domain.enums.GameMode;
import domain.enums.Type;
import domain.models.blender_mode.Blender;
import domain.models.game.Game;
import domain.models.objects.AtomShooter;
import domain.models.objects.atom.Atom;
import domain.models.player.Player;
import service.view_service.ViewFactory;

import static service.object_service.AtomFactory.createAtomByType;
import static service.object_service.AtomFactory.removeAtomByType;

public class BlenderController {
    //OVERVIEW: This class provides the methods to be called from the BlenderModeView
    // that are useful to manipulate the Player's number of atoms according to the Game logic.

    private Blender blender = Blender.getInstance();

    public BlenderController() {
        setSourceAtom(Type.ALPHA);
        setProducedAtom(Type.ALPHA);
    }

    /**
     * Sets the source atom to blend/break
     *
     * @param sourceAtom Type of the source atom
     * @see BlenderController
     */
    public void setSourceAtom(Type sourceAtom) {
        //REQUIRES: Game should be in the Blender Mode.
        //MODIFIES: None
        //EFFECTS: Sets the source atom to blend/break
        //RETURNS: void
        blender.setSourceAtom(sourceAtom);
    }

    /**
     * Sets the produced atom to blend/break
     *
     * @param producedAtom Type of the source atom
     * @see BlenderController
     */
    public void setProducedAtom(Type producedAtom) {
        //REQUIRES: Game should be in the Blender Mode.
        //MODIFIES: None
        //EFFECTS: Sets the produced atom to blend/break
        //RETURNS: void
        blender.setProducedAtom(producedAtom);
    }

    /**
     * @return a boolean value whether the blend/break operation is successful or not
     * @see BlenderController
     */
    public boolean apply() {
        //REQUIRES: Game should be in the Blender Mode.
        //MODIFIES: None
        //EFFECTS: According to the result of the blend/break operation
        //         if true --> 1) updates the UI by calling UI functions to
        //                        closing the blender window and changing the
        //                        atom number labels.
        //                     2) decreases the number of the source atom whilst
        //                        increasing the number of the produced atom.
        //         if false --> none
        //RETURNS: true if the blend/break operation is successful, false otherwise
        if (blendOrBreakAtoms()) {
            returnToGameMode();
            AtomStatisticsPanel.updateLabels();
            GameController.getInstance().returnGame();
            return true;
        }
        return false;
    }

    /**
     * @return a boolean value whether the blend/break operation is successful or not
     * @see BlenderController
     */
    public boolean blendOrBreakAtoms() {
        //REQUIRES: Game should be in the Blender Mode.
        //MODIFIES: None
        //EFFECTS:  Given the source atom / produced atom
        //
        // |Source|Produced|                            Effects                                  |
        // |------|--------|---------------------------------------------------------------------|
        //  Alpha  Alpha    none
        //
        //  Alpha  Beta     removes 2 Alpha atoms from the Player
        //                  creates 1 Beta atom and adds it/them to the Player
        //                  if --> the Player is out of Alpha atom and shooter had the Alpha atom
        //                         as its current atom --> picks another atom available.
        //
        //  Alpha  Gamma    removes 3 Alpha atoms from the Player
        //                  creates 1 Gamma atom and adds it/them to the Player
        //                  if --> the Player is out of source atom and shooter had the Alpha atom
        //                         as its current atom --> picks another atom available.
        //
        //  Alpha  Sigma    removes 4 Alpha atoms from the Player
        //                  creates 1 Sigma atom and adds it/them to the Player
        //                  if --> the Player is out of source atom and shooter had the Alpha atom
        //                         as its current atom --> picks another atom available.
        //
        //  Beta   Beta    none
        //
        //  Beta   Alpha    removes 1 Beta atoms from the Player
        //                  creates 2 Alpha atom and adds it/them to the Player
        //                  if --> the Player is out of Alpha atom and shooter had the Beta atom
        //                         as its current atom --> picks another atom available.
        //
        //  Beta   Gamma    removes 2 Beta atoms from the Player
        //                  creates 1 Gamma atom and adds it/them to the Player
        //                  if --> the Player is out of source atom and shooter had the Beta atom
        //                         as its current atom --> picks another atom available.
        //
        //  Beta   Sigma    removes 3 Beta atoms from the Player
        //                  creates 1 Sigma atom and adds it/them to the Player
        //                  if --> the Player is out of source atom and shooter had the Beta atom
        //                         as its current atom --> picks another atom available.
        //
        //  Gamma  Gamma    none
        //
        //  Gamma  Alpha    removes 1 Gamma atoms from the Player
        //                  creates 3 Alpha atom and adds it/them to the Player
        //                  if --> the Player is out of Alpha atom and shooter had the Gamma atom
        //                         as its current atom --> picks another atom available.
        //
        //  Gamma  Beta     removes 1 Gamma atoms from the Player
        //                  creates 2 Beta atom and adds it/them to the Player
        //                  if --> the Player is out of source atom and shooter had the Gamma atom
        //                         as its current atom --> picks another atom available.
        //
        //  Gamma  Sigma    removes 2 Gamma atoms from the Player
        //                  creates 1 Sigma atom and adds it/them to the Player
        //                  if --> the Player is out of source atom and shooter had the Gamma atom
        //                         as its current atom --> picks another atom available.
        //
        //  Sigma  Sigma    none
        //
        //  Sigma  Alpha    removes 1 Sigma atoms from the Player
        //                  creates 4 Alpha atom and adds it/them to the Player
        //                  if --> the Player is out of Alpha atom and shooter had the Sigma atom
        //                         as its current atom --> picks another atom available.
        //
        //  Sigma  Beta     removes 1 Sigma atoms from the Player
        //                  creates 3 Beta atom and adds it/them to the Player
        //                  if --> the Player is out of source atom and shooter had the Sigma atom
        //                         as its current atom --> picks another atom available.
        //
        //  Sigma  Gamma    removes 1 Sigma atoms from the Player
        //                  creates 2 Gamma atom and adds it/them to the Player
        //                  if --> the Player is out of source atom and shooter had the Sigma atom
        //                         as its current atom --> picks another atom available.
        //
        //RETURNS: true if the blend/break operation is successful, false otherwise
        Type sourceAtomType = blender.getSourceAtom();
        Type producedAtomType = blender.getProducedAtom();

        switch (sourceAtomType) {
            case ALPHA -> {
                switch (producedAtomType) {
                    case ALPHA -> {
                    }
                    case BETA -> {
                        if (removeAtomByType(Type.ALPHA, 2)) {
                            createAtomByType(Type.BETA, 1);
                            pickAnotherAtomIfOutOfAtoms(sourceAtomType);
                            return true;
                        }
                    }
                    case GAMMA -> {
                        if (removeAtomByType(Type.ALPHA, 3)) {
                            createAtomByType(Type.GAMMA, 1);
                            pickAnotherAtomIfOutOfAtoms(sourceAtomType);
                            return true;
                        }
                    }
                    case SIGMA -> {
                        if (removeAtomByType(Type.ALPHA, 4)) {
                            createAtomByType(Type.SIGMA, 1);
                            pickAnotherAtomIfOutOfAtoms(sourceAtomType);
                            return true;
                        }
                    }
                }
            }
            case BETA -> {
                switch (producedAtomType) {
                    case ALPHA -> {
                        if (removeAtomByType(Type.BETA, 1)) {
                            createAtomByType(Type.ALPHA, 2);
                            pickAnotherAtomIfOutOfAtoms(sourceAtomType);
                            return true;
                        }
                    }
                    case BETA -> {
                    }
                    case GAMMA -> {
                        if (removeAtomByType(Type.BETA, 2)) {
                            createAtomByType(Type.GAMMA, 1);
                            pickAnotherAtomIfOutOfAtoms(sourceAtomType);
                            return true;
                        }
                    }
                    case SIGMA -> {
                        if (removeAtomByType(Type.BETA, 3)) {
                            createAtomByType(Type.SIGMA, 1);
                            pickAnotherAtomIfOutOfAtoms(sourceAtomType);
                            return true;
                        }
                    }
                }
            }
            case GAMMA -> {
                switch (producedAtomType) {
                    case ALPHA -> {
                        if (removeAtomByType(Type.GAMMA, 1)) {
                            createAtomByType(Type.ALPHA, 3);
                            pickAnotherAtomIfOutOfAtoms(sourceAtomType);
                            return true;
                        }
                    }
                    case BETA -> {
                        if (removeAtomByType(Type.GAMMA, 1)) {
                            createAtomByType(Type.BETA, 2);
                            pickAnotherAtomIfOutOfAtoms(sourceAtomType);
                            return true;
                        }
                    }
                    case GAMMA -> {
                    }
                    case SIGMA -> {
                        if (removeAtomByType(Type.GAMMA, 2)) {
                            createAtomByType(Type.SIGMA, 1);
                            pickAnotherAtomIfOutOfAtoms(sourceAtomType);
                            return true;
                        }
                    }
                }
            }
            case SIGMA -> {
                switch (producedAtomType) {
                    case ALPHA -> {
                        if (removeAtomByType(Type.SIGMA, 1)) {
                            createAtomByType(Type.ALPHA, 4);
                            pickAnotherAtomIfOutOfAtoms(sourceAtomType);
                            return true;
                        }
                    }
                    case BETA -> {
                        if (removeAtomByType(Type.SIGMA, 1)) {
                            createAtomByType(Type.BETA, 3);
                            pickAnotherAtomIfOutOfAtoms(sourceAtomType);
                            return true;
                        }
                    }
                    case GAMMA -> {
                        if (removeAtomByType(Type.SIGMA, 1)) {
                            createAtomByType(Type.GAMMA, 2);
                            pickAnotherAtomIfOutOfAtoms(sourceAtomType);
                            return true;
                        }
                    }
                    case SIGMA -> {
                    }
                }
            }
        }
        return false;
    }

    private void pickAnotherAtomIfOutOfAtoms(Type type) {
        AtomShooterController atomShooterController = AtomShooterController.getInstance();
        Atom currentSelectedAtom = AtomShooter.getInstance().getCurrentSelectedAtom();
        Player player = Game.getInstance().getPlayer();
        if (type.equals(currentSelectedAtom.getType())) {
            switch (type) {
                case ALPHA -> {
                    if (player.getNumberOfAlphaAtoms() == 0) atomShooterController.pickAtom();
                }
                case BETA -> {
                    if (player.getNumberOfBetaAtoms() == 0) atomShooterController.pickAtom();
                }
                case GAMMA -> {
                    if (player.getNumberOfGammaAtoms() == 0) atomShooterController.pickAtom();
                }
                case SIGMA -> {
                    if (player.getNumberOfSigmaAtoms() == 0) atomShooterController.pickAtom();
                }
            }
        }
    }

    private void returnToGameMode() {
        ViewFactory.getInstance().removeView(GameMode.BLENDER_MODE);
    }
}
