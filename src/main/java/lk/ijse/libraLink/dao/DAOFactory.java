/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 3/1/24

 */

package lk.ijse.libraLink.dao;

import lk.ijse.libraLink.dao.custom.impl.BookDAOImpl;
import lk.ijse.libraLink.dao.custom.impl.BranchDAOImpl;
import lk.ijse.libraLink.dao.custom.impl.TransactionDAOImpl;
import lk.ijse.libraLink.dao.custom.impl.UserDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        USER,BOOK,TRANSACTION,BRANCH,QUERY_DAO
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types) {
            case USER:
                return new UserDAOImpl();
            case BOOK:
                return new BookDAOImpl();
            case TRANSACTION:
                return new TransactionDAOImpl();
            case BRANCH:
                return new BranchDAOImpl();
            default:
                return null;
        }
    }
}
