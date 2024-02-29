/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 2/29/24

 */

package lk.ijse.libraLink.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RegistrationFormController implements Initializable {
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        branchChoiceBox.getItems().addAll(branches);
    }

    @FXML
    void btnSignUpOnAction(ActionEvent event) {
        String nameText = txtName.getText();
        String emailText = txtEmail.getText();
        String pwText = txtPw.getText();
        String confirmPwText = txtConfirmPw.getText();
    }
}
