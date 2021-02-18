package domain.enums;

import java.util.Arrays;

public enum DifficultyLevel {
    EASY("EASY"), MEDIUM("MEDIUM"), HARD("HARD");
    private String value;

    DifficultyLevel(String value) {
        this.value = value;
    }

    public static DifficultyLevel stringToEnum(String str) {
        return Arrays.stream(DifficultyLevel.values())
                .filter(element -> element.value.equalsIgnoreCase(str))
                .findFirst().orElse(HARD);
    }
}
