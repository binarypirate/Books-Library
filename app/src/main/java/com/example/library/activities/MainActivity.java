package com.example.library.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.library.model.BookDetails;
import com.example.library.adapter.LibraryAdapter;
import com.example.library.util.LibraryController;
import com.example.library.adapter.OnBookStoreCardClickListener;
import com.example.library.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements OnBookStoreCardClickListener {
    ActivityMainBinding mBinding;
    LibraryAdapter mLibraryAdapter;
    LibraryController mLibraryController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.addFloatingBar.setOnClickListener(v -> startActivity(new Intent(this, CreateOrUpdateBookActivity.class)));

        mLibraryController = LibraryController.buildWith(openOrCreateDatabase(LibraryController.LIBRARY_DATA, MODE_PRIVATE, null));
        mLibraryAdapter = new LibraryAdapter(this);

        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mBinding.recyclerView.setAdapter(mLibraryAdapter);

        mBinding.search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mLibraryAdapter.setBooks(mLibraryController.getBookDetailsData(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public void onBookStoreCardClick(BookDetails bookDetails) {
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra("book", bookDetails);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mLibraryAdapter.setBooks(mLibraryController.getBookDetailsData(""));
    }
}