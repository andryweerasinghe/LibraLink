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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.libraLink.bo.BOFactory;
import lk.ijse.libraLink.bo.custom.BookBO;
import lk.ijse.libraLink.bo.custom.BorrowBookBO;
import lk.ijse.libraLink.dto.BookDTO;
import lk.ijse.libraLink.dto.tm.BookTM;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class BookManagingFormController implements Initializable {

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

    BorrowBookBO borrowBookBO = (BorrowBookBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.BORROW);

    @FXML
    private TableView<BookTM> tblBooks;

    @FXML
    private JFXRadioButton radioBtnAuthor;

    @FXML
    private JFXRadioButton radioBtnTitle;

    @FXML
    private JFXRadioButton radiobtnId;

    @FXML
    private AnchorPane rootNode;


    @FXML
    private TextField txtBookSearch;

    BookBO bookBO = (BookBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.BOOK);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        loadAllBooks();
    }

    @FXML
    void btnAddBookOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxmlFiles/add_book_form.fxml"));
        Parent root = fxmlLoader.load();
        AddBookFormController controller = fxmlLoader.getController();
        stage.setScene(new Scene(root));
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String searchText = txtBookSearch.getText();
        if (radiobtnId.isSelected()){
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
        tblBooks.setId("my-table");
    }

    public void setColumnAction(){
        columnAction.setCellFactory(param -> new TableCell<>() {
            final Button update = new Button("Update");
            final Button remove = new Button("Remove");

            {
                update.setOnAction(event -> {
                    BookTM bookTM = getTableView().getItems().get(getIndex());
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxmlFiles/update_book_form.fxml"));
                    try {
                        Parent root = fxmlLoader.load();

                        UpdateBookFormController updateBookFormController = fxmlLoader.getController();
                        updateBookFormController.setBookInfo(bookTM.getTitle(), bookTM.getAuthor(), bookTM.getGenre());

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }


                });
                remove.setOnAction(event -> {
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("WARNING!");
                    alert1.setContentText("Are you sure?");

                    ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
                    ButtonType no = new ButtonType("No", ButtonBar.ButtonData.NO);

                    alert1.getButtonTypes().setAll(yes, no);

                    Optional<ButtonType> result = alert1.showAndWait();

                    if (result.isPresent() && result.get() == yes){
                        BookTM bookTM = getTableView().getItems().get(getIndex());
                        boolean removed = bookBO.removeBook(bookTM.getId());
                        if (removed){
                            Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
                            alert2.setTitle("Confirmation");
                            alert2.setHeaderText("Book Deleted Successfully");
                        }
                    }
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                } else {
                    setGraphic(update);
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
}
