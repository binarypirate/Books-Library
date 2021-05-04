package com.example.library.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.library.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {
    ActivityDetailsBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());


    }
}