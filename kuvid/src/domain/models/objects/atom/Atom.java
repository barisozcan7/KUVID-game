package domain.models.objects.atom;

import domain.enums.Type;
import domain.models.game.Game;
import domain.models.objects.Drawable;

import static configs.ObjectConstants.speedConstant;

public class Atom extends Drawable {
    private double stabilityConstant;
    private int numberOfProtons;
    private int numberOfNeutrons;
    private double efficiency;

    public Atom() {
        super();
    }

    public Atom(String iconName, double xCoordinate, double yCoordinate, Type type) {
        super(iconName, xCoordinate, yCoordinate, type);
        this.setSpeed(speedConstant);
    }

    public double getStabilityConstant() {
        return stabilityConstant;
    }

    public void setStabilityConstant(double stabilityConstant) {
        this.stabilityConstant = stabilityConstant;
    }

    public int getNumberOfProtons() {
        return numberOfProtons;
    }

    public void setNumberOfProtons(int numberOfProtons) {
        this.numberOfProtons = numberOfProtons;
    }

    public int getNumberOfNeutrons() {
        return numberOfNeutrons;
    }

    public void setNumberOfNeutrons(int numberOfNeutrons) {
        this.numberOfNeutrons = numberOfNeutrons;
    }

    public double getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(double efficiency) {
        this.efficiency = efficiency;
    }
}
