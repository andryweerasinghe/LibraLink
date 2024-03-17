/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 2/28/24

 */

package lk.ijse.libraLink.entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Transactions {
    @Id
    private String id;
    private String userId;
    private String bookId;
    private String borrowedDate;
    private String returnedDate;
    private String dueDate;

    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book books;

    public Transactions(String id, String userId, String bookId, String borrowedDate, String returnedDate, String dueDate) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.borrowedDate = borrowedDate;
        this.returnedDate = returnedDate;
        this.dueDate = dueDate;
    }

    public Transactions(String id, String userId, String bookId, String borrowedDate, String dueDate) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;
    }

    public Transactions() {
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

    public String getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(String returnedDate) {
        this.returnedDate = returnedDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", bookId='" + bookId + '\'' +
                ", borrowedDate='" + borrowedDate + '\'' +
                ", returnedDate='" + returnedDate + '\'' +
                ", dueDate='" + dueDate + '\'' +
                '}';
    }
}
