package com.example.library.model;

import java.io.Serializable;

public class Book implements Serializable {
    public final String bookName;
    public final String totalPages;
    public final String issueDate;
    public final String authorName;

    public Book(String bookName, String totalPages, String issueDate, String authorName) {
        this.bookName = bookName;
        this.totalPages = totalPages;
        this.issueDate = issueDate;
        this.authorName = authorName;
    }
}
