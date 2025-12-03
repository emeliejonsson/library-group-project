import java.util.Random;

public class User
{
    private String name;
    private String userID;

    public User(String name)
    {

        if (hasValidName(name))
        {
            this.userID = idGenerator();
            this.name = name;
        }
        else
        {
            throw new IllegalArgumentException("Invalid name.");
        }
    }

    @Override
    public String toString()
    {
        return "User " + name + '\'' + ", userID= " + userID + '\'';
    }

    public String getUserID()
    {
        return userID;
    }

    public String getName()
    {
        return name;
    }

    public String idGenerator()
    {

        int length = 10;
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        int slump;
        for (int i = 0; i < length; i++)
        {
            slump = random.nextInt(10);
            sb.append(slump);
        }
        return sb.toString();
    }

    public boolean hasValidName(String name)
    {
        name = name.strip();
        if (name.matches(".*\\d.*")
            || name.isEmpty())
        {
            return false;

        }
        return true;
    }

}
