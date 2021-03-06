package com.florb;

import com.florb.controller.services.FetchFoldersService;
import com.florb.model.EmailAccount;
import com.florb.model.EmailTreeItem;
import javafx.scene.control.TreeItem;

public class EmailManager {


    //Folder handling
    private EmailTreeItem<String> foldersRoot = new EmailTreeItem<>("");
    public EmailTreeItem<String> getFoldersRoot(){
        return foldersRoot;
    }

    public void addEmailAccount(EmailAccount emailAccount){
        EmailTreeItem<String> treeItem = new EmailTreeItem<String>(emailAccount.getAddress());
        FetchFoldersService fetchFoldersService = new FetchFoldersService(emailAccount.getStore(), treeItem);
        fetchFoldersService.start();
        foldersRoot.getChildren().add(treeItem);
    }
}
