package com.four.mapper;

import com.four.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    //查询用户所有信息 模糊查询
    List<User> getUserByCondition(User user);

    //通过id查询 个人信息/用户信息
    @Select("select * from tywmf_user where userId = #{userId}")
    List<User> getUserById(String userId);

    //修改个人信息 基本资料/详细资料
    void updateUser(User user);


    /**
     * 增加用户信息
     * @param user
     * @return

     */
    public int registerAdd(User user);

    /**
     * 通过userCode获取User
     * @param userName
     * @return

     */
    public User getLoginUser(@Param("userName") String userName);
}
