package domain.models.objects.molecule;

import domain.enums.MoleculeAnimation;
import domain.enums.MoleculeStructure;
import domain.enums.Type;
import domain.models.objects.molecule.move.MoveStraight;

public class SigmaMolecule extends Molecule {
    public SigmaMolecule(double xCoordinate, double yCoordinate) {
        super("sigma_molecule.png", xCoordinate, yCoordinate, Type.SIGMA);
        setMoleculeStructure(MoleculeStructure.COMPLEX);
        setMoleculeAnimation(MoleculeAnimation.STATIONARY);
        setMoveStrategy(new MoveStraight());
    }
}
