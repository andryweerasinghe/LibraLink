package lk.ijse.libraLink.dao.custom;

import lk.ijse.libraLink.dao.CrudDAO;
import lk.ijse.libraLink.entity.User;

import java.sql.SQLException;

public interface UserDAO extends CrudDAO {
    boolean save(User entity);
    String generateNewId();
    boolean isValidUser(User entity);
    String getUserId(String name);
}
