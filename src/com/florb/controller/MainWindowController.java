package com.florb.controller;

import com.florb.EmailManager;
import com.florb.view.ViewManager;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.web.WebView;

public class MainWindowController extends BaseController {

    @FXML
    private TableView<?> emailsTableView;

    @FXML
    private TreeView<?> emailsTreeView;

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

}
