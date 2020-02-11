package ContactsManagerProject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import util.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class contactsApplication {

    static private List<Object> contactsList;
    static Input userInput = new Input();


    public static void newFile() {
        String directory = "data";
        String filename = "contacts.txt";
        Path dataDirectory = Paths.get(directory);
        System.out.println(dataDirectory.toAbsolutePath());
        Path dataFile = Paths.get(directory, filename);
        try {
            if (Files.notExists(dataDirectory)) {
                Files.createDirectories(dataDirectory);
                System.out.println("created directory");
            }
            if (!Files.exists(dataFile)) {
                Files.createFile(dataFile);
                System.out.println("Created file");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void writeFile(Object person) {
        contactsList = new ArrayList<>();
        contactsList.add(person);
        for (Object contact : contactsList){
            System.out.println(contact);
        }
        try {
            Path contactsPATH = Paths.get("data", "contacts.txt");
            Files.write(contactsPATH, Arrays.asList(convertString(contactsList)), StandardOpenOption.APPEND);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void readFile(){
        try {
            Path contactsFile = Paths.get("data", "contacts.txt");
            List<String> contactLines = Files.readAllLines(contactsFile);
            for (String line : contactLines) {
                System.out.println(line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static String[] convertString(List<Object> item){
        String[] array = new String[item.size()];
        int index = 0;
        for (Object value : item) {
            array[index] = (String) value;
            index++;
        }
        return array;
    }

//    public static void menu() {
//        System.out.println("1. View contacts.");
//        System.out.println("2. Add a new contact.");
//        System.out.println("3. Search a contact by name.");
//        System.out.println("4. Delete an existing contact.");
//        System.out.println("5. Exit.");
//        System.out.println("Enter an option (1, 2, 3, 4 or 5):");
//    }

    public static void doStuff() {
        System.out.println("Welcome!\n");
        System.out.println("Here are your menu options for your contacts: \n");
        System.out.println("1. View contacts." + "\n" + "2. Add a new contact." + "\n" + "3. Search a contact by name." + "\n" + "4. Delete an existing contact." + "\n" + "5. Exit." + "\n" + "Enter an option (1, 2, 3, 4 or 5):");
//        System.out.println(Contacts.keySet() + "\n");
        Scanner scanner = new Scanner(System.in);
        Integer option = Integer.valueOf(scanner.next());
        if (option < 1 || option > 5) {
            System.out.println("Sorry, that is not a valid option.\n");
            System.out.println("Would you like to try again?\n");
            boolean confirm = userInput.yesNo();
            if (confirm) {
                doStuff();
            } else {
                System.out.println("Goodbye, and have a wonderful day!");
            }
        } else if (option == 1) {
            readFile();
            System.out.println("\nWould you like to select another option?\n");
            boolean confirm = userInput.yesNo();
            if (confirm) {
                doStuff();
            } else {
                System.out.println("Goodbye, and have a wonderful day!");
            }
        }
    }

    //    static void readWriteFile(){
//        List<String> contactsList = null;
//
//        try{
//            Path contact = Paths.get("data", "contacts.txt");
//            contactsList = Files.readAllLines(contact);
//            for(String line : contactsList){
//                System.out.println(line);
//            }
//        }catch(IOException ioe){
//            ioe.printStackTrace();
//        }
//
//        contactsList.add("kiwi"); contactsList.add("jackfruit");
//
//        try{
//            Path contact = Paths.get("data", "contact.txt");
//            Files.write(contact, contactsList);
//        }catch(IOException ioe){
//            ioe.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
//        newFile();
        Contact person1 = new Contact("Briana", "775-313-5602");
        Contact person2 = new Contact("Matthew", "876-978-7854");
        writeFile(person1.getName() + " " + person1.getNumber());
        writeFile(person2.getName() + " " + person2.getNumber());
        doStuff();
    }
}
