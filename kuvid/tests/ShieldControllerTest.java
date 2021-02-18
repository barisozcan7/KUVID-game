import domain.controller.game.AtomShooterController;
import domain.controller.game.ShieldController;
import domain.enums.ShieldType;
import domain.models.building_mode.BuildingMode;
import domain.models.game.Game;
import domain.models.objects.AtomShooter;
import domain.models.objects.atom.Atom;
import domain.models.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShieldControllerTest {
    private Game game;
    private Player player;
    private AtomShooter shooter;
    private ShieldController shieldController;
    private AtomShooterController atomShooterController;

    @BeforeEach
    void setUp() {
        game = Game.getInstance();
        game.setGame(BuildingMode.getDefaultBuildingMode());
        player = game.getPlayer();
        shooter = AtomShooter.getInstance();
        atomShooterController = AtomShooterController.getInstance();
        atomShooterController.pickAtom();
    }

    @Test
    void validate_add_lota_shield(){
        Atom currentAtom = shooter.getCurrentSelectedAtom();

        double previousSpeed = currentAtom.getSpeed();
        double previousEfficiency = currentAtom.getEfficiency();

        ShieldController.addShieldByType(ShieldType.LOTA);

        double currentSpeed = currentAtom.getSpeed();
        double currentEfficiency = currentAtom.getEfficiency();
        assertEquals(previousSpeed*0.93, currentSpeed);
        assertEquals(previousEfficiency + ((1 - previousEfficiency) * 0.1), currentEfficiency);
    }

    @Test
    void validate_add_eta_shield(){
        Atom currentAtom = shooter.getCurrentSelectedAtom();

        double previousSpeed = currentAtom.getSpeed();
        double previousEfficiency = currentAtom.getEfficiency();
        double addedEfficiency;
        if (currentAtom.getNumberOfNeutrons() != currentAtom.getNumberOfProtons()) {
            addedEfficiency = (1 - currentAtom.getEfficiency()) *
                    Math.abs(currentAtom.getNumberOfNeutrons() - currentAtom.getNumberOfProtons()) / currentAtom.getNumberOfProtons();
        } else {
            addedEfficiency = (1 - currentAtom.getEfficiency()) * 0.05;
        }
        ShieldController.addShieldByType(ShieldType.ETA);

        double currentSpeed = currentAtom.getSpeed();
        double currentEfficiency = previousEfficiency + addedEfficiency;

        assertEquals(previousSpeed*0.95, currentSpeed);
        assertEquals(previousEfficiency + addedEfficiency, currentEfficiency);
    }

    @Test
    void validate_add_theta_shield_min_efficieny_boost(){
        Atom currentAtom = shooter.getCurrentSelectedAtom();

        double previousSpeed = currentAtom.getSpeed();
        double previousEfficiency = currentAtom.getEfficiency();
        double efficiencyBoost = 0.05;

        ShieldController.addShieldByType(ShieldType.THETA);


        double currentSpeed = currentAtom.getSpeed();
        double currentEfficiency = currentAtom.getEfficiency();

        assertEquals(previousSpeed*0.91, currentSpeed);
        assertTrue(previousEfficiency + ((1 - previousEfficiency) * efficiencyBoost) <= currentEfficiency);
    }

    @Test
    void validate_add_theta_shield_max_efficieny_boost(){
        Atom currentAtom = shooter.getCurrentSelectedAtom();

        double previousSpeed = currentAtom.getSpeed();
        double previousEfficiency = currentAtom.getEfficiency();
        double efficiencyBoost = 0.15;

        ShieldController.addShieldByType(ShieldType.THETA);


        double currentSpeed = currentAtom.getSpeed();
        double currentEfficiency = currentAtom.getEfficiency();

        assertEquals(previousSpeed*0.91, currentSpeed);
        assertTrue(previousEfficiency + ((1 - previousEfficiency) * efficiencyBoost) >= currentEfficiency);
    }

    @Test
    void validate_add_zeta_shield(){
        Atom currentAtom = shooter.getCurrentSelectedAtom();

        double previousSpeed = currentAtom.getSpeed();
        double previousEfficiency = currentAtom.getEfficiency();

        ShieldController.addShieldByType(ShieldType.ZETA);

        if (currentAtom.getNumberOfNeutrons() == currentAtom.getNumberOfProtons()) {

            double efficiencyBoost = 0.2;
            double addedEfficiency = (1 - currentAtom.getEfficiency()) * efficiencyBoost;
            double currentEfficiency = previousEfficiency + addedEfficiency;

            assertEquals(previousEfficiency + addedEfficiency, currentEfficiency);
        }
        else{
            assertEquals(previousEfficiency, currentAtom.getEfficiency());
        }

        double currentSpeed = currentAtom.getSpeed();
        assertEquals(previousSpeed*0.89, currentSpeed);
    }



}
