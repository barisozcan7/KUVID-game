package UI.views;

import UI.components.game_view.GamePanel;
import UI.components.game_view.statistics_view.StatisticsPanel;
import UI.components.game_view.statistics_view.TintPanel;
import domain.controller.game.AtomShooterController;
import domain.enums.Type;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static configs.UIConstants.*;


public class GameView extends JPanel implements MouseListener {

    private static JFrame gameWindow;
    private static JPanel gamePanel;
    private static JPanel pauseModeView;
    private final JLabel backgroundImage = new JLabel("");
    private JPanel statisticsPanel;
    private JPanel tintPanel;
    private AtomShooterController atomShooterController = AtomShooterController.getInstance();

    public GameView() {
        gameWindow = new JFrame();
        setGameWindow();
        gamePanel = new GamePanel();
        statisticsPanel = new StatisticsPanel();
        tintPanel = new TintPanel();
        pauseModeView = new PauseModeView();
        pauseModeView.setVisible(false);
        add(pauseModeView);
        add(gamePanel);
        add(statisticsPanel);
        add(tintPanel);
        add(backgroundImage);
        addMouseListener(this);
    }

    public static void repaintGamePanel() {
        gamePanel.repaint();
    }

    public static void setPauseModeVisibility(boolean isVisible) {
        pauseModeView.setVisible(isVisible);
    }

    private void setGameWindow() {
        gameWindow.getContentPane().add(this);
        gameWindow.setSize(GAME_WINDOW_WIDTH, GAME_WINDOW_HEIGHT);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setVisible(true);
        gameWindow.setResizable(false);
        gameWindow.setTitle(GAME_WINDOW_TITLE);
        gameWindow.setLocationRelativeTo(null);
        setLayout(null);
        backgroundImage.setIcon(new ImageIcon(GameView.class.getResource(BACKGROUND_IMAGE_PATH)));
        backgroundImage.setBounds(0, 0, BACKGROUND_IMAGE_WIDTH, BACKGROUND_IMAGE_HEIGHT);
    }

    public void disposeWindow() {
        gameWindow.dispose();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (x >= 917 && y >= 213 && x <= 972 && y <= 268) {
            atomShooterController.pickPowerup(Type.SIGMA);
        } else if (x >= 917 && y >= 268 && x <= 972 && y <= 322) {
            atomShooterController.pickPowerup(Type.BETA);
        } else if (x >= 917 && y >= 322 && x <= 972 && y <= 377) {
            atomShooterController.pickPowerup(Type.ALPHA);
        } else if (x >= 917 && y >= 377 && x <= 972 && y <= 432) {
            atomShooterController.pickPowerup(Type.GAMMA);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (x >= 917 && y >= 213 && x <= 972 && y <= 268) {
            atomShooterController.pickPowerup(Type.SIGMA);
        } else if (x >= 917 && y >= 268 && x <= 972 && y <= 322) {
            atomShooterController.pickPowerup(Type.BETA);
        } else if (x >= 917 && y >= 322 && x <= 972 && y <= 377) {
            atomShooterController.pickPowerup(Type.ALPHA);
        } else if (x >= 917 && y >= 377 && x <= 972 && y <= 432) {
            atomShooterController.pickPowerup(Type.GAMMA);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
