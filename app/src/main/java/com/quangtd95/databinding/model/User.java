package com.quangtd95.databinding.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

import com.quangtd95.databinding.BR;

/**
 * Quang_TD on 7/25/2017.
 */

public class User extends BaseObservable {
   /* private String firstName;
    private String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //Binding lấy data từ hàm get.
    @Bindable
    public String getFirstName() {
        return firstName;
    }

    //Binding lấy data từ hàm get.
    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;

        //thông báo thay đổi dữ liệu
        notifyPropertyChanged(BR.firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }*/

    //thay thế cho đoạn code trên
    //tương đương nhau
    public ObservableField<String> firstName = new ObservableField<>();
    public ObservableField<String> lastName = new ObservableField<>();

    public User(String firstName, String lastName) {
        this.firstName.set(firstName);
        this.lastName.set(lastName);
    }
}
