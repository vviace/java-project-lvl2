package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;
public class AppTest {
    @Test
    public void testDifferJson() throws Exception {
        String expected = Files.readString(Path.of("src/test/resources/StylishResult"));
        String actual = Differ.generate("src/test/resources/file1.json", "src/test/resources/file2.json");
        assertThat(actual).isEqualTo(expected);

    }
}
