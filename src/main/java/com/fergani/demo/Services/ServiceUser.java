package com.fergani.demo.Services;

import com.fergani.demo.Models.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;


/**
 * Created By ${
 * FERGANI DIA EL EDDINE
 * }  On
 * 21
 * sept.
 * 2020
 */
public class ServiceUser {


    /**
     * use api extern
     */
    private String Url ="http://localhost:8080/api/";
    private RestTemplate restTemplate = new RestTemplate();


    public User[] GetUsers(){
        String action = "user/getusers";
        return restTemplate.getForObject(Url+action,User[].class);
    }

    public void PostUser(User user){
        String action = "user/postuser";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> userHttpEntity = new HttpEntity<User>(user,httpHeaders);
        restTemplate.postForObject(Url+action,userHttpEntity,User.class);


    }

}
