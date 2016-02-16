package com.milman.dataSource.mappers;

import com.milman.entity.Item;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemMapper implements RowMapper<Item> {
    @Override
    public Item mapRow(ResultSet resultSet, int i) throws SQLException {
        Item item = new Item();
        item.setId(resultSet.getLong("id"));
        item.setName(resultSet.getString("item_name"));
        item.setDescription(resultSet.getString("description"));
        item.setPrice(resultSet.getString("price"));
        item.setPublicationDate(resultSet.getDate("publication_date"));
        item.setRegion(resultSet.getString("region"));
        item.setViewsAmount(resultSet.getByte("views_amount"));
        return item;
    }
}
