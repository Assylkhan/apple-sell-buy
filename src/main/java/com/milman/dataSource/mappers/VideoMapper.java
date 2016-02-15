package com.milman.dataSource.mappers;

import com.milman.entity.ItemImage;
import com.milman.entity.ItemVideo;
import com.milman.entity.Media;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VideoMapper implements RowMapper<ItemVideo> {

    @Override
    public ItemVideo mapRow(ResultSet resultSet, int i) throws SQLException {
        ItemVideo itemVideo = new ItemVideo();
        itemVideo.setId(resultSet.getLong("id"));
        itemVideo.setMediaType(
                Media.MediaType.typeFromInt(resultSet.getInt("media_type_id")));
        itemVideo.setDescription(resultSet.getString("description"));
        itemVideo.setMediaRef(resultSet.getString("media_ref"));
        return itemVideo;
    }

}