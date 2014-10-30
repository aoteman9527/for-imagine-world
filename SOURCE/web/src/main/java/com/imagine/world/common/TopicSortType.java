package com.imagine.world.common;

/**
 * Created by tuanlhd on 10/30/14.
 * There are sort type
 */
public enum TopicSortType {
    LAST_POST_TIME_ASC("topic_last_post_time ASC, topic_time ASC"),
    LAST_POST_TIME_DESC("topic_last_post_time DESC, topic_time DESC"),
    LAST_VIEW_TIME_ASC("topic_last_view_time ASC"),
    LAST_VIEW_TIME_DESC("topic_last_view_time DESC"),
    TOPIC_CREATE_TIME_ASC("topic_time ASC"),
    TOPIC_CREATE_TIME_DESC("topic_time DESC"),
    TOPIC_VIEWS_ASC("topic_views ASC"),
    TOPIC_VIEWS_DESC("topic_views DESC"),
    ;

    private String condition;

    private TopicSortType(String condition){
        this.condition = condition;
    }

    public static TopicSortType getType(String type){
        return TopicSortType.valueOf(type.toUpperCase());
    }

    public String getValue() {
        return condition;
    }
}
