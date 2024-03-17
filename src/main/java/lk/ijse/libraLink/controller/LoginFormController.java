/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 3/3/24

 */

package lk.ijse.libraLink.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.libraLink.bo.BOFactory;
import lk.ijse.libraLink.bo.custom.UserBO;
import lk.ijse.libraLink.dto.UserDTO;
import lk.ijse.libraLink.entity.User;

import java.io.IOException;

public class LoginFormController {
    @FXML
    private AnchorPane rootNode;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPw;

    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);

    @FXML
    void btnLoginOnAction(ActionEvent actionEvent) {
        String nameText = txtName.getText();
        String pwText = txtPw.getText();
        boolean validUser = userBO.isValidUser(new UserDTO(nameText, pwText));

        if (validUser){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setContentText("Login Successful!");

            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.seconds(0.8), // Adjust the duration as needed
                    event -> {
                        alert.close();
                        Stage loginStage = (Stage) txtName.getScene().getWindow();
                        loginStage.close();
                    }));

            // Set the cycle count to 1 so that the timeline stops after closing the alert
            timeline.setCycleCount(1);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxmlFiles/book_borrowing_form.fxml"));
            try {
                Parent root = fxmlLoader.load();

                BookBorrowingFormController bookBorrowingFormController = fxmlLoader.getController();
                String userId = userBO.getUserId(nameText);
                bookBorrowingFormController.setUserId(userId);

                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);

                stage.show();
                alert.show();
                timeline.play();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/fxmlFiles/registration_form.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.setTitle("SignUp");
    }
}
