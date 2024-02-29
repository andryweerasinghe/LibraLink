/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 2/29/24

 */

package lk.ijse.libraLink.entity;

public class Branch {
    private int id;
    private String name;
    private String status;

    public Branch(int id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Branch() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}