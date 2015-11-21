package com.milman.entity;

public abstract class MediaForItem extends BaseEntity {
    public enum MediaType {
        IMAGE, VIDEO
    }

    private MediaType mediaType;
    private String description;

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
