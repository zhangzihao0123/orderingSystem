package com.zzh.client.controller;

import com.zzh.client.entity.Account;
import com.zzh.client.entity.Admin;
import com.zzh.client.entity.User;
import com.zzh.client.feign.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;

@Controller
@RequestMapping("/account")
public class AccountHandler {

    @Autowired
    private AccountFeign accountFeign;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("type") String type,HttpSession session){
        Account account = accountFeign.login(username, password, type);
//        LinkedHashMap<String,Object> hashMap= (LinkedHashMap)object;
        String result=null;
            if (account==null){
            result="login";
        }else{
            switch (type){
                case "user":
                    User user=new User();
                    user.setId(account.getId());
                    user.setNickname(account.getNickname());
                    session.setAttribute("user",user);
                    result="index";
                    break;
                case "admin" :
                    Admin admin=new Admin();
                    admin.setId(account.getId());
                    admin.setUsername(account.getUsername());
                    admin.setPassword(account.getPassword());

                    session.setAttribute("admin",admin);
                    result="main.html";
                    break;
            }
        }
        return result;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login.html";
    }
}
