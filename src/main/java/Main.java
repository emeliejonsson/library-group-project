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
		String exit = "\u001B[3mKlicka en knapp för att lämna\u001B[0m";
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
					}
					else
					{
						System.out.println(
								"Skriv in titeln på boken du vill låna");
						String title = input.nextLine();
						Book bookBorrow = library.findBook(title);
						loan = new Loan(loanId, user, bookBorrow);
						loanId++;
						System.out.println(loan.toString());
					}
					System.out.println();
					System.out.println(exit);
					input.nextLine();
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
					System.out.println(exit);
					input.nextLine();
				}
				case 4 ->
				{
					for (Book books : library.getBooksList())
					{
						System.out.println("Titel: " + books.getTitle());
					}
					System.out.println();
					System.out.println(exit);
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
								System.out.println(exit);
								input.nextLine();
							}
							case 2 ->
							{
								System.out.println(
										"Skriv in titeln på boken du vill ta bort");
								String removeTitle = input.nextLine();
								System.out.println("Välj anledningen nedan");
								System.out.printf("""
								                  1. Skadad
								                  2. Saknas
								                  3. Gammal upplaga
								                  """);
								int choiceRemove = input.nextInt();
								input.nextLine();
								ReasonForRemoval removalReason = null;
								switch (choiceRemove)
								{
									case 1 ->
									{
										removalReason = ReasonForRemoval.DAMAGED;
									}
									case 2 ->
									{
										removalReason = ReasonForRemoval.LOST;
									}
									case 3 ->
									{
										removalReason = ReasonForRemoval.OUTDATED;
									}
									default ->
									{
										System.out.println(
												"Använd 1-3 för att göra val");
										System.out.println();
										System.out.println(exit);
										input.nextLine();
									}
								}
								library.removeBook(removeTitle, removalReason);
								System.out.println();
								System.out.println(exit);
								input.nextLine();
							}
							default ->
							{
								System.out.println(
										"Använd 0-2 för att göra val");
								System.out.println();
								System.out.println(exit);
								input.nextLine();
							}
						}
					}
				}
				default ->
				{
					System.out.println();
					System.out.println("Använd 0-4 för att göra val");
					System.out.println();
				}
			}
		}
	}
}

