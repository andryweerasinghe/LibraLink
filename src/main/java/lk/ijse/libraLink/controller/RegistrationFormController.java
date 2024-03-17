/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 2/29/24

 */

package lk.ijse.libraLink.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.libraLink.bo.BOFactory;
import lk.ijse.libraLink.bo.custom.UserBO;
import lk.ijse.libraLink.dto.UserDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegistrationFormController implements Initializable {

    @FXML
    private JFXButton btnSignUp;

    @FXML
    private ChoiceBox<String> branchChoiceBox;

    @FXML
    private TextField txtConfirmPw;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPw;

    private final String[] branches = {"Aluthgama", "Panadura", "Kalutara"};

    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        branchChoiceBox.getItems().addAll(branches);
    }

    @FXML
    void btnSignUpOnAction(ActionEvent event) {
        String userId = userBO.generateNewUserId();
        String nameText = txtName.getText();
        String emailText = txtEmail.getText();
        String pwText = txtPw.getText();
        String confirmPwText = txtConfirmPw.getText();
        String branchName = branchChoiceBox.getValue();
        String branchId = userBO.retrieveBranchId(branchName);

        if (userId != null && nameText != null && emailText != null && pwText != null && confirmPwText != null && branchName != null) {
            if (pwText.equals(confirmPwText)) {
                boolean saved = userBO.saveNewUser(new UserDTO(userId, branchId , nameText, emailText, pwText));
                if (saved){
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxmlFiles/login_form.fxml"));
                    try {
                        Parent root = fxmlLoader.load();

                        Stage stage = new Stage();
                        Scene scene = new Scene(root);
                        stage.setScene(scene);

                        stage.show();

                        ((Stage) btnSignUp.getScene().getWindow()).close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR!");
                alert.setContentText("Passwords do not match! Please try again");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR!");
            alert.setContentText("Fields cannot be empty!");
            alert.showAndWait();
        }
    }
}
