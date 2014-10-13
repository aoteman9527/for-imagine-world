package com.imagine.world.common;

/**
 * Created by tuan on 10/10/14.
 */
public enum AvatarType {
    REMOTE("remote",1),
    GALLERY("gallery",2),
    UPLOADED("uploaded",3);

    private String type;
    private int type2;

    private AvatarType(String type,int type2){
        this.type = type;
        this.type2 = type2;
    }

    public static AvatarType getType(String type){
        return AvatarType.valueOf(type.toUpperCase());
    }

    public String getValue() {
        return type;
    }
    public int getValue2() {
        return type2;
    }
}
