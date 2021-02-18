package domain.controller.end_game;

import domain.controller.game.GameController;
import domain.enums.GameMode;
import service.view_service.ViewFactory;

public class EndGameController {

    public EndGameController() {
    }

    public void restartGame() {
        GameController.getInstance().resetGame();
        restartGameModeView();
    }

    private void restartGameModeView() {
        ViewFactory.getInstance().removeView(GameMode.END_GAME);
        ViewFactory.getInstance().getView(GameMode.GAME);
    }

    public void returnMainMenu() {
        GameController.getInstance().resetGame();
        ViewFactory.getInstance().removeView(GameMode.END_GAME);
        ViewFactory.getInstance().getView(GameMode.MAIN_MENU);
    }

}
