/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 3/14/24

 */

package lk.ijse.libraLink.bo.custom.impl;

import lk.ijse.libraLink.bo.custom.BookBO;
import lk.ijse.libraLink.dao.DAOFactory;
import lk.ijse.libraLink.dao.custom.BookDAO;
import lk.ijse.libraLink.dao.custom.impl.BookDAOImpl;
import lk.ijse.libraLink.dto.BookDTO;
import lk.ijse.libraLink.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookBOImpl implements BookBO {

    BookDAO bookDAO = (BookDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BOOK);

    public boolean saveBook(BookDTO bookDTO){
        return bookDAO.save(new Book(bookDTO.getId(), bookDTO.getTitle(), bookDTO.getAuthor(), bookDTO.getGenre(), bookDTO.getAvailability()));
    }
    public String generateNewBookId(){
        return bookDAO.generateNewId();
    }

    public boolean removeBook(String bookId){
        return bookDAO.delete(bookId);
    }

    public boolean update(BookDTO bookDTO){
        return bookDAO.update(new Book(bookDTO.getTitle(), bookDTO.getAuthor(), bookDTO.getGenre()));
    }
}
