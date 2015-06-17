package com.imagine.world.common;

/**
 * Created by tuanlhd on 10/24/14.
 */
public enum TopicType {
    POST_NORMAL(0),
    POST_STICKY(1),
    POST_ANNOUNCE(2),
    POST_GLOBAL(3);

    private byte value;

    private TopicType(int value){
        this.value = new Integer(value).byteValue();
    }

    public byte getValue() {
        return value;
    }
}
