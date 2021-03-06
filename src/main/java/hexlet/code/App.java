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

    @Option(names = {"-f", "--format"}, description = " output format: stylish, json [default: stylish]")
    private String format;

    @Override
    public Integer call() throws Exception { // your business logic goes here...
        System.out.println(Differ.generate(filepath1, filepath2));
        return 0;
    }

    // this example implements Callable, so parsing, error handling and handling user
    // requests for usage help or version help can be done with one line of code.
    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}

