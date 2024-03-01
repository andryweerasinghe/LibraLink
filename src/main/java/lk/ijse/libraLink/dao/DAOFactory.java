/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 3/1/24

 */

package lk.ijse.libraLink.dao;

import lk.ijse.libraLink.dao.custom.impl.UserDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        USER,ITEM,ORDER,ORDER_DETAILS,QUERY_DAO
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types) {
            case USER:
                return new UserDAOImpl();
            default:
                return null;
        }
    }
}
