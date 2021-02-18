package domain.models.objects.molecule;

import domain.enums.MoleculeStructure;
import domain.enums.Type;
import domain.models.game.Game;
import domain.models.objects.molecule.move.MoveZigzagAfterQuarter;

public class BetaMolecule extends Molecule {

    public BetaMolecule(double xCoordinate, double yCoordinate) {
        super(Game.getInstance().getBetaMoleculeStructure().equals(MoleculeStructure.LINEAR) ? "beta_molecule_linear.png" : "beta_molecule.png", xCoordinate, yCoordinate, Type.BETA);
        setMoleculeStructure(Game.getInstance().getBetaMoleculeStructure());
        setMoleculeAnimation(Game.getInstance().getBetaMoleculeAnimation());
        setMoveStrategy(new MoveZigzagAfterQuarter());
    }
}
