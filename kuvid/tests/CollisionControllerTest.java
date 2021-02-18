import domain.controller.game.AtomShooterController;
import domain.controller.game.CollisionController;
import domain.models.building_mode.BuildingMode;
import domain.models.game.Game;
import domain.models.objects.AtomShooter;
import domain.models.objects.atom.AlphaAtom;
import domain.models.objects.atom.BetaAtom;
import domain.models.objects.atom.GammaAtom;
import domain.models.objects.atom.SigmaAtom;
import domain.models.objects.molecule.AlphaMolecule;
import domain.models.objects.molecule.BetaMolecule;
import domain.models.objects.molecule.GammaMolecule;
import domain.models.objects.molecule.SigmaMolecule;
import domain.models.objects.powerup.AlphaPowerup;
import domain.models.objects.powerup.BetaPowerup;
import domain.models.objects.powerup.GammaPowerup;
import domain.models.objects.powerup.SigmaPowerup;
import domain.models.objects.reaction_blockers.AlphaBlocker;
import domain.models.objects.reaction_blockers.BetaBlocker;
import domain.models.objects.reaction_blockers.GammaBlocker;
import domain.models.objects.reaction_blockers.SigmaBlocker;
import domain.models.player.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ConcurrentModificationException;

import static configs.ObjectConstants.blockerHeight;
import static configs.ObjectConstants.powerupEdge;
import static configs.UIConstants.GAME_PANEL_WIDTH;
import static configs.UIConstants.GAME_WINDOW_HEIGHT;
import static org.junit.jupiter.api.Assertions.*;

public class CollisionControllerTest {
    private Game game;
    private Player player;
    private AtomShooter shooter;
    private AtomShooterController shooterController;
    private CollisionController collisionController;

    @BeforeEach
    void setUp() {
        Game.resetGame();
        game = Game.getInstance();
        game.setGame(BuildingMode.getDefaultBuildingMode());
        player = game.getPlayer();
        shooter = AtomShooter.getInstance();
        shooterController = AtomShooterController.getInstance();
        shooterController.pickAtom();
        collisionController = new CollisionController();
    }


    @AfterEach
    void cleanUp(){
        Game.resetGame();
        game.setGame(BuildingMode.getDefaultBuildingMode());
    }

    @Test
    void validate_alpha_blocker_powerup() {
        for (double grid_x = 0; grid_x < GAME_PANEL_WIDTH; grid_x++) {
            for (double grid_y = 0; grid_y < GAME_WINDOW_HEIGHT; grid_y++) {
                AlphaBlocker alphaBlocker = new AlphaBlocker(grid_x, grid_y);
                AlphaPowerup alphaPowerup = new AlphaPowerup(grid_x, 0);
                for (double location = 1; location < GAME_WINDOW_HEIGHT; location++) {
                    alphaPowerup.setyCoordinate(location);
                    if (powerupEdge + location - 1 == grid_y) {
                        assertTrue(collisionController.isPowerupAndBlockerCollided(alphaPowerup, alphaBlocker));
                        break;
                    }
                }
            }
        }
    }

    @Test
    void validate_beta_blocker_powerup() {
        for (double grid_x = 0; grid_x < GAME_PANEL_WIDTH; grid_x+=20) {
            for (double grid_y = 1; grid_y < GAME_WINDOW_HEIGHT; grid_y+=20) {
                BetaBlocker betaBlocker = new BetaBlocker(grid_x, grid_y);
                BetaPowerup betaPowerup = new BetaPowerup(grid_x, 0);
                for (double location = 0; location < GAME_WINDOW_HEIGHT; location++) {
                    betaPowerup.setyCoordinate(location);
                    if (powerupEdge + location -1 == grid_y) {
                        assertTrue(collisionController.isPowerupAndBlockerCollided(betaPowerup, betaBlocker));
                        break;
                    }
                }
            }
        }
    }

    @Test
    void validate_gamma_blocker_powerup() {
        for (double grid_x = 0; grid_x < GAME_PANEL_WIDTH; grid_x++) {
            for (double grid_y = 0; grid_y < GAME_WINDOW_HEIGHT; grid_y++) {
                GammaBlocker gammaBlocker = new GammaBlocker(grid_x, grid_y);
                GammaPowerup gammaPowerup = new GammaPowerup(grid_x, 0);
                for (double location = 1; location < GAME_WINDOW_HEIGHT; location++) {
                    gammaPowerup.setyCoordinate(location);
                    if (powerupEdge + location - 1 == grid_y) {
                        assertTrue(collisionController.isPowerupAndBlockerCollided(gammaPowerup, gammaBlocker));
                        break;
                    }
                }
            }
        }
    }

    @Test
    void validate_sigma_blocker_powerup() {
        for (double grid_x = 0; grid_x < GAME_PANEL_WIDTH; grid_x++) {
            for (double grid_y = 0; grid_y < GAME_WINDOW_HEIGHT; grid_y++) {
                SigmaBlocker sigmaBlocker = new SigmaBlocker(grid_x, grid_y);
                SigmaPowerup sigmaPowerup = new SigmaPowerup(grid_x, 0);
                for (double location = 1; location < GAME_WINDOW_HEIGHT; location++) {
                    sigmaPowerup.setyCoordinate(location);
                    if (powerupEdge + location - 1 == grid_y) {
                        assertTrue(collisionController.isPowerupAndBlockerCollided(sigmaPowerup, sigmaBlocker));
                        break;
                    }
                }
            }
        }
    }

    @Test
    void validate_alpha_molecule_alpha() {
        AlphaAtom alphaAtom = new AlphaAtom(GAME_PANEL_WIDTH / 2, GAME_WINDOW_HEIGHT / 2);
        Game.getInstance().insertIntoAtomList(alphaAtom);
        AlphaMolecule alphaMolecule = new AlphaMolecule(GAME_PANEL_WIDTH / 2, GAME_WINDOW_HEIGHT / 2);
        Game.getInstance().insertIntoMoleculeList(alphaMolecule);
        try {
            collisionController.atomAndMoleculeCollision();
        }catch (ConcurrentModificationException e){

        }
        assertEquals(Game.getInstance().getAtomList().size(), 0);
        assertEquals(Game.getInstance().getMoleculeList().size(), 0);

    }

    @Test
    void validate_beta_molecule_beta() {
        BetaAtom betaAtom = new BetaAtom(GAME_PANEL_WIDTH / 2, GAME_WINDOW_HEIGHT / 2);
        Game.getInstance().insertIntoAtomList(betaAtom);
        BetaMolecule betaMolecule = new BetaMolecule(GAME_PANEL_WIDTH / 2, GAME_WINDOW_HEIGHT / 2);
        Game.getInstance().insertIntoMoleculeList(betaMolecule);
        try {
            collisionController.atomAndMoleculeCollision();
        }catch (ConcurrentModificationException e){

        }
        assertEquals(Game.getInstance().getAtomList().size(), 0);
        assertEquals(Game.getInstance().getMoleculeList().size(), 0);

    }

    @Test
    void validate_gamma_molecule_gamma() {
        GammaAtom gammaAtom = new GammaAtom(GAME_PANEL_WIDTH / 2, GAME_WINDOW_HEIGHT / 2);
        Game.getInstance().insertIntoAtomList(gammaAtom);
        GammaMolecule gammaMolecule = new GammaMolecule(GAME_PANEL_WIDTH / 2, GAME_WINDOW_HEIGHT / 2);
        Game.getInstance().insertIntoMoleculeList(gammaMolecule);
        try {
            collisionController.atomAndMoleculeCollision();
        }catch (ConcurrentModificationException e){

        }
        assertEquals(Game.getInstance().getAtomList().size(), 0);
        assertEquals(Game.getInstance().getMoleculeList().size(), 0);

    }

    @Test
    void validate_sigma_molecule_sigma() {
        SigmaAtom sigmaAtom = new SigmaAtom(GAME_PANEL_WIDTH / 2, GAME_WINDOW_HEIGHT / 2);
        Game.getInstance().insertIntoAtomList(sigmaAtom);
        SigmaMolecule sigmaMolecule = new SigmaMolecule(GAME_PANEL_WIDTH / 2, GAME_WINDOW_HEIGHT / 2);
        Game.getInstance().insertIntoMoleculeList(sigmaMolecule);
        try {
            collisionController.atomAndMoleculeCollision();
        }catch (ConcurrentModificationException e){

        }
        assertEquals(Game.getInstance().getAtomList().size(), 0);
        assertEquals(Game.getInstance().getMoleculeList().size(), 0);

    }

    @Test
    void validate_alpha_molecule_beta() {
        AlphaAtom alphaAtom = new AlphaAtom(GAME_PANEL_WIDTH / 2, GAME_WINDOW_HEIGHT / 2);
        Game.getInstance().insertIntoAtomList(alphaAtom);
        BetaMolecule betaMolecule = new BetaMolecule(GAME_PANEL_WIDTH / 2, GAME_WINDOW_HEIGHT / 2);
        Game.getInstance().insertIntoMoleculeList(betaMolecule);
        try {
            collisionController.atomAndMoleculeCollision();
        }catch (ConcurrentModificationException e){

        }
        assertEquals(Game.getInstance().getAtomList().size(), 1);
        assertEquals(Game.getInstance().getMoleculeList().size(), 1);

    }

    @Test
    void validate_alpha_molecule_gamma() {
        AlphaAtom alphaAtom = new AlphaAtom(GAME_PANEL_WIDTH / 2, GAME_WINDOW_HEIGHT / 2);
        Game.getInstance().insertIntoAtomList(alphaAtom);
        GammaMolecule gammaMolecule = new GammaMolecule(GAME_PANEL_WIDTH / 2, GAME_WINDOW_HEIGHT / 2);
        Game.getInstance().insertIntoMoleculeList(gammaMolecule);
        try {
            collisionController.atomAndMoleculeCollision();
        }catch (ConcurrentModificationException e){

        }
        assertEquals(Game.getInstance().getAtomList().size(), 1);
        assertEquals(Game.getInstance().getMoleculeList().size(), 1);

    }

    @Test
    void validate_alpha_molecule_sigma() {
        AlphaAtom alphaAtom = new AlphaAtom(GAME_PANEL_WIDTH / 2, GAME_WINDOW_HEIGHT / 2);
        Game.getInstance().insertIntoAtomList(alphaAtom);
        SigmaMolecule sigmaMolecule = new SigmaMolecule(GAME_PANEL_WIDTH / 2, GAME_WINDOW_HEIGHT / 2);
        Game.getInstance().insertIntoMoleculeList(sigmaMolecule);
        try {
            collisionController.atomAndMoleculeCollision();
        }catch (ConcurrentModificationException e){

        }
        assertEquals(Game.getInstance().getAtomList().size(), 1);
        assertEquals(Game.getInstance().getMoleculeList().size(), 1);

    }


    @Test
    void validate_two_powerups_at_same_location() {
        for (double grid_x = powerupEdge + 1; grid_x < GAME_PANEL_WIDTH; grid_x++) {
            for (double grid_y = powerupEdge + 1; grid_y < GAME_WINDOW_HEIGHT; grid_y++) {
                Game.getInstance().getPlayer().setNumberOfSigmaPowerups(2);
                SigmaBlocker sigmaBlocker = new SigmaBlocker(grid_x, grid_y);

                SigmaPowerup sigmaPowerup1 = new SigmaPowerup(grid_x, 0);
                Game.getInstance().insertIntoShootedPowerupList(sigmaPowerup1);

                SigmaPowerup sigmaPowerup2 = new SigmaPowerup(grid_x, 0);
                Game.getInstance().insertIntoShootedPowerupList(sigmaPowerup2);

                for (double location = 1; location < GAME_WINDOW_HEIGHT; location++) {
                    sigmaPowerup1.setyCoordinate(location);
                    sigmaPowerup2.setyCoordinate(location);
                    if (powerupEdge + location - 1 > grid_y) {
                        assertTrue(CollisionController.isPowerupAndBlockerCollided(sigmaPowerup1, sigmaBlocker));
                        Game.getInstance().removeFromShootedPowerupList(sigmaPowerup1);


                        assertEquals(Game.getInstance().getShootedPowerupList().size(), 1);
                        assertNotNull(sigmaPowerup2);
                        Game.getInstance().removeFromShootedPowerupList(sigmaPowerup2);
                        break;
                    }
                }
            }
        }
    }

    @Test
    void validate_explosion_collision_player_health() {

        int startHealth = player.getHealth();
        int oldHealth = startHealth;

        for (int x_loc = 0; x_loc < GAME_PANEL_WIDTH; x_loc++) {
            player.setHealth(startHealth);
            shooter.setxCoordinate(x_loc);
            shooterController.moveLeft();
            SigmaBlocker sigmaBlocker = new SigmaBlocker(GAME_PANEL_WIDTH, shooter.getyCoordinate());
            CollisionController.explodeBlocker(sigmaBlocker);

            assertTrue(player.getHealth() <= oldHealth);
            oldHealth = player.getHealth();
        }


    }

    @Test
    void validate_explosion_atom_destruction() {
        AlphaAtom alphaAtom = new AlphaAtom(GAME_PANEL_WIDTH / 2, GAME_WINDOW_HEIGHT / 2);
        Game.getInstance().insertIntoAtomList(alphaAtom);
        SigmaBlocker sigmaBlocker = new SigmaBlocker(GAME_PANEL_WIDTH / 2, GAME_WINDOW_HEIGHT / 2);
        try {
            CollisionController.explodeBlocker(sigmaBlocker);
        } catch (ConcurrentModificationException e) {

        }
        assertEquals(Game.getInstance().getAtomList().size(), 0);
    }

    @Test
    void validate_explosion_empty_atom_list() throws ConcurrentModificationException {
        assertEquals(Game.getInstance().getAtomList().size(), 0);
        SigmaBlocker sigmaBlocker = new SigmaBlocker(GAME_PANEL_WIDTH / 2, GAME_WINDOW_HEIGHT / 2);
        CollisionController.explodeBlocker(sigmaBlocker);
        assertEquals(Game.getInstance().getAtomList().size(), 0);
    }

    @Test
    void validate_didBlockerHitGround(){
        SigmaBlocker sigmaBlocker = new SigmaBlocker(GAME_PANEL_WIDTH / 2, GAME_WINDOW_HEIGHT / 2);

        for(int y_loc = 0; y_loc < GAME_WINDOW_HEIGHT - blockerHeight; y_loc++)
            if (CollisionController.didBlockerHitGround(sigmaBlocker))
                assertEquals(GAME_WINDOW_HEIGHT - blockerHeight - 25, y_loc);

    }

}