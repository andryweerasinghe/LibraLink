/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 3/14/24

 */

package lk.ijse.libraLink.bo.custom.impl;

import lk.ijse.libraLink.dao.custom.BookDAO;
import lk.ijse.libraLink.dao.custom.impl.BookDAOImpl;
import lk.ijse.libraLink.dto.BookDTO;
import lk.ijse.libraLink.entity.Book;

public class BookBOImpl {
    BookDAO bookDAO = new BookDAOImpl();
    public boolean saveBook(BookDTO bookDTO){
        return bookDAO.save(new Book(bookDTO.getId(), bookDTO.getTitle(), bookDTO.getAuthor(), bookDTO.getGenre(), bookDTO.getAvailability()));
    }
}
