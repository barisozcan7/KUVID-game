package domain.controller.game;

import domain.models.game.Game;
import domain.models.player.Player;

public class PlayerController {
    private static PlayerController controller;

    private PlayerController() {
    }

    public static PlayerController getInstance() {
        if (controller == null) {
            controller = new PlayerController();
        }
        return controller;
    }

    public void increaseScore(double expectedStability) {
        Player player = Game.getInstance().getPlayer();
        double newScore = player.getScore() + expectedStability;
        double roundedScore = (double) Math.round(newScore * 100) / 100;
        player.setScore(roundedScore);
    }
}
