package com.interswitch.paymentgateway.dao;

import com.interswitch.paymentgateway.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int createprofile(User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update((Connection connection) -> {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("INSERT INTO PROFILE(FIRSTNAME,LASTNAME,PASSWORD,EMAIL,ACCOUNTNUMBER,MOBILENUMBER)VALUES(?,?,?,?,?,?) ", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getAccount_number());
            preparedStatement.setString(6, user.getMobile_number());
            return preparedStatement;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public List<User> getUsers() {
        List<User> userProfile = new ArrayList<>();
        Collection<Map<String, Object>> rows = null;
        rows = jdbcTemplate.queryForList("SELECT ID,FIRSTNAME,LASTNAME,PASSWORD,EMAIL,ACCOUNTNUMBER,MOBILENUMBER FROM PROFILE");
        rows.stream().map((row) -> {
            User SingleUser = new User();
            SingleUser.setId((String) row.get("ID"));
            SingleUser.setFirstName((String) row.get("FIRSTNAME"));
            SingleUser.setLastName((String) row.get("LASTNAME"));
            SingleUser.setPassword((String) row.get("PASSWORD"));
            SingleUser.setEmail((String) row.get("EMAIL"));
            SingleUser.setAccount_number((String) row.get("ACCOUNTNUMBER"));
            SingleUser.setMobile_number((String) row.get("MOBILENUMBER"));
            return SingleUser;
        }).forEach((ss) -> {
            userProfile.add(ss);
        });
        return userProfile;
    }

    @Override
    public void updateProfile(User user, String id) {
        jdbcTemplate.update("UPDATE PROFILE SET FIRSTNAME=?,LASTNAME=?,PASSWORD=?,EMAIL=?,ACCOUNTNUMBER=?,MOBILENUMBER=? WHERE ID=?", new Object[]{
                user.getFirstName(), user.getLastName(), user.getEmail(), user.getAccount_number(), user.getPassword(), user.getMobile_number(),id});
    }

    @Override
    public void deleteProfile(String id) {
        jdbcTemplate.update("DELETE FROM PROFILE WHERE ID=?", new Object[]{id});
    }
}
