/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 3/13/24

 */

package lk.ijse.libraLink.dto;

public class BranchDTO {
    private String id;
    private String name;
    private String status;

    public BranchDTO(String id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public BranchDTO() {
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

    @Override
    public String toString() {
        return "BranchDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
