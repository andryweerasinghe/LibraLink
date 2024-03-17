/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 2/29/24

 */

package lk.ijse.libraLink.entity;

public class Branch {
    private String id;
    private String name;
    private String status;

    public Branch(String id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Branch() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
