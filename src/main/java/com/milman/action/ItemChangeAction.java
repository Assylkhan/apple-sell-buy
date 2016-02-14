package com.milman.action;

import com.milman.dataSource.ItemDao;
import com.milman.entity.*;
import com.milman.util.UserUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ItemChangeAction extends ActionSupport implements Preparable, ServletRequestAware {
    private ItemChangeType itemChangeType;
    @Autowired
    private ItemDao itemDao;
    private Item item;
    private HttpServletRequest servletRequest;
    private List<ItemImage> itemImages = new ArrayList<>();
    private List<ItemVideo> itemVideos = new ArrayList<>();
    private List<String> mediaTypes;
    private List<File> imageUpload = new ArrayList<>();
    private List<String> imageUploadFileName = new ArrayList<>();
    private List<String> imageUploadContentType = new ArrayList<>();
    private List<File> videoUpload = new ArrayList<>();
    private List<String> videoUploadFileName = new ArrayList<>();
    private List<String> videoUploadContentType = new ArrayList<>();

    private User user;
    /**
     * This is the path to save uploaded file, which is configured in struts.xml
     */
    private String saveDirectory;

    public ItemChangeType getItemChangeType() {
        return itemChangeType;
    }

    public void setItemChangeType(ItemChangeType itemChangeType) {
        this.itemChangeType = itemChangeType;
    }

    public List<ItemImage> getItemImages() {
        return itemImages;
    }

    public void setItemImages(List<ItemImage> itemImages) {
        this.itemImages = itemImages;
    }

    public List<ItemVideo> getItemVideos() {
        return itemVideos;
    }

    public void setItemVideos(List<ItemVideo> itemVideos) {
        this.itemVideos = itemVideos;
    }

    public List<String> getMediaTypes() {
        return mediaTypes;
    }

    public void setMediaTypes(List<String> mediaTypes) {
        this.mediaTypes = mediaTypes;
    }

    public List<File> getImageUpload() {
        return imageUpload;
    }

    public void setImageUpload(List<File> fileUploads) {
        this.imageUpload = fileUploads;
    }

    public List<String> getImageUploadFileName() {
        return imageUploadFileName;
    }

    public void setImageUploadFileName(List<String> fileUploadFileNames) {
        this.imageUploadFileName = fileUploadFileNames;
    }

    public List<String> getImageUploadContentType() {
        return imageUploadContentType;
    }

    public void setImageUploadContentType(List<String> fileUploadContentTypes) {
        this.imageUploadContentType = fileUploadContentTypes;
    }

    public List<File> getVideoUpload() {
        return videoUpload;
    }

    public void setVideoUpload(List<File> videoUpload) {
        this.videoUpload = videoUpload;
    }

    public List<String> getVideoUploadFileName() {
        return videoUploadFileName;
    }

    public void setVideoUploadFileName(List<String> videoUploadFileName) {
        this.videoUploadFileName = videoUploadFileName;
    }

    public List<String> getVideoUploadContentType() {
        return videoUploadContentType;
    }

    public void setVideoUploadContentType(List<String> videoUploadContentType) {
        this.videoUploadContentType = videoUploadContentType;
    }

    public String getSaveDirectory() {
        return saveDirectory;
    }

    public void setSaveDirectory(String saveDir) {
        this.saveDirectory = saveDir;
    }

    public void setItemDao(ItemDao itemDao) {
        this.itemDao = this.itemDao;
    }

    public ItemDao getItemDao() {
        return itemDao;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        servletRequest = httpServletRequest;
    }

    public String doUpload() {
        user = UserUtil.getSessionUser();
        if (itemChangeType == ItemChangeType.POST) {
            createMediasFromRequest();
        } else {
            updateMediasFromRequest();
        }
        item.setUser(user);
        item.setItemImages(itemImages);
        item.setItemVideos(itemVideos);
        Item itemFromDb = itemDao.insert(item);
        ServletActionContext.getRequest().setAttribute("flash.item", itemFromDb);
        return SUCCESS;
    }

    private void createMediasFromRequest() {
        Long itemId = itemDao.fetchLast().getId();
        String itemPath = "users/" + user.getEmail() + "/" + itemId
                + "/";
        String absolutePathUntilItem = ServletActionContext
                .getServletContext().getRealPath("/").concat(itemPath + "/");
        addMedias(itemPath, absolutePathUntilItem);
    }

    protected void addMedias(String itemPath, String absolutePathUntilItem) {
        for (int i = 0; i < imageUpload.size(); i++) {
            File uploadedFile = imageUpload.get(i);
            String fileName = imageUploadFileName.get(i);
            String relativePath = itemPath + Media.MediaType.IMAGE + "/" + fileName;
            String absolutePath = absolutePathUntilItem + Media.MediaType.IMAGE;
            ItemImage itemImage = new ItemImage();
            itemImage.setMediaRef(relativePath);
            itemImage.setMediaType(Media.MediaType.IMAGE);
            itemImages.add(itemImage);
            File destFile = new File(absolutePath, fileName);
            try {
                FileUtils.copyFile(uploadedFile, destFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        for (int i = 0; i < videoUpload.size(); i++) {
            File uploadedFile = videoUpload.get(i);
            String fileName = videoUploadFileName.get(i);
            String relativePath = itemPath + Media.MediaType.VIDEO + "/" + fileName;
            String absolutePath = absolutePathUntilItem + Media.MediaType.VIDEO;
            ItemVideo itemVideo = new ItemVideo();
            itemVideo.setMediaRef(relativePath);
            itemVideo.setMediaType(Media.MediaType.VIDEO);
            itemVideos.add(itemVideo);
            File destFile = new File(absolutePath, fileName);
            try {
                FileUtils.copyFile(uploadedFile, destFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    protected void updateMediasFromRequest() {
        Long itemId = itemDao.fetchLast().getId();
        String itemPath = "users/" + user.getEmail() + "/" + itemId
                + "/";
        String absolutePathUntilItem = ServletActionContext
                .getServletContext().getRealPath("/").concat(itemPath + "/");
        try {
            FileUtils.deleteDirectory(new File(absolutePathUntilItem));
        } catch (IOException e) {
            e.printStackTrace();
        }
        addMedias(itemPath, absolutePathUntilItem);
    }

    @Override
    public void validate() {
        if (item.getName().length() == 0) {
            addActionError("Заполните название товара");
//            addFieldError("item.username", "заполните поле");
        }

        if (item.getPrice().length() == 0) {
            addActionError("Заполните стоимость товара");
//            addFieldError("item.password", "заполните поле");
        }

        if (item.getDescription().length() == 0) {
            addActionError("Заполните описание товара");
        }
    }

    @Override
    public void prepare() throws Exception {

    }

}
