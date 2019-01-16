package com.interswitch.paymentgateway.dao;
import com.interswitch.paymentgateway.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
//@WebMvcTest(value = UserDaoTest.class,secure = false)
public class UserDaoTest {
    @Autowired
    private NamedParameterJdbcTemplate parameterJdbcTemplate;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    public void test(){
        User actor = this.jdbcTemplate.queryForObject(
                "select * from user_newtable where id = ?" ,
                new Object[]{1},
                (rs, rowNum) -> {
                    User user = new User();
                    user.setFirstName(rs.getString("firstName"));
                    user.setLastName(rs.getString("lastName"));
                    user.setEmail(rs.getString("email"));
                    user.setAccount_number(rs.getString("account_number"));
                    user.setMobile_number(rs.getString("mobile_number"));
                    return  user;
                });

                System.out.println(actor);
    }
    @Test
    public void testNamed(){
        SqlParameterSource namedParameters = new MapSqlParameterSource("id",1);
        User user = parameterJdbcTemplate.queryForObject("select * from user_newtable where id = ?",namedParameters,new BeanPropertyRowMapper<>(User.class));
        System.out.println(user);
    }
}
