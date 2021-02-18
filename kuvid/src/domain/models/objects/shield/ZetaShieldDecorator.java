package domain.models.objects.shield;

import domain.models.objects.atom.Atom;

public class ZetaShieldDecorator extends ShieldDecorator {

    public ZetaShieldDecorator(Atom atom) {
        super(atom);
    }

    public Atom addShield() {
        atom.setSpeed(atom.getSpeed() * 0.89);
        if (atom.getNumberOfNeutrons() == atom.getNumberOfProtons()) {
            double efficiencyBoost = 0.2;
            double addedEfficiency = (1 - atom.getEfficiency()) * efficiencyBoost;
            double newEfficiency = atom.getEfficiency() + addedEfficiency;
            atom.setEfficiency(newEfficiency);
        }
        return atom;
    }
}
