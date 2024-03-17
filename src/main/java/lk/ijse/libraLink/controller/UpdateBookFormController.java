/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 3/12/24

 */

package lk.ijse.libraLink.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.libraLink.bo.BOFactory;
import lk.ijse.libraLink.bo.custom.BookBO;
import lk.ijse.libraLink.dto.BookDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class UpdateBookFormController implements Initializable {
    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtGenre;

    @FXML
    private TextField txtTitle;

    private String title;

    private String author;

    private String genre;

    BookBO bookBO = (BookBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.BOOK);
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtTitle.setText(title);
        txtAuthor.setText(author);
        txtGenre.setText(genre);
    }

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        Stage loginStage = (Stage) txtGenre.getScene().getWindow();
        loginStage.close();
    }

    @FXML
    void btnSaveOnAction(ActionEvent actionEvent) {
        String titleText = txtTitle.getText();
        String authorText = txtAuthor.getText();
        String genreText = txtGenre.getText();

        BookDTO bookDTO = new BookDTO(titleText, authorText, genreText);

        boolean updated = bookBO.update(bookDTO);

        if (updated){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setContentText("Book Info Updated Successfully!");

            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.seconds(0.8), // Adjust the duration as needed
                    event -> {
                        alert.close();
                        Stage loginStage = (Stage) txtGenre.getScene().getWindow();
                        loginStage.close();
                    }));

            // Set the cycle count to 1 so that the timeline stops after closing the alert
            timeline.setCycleCount(1);

            alert.show();
            timeline.play();
        }
    }

    public void setBookInfo(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }
}
