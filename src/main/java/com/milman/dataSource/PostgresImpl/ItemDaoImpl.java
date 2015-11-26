package com.milman.dataSource.PostgresImpl;

import com.milman.dataSource.ItemDao;
import com.milman.dataSource.mappers.ItemMapper;
import com.milman.dataSource.mappers.MediaMapper;
import com.milman.entity.Item;
import com.milman.entity.Media;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemDaoImpl extends JdbcDaoSupport implements ItemDao {

    @Override
    public Item insert(Item item) {
//        insert item
        final String SQL = "INSERT INTO ITEMS " +
                "(name, price, description, user_id) " +
                "VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        getJdbcTemplate().update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                        PreparedStatement pst =
                                con.prepareStatement(SQL, new String[]{"id"});
                        pst.setString(1, item.getName());
                        pst.setString(2, item.getPrice());
                        pst.setString(3, item.getDescription());
                        pst.setLong(4, item.getUser().getId());
                        return pst;
                    }
                },
                keyHolder);
        Long id = keyHolder.getKey().longValue();
        item.setId(id);

//        insert mediasForItem
        if (!item.getMediasForItem().isEmpty()) {
            final String INSERT_MEDIA_SQL = "INSERT INTO media_for_item " +
                    "(description, media_ref, media_type_id, item_id) " +
                    "VALUES (?, ?, ?, ?)";
            List<Media> insertedMedias = new ArrayList<>();
            for (Media media : item.getMediasForItem()) {

                getJdbcTemplate().update(
                        new PreparedStatementCreator() {
                            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                                PreparedStatement pst =
                                        con.prepareStatement(INSERT_MEDIA_SQL, new String[]{"id"});
                                pst.setString(1, media.getDescription());
                                pst.setString(2, media.getMediaRef());
                                pst.setInt(3, media.getMediaType().getTypeId());
                                pst.setLong(4, item.getId());
                                return pst;
                            }
                        },
                        keyHolder);
                Long mediaId = keyHolder.getKey().longValue();
                media.setId(mediaId);
                insertedMedias.add(media);
            }
            item.setMediasForItem(insertedMedias);
        }
        return item;
    }

    @Override
    public Item fetchById(Long id) {
        return null;
    }

    @Override
    public Item fetchByParams(Map<String, Object> params) {
        return null;
    }

    @Override
    public List<Item> fetchListByUserId(Long userId) {
        final String SQL = "SELECT * FROM ITEMS WHERE user_id=?";
        final String MEDIAS_SQL = "SELECT * FROM media_for_item WHERE item_id=?";
        List<Item> items = getJdbcTemplate().query(SQL, new Object[]{userId}, new ItemMapper());
        for (Item item : items){
            item.setMediasForItem(getJdbcTemplate().query(MEDIAS_SQL, new Object[]{item.getId()}, new MediaMapper()));
        }
        return items;
    }
}
