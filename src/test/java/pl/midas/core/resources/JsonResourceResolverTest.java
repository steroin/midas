package pl.midas.core.resources;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import pl.midas.core.resources.exception.ResourceNotFoundException;

import static org.junit.Assert.*;

public class JsonResourceResolverTest {

    @Test
    public void getResourceSimpleValid() throws ResourceNotFoundException {
        JSONObject jsonObject = JsonResourceResolver.getResource("/resources/simple.json");
        assertEquals("propertyValue", jsonObject.get("property"));
        assertEquals("nestedExampleValue", jsonObject.getJSONObject("nestedProperty").get("nestedExampleKey"));
        assertEquals(5, jsonObject.getJSONObject("nestedProperty").get("nestedExampleAnotherKey"));
    }

    @Test(expected = ResourceNotFoundException.class)
    public void getResourceNotFound() throws ResourceNotFoundException {
        JsonResourceResolver.getResource("/resources/nonExisting.json");
    }

    @Test(expected = JSONException.class)
    public void getResourceInvalidJsonWrongCharacter() throws ResourceNotFoundException {
        JsonResourceResolver.getResource("/resources/wrongCharacter.json");
    }

    @Test(expected = JSONException.class)
    public void getResourceInvalidJson() throws ResourceNotFoundException {
        JsonResourceResolver.getResource("/resources/withoutOpeningBracket.json");
    }
}