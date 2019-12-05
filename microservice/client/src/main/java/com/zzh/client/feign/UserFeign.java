package com.zzh.client.feign;

import com.zzh.client.entity.User;
import com.zzh.client.entity.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "user")
public interface UserFeign {
    @GetMapping("/user/findAll/{index}/{limit}")
    public List<User> findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);

    @DeleteMapping("/user/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id);

    @PostMapping("/user/save")
    public void save(@RequestBody User user);

    @PutMapping("/user/update")
    public void update(@RequestBody User user);

    @GetMapping("/user/findById/{id}")
    public User findById(@PathVariable("id") long id);

    @GetMapping("/user/count")
    public int count();
}
