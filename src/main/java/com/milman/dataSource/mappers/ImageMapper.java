package com.milman.dataSource.mappers;

import com.milman.entity.ItemImage;
import com.milman.entity.Media;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ImageMapper implements RowMapper<ItemImage> {

    @Override
    public ItemImage mapRow(ResultSet resultSet, int i) throws SQLException {
        ItemImage itemImage = new ItemImage();
        itemImage.setId(resultSet.getLong("id"));
        itemImage.setMediaType(
                Media.MediaType.typeFromInt(resultSet.getInt("media_type_id")));
        itemImage.setDescription(resultSet.getString("description"));
        itemImage.setMediaRef(resultSet.getString("media_ref"));
        return itemImage;
    }

}