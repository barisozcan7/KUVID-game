package domain.controller.game;

import UI.components.game_view.statistics_view.PlayerStatisticsPanel;
import UI.components.game_view.statistics_view.PowerupAndShieldStatisticsPanel;
import UI.views.GameView;
import configs.GameConstants;
import domain.enums.EndGameReason;
import domain.enums.GameMode;
import domain.models.building_mode.BuildingMode;
import domain.models.game.Game;
import domain.models.objects.AtomShooter;
import service.audio_service.AudioService;
import service.view_service.ViewFactory;
import service.workers.AtomWorker;
import service.workers.MoleculeWorker;
import service.workers.PowerupWorker;
import service.workers.ReactionBlockerWorker;
import service.workers.collision_workers.AtomMoleculeCollisionWorker;
import service.workers.collision_workers.BlockerExplosionWorker;
import service.workers.collision_workers.BlockerPowerupCollisionWorker;
import service.workers.collision_workers.ShooterPowerupCollisionWorker;

import java.util.Timer;
import java.util.TimerTask;

import static service.object_service.AtomFactory.getTotalNumberOfAtoms;
import static service.object_service.FallingObjectsFactory.generateFallingObjects;
import static service.object_service.FallingObjectsFactory.getTotalNumberOfRemainingFallingObjects;

public class GameController {
    private static GameController controller;
    private Timer timer;
    private javax.swing.Timer uiTimer;
    private MoleculeWorker moleculeWorker;
    private PowerupWorker powerupWorker;
    private AtomWorker atomWorker;
    private ReactionBlockerWorker reactionBlockerWorker;
    private AtomMoleculeCollisionWorker atomMoleculeCollisionWorker;
    private BlockerExplosionWorker blockerExplosionWorker;
    private ShooterPowerupCollisionWorker shooterPowerupCollisionWorker;
    private BlockerPowerupCollisionWorker blockerPowerupCollisionWorker;

    private GameController() {
        initWorkers();
        //AudioService.playMusic();
        startTimer();
    }

    public static GameController getInstance() {
        if (controller == null) {
            controller = new GameController();
        }
        return controller;
    }

    public static void resetController() {
        controller = null;
    }

    private void initWorkers() {
        moleculeWorker = new MoleculeWorker();
        powerupWorker = new PowerupWorker();
        atomWorker = new AtomWorker();
        reactionBlockerWorker = new ReactionBlockerWorker();
        atomMoleculeCollisionWorker = new AtomMoleculeCollisionWorker();
        blockerExplosionWorker = new BlockerExplosionWorker();
        shooterPowerupCollisionWorker = new ShooterPowerupCollisionWorker();
        blockerPowerupCollisionWorker = new BlockerPowerupCollisionWorker();
    }

    public void pauseGame() {
        timer.cancel();
        uiTimer.stop();
        closeGameThreads();
        Game.getInstance().setPaused(true);
        GameView.setPauseModeVisibility(true);
        PowerupAndShieldStatisticsPanel.disableShieldButtons();
        //AudioService.pauseMusic();
    }

    public void returnMainMenu() {
        resetGame();
        ViewFactory.getInstance().removeView(GameMode.GAME);
        ViewFactory.getInstance().getView(GameMode.MAIN_MENU);
        //AudioService.stopMusic();
    }

    public void getSaveGameView() {
        ViewFactory.getInstance().getView(GameMode.SAVE_GAME);
    }

    public void getLoadGameView() {
        ViewFactory.getInstance().getView(GameMode.LOAD_GAME);
    }

    public void returnGame() {
        //AudioService.playMusic();
        initWorkers();
        startGameThreads();
        uiTimer.start();
        startTimer();
        Game.getInstance().setPaused(false);
        GameView.setPauseModeVisibility(false);
        PowerupAndShieldStatisticsPanel.enableShieldButtons();
    }

    private void decreaseRemainingTime() {
        Game.getInstance().setRemainingTime(Game.getInstance().getRemainingTime() - 1);
        PlayerStatisticsPanel.updateLabels();
    }

    private void startTimer() {
        startGameThreads();
        timer = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                decreaseRemainingTime();
                generateFallingObjects();
                AtomShooterController.getInstance().finishReloading();
                endGame();
            }
        };
        timer.schedule(task, 0, GameConstants.period);
    }

    public void setUiTimer(javax.swing.Timer timer) {
        this.uiTimer = timer;
        this.uiTimer.start();
    }

    private void endGame() {
        Game game = Game.getInstance();

        boolean isGameOver = false;

        if (game.getRemainingTime() <= 0) {
            game.setEndGameReason(EndGameReason.TIME_IS_OVER);
            isGameOver = true;
        } else if (game.getPlayer().getHealth() <= 0) {
            game.setEndGameReason(EndGameReason.DIE);
            isGameOver = true;
        } else if (getTotalNumberOfAtoms() == 0 && game.getAtomList().size() == 0) {
            game.setEndGameReason(EndGameReason.OUT_OF_ATOMS);
            isGameOver = true;
        } else if (getTotalNumberOfRemainingFallingObjects() == 0 && game.getFallingPowerupList().size() == 0 && game.getReactionBlockerList().size() == 0 && game.getMoleculeList().size() == 0) {
            game.setEndGameReason(EndGameReason.OUT_OF_FALLING_OBJECTS);
            isGameOver = true;
        }

        if (isGameOver) {
            pauseGame();
            AudioService.stopMusic();
            ViewFactory.getInstance().getView(GameMode.END_GAME);
        }
    }

    public void resetGame() {
        closeGameThreads();
        BuildingMode.resetBuildingMode();
        GameController.resetController();
        AtomShooterController.resetController();
        AtomShooter.resetShooter();
        Game.resetGame();
    }

    public void startGameThreads() {
        moleculeWorker.execute();
        powerupWorker.execute();
        atomWorker.execute();
        reactionBlockerWorker.execute();
        atomMoleculeCollisionWorker.execute();
        blockerExplosionWorker.execute();
        blockerPowerupCollisionWorker.execute();
        shooterPowerupCollisionWorker.execute();
    }

    public void closeGameThreads() {
        moleculeWorker.cancel(true);
        powerupWorker.cancel(true);
        atomWorker.cancel(true);
        reactionBlockerWorker.cancel(true);
        atomMoleculeCollisionWorker.cancel(true);
        blockerExplosionWorker.cancel(true);
        blockerPowerupCollisionWorker.cancel(true);
        shooterPowerupCollisionWorker.cancel(true);
    }
}
