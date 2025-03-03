package com.craig.user.service;

import java.util.List;

import com.craig.user.model.PageResult;
import com.craig.user.model.SimpleUserModel;
import com.craig.user.model.UserDetailModel;
import com.craig.user.model.UserModel;
import com.craig.user.model.UserQueryModel;

public interface UserService {
    /**
     * get user detail mode
     * 
     * @param userId      user id
     * @param getFollower set true get followers, false doesn't get
     * @param getFollowing set true get followings, false doesn't get
     * @return user detail model
     */
    UserDetailModel getUserDetail(Long userId, Boolean getFollower, Boolean getFollowing);

    /**
     * get user by username
     * @param userName user name
     * @param getFollower set true get followers, false doesn't get
     * @param getFollowing set true get followings, false doesn't get
     * @return user detail model
     */
    UserDetailModel getUserByName(String userName, Boolean getFollower, Boolean getFollowing);

    /**
     * get user list
     * 
     * @param query query param
     * @return list of user models
     */
    PageResult<UserModel> getUsers(UserQueryModel query);

    /**
     * insert user
     * 
     * @param insertModel model to insert
     * @return inserted user model
     */
    UserModel createUser(UserModel insertModel);

    /**
     * upodate user
     * 
     * @param updatModel the update content
     * @return updated user model
     */
    UserModel updateUser(UserModel updatModel);

    /**
     * delete user
     * 
     * @param userId user id
     */
    Boolean deleteUser(Long userId);

    /**
     * get the nearby users from the latest location when current user loggin
     * @param userId current user id
     * @return nearby users
     */
    List<SimpleUserModel> getNearbyUsers(Long userId);
}
