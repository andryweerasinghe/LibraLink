/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 3/1/24

 */

package lk.ijse.libraLink.dto;

public class UserDTO {
    private String id;
    private String branch_id;
    private String name;
    private String email;
    private String password;

    public UserDTO(String id, String branch_id, String name, String email, String password) {
        this.id = id;
        this.branch_id = branch_id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserDTO(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public UserDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", branch_id=" + branch_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
