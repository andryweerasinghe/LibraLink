/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 3/17/24

 */

package lk.ijse.libraLink.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.libraLink.bo.BOFactory;
import lk.ijse.libraLink.bo.custom.BorrowBookBO;
import lk.ijse.libraLink.dto.TransactionDTO;
import lk.ijse.libraLink.dto.tm.TransactionTM;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class DashboardFormController implements Initializable {

    @FXML
    private TableColumn<?, ?> colBBook;

    @FXML
    private TableColumn<?, ?> colBMember;

    @FXML
    private TableColumn<?, ?> colBMemberID;

    @FXML
    private TableColumn<?, ?> colTID;

    @FXML
    private Label lblBorrowedBooks;

    @FXML
    private Label lblMembers;

    @FXML
    private Label lblTotalBooks;

    @FXML
    private TableView<TransactionTM> tblBorrowedList;

    private ObservableList<TransactionTM> observableList = FXCollections.observableArrayList();

    BorrowBookBO borrowBookBO = (BorrowBookBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.BORROW);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadAllBorrowedBooks();
        setCellValueFactory();
        borrowedBooks();
        totalMembers();
        totalBooks();
    }

    private void loadAllBorrowedBooks() {
        observableList.clear();
        List<TransactionDTO> dtoList = borrowBookBO.getAllTransactions();
        for (TransactionDTO dto : dtoList) {
            observableList.add(new TransactionTM(
                    dto.getId(), dto.getUserId(), dto.getBookId(),
                    dto.getBorrowedDate()));
        }
        tblBorrowedList.setItems(observableList);
    }

    private void setCellValueFactory() {
        colTID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colBMemberID.setCellValueFactory(new PropertyValueFactory<>("userId"));
        colBMember.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        colBBook.setCellValueFactory(new PropertyValueFactory<>("borrowedDate"));

        tblBorrowedList.setId("my-table");
    }

    private void borrowedBooks() {
        String totalBorrowedBooks = borrowBookBO.getTotalBorrowedBooks();
        lblBorrowedBooks.setText(totalBorrowedBooks);
    }

    private void totalMembers() {
        String members = borrowBookBO.getTotalMembers();
        lblMembers.setText(members);
    }

    private void totalBooks() {
        String books = borrowBookBO.getTotalBooks();
        lblTotalBooks.setText(books);
    }
}
