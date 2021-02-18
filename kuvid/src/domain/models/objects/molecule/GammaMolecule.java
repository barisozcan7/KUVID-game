package domain.models.objects.molecule;

import domain.enums.MoleculeAnimation;
import domain.enums.MoleculeStructure;
import domain.enums.Type;
import domain.models.objects.molecule.move.MoveZigzagAfterHalf;

public class GammaMolecule extends Molecule {

    public GammaMolecule(double xCoordinate, double yCoordinate) {
        super("gamma_molecule.png", xCoordinate, yCoordinate, Type.GAMMA);
        setMoleculeStructure(MoleculeStructure.COMPLEX);
        setMoleculeAnimation(MoleculeAnimation.STATIONARY);
        setMoveStrategy(new MoveZigzagAfterHalf());
    }
}
