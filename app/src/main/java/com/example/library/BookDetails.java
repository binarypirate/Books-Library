package com.example.library;

public class BookDetails {
    public final String bookName ;
    public final String totalPages;
    public final String issueDate;
    public final String authorName;

    public BookDetails(String bookName, String totalPages, String issueDate, String authorName) {
        this.bookName = bookName;
        this.totalPages = totalPages;
        this.issueDate = issueDate;
        this.authorName = authorName;
    }


    public String getBookName() {
        return bookName;
    }

    public String getTotalPages() {
        return totalPages;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public String getAuthorName() {
        return authorName;
    }


    @Override
    public String toString() {
        return "BookDetails{" +
                "bookName='" + bookName + '\'' +
                ", totalPages='" + totalPages + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}
