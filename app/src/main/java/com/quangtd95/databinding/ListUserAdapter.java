package com.quangtd95.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.quangtd95.databinding.databinding.ItemListUserBinding;
import com.quangtd95.databinding.model.User;

import java.util.List;

/**
 * Quang_TD on 7/25/2017.
 */

public class ListUserAdapter extends RecyclerView.Adapter<ListUserAdapter.UserHolder> {
    private List<User> users;
    private OnItemClickListener onItemClickListener;

    public ListUserAdapter(List<User> users) {
        this.users = users;
    }

    @Override public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemListUserBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_list_user, parent, false);
        return new UserHolder(binding, onItemClickListener);
    }

    @Override public void onBindViewHolder(UserHolder holder, int position) {
        holder.setBinding(users.get(position), position);
    }

    @Override public int getItemCount() {
        return users.size();
    }

    public class UserHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ObservableField<String> stt = new ObservableField<>();
        public ObservableField<String> firstName = new ObservableField<>();
        public ObservableField<String> lastName = new ObservableField<>();
        private User user;
        private ItemListUserBinding itemListUserBinding;
        private OnItemClickListener onItemClickListener;

        UserHolder(ItemListUserBinding itemListUserBinding, OnItemClickListener onItemClickListener) {
            super(itemListUserBinding.getRoot());
            this.itemListUserBinding = itemListUserBinding;
            this.onItemClickListener = onItemClickListener;
            itemListUserBinding.getRoot().setOnClickListener(this);
        }

        void setBinding(User user, int position) {
            if (itemListUserBinding.getViewHolder() == null) {
                itemListUserBinding.setViewHolder(this);
            }
            this.user = user;
            stt.set(String.valueOf(position));
            firstName.set(user.firstName.get());
            lastName.set(user.lastName.get());

        }

        @Override public void onClick(View v) {
            if (this.onItemClickListener != null) {
                this.onItemClickListener.itemClick(user);
            }
        }
    }

    public interface OnItemClickListener {
        void itemClick(User user);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
