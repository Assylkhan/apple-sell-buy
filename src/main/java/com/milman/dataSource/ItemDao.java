package com.milman.dataSource;

import com.milman.entity.Item;

import java.util.List;
import java.util.Map;

public interface ItemDao {
    public Item insert(Item item);
    public Item fetchById(Long id);
    public Item fetchByParams(Map<String, Object> params);
    public Item fetchLast();
    public void deleteById(Long id);
    public List<Item> fetchList();
    public List<Item> fetchListByUserId(Long userId);
    public List<Item> fetchByName(String name);
}
