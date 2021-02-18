package domain.models.player;

public class Player {
    private double score;
    private int health;
    private int numberOfAlphaAtoms;
    private int numberOfBetaAtoms;
    private int numberOfSigmaAtoms;
    private int numberOfGammaAtoms;
    private int numberOfAlphaPowerups = 0;
    private int numberOfBetaPowerups = 0;
    private int numberOfSigmaPowerups = 0;
    private int numberOfGammaPowerups = 0;
    private int numberOfLotaShields;
    private int numberOfThetaShields;
    private int numberOfEtaShields;
    private int numberOfZetaShields;

    public Player() {
        this.health = 100;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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
