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
    private byte[] content;

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(String stringType) {
        this.mediaType = MediaType.valueOf(stringType.toUpperCase());
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public void setMediaType(Integer intType) {
        this.mediaType = MediaType.typeFromInt(intType);
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

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
