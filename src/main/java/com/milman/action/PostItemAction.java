package com.milman.action;

import com.milman.dataSource.ItemDao;
import com.milman.entity.Item;
import com.milman.entity.Media;
import com.milman.entity.User;
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

public class PostItemAction extends ActionSupport implements Preparable, ServletRequestAware {
    @Autowired
    private ItemDao itemDao;

    public void setItemDao(ItemDao itemDao) {
        this.itemDao = this.itemDao;
    }

    public ItemDao getItemDao() {
        return itemDao;
    }

    private Item item;

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    private HttpServletRequest servletRequest;
    private List<Media> medias = new ArrayList<>();
    private List<String> mediaTypes;
    private List<File> fileUpload = new ArrayList<>();
    private List<String> fileUploadFileName = new ArrayList<>();
    private List<String> fileUploadContentType = new ArrayList<>();
    private User user;
    /**
     * This is the path to save uploaded file, which is configured in struts.xml
     */
    private String saveDirectory;

    public String doUpload() {
        user = UserUtil.getSessionUser();
        createMediasFromRequest();
        item.setUser(user);
        item.setMediasForItem(medias);
        Item itemFromDb = itemDao.insert(item);
        ServletActionContext.getRequest().setAttribute("flash.item", itemFromDb);
        return SUCCESS;
    }

    private void createMediasFromRequest() {
        Item lastItem = itemDao.fetchLast();
        String itemPath = "users/" + user.getEmail() + "/" + lastItem.getId()
                + "/";
        String absolutePathUntilItem = ServletActionContext
                .getServletContext().getRealPath("/").concat(itemPath + "/");
        for (int i = 0; i < fileUpload.size(); i++) {
            File uploadedFile = fileUpload.get(i);
            String fileName = fileUploadFileName.get(i);
            String relativePath = itemPath + mediaTypes.get(i) + "/" + fileName;
            String absolutePath = absolutePathUntilItem + mediaTypes.get(i);
            Media media = new Media();
            media.setMediaRef(relativePath);
            media.setMediaType(mediaTypes.get(i));
            medias.add(media);
            File destFile = new File(absolutePath, fileName);
            try {
                FileUtils.copyFile(uploadedFile, destFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<Media> getMedias() {
        return medias;
    }

    public void setMedias(List<Media> medias) {
        this.medias = medias;
    }

    public List<String> getMediaTypes() {
        return mediaTypes;
    }

    public void setMediaTypes(List<String> mediaTypes) {
        this.mediaTypes = mediaTypes;
    }

    public List<File> getFileUpload() {
        return fileUpload;
    }

    public void setFileUpload(List<File> fileUploads) {
        this.fileUpload = fileUploads;
    }

    public List<String> getFileUploadFileName() {
        return fileUploadFileName;
    }

    public void setFileUploadFileName(List<String> fileUploadFileNames) {
        this.fileUploadFileName = fileUploadFileNames;
    }

    public List<String> getFileUploadContentType() {
        return fileUploadContentType;
    }

    public void setFileUploadContentType(List<String> fileUploadContentTypes) {
        this.fileUploadContentType = fileUploadContentTypes;
    }

    public String getSaveDirectory() {
        return saveDirectory;
    }

    public void setSaveDirectory(String saveDir) {
        this.saveDirectory = saveDir;
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

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        servletRequest = httpServletRequest;
    }
}
