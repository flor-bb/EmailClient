package com.florb.controller;

import com.florb.EmailManager;
import com.florb.view.ViewManager;

public abstract class BaseController {

    protected EmailManager emailManager;
    protected ViewManager viewManager;
    private String fxmlName;

    public BaseController(EmailManager emailManager, ViewManager viewManager, String fxmlName) {
        this.emailManager = emailManager;
        this.viewManager = viewManager;
        this.fxmlName = fxmlName;
    }

    public String getFxmlName() {
        return fxmlName;
    }
}
