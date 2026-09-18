import java.time.LocalDate;
import java.util.ArrayList;

public class Library {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Member> members = new ArrayList<>();
    ArrayList<Loan> loans = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public Book getBook(int bookID) {
        for (Book book : books) {
            if (book.id() == bookID) {
                return book;
            }
        }
        return null;
    }

    public Member getMember(int memberID) {
        for (Member member : members) {
            if (member.medlemsnummer() == memberID) {
                return member;
            }
        }
        return null;
    }

    public boolean returnBook(int bookID) {
        for (Loan loan : loans) {
            if (loan.book.id() == bookID) {
                loans.remove(loan);
                return false;
            }
        }
        return true;
    }

    public boolean loanBook(int bookID, int memberID) {
        Book book = getBook(bookID);
        Member member = getMember(memberID);
        if (book == null || member == null) {
            return false;
        }
        Loan loan = new Loan(book, member, LocalDate.now());
        loans.add(loan);
        return true;
    }

    public ArrayList<Loan> findLoansByMemberId(int memberID) {
        Member member = getMember(memberID);
        ArrayList<Loan> returnList = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.getLoanMember() == member) {
                returnList.add(loan);
            }
        } return returnList;
    }
}