package ContactsManagerProject;

public class Contact {
    //Properties
    private String name;
    private String number;

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    /* Getters */
    public String getName() {
        return String.format("%-8s |", this.name + "");
    }

    public String getNumber() {
        return String.format("%-12s |", this.number + "");
    }

    /* Setters */
    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
