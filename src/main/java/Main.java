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
		Loan loan = null;
		User user = null;
		int choice = -1;
		while (choice != 0)
		{
			System.out.printf("""
			                  Meny
			                    1. Registrera användare
			                    2. Låna bok
			                    3. Kolla utlånade böcker
			                    4. Visa böcker
			                    5. Admin-meny
			                    0. Lämna
			                  """);
			choice = input.nextInt();
			input.nextLine();
			switch (choice)
			{
				case 0 ->
				{
					System.out.println("Hejdå!");
				}
				case 1 ->
				{
					System.out.println("Skriv in ditt namn");
					String name = input.nextLine();
					user = new User(name);
				}
				case 2 ->
				{
					if (user == null)
					{
						System.out.println("Du måste skapa en användare först");
						System.out.println();
						System.out.println(
								"\u001B[3mKlicka en knapp för att lämna\u001B[0m");
						input.nextLine();
					}
					else
					{
						System.out.println(
								"Skriv in titeln på boken du vill låna");
						String title = input.nextLine();
						Book bookBorrow = library.findBook(title);
						loan = new Loan(loanId, user, bookBorrow);
						loanId++;
					}
				}
				case 3 ->
				{
					if (loan == null)
					{
						System.out.println("Det finns inga lån");
					}
					else
					{
						System.out.println(loan.toString());
					}
					System.out.println();
					System.out.println(
							"\u001B[3mKlicka en knapp för att lämna\u001B[0m");
					input.nextLine();
				}
				case 4 ->
				{
					for (Book books : library.getBooksList())
					{
						System.out.println("Titel: " + books.getTitle());
					}
					System.out.println();
					System.out.println(
							"\u001B[3mKlicka en knapp för att lämna\u001B[0m");
					input.nextLine();
				}
				case 5 ->
				{
					int choiceAdmin = -1;
					while (choiceAdmin != 0)
					{
						System.out.printf("""
						                  -Admin Meny-
						                    1. Lägg till bok
						                    2. Ta bort bok
						                    0. Lämna
						                  """);
						choiceAdmin = input.nextInt();
						input.nextLine();
						switch (choiceAdmin)
						{
							case 0 ->
							{
								break;
							}
							case 1 ->
							{
								System.out.println("Skriv titeln");
								String bookTitle = input.nextLine();
								System.out.println("Skriv författaren");
								String bookAuthor = input.nextLine();
								System.out.println("Skriv ISBN");
								String bookIsbn = input.nextLine();
								library.addBook(new Book(bookTitle, bookAuthor,
								                         bookIsbn, 1));
								System.out.println();
								System.out.println(
										"\u001B[3mKlicka en knapp för att lämna\u001B[0m");
								input.nextLine();
							}
							default ->
							{
								System.out.println(
										"Använd 0-2 för att göra val");
								System.out.println();
								System.out.println(
										"\u001B[3mKlicka en knapp för att lämna\u001B[0m");
								input.nextLine();
							}
						}
					}
				}
				default ->
				{
					System.out.println("Använd 0-4 för att göra val");
					System.out.println();
					System.out.println(
							"\u001B[3mKlicka en knapp för att lämna\u001B[0m");
					input.nextLine();
				}
			}
		}
	}
}

