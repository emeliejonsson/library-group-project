

public class User {
    private String name;
    private final String userID;
    private final UserStatus status;

public class User
{
	private String name;
	private final String userID;

	public User(String name)
	{

		this.name = name;
		this.userID = IdGenerator.generateID();


            this.status = UserStatus.ACTIVE;

        }


	@Override
	public String toString()
	{
		return "User " + name + '\'' + ", userID= " + userID + '\'' + "";
	}

	public String getUserID()
	{
		return userID;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

}
