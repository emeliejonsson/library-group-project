import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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

        cleanScreen();
        runLibrary(library);
    }

    private static void runLibrary(Library library) {
        try (Scanner input = new Scanner(System.in)) {
            int loanId = 1;
            Loan loan = null;
            User user = null;
            int choice = -1;
            while (choice != 0) {
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
                            cleanScreen();
                            System.out.println("Skriv in ditt namn");
                            String name = input.nextLine();
                            if (name.isEmpty()) {
                                cleanScreen();
                                cursiveText("Ditt namn kan inte vara blankt!");
                                System.out.println();
                            } else {
                                user = new User(name);
                                cleanScreen();
                                System.out.println("Användare skapad: " + user.getName());
                                System.out.println();
                                cursiveText("Klicka en knapp för att fortsätta");
                                input.nextLine();
                                cleanScreen();
                            }
                        }
                        case 2 -> {
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
                                    loan = new Loan(loanId, user, bookBorrow);
                                    loanId++;
                                    cleanScreen();
                                    System.out.println(loan.toString());
                                    System.out.println();
                                    cursiveText("Klicka en knapp för att fortsätta");
                                    input.nextLine();
                                    cleanScreen();
                                }
                            }
                        }
                        case 3 -> {
                            if (loan == null) {
                                cleanScreen();
                                System.out.println("Det finns inga lån");
                            } else {
                                cleanScreen();
                                System.out.println(loan.toString());
                            }
                            System.out.println();
                            cursiveText("Klicka en knapp för att fortsätta");
                            input.nextLine();
                            cleanScreen();
                        }
                        case 4 -> {
                            cleanScreen();
                            listBooks(library);
                            cursiveText("Klicka en knapp för att fortsätta");
                            input.nextLine();
                            cleanScreen();
                        }
                        case 5 -> {
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

    private static void adminMenu(Library library, Scanner input) {
        int choiceAdmin = -1;
        cleanScreen();
        while (choiceAdmin != 0) {
            System.out.print("""
                    -Admin Meny-
                      1. Lägg till bok
                      2. Ta bort bok
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
                    default -> {
                        cleanScreen();
                        System.out.println("Använd 0-2 för att göra val");
                        System.out.println();
                        cursiveText("Klicka en knapp för att fortsätta");
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
                    cursiveText("Klicka en knapp för att fortsätta");
                    input.nextLine();
                    cleanScreen();
                }
                case 2 -> {
                    cleanScreen();
                    removalReason = ReasonForRemoval.LOST;
                    library.removeBook(removeTitle, removalReason);
                    System.out.println();
                    cursiveText("Klicka en knapp för att fortsätta");
                    input.nextLine();
                    cleanScreen();
                }
                case 3 -> {
                    cleanScreen();
                    removalReason = ReasonForRemoval.OUTDATED;
                    library.removeBook(removeTitle, removalReason);
                    System.out.println();
                    cursiveText("Klicka en knapp för att fortsätta");
                    input.nextLine();
                    cleanScreen();
                }
                default -> {
                    cleanScreen();
                    System.out.println("Du måste välja en anledning för borttagningen");
                    System.out.println();
                    cursiveText("Klicka en knapp för att fortsätta");
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
        cursiveText("Klicka en knapp för att fortsätta");
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
                  5. Admin-meny
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


