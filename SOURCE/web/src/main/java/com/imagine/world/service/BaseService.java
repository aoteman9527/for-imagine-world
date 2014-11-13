package com.imagine.world.service;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import com.imagine.world.common.*;
import com.imagine.world.dao.*;
import com.imagine.world.exception.AuthorizationException;
import com.imagine.world.exception.InprocessException;
import com.imagine.world.exception.MyException;
import com.imagine.world.models.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;

/**
 * Created by tuanlhd on 10/31/14.
 * This class wil obtain all logic
 * this use for StatePattern and DecoratorPattern
 * State Pattern was used when a user change from no login to login state and other kind user (power user)
 * Decorator Pattern was used when each a user have each permission can use a function.
 */
public abstract class BaseService implements CombineServices {
    @Resource
    Session session;
    @Resource
    ServiceState serviceState;
    @Autowired
    HttpServletRequest request;

    @Override
    public void authorize(
//            ServiceState serviceState, HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, String email, String password) throws MyException {
        //        ValidationUtils.rejectIfEmptyOrWhitespace();
        Preconditions.checkArgument(EMAIL_PATTERN_C.matcher(email).matches(), "Invalid email " + email);
        Preconditions.checkArgument(PASSWORD_PATTERN_C.matcher(password).matches(),"Invalid password " + password );

        /**
         * Create DAOs
         */
        UserDAO userDAO = new UserDAO();
        SessionDAO sessionDAO = new SessionDAO();

        /**
         * FIND USER by EMAIL
         */
        List<UsersEntity> usersEntityList = userDAO.getUserByEmail(email);

        /**
         * Start confirm login.
         */
        if(!usersEntityList.isEmpty()){
            UsersEntity usersEntity = usersEntityList.get(0);
            int loginAttempts = usersEntity.getUserLoginAttempts();
            int lastWarning = usersEntity.getUserLastWarning();
            int currentTime = (int) (System.currentTimeMillis()/1000L);

            if(currentTime-lastWarning <= LOGIN_FAIL_TIMEOUT  ){
                usersEntity.setUserLoginAttempts(new Integer(0).byteValue());
                userDAO.merge(usersEntity);
                throw new AuthorizationException(String.format("Must waiting for %s seconds", "" + (LOGIN_FAIL_TIMEOUT - (currentTime - lastWarning))));
            }

            if(loginAttempts >= MAX_LOGIN_ATTEMPS){
                usersEntity.setUserLastWarning(currentTime);
                lastWarning = usersEntity.getUserLastWarning();
                userDAO.merge(usersEntity);
                throw new AuthorizationException(String.format("2Must waiting for %s seconds",""+(LOGIN_FAIL_TIMEOUT-(currentTime-lastWarning))));
            }

            //check password
            if(!usersEntity.getUserPassword().equals(password)){
                int currentLoginAttemps = usersEntity.getUserLoginAttempts();
                currentLoginAttemps++;
                usersEntity.setUserLoginAttempts(new Integer(currentLoginAttemps).byteValue());
                userDAO.merge(usersEntity);
                throw new AuthorizationException("Invalid password *****");
            }

            /**
             * Reset attemps and set authorization success status
             */
            usersEntity.setUserLoginAttempts(new Integer(0).byteValue());
            userDAO.merge(usersEntity);

            /**
             * Save current session
             */
            HttpSession httpSession = request.getSession();
            List<SessionsEntity> sessionsEntityList = sessionDAO.getSessionByUserId(usersEntity.getUserId());
            SessionsEntity sessionsEntity;
            if(0 == sessionsEntityList.size()){
                sessionsEntity = new SessionsEntity();
            } else
                sessionsEntity = sessionsEntityList.get(0);
            if(!httpSession.getId().equalsIgnoreCase(sessionsEntity.getSessionId()))
                sessionDAO.delete(sessionsEntity);
            sessionsEntity.setSessionId(httpSession.getId());
            sessionsEntity.setSessionUserId(usersEntity.getUserId());
            sessionsEntity.setSessionTime((int) (httpSession.getLastAccessedTime() - httpSession.getCreationTime()));
            sessionsEntity.setSessionLastVisit(currentTime);
            sessionsEntity.setSessionBrowser("TBD");
            sessionsEntity.setSessionForwardedFor(Strings.nullToEmpty(request.getHeader("X-Forwarded-For")));
            sessionsEntity.setSessionIp(Strings.nullToEmpty(request.getRemoteAddr()));
            sessionsEntity.setSessionPage("");
            sessionDAO.persist(sessionsEntity);//use persist is better than merge for this case

            /**
             * Set cookie for remember user.
             */
            Cookie cookieSessionId = new Cookie(COOKIE_KEY_SESSION_ID, httpSession.getId());//set as default. because i has not updated sequences :D
            Cookie cookieUserId = new Cookie(COOKIE_KEY_USER_ID, usersEntity.getUserId()+"");//set as default. because i has not updated sequences :D
            cookieSessionId.setMaxAge(60*60*24*365);// 1 year
            cookieUserId.setMaxAge(60*60*24*365);// 1 year
            httpServletResponse.addCookie(cookieSessionId);
            httpServletResponse.addCookie(cookieUserId);

            /**
             * Set some information to current session
             */
            session.setUserId(usersEntity.getUserId());
            session.setEmail(usersEntity.getUserEmail());
            session.setUsername(usersEntity.getUsername());
            /**
             * Switch UserType
             */
            UserType userType = UserType.getType(usersEntity.getUserType());
            switch (userType){
                case NORMAL_USER:
                    serviceState.changeToNormalUser();
                    break;
                case FOUNDER:
                    serviceState.changeToPowerUser();
                    break;
                default:
                    serviceState.changeToNoLoggedInUser();
            }



        } else { // there are not existing a user.
            throw new AuthorizationException("There are not existing such user's email " + email);

        }
    }

    @Override
    public void logOut() throws AuthorizationException {
        session.clearData();
        serviceState.changeToNoLoggedInUser();
    }

    @Override
    public void issueArticle(HttpServletResponse response) throws MyException {
        this.checkLogin(response);
        /**
         * after check login. if user is logged in. this will change state to normal user or others.
         */
//        this.serviceState.getService().issueArticle(response);
//        throw new AuthorizationException("This user does not logged in");

    }

    @Override
    public final void register(String username, String email, String password, Date birthday, Integer userType, BigDecimal timezone, Integer rank, String avatar, String avatarType, Short avatarWidth, Short avatarHeight, String userSig, String userFrom) throws MyException {
//        ValidationUtils.rejectIfEmptyOrWhitespace();
        Preconditions.checkArgument(USERNAME_PATTERN_C.matcher(username).matches(),"Invalid username "+username);
        Preconditions.checkArgument(EMAIL_PATTERN_C.matcher(email).matches(),"Invalid email "+email);
        Preconditions.checkArgument(PASSWORD_PATTERN_C.matcher(password).matches(),"Invalid password");
        // validate timezone http://stackoverflow.com/questions/13092865/timezone-validation-in-java

        UserDAO userDAO = new UserDAO();
        Preconditions.checkState(userDAO.getUserByEmail(email).isEmpty(),"This email was existed in system "+email);
        Preconditions.checkState(userDAO.getUserByUsername(username).isEmpty(),"This username was existed in system "+username);

        UserProfile userProfile = new UserProfile();
        userProfile.setUsername(username);
        userProfile.setUserEmail(email);
        userProfile.setPassword(password);

        if(null!=userType)
            userProfile.setUserType(userType);
        else
            userProfile.setUserType(UserType.NORMAL_USER.getValue());

        if(null!=birthday){
            userProfile.setBirthday(birthdayFormat.format(birthday));
        }

        if(null!=timezone){
            Preconditions.checkArgument(isValidTimezone(timezone),"Invalid Timezone");
            userProfile.setTimezone(timezone);
        } else {
            userProfile.setTimezone(new BigDecimal(0.00));
        }

        if(null!=rank && rank>=0){
            userProfile.setUserRank(rank);
        }

        //avatarType is not null
        if(!Strings.isNullOrEmpty(avatarType) && !Strings.isNullOrEmpty(avatar)){
            if(avatarType == AvatarType.UPLOADED.getValue()){
                String tempPath = session.getTempAvatarPath();
                File tempFile = new File(tempPath);
                String newPath = PATH_AVATAR_FINAL+tempFile.getName();
                avatar = newPath;
                try {
                    Files.move(tempFile, new File(newPath));
                } catch (IOException e) {
                    throw new InprocessException("ERROR moving temp avatar to fixed local "+e.getMessage());
                }
            }

            userProfile.setUserAvatar(avatar);
            userProfile.setAvatarType(avatarType);
            userProfile.setAvatarWidth(Objects.firstNonNull(avatarWidth, (short) 0));
            userProfile.setAvatarHeight(Objects.firstNonNull(avatarHeight,(short)0));
        }

        if(!Strings.isNullOrEmpty(userSig))
            userProfile.setUserSig(userSig);
        if(!Strings.isNullOrEmpty(userFrom))
            userProfile.setUserFrom(userFrom);

        //To DAO and save
        userDAO.persist(userProfile.toUserDao());
    }

    ///////// ValidateUtils /////////////////////////
    private boolean isValidTimezone(BigDecimal timezone){
        return 0 <= timezone.doubleValue() && timezone.doubleValue() <=23;
//        String[] availableIDs = TimeZone.getAvailableIDs();
//        for (String tzId : availableIDs) {
//            if(tzId.equals(timezone))
//                return true;
//        }
//        return false;
    }



    @Override
    public void uploadTempAvatar(MultipartFile multipartFile) throws MyException {
        if(!multipartFile.isEmpty())
            try {
                String fileName = multipartFile.getOriginalFilename();
                String path = PATH_AVATAR_TEMP+simpleDateFormat.format(new Date())+"."+fileName;
                multipartFile.transferTo(new File(path));
                session.setTempAvatarPath(path);
            } catch (IOException e) {
                throw new InprocessException("Error of multipartFile transfer fail "+e.getMessage());
            }
        else
            throw new InprocessException("MultipartFile is empty !!!");

    }

    @Override
    public UserProfile userInfo(HttpServletResponse response) throws MyException {
        this.checkLogin(response);
        /**
         * after check login. if user is logged in. this will change state to normal user or others.
         */
        /**
         * Do business
         */
        String email = session.getEmail();
        UserDAO userDAO = new UserDAO();
        List<UsersEntity> usersEntityList = userDAO.getUserByEmail(email);
        if(usersEntityList.isEmpty()){
            throw new InprocessException("Finding user does not exist "+email );
        }
        return new UserProfile(usersEntityList.get(0));

    }

    /**
     *
     * @param userId REQUIRED
     * @param username
     * @param currentEmail
     * @param newEmail
     * @param newPass
     * @param currentPass
     * @param userBirthday
     * @param userType
     * @param userAvatar
     * @param userAvatarType
     * @param userAvatarWidth
     * @param userAvatarHeight
     * @param userSig
     * @param userFrom
     * @throws MyException
     */
    @Override
    public void modifyUser(
            HttpServletResponse response,
            int userId, String username, String currentEmail, String newEmail,
            String newPass, String currentPass, String userBirthday,
            int userType, String userAvatar, String userAvatarType,
            Short userAvatarWidth, Short userAvatarHeight, String userSig, String userFrom) throws MyException {

        /**
         * Do business
         */
        UserDAO userDAO = new UserDAO();
        UsersEntity usersEntity = userDAO.getUserById(userId).get(0);
        if(!Strings.isNullOrEmpty(username)){
            Preconditions.checkArgument(USERNAME_PATTERN_C.matcher(username).matches(),"Invalid username "+username);
            usersEntity.setUsername(username);
            usersEntity.setUsernameClean(username.toLowerCase());
        }

        if(!Strings.isNullOrEmpty(newEmail)){
            Preconditions.checkArgument(EMAIL_PATTERN_C.matcher(newEmail).matches(),"Invalid format email "+ newEmail);
            Preconditions.checkArgument(currentEmail.equalsIgnoreCase(usersEntity.getUserEmail()),"Current email does not match");
            usersEntity.setUserEmail(newEmail);
        }

        if(!Strings.isNullOrEmpty(newPass)){
            Preconditions.checkArgument(currentPass.equals(usersEntity.getUserPassword()),"Current password does not match");
            usersEntity.setUserPassword(newPass);
        }

        if(!Strings.isNullOrEmpty(userBirthday)){
            try {
                birthdayFormat.parse(userBirthday);
            } catch (ParseException e) {
                e.printStackTrace();
                throw new InprocessException(e.getMessage());
            }
            usersEntity.setUserBirthday(userBirthday);
        }

        if(!Strings.isNullOrEmpty(userAvatar)&&!Strings.isNullOrEmpty(userAvatarType)){
            if(userAvatarType == AvatarType.UPLOADED.getValue()){
                String tempPath = session.getTempAvatarPath();
                File tempFile = new File(tempPath);
                String newPath = PATH_AVATAR_FINAL+tempFile.getName();
                userAvatar = newPath;
                try {
                    Files.move(tempFile,new File(newPath));
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new InprocessException("ERROR moving temp avatar to fixed local "+e.getMessage());
                }
            }

            usersEntity.setUserAvatar(userAvatar);
            usersEntity.setUserAvatarType(new Integer(AvatarType.valueOf(userAvatarType.toUpperCase()).getValue2()).byteValue());
            usersEntity.setUserAvatarWidth(userAvatarWidth);
            usersEntity.setUserAvatarHeight(userAvatarHeight);
        }

        if(!Strings.isNullOrEmpty(userSig)){
            usersEntity.setUserSig(userSig);
        }

        if(!Strings.isNullOrEmpty(userFrom)){
            usersEntity.setUserFrom(userFrom);
        }

        userDAO.persist(usersEntity);

        this.authorize(
                response,
                usersEntity.getUserEmail(),
                usersEntity.getUserPassword()
        );
    }

    @Override
    public void checkLogin (
//            HttpServletRequest request,
            HttpServletResponse response
//            ServiceState serviceState
    ) throws MyException {
        String email = session.getEmail();
        List<UsersEntity> usersEntityList;
        if(Strings.isNullOrEmpty(email)){
            Preconditions.checkArgument(request.getCookies()!=null," this is new request and cookie is null ");
            //Validate IP address
            String ipAddress = request.getRemoteAddr();
            CookieList cookieList = new CookieList(Arrays.asList(request.getCookies()));
            String sessionId= cookieList.getByname(this.COOKIE_KEY_SESSION_ID).getValue();
            int userId=new Integer(cookieList.getByname(this.COOKIE_KEY_USER_ID).getValue());
            SessionDAO sessionDAO = new SessionDAO();
            List<SessionsEntity> sessionsEntityList = sessionDAO.getSessionBy(sessionId,userId,ipAddress);
            if(sessionsEntityList.size() == 0)
                throw new AuthorizationException("Cookie expired there are no existed record");
            SessionsEntity sessionsEntity = sessionsEntityList.get(0);
            sessionDAO.delete(sessionsEntity);//prepare for updating new session.
            sessionsEntity.setSessionId(request.getSession().getId());//update session id
            sessionDAO.persist(sessionsEntity);//do persist hibernate
            UserDAO userDAO = new UserDAO();
            usersEntityList = userDAO.getUserById(sessionsEntity.getSessionUserId());
        } else {
            UserDAO userDAO = new UserDAO();
            usersEntityList = userDAO.getUserByEmail(email);
        }
        if(usersEntityList.isEmpty()){
            throw new InprocessException("Finding user does not exist "+email );
        }
        session.setEmail(usersEntityList.get(0).getUserEmail());
        session.setUserId(usersEntityList.get(0).getUserId());

        /**
         * Authorize again to this user
         * After do authorize. auto change state.
         */
        UsersEntity usersEntity = usersEntityList.get(0);

        this.authorize(
//                serviceState, request,
                response,usersEntity.getUserEmail(),
                usersEntity.getUserPassword());
        //DONE nothing to do here
    }

    @Override
    public void deletePost(HttpServletResponse response,int postId) throws  MyException {
        PostDAO postDAO = new PostDAO();
        List<PostsEntity> postsEntityList= postDAO.getPostById(postId);
        Preconditions.checkArgument(!postsEntityList.isEmpty(),"There are no record for delete postId="+postId);
        postDAO.delete(postsEntityList.get(0));
    }

    @Override
    public void deleteTopic(HttpServletResponse response,int topicId) throws MyException {
//        throw new AuthorizationException("This user does not logged in");
        PostDAO postDAO = new PostDAO();
        postDAO.deleteByTopicId(topicId);
        TopicDAO topicDAO = new TopicDAO();
        List<TopicsEntity> topicsEntityList = topicDAO.getTopicById(topicId);
        Preconditions.checkArgument(!topicsEntityList.isEmpty(),"There are no topic to delete by topicId="+topicId);
        topicDAO.delete(topicsEntityList.get(0));
    }

    @Override
    public void modifyPost(HttpServletResponse response,int forumId, int topicId, int postId, String subject, String text, String reason, String modifier ) throws  MyException {
//        throw new AuthorizationException("This user does not logged in");
        PostDAO postDAO = new PostDAO();
        List<PostsEntity> postsEntities = postDAO.getPostById(postId);
        Preconditions.checkArgument(!postsEntities.isEmpty(),"There are not existed post with postId="+postId);
        postsEntities.get(0).setPostEditTime((int) System.currentTimeMillis() / 1000);
        postsEntities.get(0).setPostEditReason(reason);
        postsEntities.get(0).setPostSubject(subject);
        postsEntities.get(0).setPostText(text);
        postDAO.merge(postsEntities.get(0));
    }

    @Override
    public void modifyTopic(HttpServletResponse response, int forumId, int topicId, String tittle) throws MyException {
        TopicDAO topicDAO = new TopicDAO();
        List<TopicsEntity> topicsEntities = topicDAO.getTopicById(topicId);
        Preconditions.checkArgument(!topicsEntities.isEmpty(),"There are not existed topic "+ topicId);
        topicsEntities.get(0).setTopicTitle(tittle);
        topicDAO.merge(topicsEntities.get(0));
    }

    @Override
    public void postNew(
            HttpServletResponse response,
            int forumId,String subject,String text) throws MyException {

        /**
         * does not need check logged in. because this state . user were logged in.
         */
        this.checkPermission();

        /**
         * Do Business
         */
        ForumDAO forumDAO = new ForumDAO();
        Preconditions.checkState(forumDAO.getForumById(forumId).isEmpty()==false, "There are no existed this forum");

        TopicsEntity topicsEntity = this.addNewTopic(forumId,subject,
                session.getUserId(),//userId
                System.currentTimeMillis(), //topicTime
                0,//views
                TopicStatus.ITEM_UNLOCKED.getValue(), //default
                TopicType.POST_NORMAL.getValue(), //default
                0,//Cause it is unknown the new post
                session.getUsername(),//firstPostName
                0,//this equal with first post
                session.getUsername(),//lastPostName
                session.getUserId(),//lastPostId
                TopicApproveType.WAITING.getValue()//DEFAULT allow
        );

        PostsEntity postsEntity = this.addNewPost(topicsEntity.getTopicId(),
                forumId,
                session.getUserId(),//PosterId
                System.currentTimeMillis(),//postTime
                session.getUsername(),//PosterUsername
                subject,
                text,//PostText
                new String(DigestUtils.md5(text)),
                -1, //editTime
                "",//Default
                0,//editUser
                request.getRemoteAddr()
        );

        /**
         * update Topic first_post_id
         * update Topic last_post_id
         */
        topicsEntity.setTopicFirstPostId(postsEntity.getPostId());
        topicsEntity.setTopicLastPosterId(postsEntity.getPostId());
        TopicDAO topicDAO = new TopicDAO();
        topicDAO.merge(topicsEntity);

    }


    @Override
    public final TopicsEntity addNewTopic(int forumId, String title, int posterId, long topicTime,
                                    int views, byte status, byte type,
                                    int firstPostId, String firstPosterName,
                                    int lastPostId, String lastPosterName, int lastPosterId, int approveType) {
        TopicsEntity topicsEntity = new TopicsEntity();
        topicsEntity.setForumId(forumId);
        topicsEntity.setTopicTitle(title);
        topicsEntity.setTopicPoster(posterId);
        topicsEntity.setTopicTime((int) (topicTime / 1000));
        topicsEntity.setTopicViews(views);
        topicsEntity.setTopicStatus(status);
        topicsEntity.setTopicType(type);
        topicsEntity.setTopicFirstPostId(firstPostId);
        topicsEntity.setTopicFirstPosterName(firstPosterName);
        topicsEntity.setTopicLastPostId(lastPostId);
        topicsEntity.setTopicLastPosterName(lastPosterName);
        topicsEntity.setTopicLastPosterId(lastPosterId);

        DefaultUtils.setDefaultValueTopic(topicsEntity);

        TopicDAO topicDAO = new TopicDAO();
        topicDAO.persist(topicsEntity);
        topicsEntity.setTopicId(topicDAO.getLastInsertId());
        return topicsEntity;
    }

    @Override
    public final PostsEntity addNewPost(int topicId, int forumId, int posterId,
                                  long postTime, String postUsername,
                                  String subject, String text, String checksum,
                                  long editTime, String editReason, int editUser, String posterIp) {
        PostsEntity postsEntity = new PostsEntity();
        postsEntity.setTopicId(topicId);
        postsEntity.setForumId(forumId);
        postsEntity.setPosterId(posterId);
        postsEntity.setPostTime((int) (postTime / 1000));
        postsEntity.setPostUsername(postUsername);
        postsEntity.setPostSubject(subject);
        postsEntity.setPostText(text);
        postsEntity.setPostChecksum(checksum);
        postsEntity.setPostEditTime((int) (editTime / 1000));
        postsEntity.setPostEditReason(editReason);
        postsEntity.setPostEditUser(editUser);
        postsEntity.setPosterIp(posterIp);

        DefaultUtils.setDefaultValuePost(postsEntity);

        PostDAO postDAO = new PostDAO();
        postDAO.persist(postsEntity);

        postsEntity.setPostId(postDAO.getLastInsertId());

        return postsEntity;
    }


    @Override
    public void reply(HttpServletResponse response,int forumId, int topicId, String subject, String text) throws MyException {
        /**
         * does not need check logged in. because this state . user were logged in.
         */
        this.checkPermission();

        /**
         * Do Business
         */
        //check forum existed
        ForumDAO forumDAO = new ForumDAO();
        Preconditions.checkState(forumDAO.getForumById(forumId).isEmpty()==false, "There are no existed this forum "+forumId);

        //check topic existed
        TopicDAO topicDAO = new TopicDAO();
        List<TopicsEntity> topicsEntityList = topicDAO.getTopicById(topicId);
        Preconditions.checkState(topicsEntityList.isEmpty()==false, "There are no existed this topic "+topicId);

        PostsEntity postsEntity = this.addNewPost(
                topicId,
                forumId,
                session.getUserId(),
                System.currentTimeMillis(),
                session.getUsername(),
                subject,
                text,
                new String(DigestUtils.md5(text)),//checksum
                -1,//editTime
                "",//editReason
                0,//editUser
                request.getRemoteAddr()
        );
        topicsEntityList.get(0).setTopicLastPosterId(session.getUserId());
        topicsEntityList.get(0).setTopicLastPostTime((int) (System.currentTimeMillis() / 1000));
        topicsEntityList.get(0).setTopicLastPostId(postsEntity.getPostId());
        topicDAO.merge(topicsEntityList.get(0));
    }


    @Override
    public Map getTopics(HttpServletResponse response, int forumId, int page, int num, String sortType, byte topicApproved) throws MyException {
        /**
         * Does not need to check login. cause this is base service. it will be checked by concrete class
         */

        /**
         * Do business
         */

        String sortCondition= TopicSortType.valueOf(sortType.toUpperCase()).getValue();
        TopicDAO topicDAO = new TopicDAO();
        List<TopicsEntity> topicsEntities = topicDAO.getTopicBy(
                forumId,
                sortCondition,
                topicApproved,
                page,
                num
        );

        List<Topic> topics = Lists.newArrayList();
        Iterator<TopicsEntity> it = topicsEntities.iterator();
        TopicsEntity t;
        while(it.hasNext()){
            t = it.next();
            topics.add(new Topic(t));
        }

        return ImmutableMap.<String, Object>builder().
                put("name", "Topics of forumId " + forumId).
                put("size", topics.size()).
                put("topics",topics).
                build();
    }

    @Override
    public void postInfo() {

    }

    @Override
    public Map getPosts(HttpServletResponse response, int forumId, int topicId, int page, int num, String sortType, byte postApproveType) throws MyException {

//        this.checkLogin(response);
//        return this.serviceState.getService().getPosts(
//                response,
//                forumId,
//                topicId,
//                page,
//                num,
//                sortType
//        );
        String sortCondition = PostSortType.valueOf(sortType.toUpperCase()).getValue();
        PostDAO postDAO = new PostDAO();
        List<PostsEntity> postsEntityList = postDAO.getPostBy(
                forumId,
                topicId,
                page,
                num,
                sortCondition,
                postApproveType
                );

        List<Post> posts = Lists.newArrayList();
        Iterator<PostsEntity> it = postsEntityList.iterator();
        PostsEntity p;
        while(it.hasNext()){
            p = it.next();
            posts.add(new Post(p));
        }
        TopicDAO topicDAO = new TopicDAO();
        List<TopicsEntity> topicsEntityList = topicDAO.getTopicById(topicId);

        topicsEntityList.get(0).setTopicLastViewTime((int) (System.currentTimeMillis() / 1000));
        topicDAO.merge(topicsEntityList.get(0));

        return ImmutableMap.<String, Object>builder().
                put("name", "Post of forumId= " + forumId+" topicId= "+topicId).
                put("size", posts.size()).
                put("posts",posts).
                build();
    }

    @Override
    public void checkPermission() {

    }

}
