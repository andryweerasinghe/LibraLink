/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 3/4/24

 */

package lk.ijse.libraLink.dao.custom.impl;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lk.ijse.libraLink.config.FactoryConfiguration;
import lk.ijse.libraLink.dao.custom.BookDAO;
import lk.ijse.libraLink.entity.Book;
import lk.ijse.libraLink.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

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
    public boolean delete(String bookId){
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.createNativeQuery("DELETE FROM Book WHERE id='"+bookId+"'", Book.class).executeUpdate();
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
    public Book searchById(Book entity){
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Book book = session.find(Book.class, entity.getId());
        session.getTransaction().commit();
        return book;
    }
    public Book searchByTitle(String title){
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Book book = session.find(Book.class, title);
        session.getTransaction().commit();;
        return book;

    }
    public List<Book> searchByAuthor(String author){
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        HibernateCriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> root = criteriaQuery.from(Book.class);
        criteriaQuery.select(root);
        Predicate predicate = criteriaBuilder.like(root.get("title"), "%" + author + "%");
        criteriaQuery.where(predicate);
        List<Book> books = session.createQuery(criteriaQuery).getResultList();
        session.getTransaction().commit();
        return books;
    }
    public boolean updateAvailability(String bookId){
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.createNativeQuery("UPDATE Book SET status = :availability WHERE id = :id")
                .setParameter("availability", "Borrowed")
                .setParameter("id", bookId)
                .executeUpdate();
        transaction.commit();
        session.close();
        return true;
    }
    public String generateNewId() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createNativeQuery("SELECT id FROM Book ORDER BY id DESC LIMIT 1", String.class ).setMaxResults(1);
        String id = (String) query.uniqueResult();
        transaction.commit();
        session.close();
        if (id != null) {
            int newTransactionId = Integer.parseInt(id.replace("B00-", "")) + 1;
            return String.format("B00-%03d", newTransactionId);
        } else {
            return "B00-001";
        }
    }

    @Override
    public String getTotalBooks() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query<Long> query = session.createQuery("SELECT count(*) FROM Book", Long.class);
        Long count = query.uniqueResult();
        String totalCount = String.valueOf(count);

        transaction.commit();
        session.close();

        return totalCount;
    }
}
