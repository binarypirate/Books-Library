package com.example.library.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.library.databinding.ActivityCreateOrUpdateBookBinding;
import com.example.library.model.BookDetails;
import com.example.library.util.LibraryController;

public class CreateOrUpdateBookActivity extends AppCompatActivity {
    ActivityCreateOrUpdateBookBinding mBinding;
    LibraryController mLibraryController;
    BookDetails book = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityCreateOrUpdateBookBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mLibraryController = LibraryController.buildWith(openOrCreateDatabase(LibraryController.LIBRARY_DATA, MODE_PRIVATE, null));

        if (getIntent().hasExtra("book")) {
            book = (BookDetails) getIntent().getSerializableExtra("book");
            mBinding.saveBtn.setVisibility(View.GONE);
            mBinding.updateBookName.setText(book.bookName);
            mBinding.totalPages.setText(book.totalPages);
            mBinding.issueDate.setText(book.issueDate);
            mBinding.updateAuthorName.setText(book.authorName);
        } else {
            mBinding.updateBtn.setVisibility(View.GONE);
        }

        mBinding.saveBtn.setOnClickListener(v -> {
            String name = mBinding.updateBookName.getText().toString().trim();
            String authorName = mBinding.updateAuthorName.getText().toString().trim();
            String issueDate = mBinding.issueDate.getText().toString().trim();
            String totalPages = mBinding.totalPages.getText().toString().trim();
            mLibraryController.saveLibraryData(new BookDetails(name, totalPages, issueDate, authorName));
            finish();
        });

        mBinding.updateBtn.setOnClickListener(v -> {
            String name = mBinding.updateBookName.getText().toString().trim();
            String authorName = mBinding.updateAuthorName.getText().toString().trim();
            String issueDate = mBinding.issueDate.getText().toString().trim();
            String totalPages = mBinding.totalPages.getText().toString().trim();
            book = new BookDetails(book.getId(), name, totalPages, issueDate, authorName);
            mLibraryController.updateData(book);
            Toast.makeText(this, "Data is updated", Toast.LENGTH_SHORT).show();
        });
    }
}