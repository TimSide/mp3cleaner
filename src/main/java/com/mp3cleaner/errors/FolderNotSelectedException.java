package com.mp3cleaner.errors;

public class FolderNotSelectedException extends Exception {
    private String message;

    public FolderNotSelectedException() {
        super("Exception: Folder not selected");
        this.message = "Exception: Folder not selected";
    }

    @Override
    public String getMessage() {
        System.err.println(message);
        return message;
    }
}
