/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 3/4/24

 */

package lk.ijse.libraLink.bo;

import lk.ijse.libraLink.bo.custom.impl.UserBOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
        USER,ITEM,PO
    }

    //Object creation logic for BO objects
    public SuperBO getBO(BOTypes types){
        switch (types){
            case USER:
                return new UserBOImpl();
            default:
                return null;
        }
    }

}
