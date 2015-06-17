package com.imagine.world.common;

/**
 * Created by tuanlhd on 10/30/14.
 */
public enum PostApproveType {
    WAITING(1),
    PASS_WAITING(0);

    private int type2;

    private PostApproveType(int type2){
        this.type2 = type2;
    }

    public static PostApproveType getType(String type){
        return PostApproveType.valueOf(type.toUpperCase());
    }

    public byte getValue() {
        return (byte) type2;
    }
}
