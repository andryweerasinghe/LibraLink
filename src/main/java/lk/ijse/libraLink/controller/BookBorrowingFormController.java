/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 3/12/24

 */

package lk.ijse.libraLink.controller;

import com.jfoenix.controls.JFXRadioButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.libraLink.bo.BOFactory;
import lk.ijse.libraLink.bo.custom.BookBO;
import lk.ijse.libraLink.bo.custom.BorrowBookBO;
import lk.ijse.libraLink.bo.custom.impl.BookBOImpl;
import lk.ijse.libraLink.dto.BookDTO;
import lk.ijse.libraLink.dto.tm.BookTM;
import lk.ijse.libraLink.entity.Book;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ResourceBundle;

public class BookBorrowingFormController implements Initializable {
    @FXML
    private TableColumn<BookTM, Void> columnAction;

    @FXML
    private TableColumn<?, ?> columnAuthor;

    @FXML
    private TableColumn<?, ?> columnGenre;

    @FXML
    private TableColumn<?, ?> columnId;

    @FXML
    private TableColumn<?, ?> columnTitle;

    @FXML
    private TableView<BookTM> tblBooks;

    @FXML
    private TextField txtBookSearch;

    @FXML
    private JFXRadioButton radioBtnAuthor;

    @FXML
    private JFXRadioButton radioBtnId;

    @FXML
    private JFXRadioButton radioBtnTitle;

    private String userId;

    BorrowBookBO borrowBookBO = (BorrowBookBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.BORROW);


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        loadAllBooks();
    }
    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String searchText = txtBookSearch.getText().trim();
        if (radioBtnId.isSelected()){
            BookDTO bookDTO = new BookDTO(searchText);
            BookDTO searchedBookById = borrowBookBO.searchBookById(bookDTO);
            if (searchedBookById != null){
                tblBooks.getItems().clear();

                BookTM bookTM = new BookTM(
                        searchedBookById.getId(),
                        searchedBookById.getTitle(),
                        searchedBookById.getAuthor(),
                        searchedBookById.getGenre()
                );
                tblBooks.getItems().add(bookTM);
                setColumnAction();
            }
        } else if (radioBtnTitle.isSelected()) {
            BookDTO searchedBookByTitle = borrowBookBO.searchBookByTitle(searchText);
            if (searchedBookByTitle != null){
                tblBooks.getItems().clear();

                BookTM bookTM = new BookTM(
                        searchedBookByTitle.getId(),
                        searchedBookByTitle.getTitle(),
                        searchedBookByTitle.getAuthor(),
                        searchedBookByTitle.getGenre()
                );
                tblBooks.getItems().add(bookTM);
                setColumnAction();
            }
        } else if (radioBtnAuthor.isSelected()) {
            List<BookDTO> searchedBookByAuthor = borrowBookBO.searchBookByAuthor(searchText);
            if (searchedBookByAuthor != null){
                tblBooks.getItems().clear();
                ObservableList<BookTM> obList = FXCollections.observableArrayList();
                for (BookDTO dto : searchedBookByAuthor) {
                    obList.add(new BookTM(dto.getId(), dto.getTitle(), dto.getAuthor(), dto.getGenre()));
                }
                tblBooks.setItems(obList);
                setColumnAction();
            }
        }
    }
    public void setCellValueFactory(){
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        columnAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        columnGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));

        setColumnAction();
    }
    public void setColumnAction(){
        columnAction.setCellFactory(param -> new TableCell<>() {
            final Button button = new Button("Borrow");

            {
                button.setOnAction(event -> {
                    LocalDate borrowedDate = LocalDate.now();
                    LocalDate dueDate = borrowedDate.plusDays(14);
                    String transactionId = borrowBookBO.generateNewTransactionId();
                    BookTM bookTM = getTableView().getItems().get(getIndex());
                    borrowBookBO.borrowBook(transactionId, userId, bookTM.getId(), borrowedDate.toString(), dueDate.toString());
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                } else {
                    setGraphic(button);
                }
            }
        });
    }
    public void loadAllBooks(){
        ObservableList<BookTM> obList = FXCollections.observableArrayList();
        List<BookDTO> allBooks = borrowBookBO.getAllBooks();
        for (BookDTO dto : allBooks){
            obList.add(
                    new BookTM(
                        dto.getId(),
                        dto.getTitle(),
                        dto.getAuthor(),
                        dto.getGenre()
                    )
            );
        }
        tblBooks.setItems(obList);
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
