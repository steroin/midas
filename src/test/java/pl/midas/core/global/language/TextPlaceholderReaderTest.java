package pl.midas.core.global.language;

import org.junit.Test;
import pl.midas.core.global.language.exception.PlaceholderNotFoundException;

import static org.junit.Assert.*;

public class TextPlaceholderReaderTest {

    @Test
    public void readPlaceholderValid() {
        assertEquals("exampleText", TextPlaceholderReader.readPlaceholder("en", "editor",
                "examplePlaceholders.examplePlaceholder"));
        assertEquals("anotherExampleText", TextPlaceholderReader.readPlaceholder("en", "editor",
                "examplePlaceholders.anotherExamplePlaceholder"));
        assertEquals("exampleNestedText", TextPlaceholderReader.readPlaceholder("en", "editor",
                "examplePlaceholders.nestedExamplePlaceholder.exampleNest"));
        assertEquals("exampleDeeperNestedText", TextPlaceholderReader.readPlaceholder("en", "editor",
                "examplePlaceholders.nestedExamplePlaceholder.deeperNest.deeperNestedExampleNest"));
    }

    @Test
    public void readPlaceholderValidWithSubdirectory() {
        assertEquals("exampleText", TextPlaceholderReader.readPlaceholder("en", "editor/subdirectory",
                "examplePlaceholders.examplePlaceholder"));
        assertEquals("anotherExampleText", TextPlaceholderReader.readPlaceholder("en", "editor/subdirectory",
                "examplePlaceholders.anotherExamplePlaceholder"));
        assertEquals("exampleNestedText", TextPlaceholderReader.readPlaceholder("en", "editor/subdirectory",
                "examplePlaceholders.nestedExamplePlaceholder.exampleNest"));
        assertEquals("exampleDeeperNestedText", TextPlaceholderReader.readPlaceholder("en", "editor/subdirectory",
                "examplePlaceholders.nestedExamplePlaceholder.deeperNest.deeperNestedExampleNest"));
    }

    @Test(expected = PlaceholderNotFoundException.class)
    public void readPlaceholderNotFound() {
        TextPlaceholderReader.readPlaceholder("en", "editor","examplePlaceholders.nonExistingPlaceholder");
    }

    @Test(expected = PlaceholderNotFoundException.class)
    public void readPlaceholderInvalidPath() {
        TextPlaceholderReader.readPlaceholder("en", "editor/subdirectory/idontexist",
                "examplePlaceholders.examplePlaceholder");
    }
}