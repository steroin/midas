package pl.midas.core.global.settings;

public class GlobalSettings {
    public String getSetting(GlobalSettingsConstants setting) {
        if (setting == GlobalSettingsConstants.LANGUAGE) {
            return "pl";
        }
        return null;
    }
}