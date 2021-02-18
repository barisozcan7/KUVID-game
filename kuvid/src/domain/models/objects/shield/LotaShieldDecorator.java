package domain.models.objects.shield;

import domain.models.objects.atom.Atom;

public class LotaShieldDecorator extends ShieldDecorator {

    public LotaShieldDecorator(Atom atom) {
        super(atom);
    }

    public Atom addShield() {
        double efficiencyBoost = 0.1;
        double addedEfficiency = (1 - atom.getEfficiency()) * efficiencyBoost;
        double newEfficiency = atom.getEfficiency() + addedEfficiency;
        atom.setEfficiency(newEfficiency);
        atom.setSpeed(atom.getSpeed() * 0.93);
        return atom;
    }
}
