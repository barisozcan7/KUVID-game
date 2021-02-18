package domain.models.objects.molecule.move;

import domain.models.objects.molecule.Molecule;

public class MoveStraight extends MoleculeMove implements MoleculeMoveStrategy {
    @Override
    public void move(Molecule molecule) {
        moveStraight(molecule);
    }
}
