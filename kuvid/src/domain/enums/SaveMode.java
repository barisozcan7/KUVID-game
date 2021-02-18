package domain.enums;

import java.util.Locale;

public enum SaveMode {
    FILE, DATABASE;

    @Override
    public String toString() {
        String text = name();
        return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase(Locale.ENGLISH);
    }
}
