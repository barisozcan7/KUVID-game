import domain.controller.game.AtomShooterController;
import domain.controller.game.GameController;
import domain.enums.Type;
import domain.models.building_mode.BuildingMode;
import domain.models.game.Game;
import domain.models.objects.AtomShooter;
import domain.models.objects.atom.Atom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static UI.components.game_view.statistics_view.AtomStatisticsPanel.*;
import static configs.ObjectConstants.atomEdge;
import static configs.ObjectConstants.shooterWidth;
import static domain.enums.Type.*;
import static org.junit.jupiter.api.Assertions.*;
import static service.object_service.AtomFactory.getTotalNumberOfAtoms;

class AtomShooterControllerTest {
    private AtomShooter shooter;
    private Game game;
    private AtomShooterController controller;
    private Atom selectedAtom;

    //this is the margin we use to have the atom in a better position according to the shooter.
    // this margin makes atom look exactly on top of the bullet.
    private double xCoordinateMarginForAtom = (atomEdge - shooterWidth)/2;

    @BeforeEach
    void setUp() {
        GameController.getInstance().resetGame();
        Game.getInstance().setGame(BuildingMode.getDefaultBuildingMode());
        game = Game.getInstance();
        shooter = AtomShooter.getInstance();
        controller = AtomShooterController.getInstance();
        controller.pickAtom();
        selectedAtom = shooter.getCurrentSelectedAtom();
    }

    @Test
    void validate_atom_after_pick_atom() {
        assertNotNull(selectedAtom);
        Type atomType = selectedAtom.getType();
        assertTrue(atomType == ALPHA || atomType == BETA || atomType == GAMMA || atomType == SIGMA);

        for(int i = 0; i < 3; i++){
            controller.pickAtom();
            selectedAtom = shooter.getCurrentSelectedAtom();
            atomType = selectedAtom.getType();
            assertTrue(atomType == ALPHA || atomType == BETA || atomType == GAMMA || atomType == SIGMA);
        }
    }

    @Test
    void validate_atom_coordinates_after_pick_atom() {
        assertNotNull(selectedAtom);
        assertEquals(selectedAtom.getxCoordinate() + xCoordinateMarginForAtom , shooter.getxCoordinate());

        for(int i = 0; i< 3; i++) {
            controller.moveLeft();
            assertEquals(selectedAtom.getxCoordinate() + xCoordinateMarginForAtom , shooter.getxCoordinate());
        }

        for(int i = 0; i< 10; i++) {
            controller.moveRight();
            assertEquals(selectedAtom.getxCoordinate() + xCoordinateMarginForAtom , shooter.getxCoordinate());
        }
    }

    @Test
    void validate_atom_rotation_after_pick_atom() {
        assertNotNull(selectedAtom);
        assertEquals(selectedAtom.getRotation() , shooter.getRotation());

        for(int i = 0; i< 10; i++) {
            controller.rotateClockwise();
            assertEquals(selectedAtom.getRotation() , shooter.getRotation());
        }

        for(int i = 0; i< 70; i++) {
            controller.rotateCounterclockwise();
            assertEquals(selectedAtom.getRotation() , shooter.getRotation());
        }
    }

    @Test
    void check_if_atom_is_in_inventory_after_pick_atom() {
        assertNotNull(selectedAtom);
        assertTrue(game.getAtomInventoryList().contains(selectedAtom));

        for(int i = 0; i< 3; i++) {
            controller.pickAtom();
            selectedAtom = shooter.getCurrentSelectedAtom();
            assertTrue(game.getAtomInventoryList().contains(selectedAtom));
        }
    }

    @Test
    void check_if_number_of_atoms_decrease_after_shoot() {
        Type atomType;
        int numberOfAtomsBeforeShooting;
        int numberOfAtomsAfterShooting;

        for(int i = 0; i < 5; i++){
            selectedAtom = shooter.getCurrentSelectedAtom();
            atomType = selectedAtom.getType();
            numberOfAtomsBeforeShooting = numberOfRemainingAtomsOfTypeFromGameModel(atomType);

            controller.shoot();

            numberOfAtomsAfterShooting = numberOfRemainingAtomsOfTypeFromGameModel(atomType);

            assertEquals(numberOfAtomsBeforeShooting, numberOfAtomsAfterShooting + 1);
            controller.finishReloading();
        }
    }

    @Test
    void check_if_atom_labels_are_updated_correctly_after_shoot() {
        Type atomType;
        int numberOfAtomsBeforeShooting;
        int numberOfAtomsAfterShooting;
        updateLabels();

        for(int i = 0; i < 10; i++){
            selectedAtom = shooter.getCurrentSelectedAtom();
            atomType = selectedAtom.getType();
            numberOfAtomsBeforeShooting = numberOfRemainingAtomsOfTypeFromAtomStatisticsUI(atomType);

            controller.shoot();

            numberOfAtomsAfterShooting = numberOfRemainingAtomsOfTypeFromAtomStatisticsUI(atomType);

            assertEquals(numberOfAtomsBeforeShooting, numberOfAtomsAfterShooting + 1);
            controller.finishReloading();
        }
    }

    @Test
    void check_atom_lists_after_shoot() {
        for(int i = 0; i < 10; i++){
            selectedAtom = shooter.getCurrentSelectedAtom();
            controller.shoot();
            assertFalse(game.getAtomInventoryList().contains(selectedAtom));
            assertTrue(game.getAtomList().contains(selectedAtom));
            controller.finishReloading();
        }
    }

    @Test
    void check_running_out_of_atoms() {
        for(int i = 0; i < 1000; i++){
            assertAll(() -> controller.shoot());
            assertAll(() -> controller.finishReloading());
        }
        assertEquals(getTotalNumberOfAtoms(), 0);
    }

    private int numberOfRemainingAtomsOfTypeFromGameModel(Type type) {
        game = Game.getInstance();
        if(ALPHA.equals(type)) {
            return game.getPlayer().getNumberOfAlphaAtoms();
        }
        else if(BETA.equals(type)) {
            return game.getPlayer().getNumberOfBetaAtoms();
        }
        else if(GAMMA.equals(type)) {
            return game.getPlayer().getNumberOfGammaAtoms();
        }
        else {
            return game.getPlayer().getNumberOfSigmaAtoms();
        }
    }

    private int numberOfRemainingAtomsOfTypeFromAtomStatisticsUI(Type type) {
        if(ALPHA.equals(type)) {
            return Integer.valueOf(getTextOfAlphaAtomValueLabel());
        }
        else if(BETA.equals(type)) {
            return Integer.valueOf(getTextOfBetaAtomValueLabel());
        }
        else if(GAMMA.equals(type)) {
            return Integer.valueOf(getTextOfGammaAtomValueLabel());
        }
        else {
            return Integer.valueOf(getTextOfSigmaAtomValueLabel());
        }
    }

}