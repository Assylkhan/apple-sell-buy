package com.milman.dataSource.PostgresImpl;

import com.milman.dataSource.ItemDao;
import com.milman.dataSource.mappers.ImageMapper;
import com.milman.dataSource.mappers.ItemMapper;
import com.milman.dataSource.mappers.VideoMapper;
import com.milman.entity.Item;
import com.milman.entity.Media;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ItemDaoImpl extends JdbcDaoSupport implements ItemDao {

    private final String IMAGES_BY_ITEM_ID = "SELECT * FROM item_images WHERE item_id=?";
    private final String VIDEOS_BY_ITEM_ID = "SELECT * FROM item_videos WHERE item_id=?";

    private PlatformTransactionManager transactionManager;

    public void setTransactionManager(PlatformTransactionManager txManager) {
        this.transactionManager = txManager;
    }

    @Override
    public Item insert(Item item) {
//        insert item
        final String SQL = "INSERT INTO ITEMS " +
                "(name, price, description, user_id) " +
                "VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        TransactionDefinition txDef = new DefaultTransactionDefinition();
        TransactionStatus txStatus = transactionManager.getTransaction(txDef);
        try {
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
            insertMedias(Media.MediaType.IMAGE, item, keyHolder);
            insertMedias(Media.MediaType.VIDEO, item, keyHolder);
            transactionManager.commit(txStatus);
        } catch (Exception e) {
            transactionManager.rollback(txStatus);
            throw e;
        }
        return item;
    }

    private void insertMedias(Media.MediaType mediaType, Item item, KeyHolder keyHolder) {
        String tableName = mediaType == Media.MediaType.IMAGE ? "item_images" : "item_videos";
        final String INSERT_MEDIA_SQL = "INSERT INTO " + tableName +
                "(description, media_ref, media_type_id, item_id) " +
                "VALUES (?, ?, ?, ?)";
        List<? extends Media> insertedImages = mediaType == Media.MediaType.IMAGE
                ? item.getItemImages() : item.getItemVideos();
        for (Media media : insertedImages) {
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
        }
    }

    @Override
    public Item fetchById(Long id) {
        final String SQL = "SELECT * FROM ITEMS WHERE id=?";
        Item item = getJdbcTemplate().queryForObject(SQL, new Object[]{id}, new ItemMapper());
        setMediasToItem(item);
        return item;
    }

    @Override
    public Item fetchByParams(Map<String, Object> params) {
        return null;
    }

    @Override
    public Item fetchLast() {
        final String SQL = "SELECT * FROM ITEMS ORDER BY ID DESC LIMIT 1";
        Item item = getJdbcTemplate().queryForObject(SQL, new ItemMapper());
        setMediasToItem(item);
        return item;
    }

    @Override
    public List<Item> fetchListByUserId(Long userId) {
        final String SQL = "SELECT * FROM ITEMS WHERE user_id=?";
        List<Item> items = getJdbcTemplate().query(SQL, new Object[]{userId}, new ItemMapper());
        for (Item item : items) {
            setMediasToItem(item);
        }
        return items;
    }

    private void setMediasToItem(Item item) {
        item.setItemVideos(getJdbcTemplate().query(VIDEOS_BY_ITEM_ID, new Object[]{item.getId()}, new VideoMapper()));
        item.setItemImages(getJdbcTemplate().query(IMAGES_BY_ITEM_ID, new Object[]{item.getId()}, new ImageMapper()));
    }
}
