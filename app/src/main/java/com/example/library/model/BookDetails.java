package com.example.library.model;

import androidx.annotation.NonNull;
import java.io.Serializable;

public class BookDetails extends Book implements Serializable {
    private String id;

    public BookDetails(String bookName, String totalPages, String issueDate, String authorName) {
        super(bookName, totalPages, issueDate, authorName);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NonNull
    @Override
    public String toString() {
        return "BookDetails{" +
                "id='" + id + "\'," +
                "bookName='" + bookName + '\'' +
                ", totalPages='" + totalPages + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}
