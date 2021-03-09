package com.four.service;


import com.four.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    List<User> getUserByCondition(User user);

    List<User> getUserById(String userId);

    void updateUser(User user);

    /**
     * 增加注册用户信息
     * @param user
     * @return
     */
    public int registerAdd(User user);

    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     */
    public User login(String userName, String password);

    public User getLoginUser(@Param("userName") String userName);


}
