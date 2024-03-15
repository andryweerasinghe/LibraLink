/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 3/12/24

 */

package lk.ijse.libraLink.dao.custom.impl;

import lk.ijse.libraLink.config.FactoryConfiguration;
import lk.ijse.libraLink.entity.Transaction;
import org.hibernate.Session;

public class TransactionDAOImpl {
    public boolean save(Transaction entity){
        Session session = FactoryConfiguration.getInstance().getSession();
        org.hibernate.Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }
}
