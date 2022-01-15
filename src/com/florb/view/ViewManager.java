package com.florb.view;

import com.florb.EmailManager;
import com.florb.controller.BaseController;
import com.florb.controller.LoginWindowController;
import com.florb.controller.MainWindowController;
import com.florb.controller.OptionsWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

//this class controls all the different windows
public class ViewManager {


    private EmailManager emailManager;
    private ArrayList<Stage> activeStages;
    private boolean mainViewInitialized = false;


    public ViewManager(EmailManager emailManager) {
        this.emailManager = emailManager;
        activeStages = new ArrayList<Stage>();
    }

    public boolean isMainViewInitialized(){
        return mainViewInitialized;
    }

    //View options Handling
    private ColorTheme colorTheme = ColorTheme.DARK;
    private FontSize fontSize = FontSize.MEDIUM;


    //connect the xml file with the controller
    public void showLoginWindow() {
        BaseController controller = new LoginWindowController(emailManager, this, "LoginWindow.fxml");
        initializeStage(controller);
    }

    //connect the xml file with the controller
    public void showMainWindow() {
        BaseController controller = new MainWindowController(emailManager, this, "MainWindow.fxml");
        initializeStage(controller);
        mainViewInitialized = true;
    }

    //connect the xml file with the controller
    public void showOptionsWindow() {
        BaseController controller = new OptionsWindowController(emailManager, this, "OptionsWindow.fxml");
        initializeStage(controller);
    }

    //Setting up the Stage
    private void initializeStage(BaseController controller) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
        fxmlLoader.setController(controller);
        Parent parent;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        activeStages.add(stage);
    }

    //closes the Stage
    public void closeStage(Stage stageToClose) {
        stageToClose.close();
        activeStages.remove(stageToClose);
    }


    /*
    Getter and Setters
     */
    public ColorTheme getColorTheme() {
        return colorTheme;
    }

    public void setColorTheme(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;
    }

    public FontSize getFontSize() {
        return fontSize;
    }

    public void setFontSize(FontSize fontSize) {
        this.fontSize = fontSize;
    }

    public void updateStyles() {
        for (Stage stage : activeStages) {
            Scene scene = stage.getScene();
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource(ColorTheme.getCssPath(colorTheme)).toExternalForm());
            scene.getStylesheets().add(getClass().getResource(FontSize.getCssPath(fontSize)).toExternalForm());
        }
    }
}
