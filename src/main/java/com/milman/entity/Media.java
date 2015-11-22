package com.milman.entity;

public class Media extends BaseEntity {
    public enum MediaType {
        IMAGE, VIDEO;

        public static MediaType typeFromInt(Integer value) {
            switch (value) {
                case 1:
                    return IMAGE;
                case 2:
                    return VIDEO;
                default:
                    return null;
            }
        }

        public int getTypeId() {
            if (this == IMAGE) {
                return 1;
            } else {
                return 2;
            }
        }
    }

    private MediaType mediaType;
    private String description;
    private String mediaRef;

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

    public String getMediaRef() {
        return mediaRef;
    }

    public void setMediaRef(String mediaRef) {
        this.mediaRef = mediaRef;
    }
}
