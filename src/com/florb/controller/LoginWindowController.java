package com.florb.controller;

import com.florb.EmailManager;
import com.florb.controller.services.LoginService;
import com.florb.model.EmailAccount;
import com.florb.view.ViewManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static com.florb.controller.EmailLoginResult.SUCCESS;

public class LoginWindowController extends BaseController implements Initializable {

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
        if (fieldsAreValid()) {
            EmailAccount emailAccount = new EmailAccount(emailTextField.getText(), passwordTextField.getText());
            LoginService loginService = new LoginService(emailAccount, emailManager);
            loginService.start();
            loginService.setOnSucceeded(e -> {
                EmailLoginResult emailLoginResult = loginService.getValue();

                switch (emailLoginResult) {

                    case SUCCESS:
                        System.out.println("Login successfull " + emailAccount);
                        if (!viewManager.isMainViewInitialized()) {
                            viewManager.showMainWindow();
                        }
                        Stage stage = (Stage) errorLabel.getScene().getWindow();
                        viewManager.closeStage(stage);
                        return;
                    case FAILED_BY_CREDENTIALS:
                        errorLabel.setText("Invalid Credentials");
                        return;
                    case FAILED_BY_UNEXPECTED_ERROR:
                        errorLabel.setText("Unexpected Error");
                        return;
                    default:
                        return;

                }
            });


        }

    }

    private boolean fieldsAreValid() {

        if (emailTextField.getText().isEmpty()) {
            errorLabel.setText("Please enter your Email");
            return false;
        }
        if (passwordTextField.getText().isEmpty()) {
            errorLabel.setText("Please enter your password");
            return false;
        }

        return true;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        emailTextField.setText("hdampf350@gmail.com");
        passwordTextField.setText("?aQirItrlPa5r7c5lprl");
    }
}
