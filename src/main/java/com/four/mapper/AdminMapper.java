package com.four.mapper;

import com.four.entity.Report;
import com.four.entity.Role;
import com.four.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface AdminMapper {
    /**
     *
     *查看所有的举报信息
     * @return
     */
    public List<Report> listReport(@Param("reportStatus")String reportStatus,@Param("userName")String userName,@Param("currentPageNo")int currentPageNo, @Param("pageSize")int pageSize);

    /**
     *审核举报信息
     * @param reportId
     * @return
     */
    public int updateReport(@Param("reportId")int reportId,@Param("reportStatus")String reportStatus,@Param("reportReply")String reportReply);

    /**
     *封禁id
     * @param userId
     * @return
     */
    public int banAccountStatus(@Param("userId")int userId);

    /**
     *解禁id
     * @param userId
     * @return
     */
    public int liftAccountStatus(@Param("userId")int userId);


    /**
     *
     * @param reportStatus
     * @param userName
     * @return
     */
    public int getReportCount(@Param("reportStatus")String reportStatus,@Param("userName")String userName);

    /**
     * 通过reportId删除report
     * @param reportId
     * @return
     */
    public int deleteReportById(Integer reportId);
    /**
     * 获取审核状态信息
     * @return
     */
    public List<Report> getStatusList();

    /**
     * 根据reportID查看信息
     * @return
     */
    public  Report getReportById(int reportId);

    /**
     * 获取user列表
     * @param accountStatus
     * @param userName
     * @param currentPageNo
     * @param pageSize
     * @return
     */
    public List<User> getUserList(@Param("accountStatus")int accountStatus,@Param("userName")String userName,@Param("currentPageNo")int currentPageNo, @Param("pageSize")int pageSize);

    /**
     *
     * @param accountStatus
     * @param userName
     * @return
     */
    public int getUserCount(@Param("accountStatus")int accountStatus,@Param("userName")String userName);

    /**
     * 获取账号状态的列表
     * @return
     */
    public List<User> getAccountStatusList();

    /**
     * 根据userId查看信息
     * @return
     */
    public  User getUserById(int userId);

    /**
     * 通过ruserId删除user
     * @param userId
     * @return
     */
    public int deleteUserById(Integer userId);

}
