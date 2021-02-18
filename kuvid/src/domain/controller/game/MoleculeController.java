package domain.controller.game;

import domain.enums.MoleculeAnimation;
import domain.models.game.Game;
import domain.models.objects.molecule.Molecule;

import static configs.UIConstants.Y_COORDINATE_TO_DISAPPEAR;

public class MoleculeController {
    public void move(Molecule molecule) {
        molecule.move();
        animate(molecule);
        hitGround(molecule);
    }

    private void animate(Molecule molecule) {
        if (molecule.getMoleculeAnimation() == MoleculeAnimation.SPINNING) {
            molecule.setRotation(molecule.getRotation() + Math.PI / 180);
        }
    }

    private void hitGround(Molecule molecule) {
        if (molecule.getyCoordinate() > Y_COORDINATE_TO_DISAPPEAR) {
            Game.getInstance().removeFromMoleculeList(molecule);
        }
    }
}
