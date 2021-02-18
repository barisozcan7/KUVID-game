package domain.models.objects;

import domain.enums.Type;

public class Drawable {
    private String iconName;
    private double xCoordinate;
    private double yCoordinate;
    private double rotationDegree;
    private double speed;
    private Type type;

    public Drawable() {
    }

    public Drawable(String iconName, double xCoordinate, double yCoordinate, Type type) {
        this.iconName = iconName;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.type = type;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public double getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public double getRotation() {
        return rotationDegree;
    }

    public void setRotation(double rotation) {
        this.rotationDegree = rotation;
    }

    public Type getType() {
        return this.type;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

}
