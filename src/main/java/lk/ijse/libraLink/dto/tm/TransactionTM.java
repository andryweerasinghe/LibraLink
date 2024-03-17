/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 3/17/24

 */

package lk.ijse.libraLink.dto.tm;

public class TransactionTM {
    private String id;
    private String userId;
    private String bookId;
    private String borrowedDate;

    public TransactionTM(String id, String userId, String bookId, String borrowedDate) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.borrowedDate = borrowedDate;
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
}
