/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 3/13/24

 */

package lk.ijse.libraLink.dto;

public class TransactionDTO {
    private int id;
    private int userId;
    private int bookId;
    private String borrowedDate;
    private String dueDate;

    public TransactionDTO(int id, int userId, int bookId, String borrowedDate, String dueDate) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;
    }

    public TransactionDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(String borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "TransactionDTO{" +
                "id=" + id +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", borrowedDate='" + borrowedDate + '\'' +
                ", dueDate='" + dueDate + '\'' +
                '}';
    }
}
