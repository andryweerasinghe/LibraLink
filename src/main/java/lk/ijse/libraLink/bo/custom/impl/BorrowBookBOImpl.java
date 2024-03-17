/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 3/16/24

 */

package lk.ijse.libraLink.bo.custom.impl;

import lk.ijse.libraLink.bo.custom.BorrowBookBO;
import lk.ijse.libraLink.dao.DAOFactory;
import lk.ijse.libraLink.dao.custom.BookDAO;
import lk.ijse.libraLink.dao.custom.TransactionDAO;
import lk.ijse.libraLink.dao.custom.UserDAO;
import lk.ijse.libraLink.dao.custom.impl.BookDAOImpl;
import lk.ijse.libraLink.dao.custom.impl.TransactionDAOImpl;
import lk.ijse.libraLink.dto.BookDTO;
import lk.ijse.libraLink.dto.TransactionDTO;
import lk.ijse.libraLink.entity.Book;
import lk.ijse.libraLink.entity.Transactions;

import java.util.ArrayList;
import java.util.List;

public class BorrowBookBOImpl implements BorrowBookBO {
    BookDAO bookDAO = (BookDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BOOK);
    TransactionDAO transactionDAO = (TransactionDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.TRANSACTION);
    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);
    @Override
    public boolean borrowBook(String transactionId, String userId, String bookId, String borrowedDate, String dueDate){
        boolean updated = bookDAO.updateAvailability(bookId);
        if (updated){
            transactionDAO.save(new Transactions(transactionId, userId, bookId, borrowedDate, dueDate));
        }
        return true;
    }

    @Override
    public String generateNewTransactionId() {
        return transactionDAO.generateNewId();
    }

    public BookDTO searchBookById(BookDTO bookDTO){
        Book book = bookDAO.searchById(new Book(bookDTO.getId()));
        return new BookDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getGenre(), book.getAvailability());
    }

    public BookDTO searchBookByTitle(String title){
        Book book = bookDAO.searchByTitle(title);
        return new BookDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getGenre(), book.getAvailability());
    }

    public List<BookDTO> searchBookByAuthor(String author){
        List<Book> books = bookDAO.searchByAuthor(author);
        List<BookDTO> bookDTOS = new ArrayList<>();
        for (Book book : books){
            BookDTO bookDTO = new BookDTO();
            bookDTO.setId(book.getId());
            bookDTO.setTitle(book.getTitle());
            bookDTO.setAuthor(book.getAuthor());
            bookDTO.setGenre(book.getGenre());
            bookDTO.setAvailability(book.getAvailability());

            bookDTOS.add(bookDTO);
        }
        return bookDTOS;
    }
    public List<BookDTO> getAllBooks(){
        List<Book> allBooks = bookDAO.getAll();
        List<BookDTO> bookDTOS = new ArrayList<>();

        for (Book book : allBooks){
            BookDTO bookDTO = new BookDTO();
            bookDTO.setId(book.getId());
            bookDTO.setTitle(book.getTitle());
            bookDTO.setAuthor(book.getAuthor());
            bookDTO.setGenre(book.getGenre());
            bookDTO.setAvailability(book.getAvailability());

            bookDTOS.add(bookDTO);
        }
        return bookDTOS;
    }

    @Override
    public List<TransactionDTO> getAllTransactions() {
        List<TransactionDTO> transactions = new ArrayList<>();
        List<Transactions> list = transactionDAO.getAll();
        for (Transactions transaction : list) {
            transactions.add(new TransactionDTO(
                    transaction.getId(),transaction.getUserId(),transaction.getBookId(),
                    transaction.getBorrowedDate()
            ));
        }
        return transactions;
    }

    @Override
    public String getTotalBorrowedBooks() {
        return transactionDAO.getTotalBorrowedBooks();
    }

    @Override
    public String getTotalMembers() {
        return userDAO.getTotalUsers();
    }

    @Override
    public String getTotalBooks() {
        return bookDAO.getTotalBooks();
    }
}
