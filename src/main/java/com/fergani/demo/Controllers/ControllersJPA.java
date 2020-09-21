package com.fergani.demo.Controllers;

import com.fergani.demo.DataBase.UserDataJPA;
import com.fergani.demo.Models.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created By ${
 * FERGANI DIA EL EDDINE
 * }  On
 * 19
 * sept.
 * 2020
 */
@RestController
@RequestMapping("api/userjpa")
public class ControllersJPA {
    @Autowired
    private UserDataJPA dataJPA;

    @GetMapping("/getusersjpa")
    public List<UserJPA> getUsers(){
        return dataJPA.findAll();
    }
    @GetMapping("/getusersjpaById/{id}")
    public Optional<UserJPA> getUserById(@PathVariable int id ){
        return dataJPA.findById(id)  ;
    }
    @GetMapping("/deletuserJpa/{id}")
    public void  deletuserJpa(@PathVariable int id ){ dataJPA.deleteById(id);
    }
    @GetMapping("/getusersjpaByName/{name}")
    public void  GetUsersByName(@PathVariable String name ){ dataJPA.GetUsersByName(name);
    }

     @PostMapping("/updateuser")
    public void updateUserJpa(@RequestBody UserJPA userJPA){
         dataJPA.save(userJPA);

     }
  @PostMapping("/posteuser")
    public void PostUserJpa(@RequestBody UserJPA userJPA){
         dataJPA.save(userJPA);

     }

}
