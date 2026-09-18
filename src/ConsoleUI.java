import java.time.LocalDate;
import java.util.ArrayList;

public class ConsoleUI {
    private Library library;

    public ConsoleUI(Library library) {
        this.library = library;
    }

    public void run() {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(IO.readln("Indtast dit tal for valg: "));
            switch (choice) {
                case 1 -> borrowBook();
                case 2 -> returnBook();
                case 3 -> showLoans();
                case 4 -> showOverdueLoans();
                case 0 -> running = false;
                default -> IO.println("Ugyldigt valg. Prøv igen.");
            }
        }
    }

    private void showMenu() {
        IO.println();
        IO.println("1. Lån");
        IO.println("2. Aflever");
        IO.println("3. Vis medlemmets lån");
        IO.println("4. Vis overskredne lån");
        IO.println("0. Afslut");
        IO.println();
    }

    private void borrowBook() {
        int bookID = Integer.parseInt(IO.readln("Indtast bog id: "));
        int memberID = Integer.parseInt(IO.readln("Indtast member id: "));

        boolean loanCreated = library.loanBook(bookID, memberID);

        if (loanCreated) {
            IO.println("Lån registreret");
        } else {
            IO.println("Ugyldig");
        }
    }

    private void returnBook() {
        int bookID = Integer.parseInt(IO.readln("Indtast bog id: "));

        if (library.returnBook(bookID)) {
            IO.println("Bogen er returneret");
        } else {
            IO.println("Ugyldig");
        }
    }

    private void showLoans() {
        int memberID = Integer.parseInt(IO.readln("Indtast member id: "));
        ArrayList<Loan> loans = library.findLoansByMemberId(memberID);

        if (loans.isEmpty()) {
            IO.println("Medlem har ingen lån");
        } else {
            IO.println("Medlem låner: ");

            for (Loan loan : loans) {
                IO.print(loan);
            }
        }
    }

    private void showOverdueLoans() {
        if (library.loans.isEmpty()) {
            IO.println("Der er ingen lån");
        } else {

            for (Loan loan : library.loans) {
                if(LocalDate.now().isAfter(loan.getOverdueDate())){
                    IO.println(loan);
                }
            }
        }
    }
}