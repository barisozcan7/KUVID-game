package domain.models.objects.shield;

import domain.models.objects.atom.Atom;

public abstract class ShieldDecorator extends Atom {

    protected Atom atom;

    public ShieldDecorator(Atom atom) {
        this.atom = atom;
    }

    public abstract Atom addShield();
}
