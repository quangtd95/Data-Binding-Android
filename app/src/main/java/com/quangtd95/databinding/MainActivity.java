package com.quangtd95.databinding;

import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.quangtd95.databinding.databinding.ActivityMainBinding;
import com.quangtd95.databinding.model.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        User user = new User("Thai Duy ", "Quang");
        binding.setUser(user);
        new Handler().postDelayed(() -> changeFirstName(user), 2000);
        new Handler().postDelayed(() -> changeLastName(user), 4000);
    }

    private void changeFirstName(User user) {
//        user.setFirstName(user.getFirstName() + " -> Ho");
        user.firstName.set(user.firstName.get()+" -> Ho");
    }

    private void changeLastName(User user) {
//        user.setLastName(user.getLastName() + " -> Ten");
        user.lastName.set(user.lastName.get()+" -> Ten");
    }
}
