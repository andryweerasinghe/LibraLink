/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 3/12/24

 */

package lk.ijse.libraLink.dao.custom.impl;

import lk.ijse.libraLink.config.FactoryConfiguration;
import lk.ijse.libraLink.dao.custom.TransactionDAO;
import lk.ijse.libraLink.entity.Transactions;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class TransactionDAOImpl implements TransactionDAO {
    public boolean save(Transactions entity){
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
        Query query = session.createNativeQuery("SELECT id FROM Transactions ORDER BY id DESC LIMIT 1", String.class ).setMaxResults(1);
        String id = (String) query.uniqueResult();
        transaction.commit();
        session.close();
        if (id != null) {
            int newTransactionId = Integer.parseInt(id.replace("T00-", "")) + 1;
            return String.format("T00-%03d", newTransactionId);
        } else {
            return "T00-001";
        }
    }
}
