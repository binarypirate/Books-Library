package com.example.library;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.library.databinding.BookItemsBinding;

public class LibraryViewHolder extends RecyclerView.ViewHolder {
    BookItemsBinding mBinding;

    public LibraryViewHolder(@NonNull BookItemsBinding mBinding) {
        super(mBinding.getRoot());
        this.mBinding = mBinding;

    }
}
