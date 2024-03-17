package lk.ijse.libraLink.dao.custom;

import lk.ijse.libraLink.dao.CrudDAO;

public interface BranchDAO extends CrudDAO {
    String retrieveBranchId(String name);
}
