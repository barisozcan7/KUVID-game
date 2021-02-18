package configs;

import domain.enums.MoleculeStructure;
import domain.enums.Type;
import domain.models.game.Game;
import domain.models.objects.molecule.Molecule;

import java.util.ArrayList;
import java.util.Arrays;

public class ObjectConstants {

    public static final double shooterWidth = Game.getInstance().getLengthConstant() * 3 / 8;
    public static final double shooterHeight = Game.getInstance().getLengthConstant() * 3 / 2;
    public static final double atomEdge = Game.getInstance().getLengthConstant() * 5 / 8;
    public static final double powerupEdge = Game.getInstance().getLengthConstant() * 5 / 8;
    public static final double blockerWidth = Game.getInstance().getLengthConstant() * 2 / 3;
    public static final double blockerHeight = Game.getInstance().getLengthConstant();
    public static final double defaultMoleculeWidth = Game.getInstance().getLengthConstant() * 3 / 2;
    public static final double defaultMoleculeHeight = Game.getInstance().getLengthConstant() * 3 / 2;
    public static final double betaLinearMoleculeWidth = Game.getInstance().getLengthConstant() * 9 / 4;
    public static final double betaLinearMoleculeHeight = Game.getInstance().getLengthConstant() / 2;
    public static final double alphaLinearMoleculeWidth = Game.getInstance().getLengthConstant() * 7 / 4;
    public static final double alphaLinearMoleculeHeight = Game.getInstance().getLengthConstant() / 2;
    public static final double alphaComplexMoleculeWidth = Game.getInstance().getLengthConstant() * 5 / 4;
    public static final double alphaComplexMoleculeHeight = Game.getInstance().getLengthConstant() * 5 / 4;
    public static final double sigmaMoleculeWidth = Game.getInstance().getLengthConstant() * 7 / 4;
    public static final double sigmaMoleculeHeight = Game.getInstance().getLengthConstant() * 3 / 2;
    public static final double blockerRange = Game.getInstance().getLengthConstant() / 2;
    public static final double blockerExplodeRange = Game.getInstance().getLengthConstant() * 2;

    public static final int transformSpeed = Game.getInstance().getLengthValuePercentage();
    public static final int rotateSpeed = Game.getInstance().getLengthValuePercentage();
    public static final int maxRotation = 80;
    public static final int leftMax = 10;
    public static final double rightMax = UIConstants.GAME_PANEL_WIDTH - atomEdge - 10;
    public static final double rotationLength = Game.getInstance().getLengthConstant() * 1.66;
    public static final double speedConstant = Game.getInstance().getLengthConstant() / 25;


    public static ArrayList<Double> getMoleculeSize(Molecule molecule) {

        double moleculeWidth = 0;
        double moleculeHeight = 0;

        if (MoleculeStructure.LINEAR.equals(molecule.getMoleculeStructure()) &&
                Type.BETA.equals(molecule.getType())) {
            moleculeWidth = betaLinearMoleculeWidth;
            moleculeHeight = betaLinearMoleculeHeight;
        } else if (Type.ALPHA.equals(molecule.getType())) {
            if (MoleculeStructure.LINEAR.equals(molecule.getMoleculeStructure())) {
                moleculeWidth = alphaLinearMoleculeWidth;
                moleculeHeight = alphaLinearMoleculeHeight;
            } else {
                moleculeWidth = alphaComplexMoleculeWidth;
                moleculeHeight = alphaComplexMoleculeHeight;
            }
        } else if (Type.SIGMA.equals(molecule.getType())) {
            moleculeWidth = sigmaMoleculeWidth;
            moleculeHeight = sigmaMoleculeHeight;
        } else {
            moleculeWidth = defaultMoleculeWidth;
            moleculeHeight = defaultMoleculeHeight;
        }

        return new ArrayList<>(Arrays.asList(moleculeWidth, moleculeHeight));
    }

}
