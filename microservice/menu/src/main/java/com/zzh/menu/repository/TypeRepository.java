package com.zzh.menu.repository;

import com.zzh.menu.entity.Type;

import java.util.List;

public interface TypeRepository {
    public Type findById(long id);
    public List<Type> findAll();
}
