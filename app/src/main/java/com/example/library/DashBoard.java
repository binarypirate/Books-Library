package com.example.library;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.library.databinding.ActivityDashBoardBinding;
import com.example.library.databinding.ActivityMainBinding;

public class DashBoard extends AppCompatActivity {
    ActivityDashBoardBinding mBinding;
    LibraryData mLibraryData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityDashBoardBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mLibraryData = LibraryData.buildWith(openOrCreateDatabase(LibraryData.LIBRARY_DATA, MODE_PRIVATE, null));

        mBinding.updateBtn.setOnClickListener(v -> {
            String name = mBinding.updateAuthorName.getText().toString().trim();
            String authorName = mBinding.updateAuthorName.getText().toString().trim();
            String issueDate = mBinding.issueDate.getText().toString().trim();
            String totalPages = mBinding.totalPages.getText().toString().trim();

            mLibraryData.saveLibraryData(new BookDetails(name,authorName,issueDate,totalPages));
            finish();
        });
    }
}