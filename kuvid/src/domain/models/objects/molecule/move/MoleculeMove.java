package domain.models.objects.molecule.move;

import configs.ObjectConstants;
import configs.UIConstants;
import domain.models.objects.molecule.Molecule;

public class MoleculeMove {
    private boolean isMovingToRight = true;
    private int uiTimerCounter = 0;

    public MoleculeMove() {
    }

    public boolean isMovingToRight() {
        return isMovingToRight;
    }

    public void setMovingToRight(boolean movingToRight) {
        isMovingToRight = movingToRight;
    }

    public void moveStraight(Molecule molecule) {
        molecule.setyCoordinate(molecule.getyCoordinate() + molecule.getSpeed());
    }

    public void moveZigzag(Molecule molecule) {
        uiTimerCounter++;
        double moleculeWidth = ObjectConstants.getMoleculeSize(molecule).get(0);

        if (isMovingToRight()) {
            molecule.setxCoordinate(molecule.getxCoordinate() + molecule.getSpeed());
        } else {
            molecule.setxCoordinate(molecule.getxCoordinate() - molecule.getSpeed());
        }
        molecule.setyCoordinate(molecule.getyCoordinate() + molecule.getSpeed());

        if (molecule.getxCoordinate() > UIConstants.GAME_PANEL_WIDTH - moleculeWidth) {
            setMovingToRight(!isMovingToRight());
            uiTimerCounter = 1;
        }

        if (uiTimerCounter % 100 == 0) {
            setMovingToRight(!isMovingToRight());
        }
    }
}
