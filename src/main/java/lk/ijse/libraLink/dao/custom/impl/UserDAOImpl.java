/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 3/1/24

 */

package lk.ijse.libraLink.dao.custom.impl;

import lk.ijse.libraLink.config.FactoryConfiguration;
import lk.ijse.libraLink.dao.custom.UserDAO;
import lk.ijse.libraLink.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAOImpl implements UserDAO{
    public boolean save(User entity){
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }
    public String generateNewId() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createNativeQuery("SELECT id FROM User ORDER BY id DESC LIMIT 1", String.class ).setMaxResults(1); //this doenst return a result set. what can i do?
        String id = (String) query.uniqueResult();
        transaction.commit();
        session.close();
        if (id != null) {
            int newTransactionId = Integer.parseInt(id.replace("U00-", "")) + 1;
            return String.format("U00-%03d", newTransactionId);
        } else {
            return "U00-001";
        }
    }
    public boolean isValidUser(User entity){
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.createNativeQuery("SELECT * FROM User WHERE password='" + entity.getPassword() + "' AND name='" + entity.getName() + "'", User.class).executeUpdate();
        transaction.commit();
        session.close();
        return false;
    }
    public String getUserId(String name){
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.createNativeQuery("SELECT id FROM User WHERE name=:name", User.class);
            query.setParameter("name", name);

            // Execute the query
            List<User> users = query.getResultList();

            if (!users.isEmpty()) {
                return users.get(0).getId();
            } else {
                return null;
            }
        } catch (HibernateException e) {
            throw new RuntimeException("Error fetching user ID", e);
        } finally {
            transaction.commit();
            session.close();
        }
    }
}
