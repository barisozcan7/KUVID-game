package runnable;

import domain.enums.GameMode;
import service.view_service.ViewFactory;

import javax.swing.*;

public class Run {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> ViewFactory.getInstance().getView(GameMode.MAIN_MENU));
    }
}
