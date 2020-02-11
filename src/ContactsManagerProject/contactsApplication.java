package ContactsManagerProject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import util.Input;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

public class contactsApplication {

    static private List<Contact> contactsList = new ArrayList<>();
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

    public static void writeFile(Contact person) {
        contactsList.add(person);
//        for (Object contact : contactsList){
//            System.out.println(contact);
//        }
        try {
            Path contactsPATH = Paths.get("data", "contacts.txt");
            Files.write(contactsPATH, Arrays.asList(convertString(contactsList)), StandardOpenOption.APPEND);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void readFile() {
        try {
            Path contactsFile = Paths.get("data", "contacts.txt");
            List<String> contactLines = Files.readAllLines(contactsFile);
            for (String line : contactLines) {
                System.out.println(line);
                contactsList.add(new Contact())
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void addContact() {
        System.out.print("Input your new contact's information: ");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        try {
            Path contacts = Paths.get("data", "contacts.txt");
            Files.writeString(contacts, option, StandardOpenOption.APPEND);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void removeContact() {
        System.out.println("\nHere is the current contacts list for your reference: \n");
        readFile();
        System.out.println("\nEnter the name of the contact you want to remove: \n");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        contactsList.remove(option);
    }

    public static void search() {
        List<String> filteredNames = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String option;
        System.out.println("\nEnter the name of the contact you want to search: \n");
        option = scanner.nextLine();
        for (int i = 0; i < contactsList.size(); i++) {
            if (contactsList.get(i).getName().contains(option)) {
                filteredNames.add(contactsList.get(i).getName());
            }
        }
        System.out.println(filteredNames);
    }

//    public Customer findUsingEnhancedForLoop(
//            String name, List<Customer> customers) {
//
//        for (Customer customer : customers) {
//            if (customer.getName().equals(name)) {
//                return customer;
//            }
//        }
//        return null;
//    }

//    public Object findUsingEnhancedForLoop (String name, List<Object> contactsList) {
//
//        for (Object person : contactsList) {
//            if (person.getName().equals(name)) {
//                return person;
//            }
//        }
//        return null;
//    }

    public static String[] convertString(List<Contact> item){
        String[] array = new String[item.size()];
        int index = 0;
        for (Contact value : item) {
            array[index] = value.getName();
            index++;
        }
        return array;
    }

    public static void doStuff() {

        System.out.println("\nWelcome!\n");
        System.out.println("Here are your menu options for your contacts: \n");
        System.out.println("1. View contacts." + "\n" + "2. Add a new contact." + "\n" + "3. Search a contact by name." + "\n" + "4. Delete an existing contact." + "\n" + "5. Exit.\n" + "\n" + "Enter an option (1, 2, 3, 4 or 5):");
        Scanner scanner = new Scanner(System.in);
        Integer option = Integer.valueOf(scanner.next());
        if (option < 1 || option > 5) {
            System.out.println("Sorry, that is not a valid option.\n");
            System.out.println("Would you like to try again?\n");
            boolean confirm = userInput.yesNo();
            if (confirm) {
                doStuff();
            } else {
                System.out.println("\nGoodbye, and have a wonderful day!");
            }
        } else if (option == 1) {
            System.out.println("\nYour Contacts:\n");
            readFile();
            System.out.println("\nWould you like to select another option?\n");
            boolean confirm = userInput.yesNo();
            if (confirm) {
                doStuff();
            } else {
                System.out.println("\nGoodbye, and have a wonderful day!");
            }
        } else if (option == 2) {
            addContact();
            System.out.println("\nWould you like to select another option?\n");
            boolean confirm = userInput.yesNo();
            if (confirm) {
                doStuff();
            } else {
                System.out.println("\nGoodbye, and have a wonderful day!");
            }
        } else if (option == 3) {
            search();
        } else if (option == 4) {
            removeContact();
            System.out.println("\nWould you like to select another option?\n");
            boolean confirm = userInput.yesNo();
            if (confirm) {
                doStuff();
            } else {
                System.out.println("\nGoodbye, and have a wonderful day!");
            }
        } else if (option == 5) {
            System.out.println("\nGoodbye, and have a wonderful day!");
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
//        System.out.println(contactsList);
        doStuff();
    }

}
