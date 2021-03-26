import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FixLogFinder {
    public void getLogs(String fileName, String fixTag) {
        File file = new File(fileName);

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(fixTag)) {
                    System.out.print(line);
                    // Since the rest of the log is on the next line, we advance the scanner
                    // forward by one line and print it out.
                    line = scanner.nextLine();
                    System.out.print(" " + line + "\n");
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " was not found.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FixLogFinder logFinder = new FixLogFinder();
        logFinder.getLogs("test4.txt", "052");
    }
}
