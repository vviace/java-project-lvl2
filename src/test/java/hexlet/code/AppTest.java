package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.assertj.core.api.Assertions.assertThat;

public final class AppTest {
    private static String resultJson;
    private static String resultPlain;
    private static String resultStylish;
    private static final String PATH = "src/test/resources/";

    @BeforeAll
    public static void init() throws IOException {
        resultJson = Files.readString(Path.of("src/test/resources/JsonResult"));
        resultPlain = Files.readString(Path.of("src/test/resources/PlainResult"));
        resultStylish = Files.readString(Path.of("src/test/resources/StylishResult"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void test(String format) throws Exception {
        String file1 = PATH + "file1." + format;
        String file2 = PATH + "file2." + format;

        String defaultFormat = Differ.generate(file1, file2);
        assertThat(defaultFormat).isEqualTo(resultStylish);

        String stylishFormat = Differ.generate(file1, file2, "stylish");
        assertThat(stylishFormat).isEqualTo(resultStylish);

        String plainFormat = Differ.generate(file1, file2, "plain");
        assertThat(plainFormat).isEqualTo(resultPlain);

        String jsonFormat = Differ.generate(file1, file2, "json");
        assertThat(jsonFormat).isEqualTo(resultJson);
    }
}
