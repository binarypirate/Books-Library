package com.example.library;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class LibraryData {
    public final static String LIBRARY_DATA = "lb";
    private  final String DATA_RECORD_TABLE = "DATA";

    private String id = "id";
    public final String book_name = "book_name";
    private final String total_pages = "total_pages";
    private final String author_name = "author_name";
    private final String issue_date = "issue_date";

    private final SQLiteDatabase booksRecordDataBase;

    public LibraryData(SQLiteDatabase booksRecordDataBase) {
        this.booksRecordDataBase = booksRecordDataBase;
    }


    private void createBooksDataTable(){
        String query = "CREATE TABLE IF NOT EXISTS " + DATA_RECORD_TABLE + "("
                +id + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
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
    public List<BookDetails> getBookDetailsData(){
        Cursor cursor = booksRecordDataBase.rawQuery("SELECT * FROM " + DATA_RECORD_TABLE , null);
        List<BookDetails> bookDetails = new ArrayList<>();
        while (cursor.moveToNext()){
            bookDetails.add(new BookDetails(cursor.getString(1), cursor.getString(2),cursor.getString(3)
            ,cursor.getString(4)));
        }
        return bookDetails;
    }
    public static LibraryData buildWith(SQLiteDatabase historyDatabase) {
        LibraryData data = new LibraryData(historyDatabase);
        data.createBooksDataTable();
        return data;
    }
}
