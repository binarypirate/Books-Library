package com.example.library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import com.example.library.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnBookStoreCardClickListener{
    ActivityMainBinding mBinding;
    LibraryAdapter mLibraryAdapter;
    LibraryData mLibraryData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.addFloatingBar.setOnClickListener(v ->{
            Intent intent = new Intent(MainActivity.this,DashBoard.class);
            startActivity(intent);
        });

        mLibraryData = LibraryData.buildWith(openOrCreateDatabase(LibraryData.LIBRARY_DATA, MODE_PRIVATE, null));
        mLibraryAdapter = new LibraryAdapter(mLibraryData.getBookDetailsData(), this);

        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mBinding.recyclerView.setAdapter(mLibraryAdapter);

    }

    @Override
    public void onBookStoreCardClick(BookDetails bookDetails) {
        Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
        startActivity(intent);

    }
}