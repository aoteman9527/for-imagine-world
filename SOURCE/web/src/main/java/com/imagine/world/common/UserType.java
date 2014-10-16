package com.imagine.world.common;

/**
 * Created by tuan on 10/10/14.
 */
public enum UserType {
    NORMAL_USER(0),
    INACTIVE_USER(1),
    IGNORE(2),
    FOUNDER(3);

    private int value;

    private UserType(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static UserType getType(int type){
        switch (type){
            case 0:
                return NORMAL_USER;

            case 1:
                return INACTIVE_USER;

            case 2:
                return IGNORE;

            case 3:
                return FOUNDER;

            default:
                return null;
        }

    }
}
