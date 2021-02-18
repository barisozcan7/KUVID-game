package domain.models.building_mode;

import domain.enums.DifficultyLevel;
import domain.enums.MoleculeAnimation;
import domain.enums.MoleculeStructure;

public class BuildingMode {

    private static BuildingMode buildingMode;
    private DifficultyLevel difficultyLevel = DifficultyLevel.EASY;
    private int lengthValuePercentage = 10;
    private int numberOfAlphaAtoms = 100;
    private int numberOfBetaAtoms = 100;
    private int numberOfSigmaAtoms = 100;
    private int numberOfGammaAtoms = 100;
    private int numberOfAlphaPowerups = 20;
    private int numberOfBetaPowerups = 20;
    private int numberOfSigmaPowerups = 20;
    private int numberOfGammaPowerups = 20;
    private int numberOfAlphaBlockers = 10;
    private int numberOfBetaBlockers = 10;
    private int numberOfSigmaBlockers = 10;
    private int numberOfGammaBlockers = 10;
    private int numberOfAlphaMolecules = 100;
    private int numberOfBetaMolecules = 100;
    private int numberOfSigmaMolecules = 100;
    private int numberOfGammaMolecules = 100;
    private int numberOfLotaShields = 20;
    private int numberOfThetaShields = 20;
    private int numberOfEtaShields = 20;
    private int numberOfZetaShields = 20;
    private MoleculeStructure alphaMoleculeStructure = MoleculeStructure.LINEAR;
    private MoleculeStructure betaMoleculeStructure = MoleculeStructure.LINEAR;
    private MoleculeAnimation alphaMoleculeAnimation = MoleculeAnimation.STATIONARY;
    private MoleculeAnimation betaMoleculeAnimation = MoleculeAnimation.STATIONARY;

    private BuildingMode() {
    }

    public static BuildingMode getInstance() {
        if (buildingMode == null) {
            buildingMode = new BuildingMode();
        }
        return buildingMode;
    }

    public static void resetBuildingMode() {
        buildingMode = null;
    }

    public static BuildingMode getDefaultBuildingMode() {
        return new BuildingMode();
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public int getLengthValuePercentage() {
        return lengthValuePercentage;
    }

    public void setLengthValuePercentage(int lengthValuePercentage) {
        this.lengthValuePercentage = lengthValuePercentage;
    }

    public int getNumberOfAlphaAtoms() {
        return numberOfAlphaAtoms;
    }

    public void setNumberOfAlphaAtoms(int numberOfAlphaAtoms) {
        this.numberOfAlphaAtoms = numberOfAlphaAtoms;
    }

    public int getNumberOfBetaAtoms() {
        return numberOfBetaAtoms;
    }

    public void setNumberOfBetaAtoms(int numberOfBetaAtoms) {
        this.numberOfBetaAtoms = numberOfBetaAtoms;
    }

    public int getNumberOfSigmaAtoms() {
        return numberOfSigmaAtoms;
    }

    public void setNumberOfSigmaAtoms(int numberOfSigmaAtoms) {
        this.numberOfSigmaAtoms = numberOfSigmaAtoms;
    }

    public int getNumberOfGammaAtoms() {
        return numberOfGammaAtoms;
    }

    public void setNumberOfGammaAtoms(int numberOfGammaAtoms) {
        this.numberOfGammaAtoms = numberOfGammaAtoms;
    }

    public int getNumberOfAlphaPowerups() {
        return numberOfAlphaPowerups;
    }

    public void setNumberOfAlphaPowerups(int numberOfAlphaPowerups) {
        this.numberOfAlphaPowerups = numberOfAlphaPowerups;
    }

    public int getNumberOfBetaPowerups() {
        return numberOfBetaPowerups;
    }

    public void setNumberOfBetaPowerups(int numberOfBetaPowerups) {
        this.numberOfBetaPowerups = numberOfBetaPowerups;
    }

    public int getNumberOfSigmaPowerups() {
        return numberOfSigmaPowerups;
    }

    public void setNumberOfSigmaPowerups(int numberOfSigmaPowerups) {
        this.numberOfSigmaPowerups = numberOfSigmaPowerups;
    }

    public int getNumberOfGammaPowerups() {
        return numberOfGammaPowerups;
    }

    public void setNumberOfGammaPowerups(int numberOfGammaPowerups) {
        this.numberOfGammaPowerups = numberOfGammaPowerups;
    }

    public int getNumberOfAlphaBlockers() {
        return numberOfAlphaBlockers;
    }

    public void setNumberOfAlphaBlockers(int numberOfAlphaBlockers) {
        this.numberOfAlphaBlockers = numberOfAlphaBlockers;
    }

    public int getNumberOfBetaBlockers() {
        return numberOfBetaBlockers;
    }

    public void setNumberOfBetaBlockers(int numberOfBetaBlockers) {
        this.numberOfBetaBlockers = numberOfBetaBlockers;
    }

    public int getNumberOfSigmaBlockers() {
        return numberOfSigmaBlockers;
    }

    public void setNumberOfSigmaBlockers(int numberOfSigmaBlockers) {
        this.numberOfSigmaBlockers = numberOfSigmaBlockers;
    }

    public int getNumberOfGammaBlockers() {
        return numberOfGammaBlockers;
    }

    public void setNumberOfGammaBlockers(int numberOfGammaBlockers) {
        this.numberOfGammaBlockers = numberOfGammaBlockers;
    }

    public int getNumberOfAlphaMolecules() {
        return numberOfAlphaMolecules;
    }

    public void setNumberOfAlphaMolecules(int numberOfAlphaMolecules) {
        this.numberOfAlphaMolecules = numberOfAlphaMolecules;
    }

    public int getNumberOfBetaMolecules() {
        return numberOfBetaMolecules;
    }

    public void setNumberOfBetaMolecules(int numberOfBetaMolecules) {
        this.numberOfBetaMolecules = numberOfBetaMolecules;
    }

    public int getNumberOfSigmaMolecules() {
        return numberOfSigmaMolecules;
    }

    public void setNumberOfSigmaMolecules(int numberOfSigmaMolecules) {
        this.numberOfSigmaMolecules = numberOfSigmaMolecules;
    }

    public int getNumberOfGammaMolecules() {
        return numberOfGammaMolecules;
    }

    public void setNumberOfGammaMolecules(int numberOfGammaMolecules) {
        this.numberOfGammaMolecules = numberOfGammaMolecules;
    }

    public MoleculeStructure getAlphaMoleculeStructure() {
        return alphaMoleculeStructure;
    }

    public void setAlphaMoleculeStructure(MoleculeStructure alphaMoleculeStructure) {
        this.alphaMoleculeStructure = alphaMoleculeStructure;
    }

    public MoleculeStructure getBetaMoleculeStructure() {
        return betaMoleculeStructure;
    }

    public void setBetaMoleculeStructure(MoleculeStructure betaMoleculeStructure) {
        this.betaMoleculeStructure = betaMoleculeStructure;
    }

    public MoleculeAnimation getAlphaMoleculeAnimation() {
        return alphaMoleculeAnimation;
    }

    public void setAlphaMoleculeAnimation(MoleculeAnimation alphaMoleculeAnimation) {
        this.alphaMoleculeAnimation = alphaMoleculeAnimation;
    }

    public MoleculeAnimation getBetaMoleculeAnimation() {
        return betaMoleculeAnimation;
    }

    public void setBetaMoleculeAnimation(MoleculeAnimation betaMoleculeAnimation) {
        this.betaMoleculeAnimation = betaMoleculeAnimation;
    }

    public int getNumberOfLotaShields() {
        return numberOfLotaShields;
    }

    public void setNumberOfLotaShields(int numberOfLotaShields) {
        this.numberOfLotaShields = numberOfLotaShields;
    }

    public int getNumberOfThetaShields() {
        return numberOfThetaShields;
    }

    public void setNumberOfThetaShields(int numberOfThetaShields) {
        this.numberOfThetaShields = numberOfThetaShields;
    }

    public int getNumberOfEtaShields() {
        return numberOfEtaShields;
    }

    public void setNumberOfEtaShields(int numberOfEtaShields) {
        this.numberOfEtaShields = numberOfEtaShields;
    }

    public int getNumberOfZetaShields() {
        return numberOfZetaShields;
    }

    public void setNumberOfZetaShields(int numberOfZetaShields) {
        this.numberOfZetaShields = numberOfZetaShields;
    }
}
