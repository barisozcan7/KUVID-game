import domain.controller.blender.BlenderController;
import domain.controller.game.AtomShooterController;
import domain.controller.game.ShieldController;
import domain.enums.Type;
import domain.models.building_mode.BuildingMode;
import domain.models.game.Game;
import domain.models.objects.AtomShooter;
import domain.models.objects.atom.Atom;
import domain.models.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static domain.enums.ShieldType.LOTA;
import static domain.enums.Type.*;
import static org.junit.jupiter.api.Assertions.*;

public class BlenderControllerTest {
    private Game game;
    private BlenderController blenderController;
    private Player player;
    private AtomShooter shooter;
    private AtomShooterController shooterController;

    @BeforeEach
    void setUp() {
        game = Game.getInstance();
        game.setGame(BuildingMode.getDefaultBuildingMode());
        player = game.getPlayer();
        blenderController = new BlenderController();
    }

    @Test
    void validate_out_of_atoms_blend() {
        player.setNumberOfAlphaAtoms(0);
        blenderController.setSourceAtom(ALPHA);
        blenderController.setProducedAtom(BETA);
        assertFalse(blenderController.blendOrBreakAtoms());
    }

    @Test
    void validate_out_of_atoms_break() {
        player.setNumberOfBetaAtoms(0);
        blenderController.setSourceAtom(BETA);
        blenderController.setProducedAtom(ALPHA);
        assertFalse(blenderController.blendOrBreakAtoms());
    }

    @Test
    void validate_insufficient_source_atom_blend() {
        player.setNumberOfAlphaAtoms(3);
        blenderController.setSourceAtom(ALPHA);
        blenderController.setProducedAtom(SIGMA);
        assertFalse(blenderController.blendOrBreakAtoms());
    }

    @Test
    void validate_pick_atom_if_out_of_current_selected_atom() {
        player.setNumberOfAlphaAtoms(2);
        player.setNumberOfBetaAtoms(0);
        player.setNumberOfGammaAtoms(0);
        player.setNumberOfSigmaAtoms(0);

        blenderController.setSourceAtom(ALPHA);
        blenderController.setProducedAtom(BETA);

        shooter = AtomShooter.getInstance();
        shooterController = AtomShooterController.getInstance();
        shooterController.pickAtom();

        Atom previousSelectedAtom = shooter.getCurrentSelectedAtom();
        assertEquals(previousSelectedAtom.getType(), ALPHA);

        blenderController.blendOrBreakAtoms();

        Atom currentSelectedAtom = shooter.getCurrentSelectedAtom();

        assertNotNull(currentSelectedAtom);
        assertNotEquals(previousSelectedAtom, currentSelectedAtom);
        assertEquals(currentSelectedAtom.getType(), BETA);
    }

    @Test
    void validate_blend_shielded_atom() {
        player.setNumberOfAlphaAtoms(2);
        player.setNumberOfBetaAtoms(0);
        player.setNumberOfGammaAtoms(0);
        player.setNumberOfSigmaAtoms(0);

        blenderController.setSourceAtom(ALPHA);
        blenderController.setProducedAtom(BETA);

        shooter = AtomShooter.getInstance();
        shooterController = AtomShooterController.getInstance();
        shooterController.pickAtom();

        for (int i = 0; i < player.getNumberOfLotaShields(); i++) {
            ShieldController.addShieldByType(LOTA);
        }

        blenderController.blendOrBreakAtoms();

        int currentNumAlphaAtoms = player.getNumberOfAlphaAtoms();

        assertEquals(currentNumAlphaAtoms, 0);
    }

    @Test
    void validate_only_current_selected_atom_left_break() {
        shooter = AtomShooter.getInstance();
        shooterController = AtomShooterController.getInstance();
        shooterController.pickAtom();

        Atom previousSelectedAtom = shooter.getCurrentSelectedAtom();
        Type previousSelectedAtomType = previousSelectedAtom.getType();

        int previousNumSourceAtom = 0;
        int previousNumProducedAtom = 0;
        int currentNumSourceAtom;
        int currentNumProducedAtom;

        switch (previousSelectedAtomType) {
            case ALPHA: {
                blenderController.setSourceAtom(ALPHA);
                blenderController.setProducedAtom(BETA);
                player.setNumberOfAlphaAtoms(2);
                previousNumSourceAtom = 2;
                player.setNumberOfBetaAtoms(0);
                player.setNumberOfGammaAtoms(0);
                player.setNumberOfSigmaAtoms(0);

                break;
            }
            case BETA: {
                blenderController.setSourceAtom(BETA);
                blenderController.setProducedAtom(ALPHA);
                player.setNumberOfBetaAtoms(1);
                previousNumSourceAtom = 1;
                player.setNumberOfAlphaAtoms(0);
                player.setNumberOfGammaAtoms(0);
                player.setNumberOfSigmaAtoms(0);
                break;
            }
            case SIGMA: {
                blenderController.setSourceAtom(SIGMA);
                blenderController.setProducedAtom(ALPHA);
                player.setNumberOfSigmaAtoms(1);
                previousNumSourceAtom = 1;
                player.setNumberOfAlphaAtoms(0);
                player.setNumberOfGammaAtoms(0);
                player.setNumberOfBetaAtoms(0);
                break;
            }
            case GAMMA: {
                blenderController.setSourceAtom(GAMMA);
                blenderController.setProducedAtom(ALPHA);
                player.setNumberOfGammaAtoms(1);
                previousNumSourceAtom = 1;
                player.setNumberOfAlphaAtoms(0);
                player.setNumberOfSigmaAtoms(0);
                player.setNumberOfBetaAtoms(0);
                break;
            }
        }

        blenderController.blendOrBreakAtoms();
        Atom currentSelectedAtom = shooter.getCurrentSelectedAtom();

        switch (previousSelectedAtomType) {
            case ALPHA: {
                currentNumSourceAtom = player.getNumberOfAlphaAtoms();
                currentNumProducedAtom = player.getNumberOfBetaAtoms();
                assertEquals(currentNumSourceAtom, 0);
                assertEquals(previousNumProducedAtom + 1, currentNumProducedAtom);
                assertNotNull(currentSelectedAtom);
                assertNotEquals(previousSelectedAtom, currentSelectedAtom);
                break;
            }
            case BETA: {
                currentNumSourceAtom = player.getNumberOfBetaAtoms();
                currentNumProducedAtom = player.getNumberOfAlphaAtoms();

                assertEquals(currentNumSourceAtom, 0);
                assertEquals(previousNumProducedAtom + 2, currentNumProducedAtom);
                assertNotNull(currentSelectedAtom);
                assertNotEquals(previousSelectedAtom, currentSelectedAtom);
                break;
            }
            case SIGMA: {
                currentNumSourceAtom = player.getNumberOfSigmaAtoms();
                currentNumProducedAtom = player.getNumberOfAlphaAtoms();

                assertEquals(currentNumSourceAtom, 0);
                assertEquals(previousNumProducedAtom + 4, currentNumProducedAtom);
                assertNotNull(currentSelectedAtom);
                assertNotEquals(previousSelectedAtom, currentSelectedAtom);
                break;
            }
            case GAMMA: {
                currentNumSourceAtom = player.getNumberOfGammaAtoms();
                currentNumProducedAtom = player.getNumberOfAlphaAtoms();

                assertEquals(currentNumSourceAtom, 0);
                assertEquals(previousNumProducedAtom + 3, currentNumProducedAtom);
                assertNotNull(currentSelectedAtom);
                assertNotEquals(previousSelectedAtom, currentSelectedAtom);
                break;
            }
        }
    }

    @Test
    void validate_alpha_to_alpha_blend() {
        blenderController.setSourceAtom(ALPHA);
        blenderController.setProducedAtom(ALPHA);
        assertFalse(blenderController.blendOrBreakAtoms());
    }

    @Test
    void validate_alpha_to_beta_blend() {
        blenderController.setSourceAtom(ALPHA);
        blenderController.setProducedAtom(BETA);

        int previousNumAlphaAtoms = player.getNumberOfAlphaAtoms();
        int previousNumBetaAtoms = player.getNumberOfBetaAtoms();
        blenderController.blendOrBreakAtoms();
        int currentNumAlphaAtoms = player.getNumberOfAlphaAtoms();
        int currentNumBetaAtoms = player.getNumberOfBetaAtoms();

        assertEquals(previousNumAlphaAtoms - 2, currentNumAlphaAtoms);
        assertEquals(previousNumBetaAtoms + 1, currentNumBetaAtoms);
    }

    @Test
    void validate_alpha_to_gamma_blend() {
        blenderController.setSourceAtom(ALPHA);
        blenderController.setProducedAtom(GAMMA);

        int previousNumAlphaAtoms = player.getNumberOfAlphaAtoms();
        int previousNumGammaAtoms = player.getNumberOfGammaAtoms();
        blenderController.blendOrBreakAtoms();
        int currentNumAlphaAtoms = player.getNumberOfAlphaAtoms();
        int currentNumGammaAtoms = player.getNumberOfGammaAtoms();

        assertEquals(previousNumAlphaAtoms - 3, currentNumAlphaAtoms);
        assertEquals(previousNumGammaAtoms + 1, currentNumGammaAtoms);
    }

    @Test
    void validate_alpha_to_sigma_blend() {
        blenderController.setSourceAtom(ALPHA);
        blenderController.setProducedAtom(SIGMA);

        int previousNumAlphaAtoms = player.getNumberOfAlphaAtoms();
        int previousNumSigmaAtoms = player.getNumberOfSigmaAtoms();
        blenderController.blendOrBreakAtoms();
        int currentNumAlphaAtoms = player.getNumberOfAlphaAtoms();
        int currentNumSigmaAtoms = player.getNumberOfSigmaAtoms();

        assertEquals(previousNumAlphaAtoms - 4, currentNumAlphaAtoms);
        assertEquals(previousNumSigmaAtoms + 1, currentNumSigmaAtoms);
    }

    @Test
    void validate_beta_to_alpha_break() {
        blenderController.setSourceAtom(BETA);
        blenderController.setProducedAtom(ALPHA);

        int previousNumBetaAtoms = player.getNumberOfBetaAtoms();
        int previousNumAlphaAtoms = player.getNumberOfAlphaAtoms();
        blenderController.blendOrBreakAtoms();
        int currentNumBetaAtoms = player.getNumberOfBetaAtoms();
        int currentNumAlphaAtoms = player.getNumberOfAlphaAtoms();

        assertEquals(previousNumBetaAtoms - 1, currentNumBetaAtoms);
        assertEquals(previousNumAlphaAtoms + 2, currentNumAlphaAtoms);
    }

    @Test
    void validate_beta_to_beta_blend() {
        blenderController.setSourceAtom(BETA);
        blenderController.setProducedAtom(BETA);
        assertFalse(blenderController.blendOrBreakAtoms());
    }

    @Test
    void validate_beta_to_gamma_blend() {
        blenderController.setSourceAtom(BETA);
        blenderController.setProducedAtom(GAMMA);

        int previousNumBetaAtoms = player.getNumberOfBetaAtoms();
        int previousNumGammaAtoms = player.getNumberOfGammaAtoms();
        blenderController.blendOrBreakAtoms();
        int currentNumBetaAtoms = player.getNumberOfBetaAtoms();
        int currentNumGammaAtoms = player.getNumberOfGammaAtoms();

        assertEquals(previousNumBetaAtoms - 2, currentNumBetaAtoms);
        assertEquals(previousNumGammaAtoms + 1, currentNumGammaAtoms);
    }

    @Test
    void validate_beta_to_sigma_blend() {
        blenderController.setSourceAtom(BETA);
        blenderController.setProducedAtom(SIGMA);

        int previousNumBetaAtoms = player.getNumberOfBetaAtoms();
        int previousNumSigmaAtoms = player.getNumberOfSigmaAtoms();
        blenderController.blendOrBreakAtoms();
        int currentNumBetaAtoms = player.getNumberOfBetaAtoms();
        int currentNumSigmaAtoms = player.getNumberOfSigmaAtoms();

        assertEquals(previousNumBetaAtoms - 3, currentNumBetaAtoms);
        assertEquals(previousNumSigmaAtoms + 1, currentNumSigmaAtoms);
    }

    @Test
    void validate_gamma_to_alpha_break() {
        blenderController.setSourceAtom(GAMMA);
        blenderController.setProducedAtom(ALPHA);

        int previousNumGammaAtoms = player.getNumberOfGammaAtoms();
        int previousNumAlphaAtoms = player.getNumberOfAlphaAtoms();
        blenderController.blendOrBreakAtoms();
        int currentNumGammaAtoms = player.getNumberOfGammaAtoms();
        int currentNumAlphaAtoms = player.getNumberOfAlphaAtoms();

        assertEquals(previousNumGammaAtoms - 1, currentNumGammaAtoms);
        assertEquals(previousNumAlphaAtoms + 3, currentNumAlphaAtoms);
    }

    @Test
    void validate_gamma_to_beta_break() {
        blenderController.setSourceAtom(GAMMA);
        blenderController.setProducedAtom(BETA);

        int previousNumGammaAtoms = player.getNumberOfGammaAtoms();
        int previousNumBetaAtoms = player.getNumberOfBetaAtoms();
        blenderController.blendOrBreakAtoms();
        int currentNumGammaAtoms = player.getNumberOfGammaAtoms();
        int currentNumBetaAtoms = player.getNumberOfBetaAtoms();

        assertEquals(previousNumGammaAtoms - 1, currentNumGammaAtoms);
        assertEquals(previousNumBetaAtoms + 2, currentNumBetaAtoms);
    }

    @Test
    void validate_gamma_to_gamma_blend() {
        blenderController.setSourceAtom(GAMMA);
        blenderController.setProducedAtom(GAMMA);
        assertFalse(blenderController.blendOrBreakAtoms());
    }

    @Test
    void validate_gamma_to_sigma_blend() {
        blenderController.setSourceAtom(GAMMA);
        blenderController.setProducedAtom(SIGMA);

        int previousNumGammaAtoms = player.getNumberOfGammaAtoms();
        int previousNumSigmaAtoms = player.getNumberOfSigmaAtoms();
        blenderController.blendOrBreakAtoms();
        int currentNumGammaAtoms = player.getNumberOfGammaAtoms();
        int currentNumSigmaAtoms = player.getNumberOfSigmaAtoms();

        assertEquals(previousNumGammaAtoms - 2, currentNumGammaAtoms);
        assertEquals(previousNumSigmaAtoms + 1, currentNumSigmaAtoms);
    }

    @Test
    void validate_sigma_to_alpha_break() {
        blenderController.setSourceAtom(SIGMA);
        blenderController.setProducedAtom(ALPHA);

        int previousNumSigmaAtoms = player.getNumberOfSigmaAtoms();
        int previousNumAlphaAtoms = player.getNumberOfAlphaAtoms();
        blenderController.blendOrBreakAtoms();
        int currentNumSigmaAtoms = player.getNumberOfSigmaAtoms();
        int currentNumAlphaAtoms = player.getNumberOfAlphaAtoms();

        assertEquals(previousNumSigmaAtoms - 1, currentNumSigmaAtoms);
        assertEquals(previousNumAlphaAtoms + 4, currentNumAlphaAtoms);
    }

    @Test
    void validate_sigma_to_beta_break() {
        blenderController.setSourceAtom(SIGMA);
        blenderController.setProducedAtom(BETA);

        int previousNumSigmaAtoms = player.getNumberOfSigmaAtoms();
        int previousNumBetaAtoms = player.getNumberOfBetaAtoms();
        blenderController.blendOrBreakAtoms();
        int currentNumSigmaAtoms = player.getNumberOfSigmaAtoms();
        int currentNumBetaAtoms = player.getNumberOfBetaAtoms();

        assertEquals(previousNumSigmaAtoms - 1, currentNumSigmaAtoms);
        assertEquals(previousNumBetaAtoms + 3, currentNumBetaAtoms);
    }

    @Test
    void validate_sigma_to_gamma_break() {
        blenderController.setSourceAtom(SIGMA);
        blenderController.setProducedAtom(GAMMA);

        int previousNumSigmaAtoms = player.getNumberOfSigmaAtoms();
        int previousNumGammaAtoms = player.getNumberOfGammaAtoms();
        blenderController.blendOrBreakAtoms();
        int currentNumSigmaAtoms = player.getNumberOfSigmaAtoms();
        int currentNumGammaAtoms = player.getNumberOfGammaAtoms();

        assertEquals(previousNumSigmaAtoms - 1, currentNumSigmaAtoms);
        assertEquals(previousNumGammaAtoms + 2, currentNumGammaAtoms);
    }

    @Test
    void validate_sigma_to_sigma_blend() {
        blenderController.setSourceAtom(SIGMA);
        blenderController.setProducedAtom(SIGMA);
        assertFalse(blenderController.blendOrBreakAtoms());
    }

}
