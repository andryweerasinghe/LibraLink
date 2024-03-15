/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 3/4/24

 */

package lk.ijse.libraLink.dao.custom.impl;

import lk.ijse.libraLink.config.FactoryConfiguration;
import lk.ijse.libraLink.dao.custom.BookDAO;
import lk.ijse.libraLink.entity.Book;
import lk.ijse.libraLink.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BookDAOImpl implements BookDAO {
    public boolean save(Book entity){
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }
    public boolean update(Book entity){
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }
    public boolean delete(int bookId){
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.createNativeQuery("DELETE FROM Book WHERE id='"+bookId+"'", User.class).executeUpdate();
        transaction.commit();
        session.close();
        return true;
    }
    public List<Book> getAll(){
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<Book> list = session.createNativeQuery("SELECT * FROM Book", Book.class).list();
        transaction.commit();
        session.close();
        return list;
    }
    public Book search(Book entity){
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Book book = session.find(Book.class, entity.getId());
        session.getTransaction().commit();
        return book;
    }
}
