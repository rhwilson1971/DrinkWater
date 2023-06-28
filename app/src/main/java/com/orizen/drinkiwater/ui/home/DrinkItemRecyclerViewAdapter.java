package com.orizen.drinkiwater.ui.home;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.orizen.drinkiwater.data.model.DrinkItemEntry;
import com.orizen.drinkiwater.databinding.FragmentItemBinding;
import com.orizen.drinkiwater.ui.placeholder.PlaceholderContent.PlaceholderItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class DrinkItemRecyclerViewAdapter extends RecyclerView.Adapter<DrinkItemRecyclerViewAdapter.ViewHolder> {

    private final List<DrinkItemEntry> mValues;

    public DrinkItemRecyclerViewAdapter(List<DrinkItemEntry> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.drinkAmount.setText(mValues.get(position).getAmount().toString());
        holder.drinkName.setText(mValues.get(position).getDrinkName());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView drinkName;
        public final TextView drinkAmount;
        public DrinkItemEntry mItem;
        public ViewHolder(FragmentItemBinding binding) {
            super(binding.getRoot());
            drinkName = binding.textViewDrink;
            drinkAmount = binding.textViewAmount;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + drinkName.getText() + "' " + drinkAmount.getText() + "'";
        }
    }
}