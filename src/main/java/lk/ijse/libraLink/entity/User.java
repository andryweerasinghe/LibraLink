/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 2/28/24

 */

package lk.ijse.libraLink.entity;

public class User {
    private int id;
    private int branch_id;
    private String name;
    private String email;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(int id, int branch_id, String name, String email, String password) {
        this.id = id;
        this.branch_id = branch_id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
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
}