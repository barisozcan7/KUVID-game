package domain.models.objects.atom;

import domain.enums.Type;

import static utils.Utils.selectRandomInteger;

public class BetaAtom extends Atom {
    public BetaAtom(double xCoordinate, double yCoordinate) {
        super("beta_atom.png", xCoordinate, yCoordinate, Type.BETA);
        setStabilityConstant(0.9);
        setNumberOfProtons(16);
        setNumberOfNeutrons(selectRandomInteger(15, 16, 17, 18, 21));
        initializeEfficiency();
    }

    private void initializeEfficiency() {
        setEfficiency(getStabilityConstant() - (0.5 * Math.abs(getNumberOfNeutrons() - getNumberOfProtons()) / getNumberOfProtons()));
    }
}
