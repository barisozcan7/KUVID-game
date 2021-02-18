package service.save_service;

import domain.enums.SaveMode;
import domain.models.options.SaveOptions;

import java.util.ArrayList;

public class SaveLoadAdapter implements SaveLoad {

    AdvancedSaveLoad advancedSaveLoad;

    public SaveLoadAdapter(SaveMode saveMode) {
        if (saveMode.equals(SaveMode.FILE)) {
            advancedSaveLoad = new FileSave();
        } else if (saveMode.equals(SaveMode.DATABASE)) {
            advancedSaveLoad = new DatabaseSave();
        }
    }

    @Override
    public void save(SaveMode saveMode, String username) {
        if (saveMode.equals(SaveMode.FILE)) {
            advancedSaveLoad.saveToFile(username);
        } else if (saveMode.equals(SaveMode.DATABASE)) {
            advancedSaveLoad.saveToDatabase(username);
        }
    }

    @Override
    public void load(SaveMode saveMode, SaveOptions saveOptions) {
        if (saveMode.equals(SaveMode.FILE)) {
            advancedSaveLoad.loadFromFile(saveOptions);
        } else if (saveMode.equals(SaveMode.DATABASE)) {
            advancedSaveLoad.loadFromDatabase(saveOptions);
        }
    }

    @Override
    public ArrayList<SaveOptions> fetch(SaveMode saveMode) {
        if (saveMode.equals(SaveMode.FILE)) {
            return advancedSaveLoad.fetchFiles();
        } else if (saveMode.equals(SaveMode.DATABASE)) {
            return advancedSaveLoad.fetchDatabase();
        }
        return advancedSaveLoad.fetchFiles();
    }
}
