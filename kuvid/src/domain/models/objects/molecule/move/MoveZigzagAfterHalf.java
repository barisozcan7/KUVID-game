package domain.models.objects.molecule.move;

import domain.models.objects.molecule.Molecule;

import static configs.UIConstants.Y_COORDINATE_TO_DISAPPEAR;

public class MoveZigzagAfterHalf extends MoleculeMove implements MoleculeMoveStrategy {
    @Override
    public void move(Molecule molecule) {
        if (molecule.getyCoordinate() < Y_COORDINATE_TO_DISAPPEAR / 2) {
            moveStraight(molecule);
        } else {
            moveZigzag(molecule);
        }
    }
}
