package com.imagine.world.common;

/**
 * Created by tuanlhd on 10/24/14.
 */
public enum TopicStatus {
    ITEM_UNLOCKED(0),
    ITEM_LOCKED(1),
    ITEM_MOVED(2);

    private byte value;

    private TopicStatus(int status){
        this.value = new Integer(status).byteValue();
    }

    public byte getValue() {
        return value;
    }
}
