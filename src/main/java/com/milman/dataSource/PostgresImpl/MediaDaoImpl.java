package com.milman.dataSource.PostgresImpl;

import com.milman.dataSource.MediaDao;
import com.milman.entity.Media;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class MediaDaoImpl extends JdbcDaoSupport implements MediaDao {
    @Override
    public Media insert(Media media) {
        return null;
    }

    @Override
    public Media findById(Long id) {
        return null;
    }
}
