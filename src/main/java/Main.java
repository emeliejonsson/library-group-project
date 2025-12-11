import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("Game of Thrones", "Göran Andersson", "9781234000012", 12);
        Book book1 = new Book("Breaking Java", "Walter White", "9781234000013", 1);
        Book book2 = new Book("Göran", "Göran Svensson", "9781234000014", 6);
        Book book3 = new Book("Sopranos", "Tony Soprano", "9781234000015", 3);
        Book book4 = new Book("Whole Life 3", "Gabe Newell", "9781234000016", 1);
        Book book5 = new Book("League of Singed Inters", "Gustav Karlsson", "9781234000017", 5);
        Library library = new Library();
        library.addBook(book);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);

        cleanScreen();
        runLibrary(library);
    }

    private static void runLibrary(Library library) {
        try (Scanner input = new Scanner(System.in)) {
            int loanId;
            Loan loan = null;
            User user = null;
            int choice = -1;
            while (choice != 0) {
                loanId = ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE);
                printMenu();
                if (input.hasNextInt()) {
                    choice = input.nextInt();
                    input.nextLine();
                    switch (choice) {
                        case 0 -> {
                            cleanScreen();
                            System.out.println("Hejdå!");
                        }
                        case 1 -> {
                            user = createUser(input, user);
                        }
                        case 2 -> {
                            loan = newLoan(library, user, input, loan, loanId);
                        }
                        case 3 -> {
                            cleanScreen();
                            if (loan == null) {
                                System.out.println("Du har inga lån");
                            } else {
                                System.out.println(loan.toString());
                            }
                            System.out.println();
                            cursiveText("Klicka retur för att fortsätta");
                            input.nextLine();
                            cleanScreen();
                        }
                        case 4 -> {
                            cleanScreen();
                            listBooks(library);
                            cursiveText("Klicka retur för att fortsätta");
                            input.nextLine();
                            cleanScreen();
                        }
                        case 5 -> {
                            cleanScreen();
                            endLoan(loan, input);
                        }
                        case 6 -> {
                            adminMenu(library, input);
                        }
                        default -> {
                            cleanScreen();
                            cursiveText("Använd 0-5 för att göra val!");
                            System.out.println();
                        }
                    }
                } else {
                    cleanScreen();
                    cursiveText("Använd bara siffror när du gör val!");
                    System.out.println();
                    input.next();
                }
            }
        }
    }

    private static User createUser(Scanner input, User user) {
        cleanScreen();
        System.out.println("Skriv in ditt namn (Inga siffror)");
        String inputname = input.nextLine();
        if (hasValidName(inputname)) {
            user = new User(inputname);
            System.out.println();
            System.out.println("Välkommen " + inputname + " ditt ID är " + user.getUserID());
            System.out.println();
            cursiveText("Klicka retur för att fortsätta");
            input.nextLine();
            cleanScreen();
        } else {
            System.out.printf("Ingen användare skapat, var snäll och skriv in endast bokstäver");
            System.out.println();
            System.out.println();
            cursiveText("Klicka retur för att fortsätta");
            input.nextLine();
            cleanScreen();
        }
        return user;
    }

    private static Loan newLoan(Library library, User user, Scanner input, Loan loan, int loanId) {
        if (user == null) {
            cleanScreen();
            cursiveText("Du måste skapa en användare först!");
            System.out.println();
        } else {
            cleanScreen();
            listBooks(library);
            System.out.println("Skriv in titeln på boken du vill låna");
            String title = input.nextLine();
            if (title.isEmpty()) {
                cleanScreen();
                cursiveText("Du måste skriva en titel!");
                System.out.println();
            } else {
                Book bookBorrow = library.findBook(title);
                if (bookBorrow != null) {
                    loan = new Loan(loanId, user, bookBorrow);
                    cleanScreen();
                    System.out.println(loan.toString());
                }
                System.out.println();
                cursiveText("Klicka retur för att fortsätta");
                input.nextLine();
                cleanScreen();
            }
        }
        return loan;
    }

    private static void endLoan(Loan loan, Scanner input) {
        if (loan != null) {
            int choiceEndLoan = -1;
            while (choiceEndLoan != 0) {
                System.out.println(loan.toString());
                System.out.println();
                System.out.println("1. Avsluta ditt lån");
                System.out.println("0. Avbryt/Lämna");
                choiceEndLoan = input.nextInt();
                switch (choiceEndLoan) {
                    case 0 -> {
                        cleanScreen();
                        break;
                    }
                    case 1 -> {
                        loan.endLoan();
                        cleanScreen();
                    }
                    default -> {
                        cleanScreen();
                        System.out.println("Använd 0-1 för att göra val");
                        System.out.println();
                        cursiveText("Klicka retur för att fortsätta");
                        input.nextLine();
                        cleanScreen();
                    }
                }
            }
        } else {
            cleanScreen();
            cursiveText("Du har inga lån");
            System.out.println();
        }
    }

    private static void adminMenu(Library library, Scanner input) {
        int choiceAdmin = -1;
        cleanScreen();
        while (choiceAdmin != 0) {
            System.out.print("""
                    -Admin Meny-
                      1. Lägg till bok
                      2. Ta bort bok
                      3. Se gallrade böcker
                      0. Lämna
                    """);
            if (input.hasNextInt()) {
                choiceAdmin = input.nextInt();
                input.nextLine();
                switch (choiceAdmin) {
                    case 0 -> {
                        break;
                    }
                    case 1 -> {
                        cleanScreen();
                        createBook(library, input);
                    }
                    case 2 -> {
                        cleanScreen();
                        removeBook(library, input);
                    }
                    case 3 -> {
                        cleanScreen();
                        library.listRemovedBooks();
                        System.out.println();
                        cursiveText("Klicka retur för att fortsätta");
                        input.nextLine();
                    }
                    default -> {
                        cleanScreen();
                        System.out.println("Använd 0-2 för att göra val");
                        System.out.println();
                        cursiveText("Klicka retur för att fortsätta");
                        input.nextLine();
                        cleanScreen();
                    }
                }
            } else {
                cleanScreen();
                cursiveText("Använd bara siffror när du gör val!");
                System.out.println();
                input.next();
            }
        }
        cleanScreen();
    }

    private static void removeBook(Library library, Scanner input) {
        listBooks(library);
        System.out.println();
        System.out.println("Skriv in titeln på boken du vill ta bort");
        System.out.println();
        String removeTitle = input.nextLine();
        System.out.println();
        System.out.println("Välj anledningen nedan");
        System.out.print("""
                1. Skadad
                2. Saknas
                3. Gammal upplaga
                0. Avbryt
                """);
        if (input.hasNextInt()) {
            int choiceRemove = input.nextInt();
            input.nextLine();
            ReasonForRemoval removalReason = null;
            switch (choiceRemove) {
                case 0 -> {
                    cleanScreen();
                }
                case 1 -> {
                    cleanScreen();
                    removalReason = ReasonForRemoval.DAMAGED;
                    library.removeBook(removeTitle, removalReason);
                    System.out.println();
                    cursiveText("Klicka retur för att fortsätta");
                    input.nextLine();
                    cleanScreen();
                }
                case 2 -> {
                    cleanScreen();
                    removalReason = ReasonForRemoval.LOST;
                    library.removeBook(removeTitle, removalReason);
                    System.out.println();
                    cursiveText("Klicka retur för att fortsätta");
                    input.nextLine();
                    cleanScreen();
                }
                case 3 -> {
                    cleanScreen();
                    removalReason = ReasonForRemoval.OUTDATED;
                    library.removeBook(removeTitle, removalReason);
                    System.out.println();
                    cursiveText("Klicka retur för att fortsätta");
                    input.nextLine();
                    cleanScreen();
                }
                default -> {
                    cleanScreen();
                    System.out.println("Du måste välja en anledning för borttagningen");
                    System.out.println();
                    cursiveText("Klicka retur för att fortsätta");
                    input.nextLine();
                    cleanScreen();
                }
            }
        } else {
            cleanScreen();
            cursiveText("Använd bara siffror när du gör val!");
            System.out.println();
            input.next();
        }
    }

    private static void createBook(Library library, Scanner input) {
        System.out.println("Skriv titeln");
        String bookTitle = input.nextLine();
        if (bookTitle.isEmpty()) {
            cleanScreen();
            System.out.println("Du måste skriva in en titel");
            System.out.println();
            return;
        }
        System.out.println("Skriv författaren");
        String bookAuthor = input.nextLine();
        if (bookAuthor.isEmpty()) {
            cleanScreen();
            System.out.println("Du måste skriva in en författare");
            System.out.println();
            return;
        }
        System.out.println("Skriv ISBN");
        String bookIsbn = input.nextLine();
        if (bookIsbn.isEmpty()) {
            cleanScreen();
            System.out.println("Du måste skriva in ett isbn");
            System.out.println();
            return;
        }
        System.out.println();
        library.addBook(new Book(bookTitle, bookAuthor, bookIsbn, 1));
        System.out.println();
        cursiveText("Klicka retur för att fortsätta");
        input.nextLine();
        cleanScreen();
    }

    private static void printMenu() {
        System.out.print("""
                Meny
                  1. Registrera användare
                  2. Låna bok
                  3. Visa dina lån
                  4. Visa böcker
                  5. Avsluta lån
                  6. Admin-meny
                  0. Lämna
                """);
    }

    private static void listBooks(Library library) {
        for (Book books : library.getBooksList()) {
            System.out.println("Titel: " + books.getTitle() + ", " + "antal:" + books.getCopies());
        }
        System.out.println();
    }

    private static void cursiveText(String x) {
        System.out.println("\u001B[3m" + x + "\u001B[0m");
    }

    private static void cleanScreen() {
        System.out.println("\033[H\033[2J");
    }

    private static boolean hasValidName(String name) {
        name = name.strip();
        if (name.matches(".*\\d.*") || name.isEmpty()) {
            return false;

        }
        return true;
    }

}


