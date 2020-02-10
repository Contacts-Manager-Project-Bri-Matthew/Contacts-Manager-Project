package ContactsManagerProject;

import java.util.ArrayList;

public class Contact {
    //Properties
    private String name;
    private Long number;
    private ArrayList<Long> numbers;

    public Contact(String name, long number) {
        this.name = name;
        this.numbers = new ArrayList<>();
        this.numbers.add(number);
    }

    public String getName() {
        return name;
    }

//    public void addNumber(long number){
//        this.numbers.add((number));
//    }

    public ArrayList<Long> getNumbers() {
        return this.numbers;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getNumber() {
        return this.number;
    }

    public static void main(String[] args) {
//        ContactsManagerProject.Contact contact1 = new ContactsManagerProject.Contact("Matthew", 100);
//        System.out.println(contact1.getName());
//        System.out.println(contact1.getNumbers());
    }
}
