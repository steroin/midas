package pl.midas.core.resources;

import org.json.JSONObject;
import org.json.JSONTokener;
import pl.midas.core.resources.exception.ResourceNotFoundException;

import java.io.InputStream;

public class JsonResourceResolver {
    public static JSONObject getResource(String path) throws ResourceNotFoundException {
        InputStream resourceStream = JsonResourceResolver.class.getResourceAsStream(path);

        if (resourceStream == null) {
            throw new ResourceNotFoundException();
        }

        return new JSONObject(new JSONTokener(resourceStream));
    }
}
