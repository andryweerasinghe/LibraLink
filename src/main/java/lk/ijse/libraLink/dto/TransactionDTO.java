/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 3/13/24

 */

package lk.ijse.libraLink.dto;

public class TransactionDTO {
    private String id;
    private String userId;
    private String bookId;
    private String borrowedDate;
    private String dueDate;

    public TransactionDTO(String id, String userId, String bookId, String borrowedDate, String dueDate) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;
    }

    public TransactionDTO(String id, String userId, String bookId, String borrowedDate) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.borrowedDate = borrowedDate;
    }

    public TransactionDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
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
