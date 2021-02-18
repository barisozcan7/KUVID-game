package domain.models.objects.shield;

import domain.models.objects.atom.Atom;

public class EtaShieldDecorator extends ShieldDecorator {

    public EtaShieldDecorator(Atom atom) {
        super(atom);
    }

    @Override
    public Atom addShield() {
        double addedEfficiency;
        if (atom.getNumberOfNeutrons() != atom.getNumberOfProtons()) {
            addedEfficiency = (1 - atom.getEfficiency()) * Math.abs(atom.getNumberOfNeutrons() - atom.getNumberOfProtons()) / atom.getNumberOfProtons();
        } else {
            addedEfficiency = (1 - atom.getEfficiency()) * 0.05;
        }
        double newEfficiency = atom.getEfficiency() + addedEfficiency;
        atom.setEfficiency(newEfficiency);
        atom.setSpeed(atom.getSpeed() * 0.95);
        return atom;
    }
}
