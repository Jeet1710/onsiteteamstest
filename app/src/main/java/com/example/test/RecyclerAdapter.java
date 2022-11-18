package com.example.test;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.databinding.ItemValuesBinding;

import java.util.ArrayList;
final
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    private  ArrayList<String> values;

    public RecyclerAdapter(MainViewModel viewModel) {
        values = viewModel.getValues().getValue();
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemValuesBinding binding = ItemValuesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new RecyclerViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.binding.setData(values.get(position));
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        ItemValuesBinding binding;
        public RecyclerViewHolder(@NonNull ItemValuesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
