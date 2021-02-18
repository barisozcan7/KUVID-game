package domain.models.objects.atom;

import domain.enums.Type;

import static utils.Utils.selectRandomInteger;

public class GammaAtom extends Atom {
    public GammaAtom(double xCoordinate, double yCoordinate) {
        super("gamma_atom.png", xCoordinate, yCoordinate, Type.GAMMA);
        setStabilityConstant(0.8);
        setNumberOfProtons(32);
        setNumberOfNeutrons(selectRandomInteger(29, 32, 33));
        initializeEfficiency();
    }

    private void initializeEfficiency() {
        setEfficiency(getStabilityConstant() + ((Math.abs(getNumberOfNeutrons() - getNumberOfProtons())) / (2 * getNumberOfProtons())));
    }
}
