package service.view_service;

import UI.views.*;
import domain.enums.GameMode;
import domain.models.building_mode.BuildingMode;
import domain.models.game.Game;
import service.save_service.DatabaseSave;

import javax.swing.*;

public class ViewFactory {

    private static ViewFactory viewFactory;
    private static BuildingModeView buildingModeView;
    private static GameView gameView;
    private static BlenderModeView blenderModeView;
    private static EndGameView endGameView;
    private static MainMenuView mainMenuView;
    private static SaveGameView saveGameView;
    private static LoadGameView loadGameView;
    private GameMode gameMode;

    private ViewFactory() {
    }

    public static ViewFactory getInstance() {
        if (viewFactory == null) {
            viewFactory = new ViewFactory();
            DatabaseSave.setUpMongo();
        }

        return viewFactory;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public JPanel getView(GameMode mode) {
        switch (mode) {
            case BUILDING_MODE:
                buildingModeView = new BuildingModeView();
                setGameMode(GameMode.BUILDING_MODE);
                return buildingModeView;
            case GAME:
                removeView(GameMode.BUILDING_MODE);
                Game.getInstance().setGame(BuildingMode.getInstance());
                gameView = new GameView();
                setGameMode(GameMode.GAME);
                return gameView;
            case DEFAULT_GAME:
                BuildingMode buildingMode = BuildingMode.getDefaultBuildingMode();
                Game.getInstance().setGame(buildingMode);
                gameView = new GameView();
                setGameMode(GameMode.DEFAULT_GAME);
                return gameView;
            case BLENDER_MODE:
                blenderModeView = new BlenderModeView();
                setGameMode(GameMode.BLENDER_MODE);
                return blenderModeView;
            case END_GAME:
                endGameView = new EndGameView();
                removeView(GameMode.GAME);
                return endGameView;
            case MAIN_MENU:
                mainMenuView = new MainMenuView();
                setGameMode(GameMode.MAIN_MENU);
                return mainMenuView;
            case SAVE_GAME:
                saveGameView = new SaveGameView();
                return saveGameView;
            case LOAD_GAME:
                loadGameView = new LoadGameView();
                return loadGameView;
            default:
                return new JPanel();
        }
    }

    public void removeView(GameMode mode) {
        switch (mode) {
            case BUILDING_MODE:
                if (buildingModeView != null) {
                    buildingModeView.disposeWindow();
                }
                break;
            case BLENDER_MODE:
                blenderModeView.disposeWindow();
                break;
            case GAME:
                gameView.disposeWindow();
                break;
            case END_GAME:
                endGameView.disposeWindow();
                break;
            case MAIN_MENU:
                mainMenuView.disposeWindow();
                break;
            case SAVE_GAME:
                saveGameView.disposeWindow();
                break;
            case LOAD_GAME:
                loadGameView.disposeWindow();
                break;
        }
    }
}
