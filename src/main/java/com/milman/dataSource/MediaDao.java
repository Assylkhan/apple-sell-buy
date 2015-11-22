package com.milman.dataSource;

import com.milman.entity.Media;

public interface MediaDao {
    public Media insert(Media media);
    public Media findById(Long id);
}
