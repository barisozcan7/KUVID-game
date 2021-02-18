package service.save_service;

import domain.enums.SaveMode;
import domain.models.options.SaveOptions;

import java.util.ArrayList;

public interface SaveLoad {

    void save(SaveMode saveMode, String username);

    void load(SaveMode saveMode, SaveOptions saveOptions);

    ArrayList<SaveOptions> fetch(SaveMode saveMode);
}
