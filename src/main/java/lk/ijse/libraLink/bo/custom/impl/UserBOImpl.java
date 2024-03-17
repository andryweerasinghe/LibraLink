/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 3/4/24

 */

package lk.ijse.libraLink.bo.custom.impl;

import lk.ijse.libraLink.bo.custom.UserBO;
import lk.ijse.libraLink.dao.DAOFactory;
import lk.ijse.libraLink.dao.custom.BranchDAO;
import lk.ijse.libraLink.dao.custom.UserDAO;
import lk.ijse.libraLink.dto.UserDTO;
import lk.ijse.libraLink.entity.User;

import java.sql.SQLException;

public class UserBOImpl implements UserBO {
    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);
    BranchDAO branchDAO = (BranchDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BRANCH);
    @Override
    public boolean isValidUser(UserDTO userDTO){
        return userDAO.isValidUser(new User(userDTO.getName(), userDTO.getPassword()));
    }
    @Override
    public String getUserId(String name){
        return userDAO.getUserId(name);
    }

    @Override
    public boolean saveNewUser(UserDTO userDTO) {
        return userDAO.save(new User(userDTO.getId(), userDTO.getBranch_id(), userDTO.getName(), userDTO.getEmail(), userDTO.getPassword()));
    }

    @Override
    public String generateNewUserId() {
        return userDAO.generateNewId();
    }

    @Override
    public String retrieveBranchId(String name){
        return branchDAO.retrieveBranchId(name);
    }
}
