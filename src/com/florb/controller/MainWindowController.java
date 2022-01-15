package com.florb.controller;

import com.florb.EmailManager;
import com.florb.view.ViewManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController extends BaseController implements Initializable {

    @FXML
    private TableView<?> emailsTableView;

    @FXML
    private TreeView<String> emailsTreeView;

    @FXML
    private WebView emailsWebView;

    public MainWindowController(EmailManager emailManager, ViewManager viewManager, String fxmlName) {
        super(emailManager, viewManager, fxmlName);
    }

    @FXML
    void optionsAction() {
        viewManager.showOptionsWindow();
    }


    @FXML
    void addAccountAction() {
        viewManager.showLoginWindow();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUpEmailsTreeView();

    }

    private void setUpEmailsTreeView() {
        emailsTreeView.setRoot(emailManager.getFoldersRoot());
        emailsTreeView.setShowRoot(false);
    }
}
