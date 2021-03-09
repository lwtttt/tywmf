package com.four.service;

import com.four.entity.User;
import com.four.mapper.UserMapper;
import com.four.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getUserByCondition(User user) {
        List<User> userByCondition = userMapper.getUserByCondition(user);
        return userByCondition;
    }

    @Override
    public List<User> getUserById(String userId) {
        List<User> userById = userMapper.getUserById(userId);
        return userById;
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public int registerAdd(User user) {
        try {
            int result=userMapper.registerAdd(user);
            System.out.println("************"+result);
            if(result>0){
                return  result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public User login(String userName, String password) {
        User user = null;
        try {
            user = userMapper.getLoginUser(userName);
            System.out.println("************"+user);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //匹配密码
        if(null != user){
            if(!user.getPassword().equals(password))
                user = null;
        }

        return user;
    }

    @Override
    public User getLoginUser(String userName) {
        return userMapper.getLoginUser(userName);
    }

}
