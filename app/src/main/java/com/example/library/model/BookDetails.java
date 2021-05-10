package com.example.library.model;

import androidx.annotation.NonNull;
import java.io.Serializable;

public class BookDetails extends Book implements Serializable {
    private String id;

    public BookDetails(String bookName, String totalPages, String issueDate, String authorName) {
        super(bookName, totalPages, issueDate, authorName);
    }

    public BookDetails(String id, String bookName, String totalPages, String issueDate, String authorName) {
        super(bookName, totalPages, issueDate, authorName);
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @NonNull
    @Override
    public String toString() {
        return "BookDetail: \n" +
                "Book Name: " + bookName + "\n" +
                "Total Pages: " + totalPages + "\n" +
                "Issue Date: " + issueDate + "\n" +
                "Author Name: " + authorName;
    }
}
