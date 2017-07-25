package com.quangtd95.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.quangtd95.databinding.databinding.ActivityMainBinding;
import com.quangtd95.databinding.model.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ListUserAdapter.OnItemClickListener {
    private ObservableField<String> title = new ObservableField<>();
    private ListUserAdapter listUserAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        title.set("Example data binding Recycler View");
        binding.setMain(this);
        setData();
        binding.recycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.recycleView.setAdapter(listUserAdapter);
    }

    private void setData() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            User user = new User("firstName " + i, "lastName " + i);
            users.add(user);
        }
        listUserAdapter = new ListUserAdapter(users);
        listUserAdapter.setOnItemClickListener(this);
    }

    @Override public void itemClick(User user) {
        Toast.makeText(this, "onClick " + user.firstName, Toast.LENGTH_SHORT).show();
    }
}
