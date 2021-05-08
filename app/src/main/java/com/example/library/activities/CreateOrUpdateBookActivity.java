package com.example.library.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.library.databinding.ActivityCreateOrUpdateBookBinding;
import com.example.library.model.BookDetails;
import com.example.library.util.LibraryData;

public class CreateOrUpdateBookActivity extends AppCompatActivity {
    ActivityCreateOrUpdateBookBinding mBinding;
    LibraryData mLibraryData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityCreateOrUpdateBookBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mLibraryData = LibraryData.buildWith(openOrCreateDatabase(LibraryData.LIBRARY_DATA, MODE_PRIVATE, null));
        BookDetails book = (BookDetails) getIntent().getSerializableExtra("book");

        mBinding.saveBtn.setOnClickListener(v -> {
            String name = mBinding.updateAuthorName.getText().toString().trim();
            String authorName = mBinding.updateAuthorName.getText().toString().trim();
            String issueDate = mBinding.issueDate.getText().toString().trim();
            String totalPages = mBinding.totalPages.getText().toString().trim();

            mLibraryData.saveLibraryData(new BookDetails(name,authorName,issueDate,totalPages));
            finish();
        });
        mBinding.updateBtn.setOnClickListener(v -> {
            String name = mBinding.updateAuthorName.getText().toString().trim();
            String authorName = mBinding.updateAuthorName.getText().toString().trim();
            String issueDate = mBinding.issueDate.getText().toString().trim();
            String totalPages = mBinding.totalPages.getText().toString().trim();
            boolean isUpdate = mLibraryData.updateData( book.toString(),name,authorName,issueDate,totalPages);
            if(isUpdate == true){
                Toast.makeText(this, "Data is updated", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "Data is not updated", Toast.LENGTH_SHORT).show();
            }
        });
    }
}