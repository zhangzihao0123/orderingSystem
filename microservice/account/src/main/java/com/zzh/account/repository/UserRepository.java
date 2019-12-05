package com.zzh.account.repository;

import com.zzh.account.entity.Admin;
import com.zzh.account.entity.User;

public interface UserRepository {
    public User login(String username, String password);
}
