

public class User {
    private String name;
    private final String userID;
    private final UserStatus status;

    public User(String name) {

        if (Validate.hasValidName(name)) {
            this.name = name;

            this.userID = IdGenerator.generateID()

            this.status = UserStatus.ACTIVE;

        } else {
            throw new IllegalArgumentException("Invalid name.");
        }

    }


    @Override
    public String toString() {
        return "User " +
                name + '\'' +
                ", userID= " + userID + '\''
                + "";
    }

    public String getUserID() {
        return userID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
