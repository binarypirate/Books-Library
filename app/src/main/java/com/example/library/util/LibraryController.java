package com.example.library.util;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.library.model.BookDetails;

import java.util.ArrayList;
import java.util.List;

public class LibraryController {
    public final static String LIBRARY_DATA = "lb";
    private  final String DATA_RECORD_TABLE = "DATA";

    private String id = "id";
    public final String book_name = "book_name";
    private final String total_pages = "total_pages";
    private final String author_name = "author_name";
    private final String issue_date = "issue_date";

    private final SQLiteDatabase booksRecordDataBase;

    public LibraryController(SQLiteDatabase booksRecordDataBase) {
        this.booksRecordDataBase = booksRecordDataBase;
    }

    private void createBooksDataTable(){
        String query = "CREATE TABLE IF NOT EXISTS " + DATA_RECORD_TABLE + "(" +
                id + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                book_name + " VARCHAR(100) NOT NULL," +
                total_pages + " VARCHAR(5) NOT NULL, " +
                author_name + " VARCHAR(100) NOT NULL,"+
                issue_date + " VARCHAR(15) NOT NULL" + ")";
        booksRecordDataBase.execSQL(query);
    }

    public void saveLibraryData(BookDetails bookDetails){
        String query = "INSERT INTO " + DATA_RECORD_TABLE + "("
                + book_name + "," + total_pages + "," + issue_date + "," + author_name + ")" +
                "VALUES ('"+bookDetails.bookName+"' , '"+bookDetails.totalPages+"' , '"+
                bookDetails.issueDate+"', '"+bookDetails.authorName+"')";
        booksRecordDataBase.execSQL(query);
    }

    public BookDetails getBookDetail(String id) {
        Cursor cursor = booksRecordDataBase.rawQuery("SELECT * FROM " + DATA_RECORD_TABLE + " WHERE id='"+id+"'", null);
        cursor.moveToFirst();
        BookDetails bookDetail = new BookDetails(cursor.getString(1), cursor.getString(2),cursor.getString(4)
                ,cursor.getString(3));
        bookDetail.setId(cursor.getString(0));
        return bookDetail;
    }

    public List<BookDetails> getBookDetailsData(String filter) {
        Cursor cursor = booksRecordDataBase.rawQuery("SELECT * FROM " + DATA_RECORD_TABLE , null);
        List<BookDetails> bookDetails = new ArrayList<>();
        while (cursor.moveToNext()){
            BookDetails bookDetail = new BookDetails(cursor.getString(1), cursor.getString(2),cursor.getString(4)
            ,cursor.getString(3));
            bookDetail.setId(cursor.getString(0));
            if (bookDetail.bookName.contains(filter) || bookDetail.authorName.contains(filter)) {
                bookDetails.add(bookDetail);
            }
        }
        return bookDetails;
    }

    public void deleteData(BookDetails book) {
        String query = "DELETE FROM " + DATA_RECORD_TABLE + " WHERE id='"+book.getId()+"'";
        booksRecordDataBase.execSQL(query);
    }

    public void updateData(BookDetails book) {
        String query = "UPDATE " + DATA_RECORD_TABLE + " SET " +
                book_name + "='" + book.bookName  + "', " +
                total_pages + "='" + book.totalPages  + "', " +
                author_name + "='" + book.authorName  + "', " +
                issue_date + "='" + book.issueDate  + "' " +
                "WHERE " + id + "='"+book.getId()+"'";
        Log.d("UpdateQuery", "updateData: "+ query);
        booksRecordDataBase.execSQL(query);
    }

    public static LibraryController buildWith(SQLiteDatabase historyDatabase) {
        LibraryController data = new LibraryController(historyDatabase);
        data.createBooksDataTable();
        return data;
    }
}