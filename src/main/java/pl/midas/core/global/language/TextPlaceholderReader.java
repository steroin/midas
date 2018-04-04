package pl.midas.core.global.language;

import org.json.JSONObject;
import pl.midas.core.global.language.exception.PlaceholderNotFoundException;
import pl.midas.core.global.settings.GlobalSettings;
import pl.midas.core.global.settings.GlobalSettingsConstants;
import pl.midas.core.resources.JsonResourceResolver;
import pl.midas.core.resources.exception.ResourceNotFoundException;

import java.util.HashMap;
import java.util.Map;


public class TextPlaceholderReader {

    private static final String JSON_EXTENSION = "json";
    private static final Map<String, JSONObject> cachedPacks = new HashMap<>();

    public static String readPlaceholder(String path, String xPath) {
        String[] splittedXPath = xPath.split("\\.");
        String jsonFileName = splittedXPath[0];
        String language = GlobalSettings.getSetting(GlobalSettingsConstants.LANGUAGE);

        try {
            JSONObject jsonObject = JsonResourceResolver.getResource(buildResourcePath(language, path, jsonFileName));

            for (int i = 1; i < splittedXPath.length - 1; i++) {
                if (!jsonObject.has(splittedXPath[i])) {
                    throw new PlaceholderNotFoundException();
                }
                jsonObject = jsonObject.getJSONObject(splittedXPath[i]);
            }

            if (!jsonObject.has(splittedXPath[splittedXPath.length - 1])) {
                throw new PlaceholderNotFoundException();
            }

            return jsonObject.getString(splittedXPath[splittedXPath.length - 1]);
        } catch (ResourceNotFoundException e) {
            throw new PlaceholderNotFoundException();
        }
    }

    private static String buildResourcePath(String language, String path, String fileName) {
        return "/lang/" + language + "/" + path + "/" + fileName + "." + JSON_EXTENSION;
    }
}
