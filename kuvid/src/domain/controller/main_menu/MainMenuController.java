package domain.controller.main_menu;

import domain.enums.GameMode;
import service.view_service.ViewFactory;

public class MainMenuController {

    public void exitGame() {
        System.exit(0);
    }

    public void enterBuildingMode() {
        ViewFactory.getInstance().removeView(GameMode.MAIN_MENU);
        ViewFactory.getInstance().getView(GameMode.BUILDING_MODE);
    }

    public void playGame() {
        ViewFactory.getInstance().removeView(GameMode.MAIN_MENU);
        ViewFactory.getInstance().getView(GameMode.DEFAULT_GAME);
    }

    public void getLoadGameView() {
        ViewFactory.getInstance().getView(GameMode.LOAD_GAME);
    }

}
