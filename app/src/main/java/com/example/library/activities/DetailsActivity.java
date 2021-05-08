package com.example.library.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import com.example.library.R;
import com.example.library.databinding.ActivityDetailsBinding;
import com.example.library.model.BookDetails;
import com.example.library.util.LibraryData;

public class DetailsActivity extends AppCompatActivity {
    ActivityDetailsBinding mBinding;

    LibraryData mLibraryData;

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());


        BookDetails book = (BookDetails) getIntent().getSerializableExtra("book");

//        String desplayData = "";
//        for (int data : book.){
//            desplayData = desplayData + data + "\n";
//        }

        mBinding.bookName.setText(book.bookName + "\n" + book.issueDate + "\n" + book.totalPages
        + "\n" + book.authorName);
        Toast.makeText(this, book.toString(), Toast.LENGTH_LONG).show();


        mBinding.deleteBtn.setOnClickListener(v -> {
            mLibraryData.deleteData(book.toString());
            Toast.makeText(this, "deleted", Toast.LENGTH_SHORT).show();
        });

        mBinding.editBtn.setOnClickListener(v -> {
            Intent intent = new Intent(DetailsActivity.this, CreateOrUpdateBookActivity.class);
            startActivity(intent);
        });
    }

}