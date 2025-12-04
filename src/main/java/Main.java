import java.util.Scanner;
public class Main
{
	public static void main(String[] args)
	{
		Book book = new Book("hej", "göran", "129391239", 12);
		Book book1 = new Book("korv", "göran", "121239", 1);
		Book book2 = new Book("apa", "göran", "12939133239", 6);
		Book book3 = new Book("ram", "göran", "1291239", 3);
		Book book4 = new Book("cpu", "göran", "1293912", 1);
		Book book5 = new Book("gpu", "göran", "29391239", 5);
		Library library = new Library();
		library.addBook(book);
		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		library.addBook(book4);
		library.addBook(book5);

		Scanner input = new Scanner(System.in);
		int loanId = 1;
		while (true)
		{
			System.out.printf("""
			                  Meny
			                    1. Registrera användare
			                    2. Låna bok
			                    3. Kolla utlånade böcker
			                    3. Visa böcker
			                    4. Admin-meny
			                    0. Lämna
			                  """);
			int choice = input.nextInt();
			switch (choice)
			{
				case 0 ->
				{
					System.out.println("Hejdå!");
					break;
				}
				case 1 ->
				{
					System.out.println("Skriv in ditt namn");
					String name = input.nextLine();
					User user = new User(name);
				}
				case 2 ->
				{
					System.out.println("Skriv in boken du vill låna");
					
				}
				case 3 ->
				{

				}
				case 4 ->
				{

				}
				default ->
				{
					System.out.println("Använd 0-4 för att göra valen");
				}
			}
		}
	}
}

