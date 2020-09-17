package com.fergani.demo.Controllers;
import com.fergani.demo.DataBase.UserData;
import com.fergani.demo.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/user")

public class UserController {
   @Autowired
   private UserData datain;

    @PostMapping("/SetUser")
    public void SetUser(@RequestBody User user){

        System.out.println("ID :" + user.getId());
        System.out.println("FirstName :" + user.getFirstName());
        System.out.println("Lastname :" + user.getLastname());
        try {
            datain.insert(user);
        }catch (Exception e){
          System.out.println("no insart");
        }

    }

    @GetMapping("/getUsers")
    public List<User> getUser(){
        return   datain.GetAllUser();

    }

     @GetMapping("/getUserById/{id}")
     public User getUserById(@PathVariable String id){
        List<User> users = new ArrayList<>();
        users.add(new User(1,"fer","ramy"));
        users.add(new User(2,"fer","dia"));
        users.add(new User(3,"fer","chmso"));
        users.add(new User(4,"fer","ddd"));
        User user = users.stream().filter(u -> u.getId()==Integer.parseInt(id)).findAny().orElse(null);
        return user;
    }

    @GetMapping("/deleteUsers/{id}")
    public int DeleteUser(@PathVariable int id ){
        return   datain.delete(id);

    }
   @GetMapping("/updataUsers")
    public int updataUser(@RequestBody User user){
        return   datain.UpdataUser(user);

    }


}
