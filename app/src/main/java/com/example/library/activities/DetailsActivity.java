package com.example.library.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.library.databinding.ActivityDetailsBinding;
import com.example.library.model.BookDetails;
import com.example.library.util.LibraryController;

public class DetailsActivity extends AppCompatActivity {
    ActivityDetailsBinding mBinding;

    LibraryController mLibraryController;
    BookDetails mBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mLibraryController = LibraryController.buildWith(openOrCreateDatabase(LibraryController.LIBRARY_DATA, MODE_PRIVATE, null));
        mBook = (BookDetails) getIntent().getSerializableExtra("book");

        mBinding.deleteBtn.setOnClickListener(v -> {
            mLibraryController.deleteData(mBook);
            finish();
        });

        mBinding.editBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, CreateOrUpdateBookActivity.class);
            intent.putExtra("book", mBook);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mBinding.bookName.setText(mLibraryController.getBookDetail(mBook.getId()).toString());
    }
}