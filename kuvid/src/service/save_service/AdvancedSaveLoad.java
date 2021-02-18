package service.save_service;

import domain.models.options.SaveOptions;

import java.util.ArrayList;

public interface AdvancedSaveLoad {
    void saveToFile(String username);

    void loadFromFile(SaveOptions saveOptions);

    ArrayList<SaveOptions> fetchFiles();

    void saveToDatabase(String username);

    void loadFromDatabase(SaveOptions saveOptions);

    ArrayList<SaveOptions> fetchDatabase();
}
