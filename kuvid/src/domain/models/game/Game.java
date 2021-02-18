package domain.models.game;

import configs.GameConstants;
import configs.UIConstants;
import domain.enums.DifficultyLevel;
import domain.enums.EndGameReason;
import domain.enums.MoleculeAnimation;
import domain.enums.MoleculeStructure;
import domain.models.building_mode.BuildingMode;
import domain.models.objects.atom.Atom;
import domain.models.objects.molecule.Molecule;
import domain.models.objects.powerup.Powerup;
import domain.models.objects.reaction_blockers.ReactionBlocker;
import domain.models.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static Game game;
    private Player player;
    private DifficultyLevel difficultyLevel;
    private int lengthValuePercentage;
    private int remainingTime;
    private int numberOfAlphaPowerups;
    private int numberOfBetaPowerups;
    private int numberOfSigmaPowerups;
    private int numberOfGammaPowerups;
    private int numberOfAlphaBlockers;
    private int numberOfBetaBlockers;
    private int numberOfSigmaBlockers;
    private int numberOfGammaBlockers;
    private int numberOfAlphaMolecules;
    private int numberOfBetaMolecules;
    private int numberOfSigmaMolecules;
    private int numberOfGammaMolecules;
    private MoleculeStructure alphaMoleculeStructure;
    private MoleculeStructure betaMoleculeStructure;
    private MoleculeAnimation alphaMoleculeAnimation;
    private MoleculeAnimation betaMoleculeAnimation;
    private List<Atom> atomList;
    private List<Molecule> moleculeList;
    private List<Powerup> fallingPowerupList;
    private List<Powerup> shootedPowerupList;
    private List<ReactionBlocker> reactionBlockerList;
    private List<Atom> atomInventoryList;
    private boolean isPaused;
    private EndGameReason endGameReason;
    private int lengthConstant;
    private int numberOfFallingObjectsPerSecond;

    private Game() {
        atomList = new ArrayList<>();
        moleculeList = new ArrayList<>();
        fallingPowerupList = new ArrayList<>();
        shootedPowerupList = new ArrayList<>();
        reactionBlockerList = new ArrayList<>();
        atomInventoryList = new ArrayList<>();
    }

    public static Game getInstance() {
        if (game == null) {
            game = new Game();
        }
        return game;
    }

    public static void resetGame() {
        game = null;
    }

    public EndGameReason getEndGameReason() {
        return endGameReason;
    }

    public void setEndGameReason(EndGameReason endGameReason) {
        this.endGameReason = endGameReason;
    }

    public List<Atom> getAtomList() {
        return atomList;
    }

    public void insertIntoAtomList(Atom atom) {
        this.atomList.add(atom);
    }

    public void removeFromAtomlist(Atom atom) {
        this.atomList.remove(atom);
    }

    public List<Molecule> getMoleculeList() {
        return moleculeList;
    }

    public void insertIntoMoleculeList(Molecule molecule) {
        this.moleculeList.add(molecule);
    }

    public void removeFromMoleculeList(Molecule molecule) {
        this.moleculeList.remove(molecule);
    }

    public List<Powerup> getFallingPowerupList() {
        return fallingPowerupList;
    }

    public void insertIntoFallingPowerupList(Powerup powerup) {
        this.fallingPowerupList.add(powerup);
    }

    public void removeFromFallingPowerupList(Powerup powerup) {
        this.fallingPowerupList.remove(powerup);
    }

    public List<Powerup> getShootedPowerupList() {
        return shootedPowerupList;
    }

    public void insertIntoShootedPowerupList(Powerup powerup) {
        this.shootedPowerupList.add(powerup);
    }

    public void removeFromShootedPowerupList(Powerup powerup) {
        this.shootedPowerupList.remove(powerup);
    }

    public List<ReactionBlocker> getReactionBlockerList() {
        return reactionBlockerList;
    }

    public void insertIntoReactionBlockerList(ReactionBlocker blocker) {
        this.reactionBlockerList.add(blocker);
    }

    public void removeFromReactionBlockerList(ReactionBlocker blocker) {
        this.reactionBlockerList.remove(blocker);
    }

    public void setGame(BuildingMode buildingMode) {
        setPlayer(new Player());
        setDifficultyLevel(buildingMode.getDifficultyLevel());
        setLengthValuePercentage(buildingMode.getLengthValuePercentage());
        setRemainingTime(GameConstants.totalTime);
        player.setNumberOfAlphaAtoms(buildingMode.getNumberOfAlphaAtoms());
        setNumberOfAlphaBlockers(buildingMode.getNumberOfAlphaBlockers());
        setNumberOfAlphaMolecules(buildingMode.getNumberOfAlphaMolecules());
        setNumberOfAlphaPowerups(buildingMode.getNumberOfAlphaPowerups());
        player.setNumberOfBetaAtoms(buildingMode.getNumberOfBetaAtoms());
        setNumberOfBetaBlockers(buildingMode.getNumberOfBetaBlockers());
        setNumberOfBetaMolecules(buildingMode.getNumberOfBetaMolecules());
        setNumberOfBetaPowerups(buildingMode.getNumberOfBetaPowerups());
        player.setNumberOfSigmaAtoms(buildingMode.getNumberOfSigmaAtoms());
        setNumberOfSigmaBlockers(buildingMode.getNumberOfSigmaBlockers());
        setNumberOfSigmaMolecules(buildingMode.getNumberOfSigmaMolecules());
        setNumberOfSigmaPowerups(buildingMode.getNumberOfSigmaPowerups());
        player.setNumberOfGammaAtoms(buildingMode.getNumberOfGammaAtoms());
        setNumberOfGammaBlockers(buildingMode.getNumberOfGammaBlockers());
        setNumberOfGammaMolecules(buildingMode.getNumberOfGammaMolecules());
        setNumberOfGammaPowerups(buildingMode.getNumberOfGammaPowerups());
        setAlphaMoleculeStructure(buildingMode.getAlphaMoleculeStructure());
        setAlphaMoleculeAnimation(buildingMode.getAlphaMoleculeAnimation());
        setBetaMoleculeStructure(buildingMode.getBetaMoleculeStructure());
        setBetaMoleculeAnimation(buildingMode.getBetaMoleculeAnimation());
        setLengthConstant();
        setNumberOfFallingObjectsPerSecondAccordingToDifficulty();
        player.setNumberOfLotaShields(buildingMode.getNumberOfLotaShields());
        player.setNumberOfThetaShields(buildingMode.getNumberOfThetaShields());
        player.setNumberOfZetaShields(buildingMode.getNumberOfZetaShields());
        player.setNumberOfEtaShields(buildingMode.getNumberOfEtaShields());
    }

    public void loadGame(Game game) {
        this.game = game;
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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
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

    public boolean isPaused() {
        return isPaused;
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }

    private void setLengthConstant() {
        lengthConstant = lengthValuePercentage * UIConstants.GAME_WINDOW_HEIGHT / 100;
    }

    public int getLengthConstant() {
        return lengthConstant;
    }

    public int getNumberOfFallingObjectsPerSecond() {
        return numberOfFallingObjectsPerSecond;
    }

    public void setNumberOfFallingObjectsPerSecond(int numberOfFallingObjectsPerSecond) {
        this.numberOfFallingObjectsPerSecond = numberOfFallingObjectsPerSecond;
    }

    public void setNumberOfFallingObjectsPerSecondAccordingToDifficulty() {
        switch (this.difficultyLevel) {
            case EASY -> setNumberOfFallingObjectsPerSecond(1);
            case MEDIUM -> setNumberOfFallingObjectsPerSecond(2);
            case HARD -> setNumberOfFallingObjectsPerSecond(4);
        }
    }

    public List<Atom> getAtomInventoryList() {
        return atomInventoryList;
    }

    public void insertToAtomInventoryList(Atom atom) {
        atomInventoryList.add(atom);
    }

    public void removeFromAtomInventoryList(Atom atom) {
        atomInventoryList.remove(atom);
    }
}
