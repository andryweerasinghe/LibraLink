package lk.ijse.libraLink.bo.custom;

import lk.ijse.libraLink.bo.SuperBO;
import lk.ijse.libraLink.dto.UserDTO;

import java.sql.SQLException;

public interface UserBO extends SuperBO {
    boolean isValidUser(UserDTO userDTO);
    String getUserId(String name);
    boolean saveNewUser(UserDTO userDTO);
    String generateNewUserId();
    String retrieveBranchId(String name);
}
