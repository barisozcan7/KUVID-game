package domain.models.objects.atom;

import domain.enums.Type;

import static utils.Utils.selectRandomInteger;

public class AlphaAtom extends Atom {
    public AlphaAtom(double xCoordinate, double yCoordinate) {
        super("alpha_atom.png", xCoordinate, yCoordinate, Type.ALPHA);
        setStabilityConstant(0.85);
        setNumberOfProtons(8);
        setNumberOfNeutrons(selectRandomInteger(7, 8, 9));
        initializeEfficiency();
    }

    private void initializeEfficiency() {
        setEfficiency((1 - ((Math.abs(getNumberOfNeutrons() - getNumberOfProtons())) / getNumberOfProtons())) * getStabilityConstant());
    }
}

