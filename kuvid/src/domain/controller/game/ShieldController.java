package domain.controller.game;

import UI.components.game_view.statistics_view.PowerupAndShieldStatisticsPanel;
import domain.enums.ShieldType;
import domain.models.game.Game;
import domain.models.objects.AtomShooter;
import domain.models.objects.atom.Atom;
import domain.models.objects.shield.EtaShieldDecorator;
import domain.models.objects.shield.LotaShieldDecorator;
import domain.models.objects.shield.ThetaShieldDecorator;
import domain.models.objects.shield.ZetaShieldDecorator;
import domain.models.player.Player;

public final class ShieldController {

    private ShieldController() {
    }

    public static void addShield(ShieldType shieldType) {
        addShieldByType(shieldType);
        PowerupAndShieldStatisticsPanel.updateShieldLabels();
    }

    public static void addShieldByType(ShieldType shieldType) {
        //REQUIRES: Game should be running.
        //MODIFIES: None
        //EFFECTS:  Given the shield type , shooters current atom:
        //
        // |Shield|                            Effects                                  |
        // |---------------------------------------------------------------------------|
        //
        //  Eta      IF: player has 0 shield: None
        //           Else:
        //           decreases the current atom's speed by 5 percent
        //           increases the efficiency with the formula:
        //
        //           if # shielded atom neutrones != # shielded atom protones:
        //           (1 - shielded atom efficiency) * |# shielded atom neutrones - # shielded atom protones| / # shielded atom protones.
        //
        //           Otherwise:
        //           (1 - shielded atom efficiency) * Eta_efficiency_boost
        //           Eta_efficiency_boost = 0.05
        //
        //
        //  Lota     IF: player has 0 shield: None
        //           Else:
        //           decreases the current atom's speed by 7 percent
        //           increases the efficiency with the formula:
        //
        //           (1 - shielded atom efficiency) * Lota_efficiency_boost
        //           Lota_efficiency_boost = 0.1
        //
        //  Theta    IF: player has 0 shield: None
        //           Else:
        //           decreases the current atom's speed by 9 percent.
        //           increases the efficiency with the following formula:
        //
        //           (1 - shielded atom efficiency) * Theta_efficiency_boost
        //           Theta_efficiency_boost = is random between 0.05 and 0.15)
        //
        //  Zeta     IF: player has 0 shield: None
        //           Else:
        //           decreases the current atom's speed by 11 percent.
        //           increases the efficiency with the following formula:
        //
        //           (1 - shielded atom efficiency) * Zeta_efficiency_boost
        //           (Zeta_efficiency_boost = 0.2)
        //           Zeta improves the efficiency iff
        //           # shielded atom protons = # shielded atom neutrons
        //
        //
        //

        //RETURNS: none
        AtomShooter shooter = AtomShooter.getInstance();
        Atom currentAtom = shooter.getCurrentSelectedAtom();

        if (currentAtom != null) {
            Player player = Game.getInstance().getPlayer();

            switch (shieldType) {
                case ETA -> {
                    int numberOfEtaShields = player.getNumberOfEtaShields();
                    if (numberOfEtaShields > 0) {
                        shooter.setCurrentSelectedAtom(new EtaShieldDecorator(currentAtom).addShield());
                        player.setNumberOfEtaShields(numberOfEtaShields - 1);
                    }
                }
                case THETA -> {
                    int numberOfThetaShields = player.getNumberOfThetaShields();
                    if (numberOfThetaShields > 0) {
                        shooter.setCurrentSelectedAtom(new ThetaShieldDecorator(currentAtom).addShield());
                        player.setNumberOfThetaShields(numberOfThetaShields - 1);
                    }
                }
                case ZETA -> {
                    int numberOfZetaShields = player.getNumberOfZetaShields();
                    if (numberOfZetaShields > 0) {
                        shooter.setCurrentSelectedAtom(new ZetaShieldDecorator(currentAtom).addShield());
                        player.setNumberOfZetaShields(numberOfZetaShields - 1);
                    }
                }
                case LOTA -> {
                    int numberOfLotaShields = player.getNumberOfLotaShields();
                    if (numberOfLotaShields > 0) {
                        shooter.setCurrentSelectedAtom(new LotaShieldDecorator(currentAtom).addShield());
                        player.setNumberOfLotaShields(numberOfLotaShields - 1);
                    }
                }
            }
        }
    }
}
