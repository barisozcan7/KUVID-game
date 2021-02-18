package domain.models.objects.atom;

import domain.enums.Type;

import static utils.Utils.selectRandomInteger;

public class SigmaAtom extends Atom {
    public SigmaAtom(double xCoordinate, double yCoordinate) {
        super("sigma_atom.png", xCoordinate, yCoordinate, Type.SIGMA);
        setStabilityConstant(0.7);
        setNumberOfProtons(64);
        setNumberOfNeutrons(selectRandomInteger(63, 64, 67));
        initializeEfficiency();
    }

    private void initializeEfficiency() {
        setEfficiency(((1 + getStabilityConstant()) / 2) + ((Math.abs(getNumberOfNeutrons() - getNumberOfProtons())) / getNumberOfProtons()));
    }
}
