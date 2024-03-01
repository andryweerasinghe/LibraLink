/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 3/1/24

 */

package lk.ijse.libraLink.dao.custom.impl;

import lk.ijse.libraLink.config.FactoryConfiguration;
import lk.ijse.libraLink.dao.custom.UserDAO;
import lk.ijse.libraLink.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO{
    public boolean save(User entity){
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }
    public String generateNewId() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        int id = session.createNativeQuery("SELECT id FROM User ORDER BY id DESC LIMIT 1");
        if (resultSet.next()){
            String id = resultSet.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }

}
