import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Shell {

    /**
     * Exec a command.
     * @param command to execute.
     * @param dir the directory in which execute command. If null is the working directory.
     * @return String the command output.
     * @throws IllegalArgumentException if command is null.
     */
    public static String exec(String command, File dir) {
        StringBuilder output = new StringBuilder();

        Process p;
        try {
            p = Runtime.getRuntime().exec(command, null, dir);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line;
            while ((line = reader.readLine())!= null)
                output.append(line).append("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();
    }

    /**
     * Exec a command.
     * @param command to execute.
     * @param directory the directory in which execute command. If null is the working directory.
     * @return String the command output.
     * @throws IllegalArgumentException if command is null.
     * @throws NullPointerException if directory is null.
     */
    public static String exec(String command, String directory) {
        File dir = new File(directory);
        return exec(command, dir);
    }

    /**
     * Exec a command.
     * @param command to execute.
     * @return String the command output.
     * @throws IllegalArgumentException if command is null.
     */
    public static String exec(String command) {
        return exec(command, (File) null);
    }

}