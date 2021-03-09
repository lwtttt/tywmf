package com.four.service;

import com.four.mapper.AdminMapper;
import com.four.entity.Report;
import com.four.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService {



        @Resource
        private AdminMapper adminMapper;

    @Override
    public List<Report> listReport(String reportStatus, String userName, int currentPageNo, int pageSize) {
        List<Report> reportList = null;
        currentPageNo=(currentPageNo-1)*pageSize;
        reportList =adminMapper.listReport(reportStatus,userName,currentPageNo,pageSize);
        if (reportList.size()==0){

            return null;
        }else {
            return reportList;}
         }

    @Override
    public int updateReport(int reportId, String reportStatus,String reportReply){
        int result= adminMapper.updateReport(reportId,reportStatus,reportReply);
        return result;
    }


    @Override
    public int banAccountStatus(int userId) {
        int result=adminMapper.banAccountStatus(userId);
        return result;
    }

    @Override
    public int liftAccountStatus(int userId) {
        int result=adminMapper.liftAccountStatus(userId);
        return result;
    }

    @Override
    public int getReportCount(String reportStatus, String userName) {
        int count = adminMapper.getReportCount(reportStatus,userName);
        return count;
    }

    @Override
    public int deleteReportById(Integer reportId) {
        int result= adminMapper.deleteReportById(reportId);
        return result;
    }

    @Override
    public List<Report> getStatusList(){
        // TODO Auto-generated method stub
        List<Report> statusList = null;
        statusList = adminMapper.getStatusList();
        return statusList;
    }

    @Override
    public Report getReportById(int reportId) {
        Report report = new Report();
        report = adminMapper.getReportById(reportId);
        return report;
    }

    @Override
    public List<User> getUserList(int accountStatus, String userName, int currentPageNo, int pageSize) {
        List<User> userList = null;
        currentPageNo=(currentPageNo-1)*pageSize;
        userList =adminMapper.getUserList(accountStatus,userName,currentPageNo,pageSize);
        if (userList.size()==0){
            return null;
        }else {
            return userList;
        }
    }

    @Override
    public int getUserCount(int accountStatus, String userName) {
        int count = adminMapper.getUserCount(accountStatus,userName);
        return count;
    }

    @Override
    public List<User> getAccountStatusList(){
        // TODO Auto-generated method stub
        List<User> userList = null;
        userList = adminMapper.getAccountStatusList();
        return userList;
    }

    @Override
    public User getUserById(int userId) {
        User user= new User();
        user = adminMapper.getUserById(userId);
        return user;
    }

    @Override
    public int deleteUserById(Integer userId) {
        int result=adminMapper.deleteUserById(userId);
        return result;
    }

}
