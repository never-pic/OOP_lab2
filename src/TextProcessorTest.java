import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TextProcessorTest {

    private final TextProcessor processor = new TextProcessor();

    @Test
    void testProcessTextStandardCase() {
        String input = "Hello world. This is a test string.";
        char start = 't';
        char end = 's';
        StringBuilder result = processor.processText(input, start, end);
        assertFalse(result.toString().contains("This is a tes"));
    }

    @Test
    void testNoSubstringFound() {
        String input = "Simple sentence.";
        char start = 'z';
        char end = 'x';
        StringBuilder result = processor.processText(input, start, end);
        assertEquals(input, result.toString());
    }

    @Test
    void testEmptyInputThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            processor.processText("", 'a', 'b');
        });
    }

    @Test
    void testSingleCharacterSubstring() {
        String input = "Apple.";
        char start = 'p';
        char end = 'p';
        StringBuilder result = processor.processText(input, start, end);
        assertEquals("Ale.", result.toString());
    }
}