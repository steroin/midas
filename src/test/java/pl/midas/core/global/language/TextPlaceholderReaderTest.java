package pl.midas.core.global.language;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import pl.midas.core.global.language.exception.PlaceholderNotFoundException;
import pl.midas.core.global.settings.GlobalSettings;
import pl.midas.core.global.settings.GlobalSettingsConstants;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(GlobalSettings.class)
public class TextPlaceholderReaderTest {

    @Before
    public void setup() {
        PowerMockito.mockStatic(GlobalSettings.class);
        when(GlobalSettings.getSetting(GlobalSettingsConstants.LANGUAGE)).thenReturn("en");
    }

    @Test
    public void readPlaceholderValid() {
        assertEquals("exampleText", TextPlaceholderReader.readPlaceholder("editor",
                "examplePlaceholders.examplePlaceholder"));
        assertEquals("anotherExampleText", TextPlaceholderReader.readPlaceholder("editor",
                "examplePlaceholders.anotherExamplePlaceholder"));
        assertEquals("exampleNestedText", TextPlaceholderReader.readPlaceholder("editor",
                "examplePlaceholders.nestedExamplePlaceholder.exampleNest"));
        assertEquals("exampleDeeperNestedText", TextPlaceholderReader.readPlaceholder("editor",
                "examplePlaceholders.nestedExamplePlaceholder.deeperNest.deeperNestedExampleNest"));
    }

    @Test
    public void readPlaceholderValidWithSubdirectory() {
        assertEquals("exampleText", TextPlaceholderReader.readPlaceholder("editor/subdirectory",
                "examplePlaceholders.examplePlaceholder"));
        assertEquals("anotherExampleText", TextPlaceholderReader.readPlaceholder("editor/subdirectory",
                "examplePlaceholders.anotherExamplePlaceholder"));
        assertEquals("exampleNestedText", TextPlaceholderReader.readPlaceholder("editor/subdirectory",
                "examplePlaceholders.nestedExamplePlaceholder.exampleNest"));
        assertEquals("exampleDeeperNestedText", TextPlaceholderReader.readPlaceholder("editor/subdirectory",
                "examplePlaceholders.nestedExamplePlaceholder.deeperNest.deeperNestedExampleNest"));
    }

    @Test(expected = PlaceholderNotFoundException.class)
    public void readPlaceholderNotFound() {
        TextPlaceholderReader.readPlaceholder("editor","examplePlaceholders.nonExistingPlaceholder");
    }

    @Test(expected = PlaceholderNotFoundException.class)
    public void readPlaceholderInvalidPath() {
        TextPlaceholderReader.readPlaceholder("editor/subdirectory/idontexist",
                "examplePlaceholders.examplePlaceholder");
    }
}