/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.util.concurrent.Callable;

@Command(name = "gendiff",
        description = "Compares two configuration files and shows a difference.")
class App implements Callable<Integer> {
    @Parameters(index = "0", description = " path to first file")
    private String filepath1;

    @Parameters(index = "1", description = " path to second file")
    private String filepath2;

    @Option(names = {"-h", "--help"}, description = " Show this help message and exit.", usageHelp = true)
    private boolean help;

    @Option(names = {"-V", "--version"}, description = " Print version information and exit.")
    private String version;

    @Option(names = {"-f", "--format"},
            description = " output format: stylish, plain, json. Default format: ${DEFAULT-VALUE}",
            defaultValue = "stylish")
    private String format;

    @Override
    public Integer call() throws Exception {
        try {
            System.out.println(Differ.generate(filepath1, filepath2, format));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 1;
        }
        return 0;
    }
    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}

