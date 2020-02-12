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

public class contactsApplication {

    static private List<Contact> contactsList;
    static private Scanner scanner = new Scanner(System.in);
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
//        contactsList = new ArrayList<>();
//        contactsList.add(person);
//        for (Object contact : contactsList){
//            System.out.println(contact);
//        }
        try {
            Path contactsPATH = Paths.get("data", "contacts.txt");
            List<String> newPerson = Arrays.asList(person.getName() + " " + person.getNumber());
            Files.write(contactsPATH, newPerson, StandardOpenOption.APPEND);
//
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    static void readWriteFile(){
        List<String> contactsList = null;

        try{
            Path contact = Paths.get("data", "contacts.txt");

            contactsList = Files.readAllLines(contact);
            for(String line : contactsList){
                System.out.println(line);
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }

        try{
            Path contact = Paths.get("data", "contact.txt");
            Files.write(contact, contactsList);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    public static void searchString(String userInput){

        Path contact = Paths.get("data","contacts.txt");
        List<String> PersonList;
        try{
            PersonList = Files.readAllLines(contact);
            for(String person : PersonList){
                if(person.toLowerCase().contains(userInput.toLowerCase())){
                    System.out.println("Contact: " + person + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteString(String input){

        Path contact = Paths.get("data","contacts.txt");
        List<String> PersonList;
//        List<String> toRemove = new ArrayList<>();
        try{
            PersonList = Files.readAllLines(contact);
            for(String person : PersonList){
                if(person.toLowerCase().contains(input.toLowerCase())){
//                    int index = PersonList.indexOf(person);
                    PersonList.remove(input);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            readWriteFile();
            System.out.println("\nWould you like to select another option?\n");
            boolean confirm = userInput.yesNo();
            if (confirm) {
                doStuff();
            } else {
                System.out.println("\nGoodbye, and have a wonderful day!");
            }
        } else if (option == 2) {
            System.out.println("Enter the name of your new contact: ");
            Scanner scanner2 = new Scanner(System.in);
            String userInputName = scanner2.nextLine();
            System.out.println("Enter a number");
            Scanner scanner3 = new Scanner(System.in);
            String userInputNumber = scanner3.nextLine();
            Contact person = new Contact(userInputName, userInputNumber);
            writeFile(person);
            System.out.println("\nYou've successfully added your new contact!\n");
            System.out.println("\nWould you like to select another option?\n");
            boolean confirm = userInput.yesNo();
            if (confirm) {
                doStuff();
            } else {
                System.out.println("\nGoodbye, and have a wonderful day!");
            }
        } else if (option == 3) {
            System.out.println("Enter a name to search:");
            Scanner scanner4 = new Scanner(System.in);
            String name = scanner4.nextLine();
            searchString(name);
            System.out.println("\nWould you like to select another option?\n");
            boolean confirm = userInput.yesNo();
            if (confirm) {
                doStuff();
            } else {
                System.out.println("\nGoodbye, and have a wonderful day!");
            }
        } else if (option == 4) {
            System.out.println("Enter the name of the contact you want to delete: ");
            Scanner scanner5 = new Scanner(System.in);
            String name = scanner5.nextLine();
            deleteString(name);
            System.out.println("\nThe contact was successfully deleted!\n");
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

    public static void main(String[] args) {
        doStuff();
    }

}
