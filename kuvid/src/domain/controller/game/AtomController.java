package domain.controller.game;

import configs.UIConstants;
import domain.models.game.Game;
import domain.models.objects.atom.Atom;

import static configs.ObjectConstants.atomEdge;

public class AtomController {
    public void move(Atom atom) {
        removeAtomOutOfBounds(atom);
        double rotation = atom.getRotation();
        atom.setxCoordinate(atom.getxCoordinate() + Math.cos(Math.toRadians(90 - rotation)) * atom.getSpeed());
        atom.setyCoordinate(atom.getyCoordinate() - Math.sin(Math.toRadians(90 - rotation)) * atom.getSpeed());
        hitWall(atom);
    }

    private void removeAtomOutOfBounds(Atom atom) {
        if (atom.getyCoordinate() < -40) {
            Game.getInstance().removeFromAtomlist(atom);
        }
    }

    private void hitWall(Atom atom) {
        if (atom.getxCoordinate() < 0 ||
                atom.getxCoordinate() > UIConstants.GAME_PANEL_WIDTH - atomEdge) {
            atom.setRotation(atom.getRotation() * -1);
        }
    }
}
