package com.zzh.order.repository;


import com.zzh.order.entity.User;

import java.util.List;


public interface UserRepository {
    public void update(User user);
    public List<User> findAll(int index, int limit);
    public int count();
    public void save(User user);
    public void deleteById(long id);
    public User findById(long id);

}
