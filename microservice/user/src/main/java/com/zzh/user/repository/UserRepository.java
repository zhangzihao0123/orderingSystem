package com.zzh.user.repository;

import com.zzh.user.entity.User;

import java.util.List;

public interface UserRepository {
    public List<User> findAll(int index,int limit);
    public int count();
    public User findById(Long id);
    public void update(User user);
    public void deleteById(long id);
    public void save(User user);
}
