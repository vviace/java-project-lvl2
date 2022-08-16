package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;
public class AppTest {
    private static String resultJson;
    private static String resultPlain;
    private static String resultStylish;

    private static String jsonPath1;
    private static String jsonPath2;
    private static String ymlPath1;
    private static String ymlPath2;
    // 8 tests BEFORE ALL 3 //
    @BeforeAll
    public static void init() throws IOException {
        resultJson = Files.readString(Path.of("src/test/resources/JsonResult"));
        resultPlain = Files.readString(Path.of("src/test/resources/PlainResult"));
        resultStylish = Files.readString(Path.of("src/test/resources/StylishResult"));

        jsonPath1 = "src/test/resources/file1.json";
        jsonPath2 = "src/test/resources/file2.json";
        ymlPath1 = "src/test/resources/file1.yml";
        ymlPath2 = "src/test/resources/file2.yml";
    }

    @Test
    public void testYmlDefault() throws Exception {
        String actual = Differ.generate(ymlPath1, ymlPath2, "");
        assertThat(actual).isEqualTo(resultStylish);
    }
    @Test
    public void testJsonDefault() throws Exception {
        String actual = Differ.generate(jsonPath1, jsonPath2, "");
        assertThat(actual).isEqualTo(resultStylish);
    }
    @Test
    public void testJsonStylish() throws Exception {
        String actual = Differ.generate(jsonPath1, jsonPath2, "stylish");
        assertThat(actual).isEqualTo(resultStylish);
    }
    @Test
    public void testYmlStylish() throws Exception {
        String actual = Differ.generate(ymlPath1, ymlPath2, "stylish");
        assertThat(actual).isEqualTo(resultStylish);
    }
    @Test
    public void testJsonPlain() throws Exception {
        String actual = Differ.generate(jsonPath1, jsonPath2, "plain");
        assertThat(actual).isEqualTo(resultPlain);
    }
    @Test
    public void testYmlPlain() throws Exception {
        String actual = Differ.generate(ymlPath1, ymlPath2, "plain");
        assertThat(actual).isEqualTo(resultPlain);
    }
    @Test
    public void testJson() throws Exception {
        String actual = Differ.generate(jsonPath1, jsonPath2, "json");
        assertThat(actual).isEqualTo(resultJson);
    }
    @Test
    public void testYmlJson() throws Exception {
        String expected = Files.readString(Path.of("src/test/resources/JsonResult"));
        String actual = Differ.generate(ymlPath1, ymlPath2, "json");
        assertThat(actual).isEqualTo(resultJson);
    }

}
