package domain.models.options;

import domain.enums.SaveMode;

public class SaveOptions {
    public String name;
    public String date;
    public SaveMode saveMode;

    public SaveOptions(String name, String date, SaveMode saveMode) {
        this.name = name;
        this.date = date;
        this.saveMode = saveMode;
    }

}
