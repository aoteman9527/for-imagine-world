package com.imagine.world.common;

/**
 * Created by tuanlhd on 10/30/14.
 */
public enum TopicApproveType {
    WAITING(1),
    PASS_WAITING(0);

    private int type2;

    private TopicApproveType(int type2){
        this.type2 = type2;
    }

    public static TopicApproveType getType(String type){
        return TopicApproveType.valueOf(type.toUpperCase());
    }

    public byte getValue() {
        return (byte) type2;
    }
}
