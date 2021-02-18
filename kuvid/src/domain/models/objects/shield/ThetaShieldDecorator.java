package domain.models.objects.shield;

import domain.models.objects.atom.Atom;

import static utils.Utils.generateRandomInteger;

public class ThetaShieldDecorator extends ShieldDecorator {

    public ThetaShieldDecorator(Atom atom) {
        super(atom);
    }

    public Atom addShield() {
        double efficiencyBoost = (double) generateRandomInteger(5, 15) / 100;
        double addedEfficiency = (1 - atom.getEfficiency()) * efficiencyBoost;
        double newEfficiency = atom.getEfficiency() + addedEfficiency;
        atom.setEfficiency(newEfficiency);
        atom.setSpeed(atom.getSpeed() * 0.91);
        return atom;
    }
}
