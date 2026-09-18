import java.time.LocalDate;

public class Loan {
    final Book book;
    final Member loanMember;
    final LocalDate borrowedDate;

    public Loan(Book book, Member member, LocalDate borrowedDate) {
        this.book = book;
        this.loanMember = member;
        this.borrowedDate = borrowedDate;
    }

    public Member getLoanMember() {
        return loanMember;
    }

    public LocalDate getDueDate() {
        return borrowedDate.plusDays(14);
    }
    public LocalDate getOverdueDate() {
        return borrowedDate.minusDays(14);
    }

    public String toString() {
        return String.format("""
                Bog: %s
                Låner: %s
                Lånt: %s
                Afleveringsfrist: %s
                """,
                book,
                loanMember,
                borrowedDate,
                getDueDate());
    }
}