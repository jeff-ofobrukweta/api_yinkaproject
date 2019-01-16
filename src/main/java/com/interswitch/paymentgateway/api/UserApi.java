package com.interswitch.paymentgateway.api;

import com.interswitch.paymentgateway.api.Handlers.LoginRequest;
import com.interswitch.paymentgateway.api.Handlers.Response;
import com.interswitch.paymentgateway.api.Handlers.SignupRequest;
import com.interswitch.paymentgateway.api.Handlers.SignupResponse;
import com.interswitch.paymentgateway.dao.UserDao;
import com.interswitch.paymentgateway.model.User;
import com.interswitch.paymentgateway.util.AccountUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api/v1")

public class UserApi {
    @Autowired
    UserDao userDao;

    @PostMapping("/api/v1/signup")
    public Response signup(@Validated @RequestBody SignupRequest request){
        Response response = null;
        System.out.println(request);
        response = new SignupResponse("00","Successful",null, AccountUtil.generateAccountNo(10));
        return  response;
    }

    @PostMapping("/login")
    public  Response login(@Validated @RequestBody LoginRequest request){
        Response response = null;
        return  response;
    }

    @GetMapping(value="/hello")
    public String welcome(){
        return  "hello foul get request";
    }

    @RequestMapping(value = "/profiles",method = RequestMethod.POST)
    public ResponseEntity<Object>createprofile(@RequestBody User user){
        userDao.createprofile(user);
        return new ResponseEntity<>("Profile created Sucessfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/profiles",method = RequestMethod.GET)
    public ResponseEntity<Object>getUsers(){
        return new ResponseEntity<>(userDao.getUsers(),HttpStatus.OK);
    }

    @RequestMapping(value = "/profiles/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Object>updateUsers(@RequestBody User user, @PathVariable("id") String id){
        userDao.updateProfile(user,id);
        return new ResponseEntity<>("Profile updated sucessfully",HttpStatus.OK); }

    @RequestMapping(value = "/profiles/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Object>deleteUsers(@PathVariable("id") String id){
        userDao.deleteProfile(id);
        return new ResponseEntity<>("Profile Deleted sucessfully",HttpStatus.OK); }
}
