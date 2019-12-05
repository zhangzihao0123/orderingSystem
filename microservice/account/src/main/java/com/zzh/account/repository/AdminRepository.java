package com.zzh.account.repository;

import com.zzh.account.entity.Admin;
import com.zzh.account.entity.User;

public interface AdminRepository {
    public Admin login(String username, String password);
}
