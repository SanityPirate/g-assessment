import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LogFinder {
    public void getLogs(String fileName) {
        File file = new File(fileName);

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.toUpperCase().contains("[WARN]") || line.toUpperCase().contains("[ERROR]")
                        || line.toUpperCase().contains("[FATAL]")) {
                    System.out.println(line);
                }
            }
        } catch(FileNotFoundException e) {
            System.out.println("File " + fileName + " was not found.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LogFinder logFinder = new LogFinder();
        logFinder.getLogs("gelber_ops.log");
    }
}