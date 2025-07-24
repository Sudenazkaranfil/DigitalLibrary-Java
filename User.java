// Inheritance
public class User extends Person {
    private String userName;
    private String password;

    // Constructor
    public User(int id, String firstName, String lastName, int age, String userName, String password) {
        // to call the superclass constructor (Person)
        super(id, firstName, lastName, age);
        this.userName = userName;
        this.password = password;
    }

    // Getter methods
    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }

    // Setter methods
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", age=" + getAge() +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
