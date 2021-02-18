package domain.models.objects.molecule;

import domain.enums.MoleculeAnimation;
import domain.enums.MoleculeStructure;
import domain.enums.Type;
import domain.models.game.Game;
import domain.models.objects.Drawable;
import domain.models.objects.molecule.move.MoleculeMoveStrategy;

import static configs.ObjectConstants.speedConstant;

public class Molecule extends Drawable {
    private MoleculeStructure moleculeStructure;
    private MoleculeAnimation moleculeAnimation;
    private MoleculeMoveStrategy moveStrategy;

    public Molecule() {
    }

    public Molecule(String iconName, double xCoordinate, double yCoordinate, Type type) {
        super(iconName, xCoordinate, yCoordinate, type);
        this.setSpeed(speedConstant / 2);
    }

    public MoleculeStructure getMoleculeStructure() {
        return moleculeStructure;
    }

    public void setMoleculeStructure(MoleculeStructure moleculeStructure) {
        this.moleculeStructure = moleculeStructure;
    }

    public MoleculeAnimation getMoleculeAnimation() {
        return moleculeAnimation;
    }

    public void setMoleculeAnimation(MoleculeAnimation moleculeAnimation) {
        this.moleculeAnimation = moleculeAnimation;
    }

    public MoleculeMoveStrategy getMoveStrategy() {
        return moveStrategy;
    }

    public void setMoveStrategy(MoleculeMoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        moveStrategy.move(this);
    }
}
