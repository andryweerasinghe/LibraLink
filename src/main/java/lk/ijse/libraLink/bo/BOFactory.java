/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 3/4/24

 */

package lk.ijse.libraLink.bo;

import lk.ijse.libraLink.bo.custom.impl.BookBOImpl;
import lk.ijse.libraLink.bo.custom.impl.BorrowBookBOImpl;
import lk.ijse.libraLink.bo.custom.impl.UserBOImpl;
import lk.ijse.libraLink.dao.custom.impl.BookDAOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
        USER,BOOK,BORROW
    }

    //Object creation logic for BO objects
    public SuperBO getBO(BOTypes types){
        switch (types){
            case USER:
                return new UserBOImpl();
            case BOOK:
                return new BookBOImpl();
            case BORROW:
                return new BorrowBookBOImpl();
            default:
                return null;
        }
    }

}
