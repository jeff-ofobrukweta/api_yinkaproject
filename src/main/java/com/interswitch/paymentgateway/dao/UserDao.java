package com.interswitch.paymentgateway.dao;
import com.interswitch.paymentgateway.model.User;

import java.util.List;

public interface UserDao {
    public abstract int createprofile(User user);
    public abstract List<User>getUsers();
    public abstract void updateProfile(User user,String id);
    public abstract void deleteProfile(String id);
}
