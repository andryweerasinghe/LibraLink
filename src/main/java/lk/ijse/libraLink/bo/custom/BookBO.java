package lk.ijse.libraLink.bo.custom;

import lk.ijse.libraLink.bo.SuperBO;
import lk.ijse.libraLink.dto.BookDTO;
import lk.ijse.libraLink.entity.Book;

import java.util.List;

public interface BookBO extends SuperBO {
    boolean saveBook(BookDTO bookDTO);
    String generateNewBookId();
    boolean removeBook(String bookId);
    boolean update(BookDTO bookDTO);
}
