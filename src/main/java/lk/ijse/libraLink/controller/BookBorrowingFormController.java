/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 3/12/24

 */

package lk.ijse.libraLink.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class BookBorrowingFormController implements Initializable {
    @FXML
    private TableColumn<?, ?> columnAction;

    @FXML
    private TableColumn<?, ?> columnAuthor;

    @FXML
    private TableColumn<?, ?> columnGenre;

    @FXML
    private TableColumn<?, ?> columnId;

    @FXML
    private TableColumn<?, ?> columnTitle;

    @FXML
    private TableView<?> tblBooks;

    @FXML
    private TextField txtBookSearch;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }
}
