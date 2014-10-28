package com.imagine.world.common;

import com.google.common.base.Objects;
import com.imagine.world.models.PostsEntity;
import com.imagine.world.models.TopicsEntity;
import com.imagine.world.models.UsersEntity;

import java.util.Random;

/**
 * Created by tuanlhd on 10/28/14.
 */
public class DefaultUtils {

    public static PostsEntity setDefaultValuePost(PostsEntity p){
        p.setBbcodeBitfield(Objects.firstNonNull(p.getBbcodeBitfield(),""));
        p.setBbcodeUid(Objects.firstNonNull(p.getBbcodeUid(),""));

        return p;
    }

    public static TopicsEntity setDefaultValueTopic(TopicsEntity t){
        t.setForumId(Objects.firstNonNull(t.getForumId(),0));
        t.setIconId(Objects.firstNonNull(t.getIconId(),0));
        t.setPollLastVote(Objects.firstNonNull(t.getPollLastVote(),0));
        t.setPollLength(Objects.firstNonNull(t.getPollLength(),0));

        t.setPollMaxOptions(Objects.firstNonNull(t.getPollMaxOptions(), (byte) 0));
        t.setPollStart(Objects.firstNonNull(t.getPollStart(), 0));
        t.setPollTitle(Objects.firstNonNull(t.getPollTitle(), ""));
        t.setTopicFirstPosterColour(Objects.firstNonNull(t.getTopicFirstPosterColour(), ""));
        t.setTopicLastPostSubject(Objects.firstNonNull(t.getTopicLastPostSubject(), ""));
        t.setTopicLastPosterColour(Objects.firstNonNull(t.getTopicLastPosterColour(), ""));

        return t;
    }

    public static UsersEntity setDefaultValueUser(UsersEntity u){
        u.setUserActkey(Objects.firstNonNull(u.getUserActkey(),new Random().nextInt(16)+""));
        u.setUserAim(Objects.firstNonNull(u.getUserAim(),""));
        u.setUserColour(Objects.firstNonNull(u.getUserColour(),""));
        u.setUserDateformat(Objects.firstNonNull(u.getUserDateformat(),""));
        u.setUserFormSalt(Objects.firstNonNull(u.getUserFormSalt(),""));
        u.setUserIcq(Objects.firstNonNull(u.getUserIcq(),""));
        u.setUserInterests(Objects.firstNonNull(u.getUserInterests(),""));
        u.setUserIp(Objects.firstNonNull(u.getUserIp(),""));
        u.setUserJabber(Objects.firstNonNull(u.getUserJabber(),""));
        u.setUserLang(Objects.firstNonNull(u.getUserLang(),""));
        u.setUserLastConfirmKey(Objects.firstNonNull(u.getUserLastConfirmKey(),""));
        u.setUserLastpage(Objects.firstNonNull(u.getUserLastpage(),""));
        u.setUserMsnm(Objects.firstNonNull(u.getUserMsnm(),""));
        u.setUserNewpasswd(Objects.firstNonNull(u.getUserNewpasswd(),""));
        u.setUserOcc(Objects.firstNonNull(u.getUserOcc(),""));
        u.setUserPermissions(Objects.firstNonNull(u.getUserPermissions(),""));
        u.setUserPostSortbyDir(Objects.firstNonNull(u.getUserPostSortbyDir(),""));
        u.setUserPostSortbyType(Objects.firstNonNull(u.getUserPostSortbyType(),""));
        u.setUserSigBbcodeBitfield(Objects.firstNonNull(u.getUserSigBbcodeBitfield(),""));
        u.setUserSigBbcodeUid(Objects.firstNonNull(u.getUserSigBbcodeUid(),""));
        u.setUserTopicSortbyDir(Objects.firstNonNull(u.getUserPostSortbyDir(),""));
        u.setUserTopicSortbyType(Objects.firstNonNull(u.getUserPostSortbyType(),""));
        u.setUserWebsite(Objects.firstNonNull(u.getUserWebsite(),""));
        u.setUserYim(Objects.firstNonNull(u.getUserYim(),""));

        return u;
    }
}
