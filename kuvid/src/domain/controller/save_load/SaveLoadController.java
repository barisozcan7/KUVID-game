package domain.controller.save_load;


import domain.enums.SaveMode;
import domain.models.options.SaveOptions;
import service.save_service.SaveLoad;
import service.save_service.SaveLoadAdapter;
import service.save_service.ServerConnection;

import java.util.ArrayList;

public class SaveLoadController implements SaveLoad {
    SaveLoadAdapter saveLoadAdapter;

    @Override
    public void save(SaveMode saveMode, String username) {
        //REQUIRES: 1) Game should be in the pause mode.
        //          2) Database-save should be available if MongoDB is running.
        //          3) Player should enter a name for saving with that filename.
        //          4) Player should specify the type of the save choosing a button.
        //MODIFIES: The player has two options for saving the game.
        //          First one is saving the game to a file, and the
        //          second one is saving the game to the database.
        //          -> If player selects saving the game with file option;
        //          It modifies the json files (one for keeping the game status
        //          and the other one for the shooter) that are created under the
        //          save folder.
        //          -> If player selects saving the game with the database option
        //          (which is not available if MongoDB service is not running);
        //          It modifies the collection that is created in MongoDB service
        //          by inserting two documents that keeps the game and the shooter
        //          status as mentioned before.
        //EFFECTS: -> If player saved the game with file option;
        //          It creates a file under the save folder with a unique name that
        //          has the filename and the date of save in it. (the timestamp
        //          converted to an actual date). There would be two json files in
        //          that file (mentioned above).
        //          -> If player saved the game with database option;
        //          It creates a collection and inserts two documents called gameDoc
        //          and shooterDoc in it.
        //RETURNS: void
        saveLoadAdapter = new SaveLoadAdapter(saveMode);
        saveLoadAdapter.save(saveMode, username);
    }

    @Override
    public void load(SaveMode saveMode, SaveOptions saveOptions) {
        //REQUIRES: 1) Game should be in the pause mode or in main menu.
        //          2) Database-load should be available if MongoDB is running.
        //MODIFIES: None
        //EFFECTS:  The player has two options for loading the game.
        //          First one is loading the game from a file, and the
        //          second one is loading the game from the database.
        //          -> If player loaded the game with file option;
        //          It loads the game and the shooter according
        //          to the information provided by json files.
        //          -> If player loaded the game with database option
        //          (which is not available if MongoDB service is not running);
        //          It loads the game and the shooter according to the
        //          information provided by documents that are obtained
        //          from db (the document with the unique name).
        //RETURNS: void
        saveLoadAdapter = new SaveLoadAdapter(saveMode);
        saveLoadAdapter.load(saveMode, saveOptions);
    }

    @Override
    public ArrayList<SaveOptions> fetch(SaveMode saveMode) {
        //REQUIRES: Game should be in the pause mode.
        //MODIFIES: None
        //EFFECTS:  -> The fetch method in save-to-file has the following effects;
        //          It adds the all of the saved files to an arraylist using the
        //          name converter method fileNameToSaveOptionsConverter.
        //          SaveOptions includes the filename, date and the save mode.
        //          -> The fetch method in save-to-db has the following effects;
        //          It iterates over the collections and adds all of the saved files
        //          to an arraylist using the name converter method
        //          fileNameToSaveOptionsConverter. SaveOptions includes the
        //          filename, date and the save mode.
        //RETURNS: ArrayList of SaveOptions -> This list represents
        //         all the saved files.
        saveLoadAdapter = new SaveLoadAdapter(saveMode);
        return saveLoadAdapter.fetch(saveMode);
    }

    public boolean isDbAvailable() {
        return ServerConnection.isAvailable();
    }
}
