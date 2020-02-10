import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ContactsManager {

    public static void main(String[] args) {
        newFile();
        writeFile();
//        readWriteFile();
    }

    static void newFile() {
        String directory = "data";

        String filename = "contacts.txt";

        Path dataDirectory = Paths.get(directory);
        System.out.println(dataDirectory.toAbsolutePath());
        Path dataFile = Paths.get(directory, filename);

        try {
            if (Files.notExists(dataDirectory)) {
                Files.createDirectories(dataDirectory);
                System.out.println("Created Directory");
            }
            if (!Files.exists(dataFile)) {
                Files.createFile(dataFile);
                System.out.println("Created File");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    static void writeFile() {
        List<String> contacts = new ArrayList<>();
        contacts.add("Briana");contacts.add("Matthew");contacts.add("Nicole");contacts.add("Ryan");
        for (String con : contacts){
            System.out.println(con);
        }
        try {
            Path list = Paths.get("data", "contacts.txt");
            Files.write(list, contacts);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    static void readFile(){
        try {
            Path contactFile = Paths.get("data", "contacts.txt");
            List<String> contactLines = Files.readAllLines(contactFile);
            for (String line : contactLines) {
                System.out.println(line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }



}
