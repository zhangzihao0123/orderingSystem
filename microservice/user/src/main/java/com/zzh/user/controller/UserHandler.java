package com.zzh.user.controller;

import com.zzh.user.entity.User;
import com.zzh.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/findAll/{index}/{limit}")
    public List<User> findAll(@PathVariable("index") int index,@PathVariable("limit") int limit){
        return userRepository.findAll(index,limit);
    }

    @PostMapping("/save")
    public void save(@RequestBody User user){
        userRepository.save(user);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        userRepository.deleteById(id);
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") long id){
        return userRepository.findById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody User user){
        userRepository.update(user);
    }

    @GetMapping("/count")
    public int count(){
        return userRepository.count();
    }
}
