package lk.ijse.libraLink.dao.custom;

import lk.ijse.libraLink.config.FactoryConfiguration;
import lk.ijse.libraLink.entity.Book;
import lk.ijse.libraLink.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public interface BookDAO {
    boolean save(Book entity);
    boolean update(Book entity);
    boolean delete(int bookId);
    List<Book> getAll();
    Book searchById(Book entity);
    Book searchByTitle(Book entity);
}
