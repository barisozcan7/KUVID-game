package domain.models.objects.molecule.move;

import domain.models.objects.molecule.Molecule;

public class MoveZigzag extends MoleculeMove implements MoleculeMoveStrategy {
    @Override
    public void move(Molecule molecule) {
        moveZigzag(molecule);
    }
}
