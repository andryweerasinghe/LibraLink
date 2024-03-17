package lk.ijse.libraLink.dao.custom;

import lk.ijse.libraLink.config.FactoryConfiguration;
import lk.ijse.libraLink.dao.CrudDAO;
import lk.ijse.libraLink.entity.Book;
import lk.ijse.libraLink.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public interface BookDAO extends CrudDAO {
    boolean save(Book entity);
    boolean update(Book entity);
    boolean delete(String bookId);
    List<Book> getAll();
    Book searchById(Book entity);
    List<Book> searchByAuthor(String author);
    Book searchByTitle(String title);
    boolean updateAvailability(String bookId);
    String generateNewId();
}
