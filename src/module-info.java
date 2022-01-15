module EmailClient {

    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.web;
    requires activation;
    requires java.mail;

    opens com.florb;
    opens com.florb.view;
    opens com.florb.controller;
    opens com.florb.model;

}