package com.imagine.world.common;

/**
 * Created by tuanlhd on 10/30/14.
 * There are sort type
 */
public enum PostSortType {
     POST_USERNAME_DESC("post_username DESC"),
     POST_USERNAME_ASC("post_username ASC"),
     POST_TIME_DESC("post_time DESC"),
     POST_TIME_ASC("post_time ASC"),
     POST_SUBJECT_DESC("post_subject DESC"),
     POST_SUBJECT_ASC("post_subject ASC"),
    ;

    private String condition;

    private PostSortType(String condition){
        this.condition = condition;
    }

    public static PostSortType getType(String type){
        return PostSortType.valueOf(type.toUpperCase());
    }

    public String getValue() {
        return condition;
    }
}
