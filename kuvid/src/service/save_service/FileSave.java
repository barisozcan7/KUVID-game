package service.save_service;

import UI.components.game_view.statistics_view.StatisticsPanel;
import UI.views.GameView;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.enums.SaveMode;
import domain.models.game.Game;
import domain.models.objects.AtomShooter;
import domain.models.options.SaveOptions;
import utils.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileSave implements AdvancedSaveLoad {

    public void saveToFile(String username) {
        ObjectMapper mapper = new ObjectMapper();
        String folderName = Utils.fileNameGenerator(username);
        File source = new File("save");
        Path newFolder = Paths.get(source.getAbsolutePath() + "/" + folderName);
        try {
            Files.createDirectories(newFolder);
            File gameFile = new File(newFolder.toUri().getPath(), "game.json");
            File shooterFile = new File(newFolder.toUri().getPath(), "atomshooter.json");
            mapper.writeValue(gameFile, Game.getInstance());
            mapper.writeValue(shooterFile, AtomShooter.getInstance());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(SaveOptions saveOptions) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File source = new File("save");
            String fileName = saveOptions.name + "_" + saveOptions.date;
            Path folder = Paths.get(source.getAbsolutePath() + "/" + fileName);
            File gameFile = new File(folder.toUri().getPath(), "game.json");
            File shooterFile = new File(folder.toUri().getPath(), "atomshooter.json");
            Game.getInstance().loadGame(mapper.readValue(gameFile, Game.class));
            AtomShooter.getInstance().loadAtomShooter(mapper.readValue(shooterFile, AtomShooter.class));
        } catch (FileNotFoundException e) {
            //todo: dosya yoksa hatayi handle et
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<SaveOptions> fetchFiles() {
        File[] files = new File("save/").listFiles();
        ArrayList<SaveOptions> list = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                list.add(Utils.fileNameToSaveOptionsConverter(file.getName(), SaveMode.FILE));
            }
        }
        return list;
    }

    @Override
    public void saveToDatabase(String username) {
    }

    @Override
    public void loadFromDatabase(SaveOptions saveOptions) {
    }

    @Override
    public ArrayList<SaveOptions> fetchDatabase() {
        return null;
    }


}
