package com.example.library.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.library.databinding.ActivityDetailsBinding;
import com.example.library.model.BookDetails;

public class DetailsActivity extends AppCompatActivity {
    ActivityDetailsBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        BookDetails book = (BookDetails) getIntent().getSerializableExtra("book");

        Toast.makeText(this, book.toString(), Toast.LENGTH_LONG).show();
    }
}