package ContactsManagerProject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ContactsManager {

    /*** Change the path ***/
    final static String outputFilePath = "/Users/macuser/IdeaProjects/Contacts-Manager-Project/data/contacts.txt";

//    static List<String> contacts = new ArrayList<>();
    static HashMap<String, Contact> Contacts = new HashMap<>();
//    static Input userInput = new Input();

    public static void main(String[] args) {

        Contacts.put("Briana", new Contact("Briana V", 1231231234));
        Contacts.put("Matthew", new Contact("Matthew H", 1231231235));
        Contacts.put("Nicole", new Contact("Nicole B", 1231231236));
        Contacts.put("Ryan", new Contact("Ryan M", 1231231237));

//        newFile();
//        writeFile();
//          readFile();
//          menu();
//        readWriteFile();
        writeFile();
//        doStuff();
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

//    static void writeFile() {
//        List<String> contacts = new ArrayList<>();
//        contacts.add("Briana");contacts.add("Matthew");contacts.add("Nicole");contacts.add("Ryan");
//        for (String con : contacts){
//            System.out.println(con);
//        }
//        try {
//            Path list = Paths.get("data", "contacts.txt");
//            Files.write(list, contacts);
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
//    }

    static void writeFile() {

        //new file object
        File file = new File(outputFilePath);
        BufferedWriter bf = null;

        try{

            //create new BufferedWriter for the output file
            bf = new BufferedWriter( new FileWriter(file) );

            //iterate map entries
            for(Map.Entry<String, Contact> entry : Contacts.entrySet()){

                //put key and value separated by a colon
                bf.write( entry.getKey() + ":" + entry.getValue().getNumber() );

                //new line
                bf.newLine();
            }

            bf.flush();

        }catch(IOException e){
            e.printStackTrace();
        }finally{

            try{
                //always close the writer
                bf.close();
            } catch (Exception ignored){}
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

    static void menu(){
        System.out.println("1. View contacts.");
        System.out.println("2. Add a new contact.");
        System.out.println("3. Search a contact by name.");
        System.out.println("4. Delete an existing contact.");
        System.out.println("5. Exit.");
        System.out.println("Enter an option (1, 2, 3, 4 or 5):");
    }


//    static void doStuff() {
//        System.out.println("Welcome!\n");
//        System.out.println("Here are your menu options for your contacts: \n");
//        System.out.println("1. View contacts." + "\n" + "3. Search a contact by name." + "\n" + "4. Delete an existing contact." + "\n" + "5. Exit." + "\n" + "Enter an option (1, 2, 3, 4 or 5):");
////        System.out.println(Contacts.keySet() + "\n");
//        Scanner scanner = new Scanner(System.in);
//        String option = scanner.next();
//        if (!contacts) {
//            System.out.println("Sorry, no student found with the GitHub username of " + "\"" + option + "\"." + "\n");
//            System.out.println("\nWould you like to see another student?\n");
//            boolean confirm = userInput.yesNo();
//            if (confirm) {
//                doStuff();
//            } else {
//                System.out.println("Goodbye, and have a wonderful day!");
//            }
//        } else if (Contacts.containsKey(option)) {
//            System.out.printf("\nName: %S - GitHub Username: %S - Current Average: %f\n", Contacts.get(option).getName(), option, Contacts.get(option).getGradeAverage());
//            System.out.println("\nWould you like to see another student?\n");
//            boolean confirm = userInput.yesNo();
//            if (confirm) {
//                doStuff();
//            } else {
//                System.out.println("Goodbye, and have a wonderful day!");
//            }
//        }
//    }

}
