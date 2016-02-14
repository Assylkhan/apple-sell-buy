package com.milman.dataSource.mappers;

import com.milman.entity.ItemImage;
import com.milman.entity.Media;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MediaMapper implements RowMapper<ItemImage> {

    @Override
    public ItemImage mapRow(ResultSet resultSet, int i) throws SQLException {
        ItemImage media = new ItemImage();
        media.setId(resultSet.getLong("id"));
        media.setMediaType(
                Media.MediaType.typeFromInt(resultSet.getInt("media_type_id")));
        media.setDescription(resultSet.getString("description"));
        media.setMediaRef(resultSet.getString("media_ref"));
        return media;
    }

}
