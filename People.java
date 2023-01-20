public class People {
    private String firstName;
    private String lastName;

    People(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    // public String getLastName() {
    //     return lastName;
    // }

    // public void showInfo() {
    //     System.out.printf("First name: %s\nLast name: %s\n", this.firstName, this.lastName);
    // }
}
