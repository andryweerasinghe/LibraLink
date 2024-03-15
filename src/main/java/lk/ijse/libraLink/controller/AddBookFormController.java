/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 3/12/24

 */

package lk.ijse.libraLink.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddBookFormController {
    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtGenre;

    @FXML
    private TextField txtTitle;

    @FXML
    void btnCancelOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String titleText = txtTitle.getText();
        String authorText = txtAuthor.getText();
        String genreText = txtGenre.getText();


    }
}
