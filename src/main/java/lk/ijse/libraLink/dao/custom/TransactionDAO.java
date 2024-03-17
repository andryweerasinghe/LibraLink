package lk.ijse.libraLink.dao.custom;

import lk.ijse.libraLink.dao.CrudDAO;
import lk.ijse.libraLink.entity.Transactions;

public interface TransactionDAO extends CrudDAO {
    boolean save(Transactions entity);
    String generateNewId() ;
}
