package com.zzh.menu.repository;

import com.zzh.menu.entity.Menu;

import java.util.List;

public interface MenuRepository {
    public List<Menu> findAll(int index, int limit);
    public int count();
    public Menu findById(Long id);
    public void update(Menu menu);
    public void deleteById(long id);
    public void save(Menu menu);
}
