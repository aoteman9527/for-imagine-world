package com.imagine.world.common;

/**
 * Created by tuan on 10/10/14.
 */
public enum AvatarType {
    REMOTE("remote"),
    GALLERY("gallery"),
    UPLOADED("uploaded");

    private String type;

    private AvatarType(String type){
        this.type = type;
    }

    public String getValue() {
        return type;
    }
}
