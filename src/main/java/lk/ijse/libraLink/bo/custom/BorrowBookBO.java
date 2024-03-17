package lk.ijse.libraLink.bo.custom;

import lk.ijse.libraLink.bo.SuperBO;
import lk.ijse.libraLink.dto.BookDTO;
import lk.ijse.libraLink.dto.TransactionDTO;

import java.sql.SQLException;
import java.util.List;

public interface BorrowBookBO extends SuperBO {
    boolean borrowBook(String transactionId, String userId, String bookId, String borrowedDate, String dueDate);
    String generateNewTransactionId();
    BookDTO searchBookById(BookDTO bookDTO);
    BookDTO searchBookByTitle(String title);
    List<BookDTO> searchBookByAuthor(String author);
    List<BookDTO> getAllBooks();
    List<TransactionDTO> getAllTransactions();
    String getTotalBorrowedBooks();
    String getTotalMembers();
    String getTotalBooks();
}
