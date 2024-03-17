/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 3/17/24

 */

package lk.ijse.libraLink.dao.custom.impl;

import lk.ijse.libraLink.config.FactoryConfiguration;
import lk.ijse.libraLink.dao.custom.BranchDAO;
import lk.ijse.libraLink.entity.Branch;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BranchDAOImpl implements BranchDAO {
    public String retrieveBranchId(String name) {
        Session session = null;
        Transaction transaction = null;
        String branchId = null;

        try {
            session = FactoryConfiguration.getInstance().getSession();
            transaction = session.beginTransaction();
            Query query = session.createNativeQuery("SELECT id FROM Branch WHERE name= :name", Branch.class);
            query.setParameter("name", name);

            List<Branch> branches = query.getResultList();
            transaction.commit();

            if (!branches.isEmpty()) {
                branchId = branches.get(0).getId();
            }
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error retrieving branch ID", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return branchId;
    }

}
