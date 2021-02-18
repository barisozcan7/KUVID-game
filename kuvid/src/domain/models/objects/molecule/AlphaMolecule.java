package domain.models.objects.molecule;

import domain.enums.MoleculeStructure;
import domain.enums.Type;
import domain.models.game.Game;
import domain.models.objects.molecule.move.MoveZigzag;

public class AlphaMolecule extends Molecule {
    public AlphaMolecule(double xCoordinate, double yCoordinate) {
        super(Game.getInstance().getAlphaMoleculeStructure().equals(MoleculeStructure.LINEAR) ? "alpha_molecule_linear.png" : "alpha_molecule.png", xCoordinate, yCoordinate, Type.ALPHA);
        setMoleculeStructure(Game.getInstance().getAlphaMoleculeStructure());
        setMoleculeAnimation(Game.getInstance().getAlphaMoleculeAnimation());
        setMoveStrategy(new MoveZigzag());
    }
}
