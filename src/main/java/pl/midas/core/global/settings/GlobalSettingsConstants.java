package pl.midas.core.global.settings;

public enum GlobalSettingsConstants {
    LANGUAGE("language");

    private String value;

    GlobalSettingsConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
