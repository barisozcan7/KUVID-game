package UI.views;

import UI.components.game_view.statistics_view.StatisticsPanel;
import domain.controller.game.GameController;
import domain.controller.save_load.SaveLoadController;
import domain.enums.GameMode;
import domain.enums.SaveMode;
import domain.models.options.SaveOptions;
import service.view_service.ViewFactory;
import utils.Utils;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoadGameView extends JPanel implements ListSelectionListener, ActionListener {
    private static JFrame window;
    JButton loadGameButton;
    JButton backButton;
    private JTable table;
    private JLabel descriptionLabel;
    private final SaveLoadController controller;
    private SaveOptions selectedSave;

    public LoadGameView() {
        controller = new SaveLoadController();
        setWindow();
        setLabel();
        setButtons();
        initializeTable();
        populateTable();
    }

    private SaveOptions getSelectedSave() {
        return selectedSave;
    }

    private void setSelectedSave(SaveOptions selectedSave) {
        this.selectedSave = selectedSave;
    }

    private void setWindow() {
        window = new JFrame();
        window.getContentPane().add(this);
        window.setSize(600, 600);
        window.setTitle("Load Game");
        window.setVisible(true);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setFocusable(true);
        setBackground(Color.DARK_GRAY);
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        ArrayList<SaveOptions> fileList = controller.fetch(SaveMode.FILE);
        ArrayList<SaveOptions> dbList = controller.isDbAvailable() ? controller.fetch(SaveMode.DATABASE) : new ArrayList<>();

        if (fileList.isEmpty() && dbList.isEmpty()) {
            loadGameButton.setEnabled(false);
        }
        for (SaveOptions options : fileList) {
            model.addRow(new Object[]{options.saveMode, options.name, Utils.timestampToDateConverter(options.date)});
        }

        for (SaveOptions options : dbList) {
            model.addRow(new Object[]{options.saveMode, options.name, Utils.timestampToDateConverter(options.date)});
        }
    }


    private void setLabel() {
        descriptionLabel = new JLabel("Select a save to load");
        descriptionLabel.setFont(new Font("Open Sans", Font.PLAIN, 14));
    }

    private void initializeTable() {

        String[] header = {"Saved to", "Name", "Date"};
        String[][] data = {};

        DefaultTableModel model = new DefaultTableModel(data, header);

        table = new JTable(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Saved to", "Name", "Date"
                }
        ) {
            final Class[] columnTypes = new Class[]{
                    Object.class, String.class, String.class
            };

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });

        table.getTableHeader().setReorderingAllowed(false);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setShowHorizontalLines(false);
        table.setShowVerticalLines(false);
        table.setForeground(Color.WHITE);
        table.setShowGrid(false);
        table.setBackground(Color.DARK_GRAY);
        table.setFont(new Font("Open Sans", Font.PLAIN, 16));
        table.setPreferredScrollableViewportSize(new Dimension(450, 63));
        table.setFillsViewportHeight(true);
        table.setRowHeight(80);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(String.class, centerRenderer);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);

        JScrollPane js = new JScrollPane(table);
        js.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        js.setBounds(15, 50, 550, 400);
        js.setVisible(true);
        setLayout(null);
        add(js);

        JTableHeader th = table.getTableHeader();
        th.setPreferredSize(new Dimension(50, 50));
        th.setFont(new Font("Open Sans", Font.BOLD, 16));
        table.getSelectionModel().addListSelectionListener(this);


    }

    private void setButtons() {
        loadGameButton = new JButton("Load Game");
        loadGameButton.setFont(new Font("Open Sans", Font.PLAIN, 14));
        loadGameButton.setBounds(321, 477, 185, 47);
        loadGameButton.addActionListener(this);
        add(loadGameButton);

        backButton = new JButton("Back");
        backButton.setBackground(Color.GRAY);
        backButton.setFont(new Font("Open Sans", Font.PLAIN, 14));
        backButton.setBounds(86, 477, 185, 47);
        backButton.addActionListener(this);
        add(backButton);
    }

    public void disposeWindow() {
        window.dispose();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        SaveMode saveMode = (SaveMode) table.getValueAt(table.getSelectedRow(), 0);
        String name = table.getValueAt(table.getSelectedRow(), 1).toString();
        String date = table.getValueAt(table.getSelectedRow(), 2).toString();
        long timestamp = Utils.DateStringToTimestampConverter(date);
        setSelectedSave(new SaveOptions(name, Long.toString(timestamp), saveMode));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loadGameButton) {
            if (ViewFactory.getInstance().getGameMode().equals(GameMode.MAIN_MENU)) {
                ViewFactory.getInstance().removeView(GameMode.MAIN_MENU);
                ViewFactory.getInstance().getView(GameMode.DEFAULT_GAME);
                GameController.getInstance().pauseGame();
            }
            controller.load(getSelectedSave().saveMode, getSelectedSave());
            StatisticsPanel.updateAllLabels();
            GameView.repaintGamePanel();
            disposeWindow();
        }

        if (e.getSource() == backButton) {
            disposeWindow();
        }
    }
}
