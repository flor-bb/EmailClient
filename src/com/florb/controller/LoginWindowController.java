package com.florb.controller;

import com.florb.EmailManager;
import com.florb.view.ViewManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginWindowController extends BaseController {

    @FXML
    private TextField emailTextField;

    @FXML
    private Label errorLabel;

    @FXML
    private PasswordField passwordTextField;

    public LoginWindowController(EmailManager emailManager, ViewManager viewManager, String fxmlName) {
        super(emailManager, viewManager, fxmlName);
    }

    @FXML
    void loginButtonAction() {
        viewManager.showMainWindow();
        Stage stage = (Stage) errorLabel.getScene().getWindow();
        viewManager.closeStage(stage);
    }

}
