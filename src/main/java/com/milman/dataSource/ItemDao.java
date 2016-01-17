package com.milman.dataSource;

import com.milman.entity.Item;

import java.util.List;
import java.util.Map;

public interface ItemDao {
    public Item insert(Item item);
    public Item fetchById(Long id);
    public Item fetchByParams(Map<String, Object> params);
    public Item fetchLast();
    public List<Item> fetchListByUserId(Long userId);
}
