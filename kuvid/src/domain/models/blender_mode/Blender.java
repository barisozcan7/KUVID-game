package domain.models.blender_mode;

import domain.enums.Type;

public class Blender {
    public static Blender blender;
    private Type sourceAtom;
    private Type producedAtom;

    public static Blender getInstance() {
        if (blender == null) {
            blender = new Blender();
        }
        return blender;
    }

    public Type getSourceAtom() {
        return sourceAtom;
    }

    public void setSourceAtom(Type sourceAtom) {
        this.sourceAtom = sourceAtom;
    }

    public Type getProducedAtom() {
        return producedAtom;
    }

    public void setProducedAtom(Type producedAtom) {
        this.producedAtom = producedAtom;
    }
}
