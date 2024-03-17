/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 3/12/24

 */

package lk.ijse.libraLink.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.libraLink.bo.BOFactory;
import lk.ijse.libraLink.bo.custom.BookBO;
import lk.ijse.libraLink.dto.BookDTO;

import java.io.IOException;
import java.util.Optional;

public class AddBookFormController {

    @FXML
    private AnchorPane rootNode;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtGenre;

    @FXML
    private TextField txtTitle;

    BookBO bookBO = (BookBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.BOOK);

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxmlFiles/login_form.fxml"));
        try {
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();

            ((Stage)rootNode.getScene().getWindow()).close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String bookId = bookBO.generateNewBookId();
        String titleText = txtTitle.getText();
        String authorText = txtAuthor.getText();
        String genreText = txtGenre.getText();

        boolean saved = bookBO.saveBook(new BookDTO(bookId, titleText, authorText, genreText, "Available"));
        if (saved){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Book Saved Successfully");
            alert.setContentText("Do you want to add another book?");

            ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType no = new ButtonType("No", ButtonBar.ButtonData.NO);

            alert.getButtonTypes().setAll(yes, no);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == yes){
                txtTitle.clear();
                txtGenre.clear();
                txtAuthor.clear();
            } else {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxmlFiles/login_form.fxml"));
                try {
                    Parent root = fxmlLoader.load();

                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);

                    stage.show();

                    ((Stage)rootNode.getScene().getWindow()).close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
