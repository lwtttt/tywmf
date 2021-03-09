package com.four.controller;

import com.alibaba.fastjson.JSON;
import com.four.entity.Report;
import com.four.entity.User;
import com.four.service.AdminService;
import com.four.tools.Constants;
import com.four.tools.PageSupport;
import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {


    @Resource
    private AdminService adminService;
    private Logger logger = Logger.getLogger(AdminController.class);


    @RequestMapping("admin.html")
    public String login() {
        logger.debug("============用户访问了AdminController的login方法=======");
        return "frame";
    }

    @RequestMapping("rregister.html")
    public String register() {
        logger.debug("============用户访问了AdminController的register方法=======");
        return "register";
    }
    @RequestMapping("chat.html")
    public String chat() {
        logger.debug("============用户访问了AdminController的login方法=======");
        return "index";
    }

    @RequestMapping("/getReportList")
    public String getReportList(Model model, @RequestParam(value = "userName", required = false) String userName, @RequestParam(value = "reportStatus", required=false) String reportStatus, @RequestParam(value = "pageIndex", required = false) String pageIndex) {
        logger.debug("============用户访问了AdminController的getreportList方法=======");
        System.out.println("访问举报信息列表");

        List<Report> reportList = null;
        int pageSize = Constants.pageSize;
        String _userName="";
        String _reportStatus="";
        // 当前页码
        int currentPageNo = 1;
        if (userName != null && userName != "") {
            _userName=userName; }
        if (reportStatus != null && reportStatus != "") {
            _reportStatus=reportStatus; }

        if (pageIndex != null && pageIndex != "") {
            currentPageNo = Integer.parseInt(pageIndex); }

        // 获取总记录数

        int totalCount = adminService.getReportCount(_reportStatus,_userName);

        PageSupport pages = new PageSupport();
        pages.setCurrentPageNo(currentPageNo);
        pages.setPageSize(pageSize);
        pages.setTotalCount(totalCount);
        reportList = adminService.listReport(_reportStatus,_userName,currentPageNo,pageSize);
        List<Report> statusList = adminService.getStatusList();



        model.addAttribute("statusList",statusList);
        model.addAttribute("userName",_userName);
        model.addAttribute("reportList",reportList);
        model.addAttribute("pages", pages);
        model.addAttribute("reportStatus",_reportStatus);
        return "admin";
    }

    @RequestMapping(value ="/reportDelete",produces="application/json;charset=UTF-8")
    @ResponseBody
    public String reportDelete(@RequestParam("reportId") String reportId) {
        logger.debug(
                "============用户访问了AdminController的reportDelete方法======================");
        int result = adminService.deleteReportById(Integer.parseInt(reportId));

        Map<String, String> delResult = new HashMap<String, String>();

        if (result>0) {
            delResult.put("delResult", "true");

        } else {
            delResult.put("delResult", "false");

        } return JSON.toJSONString(delResult); }

    @RequestMapping("/reportModifyView")
    public String userView(Model model, @RequestParam("reportId") String reportId) {
        logger.debug("============用户访问了UserController的userView方法======================");
        Report report = adminService.getReportById(Integer.parseInt(reportId));
        model.addAttribute("report", report);
        return "reportView";

    }



    @RequestMapping(value="/getStatusList", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getStatusList() throws Exception {
        List<Report> statusList = adminService.getStatusList();
        String jsonStr = JSON.toJSONString(statusList);
        return jsonStr;
    }

    @RequestMapping(value="/getAccountStatusList", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getAccountStatusList() throws Exception {
        List<User> userList = adminService.getAccountStatusList();
        String jsonStr = JSON.toJSONString(userList);
        return jsonStr;
    }


    @RequestMapping("/reportModifySave")
    public String userModifySave(Model model, @RequestParam("reportId") String reportId,@RequestParam("reportStatus") String reportStatus,@RequestParam("reportReply") String reportReply){
        if (adminService.updateReport(Integer.parseInt(reportId),reportStatus,reportReply)>0) {
            return "redirect:/getReportList"; }
        return "admin";

    }

    @RequestMapping("/getUserList")
    public String getUserList(Model model, @RequestParam(value = "userName", required = false) String userName, @RequestParam(value = "accountStatus", required=false) String accountStatus, @RequestParam(value = "pageIndex", required = false) String pageIndex) {
        logger.debug("============用户访问了AdminController的getUserList方法=======");
        System.out.println("访问用户列表");

        List<User> userList = null;
        int pageSize = Constants.pageSize;
        int _accountStatus=-1;
        String _userName="";
        if (accountStatus != null && accountStatus != "") {
            _accountStatus=Integer.parseInt(accountStatus); }

        // 当前页码
        int currentPageNo = 1;
        if (userName != null && userName != "") {
            _userName=userName; }

        if (pageIndex != null && pageIndex != "") {
            currentPageNo = Integer.parseInt(pageIndex); }

        // 获取总记录数

        int totalCount = adminService.getUserCount(_accountStatus,_userName);

        PageSupport pages = new PageSupport();
        pages.setCurrentPageNo(currentPageNo);
        pages.setPageSize(pageSize);
        pages.setTotalCount(totalCount);
        userList = adminService.getUserList(_accountStatus,_userName,currentPageNo,pageSize);
        List<User> accountStatusList = adminService.getAccountStatusList();



        model.addAttribute("accountStatusList",accountStatusList);
        model.addAttribute("userName",_userName);
        model.addAttribute("userList",userList);
        model.addAttribute("pages", pages);
        model.addAttribute("accountStatus",_accountStatus);

        return "managerUser";
    }

    @RequestMapping(value ="/banUser",produces="application/json;charset=UTF-8")
    @ResponseBody
    public String banUser(@RequestParam("userId") String userId) {
        logger.debug(
                "============用户访问了AdminController的userBan方法======================");
        Map<String, String> delResult = new HashMap<String, String>();
        User user =adminService.getUserById(Integer.parseInt(userId));
        if (user.getAccountStatus()==0){
            delResult.put("delResult", "isBan");
            return JSON.toJSONString(delResult);
        }else{
        int result = adminService.banAccountStatus(Integer.parseInt(userId));
        if (result>0) {
            delResult.put("delResult", "true");

        } else {
            delResult.put("delResult", "false");

        } return JSON.toJSONString(delResult); }
    }

    @RequestMapping(value ="/liftUser",produces="application/json;charset=UTF-8")
    @ResponseBody
    public String liftUser(@RequestParam("userId") String userId) {
        logger.debug(
                "============用户访问了AdminController的userBan方法======================");
        Map<String, String> delResult = new HashMap<String, String>();
        User user =adminService.getUserById(Integer.parseInt(userId));
        if (user.getAccountStatus()==1){
            delResult.put("delResult", "islift");
            return JSON.toJSONString(delResult);
        }else{
            int result = adminService.liftAccountStatus(Integer.parseInt(userId));
            if (result>0) {
                delResult.put("delResult", "true");

            } else {
                delResult.put("delResult", "false");

            } return JSON.toJSONString(delResult); }
    }


    @RequestMapping(value ="/userDelete",produces="application/json;charset=UTF-8")
    @ResponseBody
    public String userDelete(@RequestParam("userId") String userId) {
        logger.debug(
                "============用户访问了AdminController的userDelete方法======================");
        Map<String, String> delResult = new HashMap<String, String>();
        User user = adminService.getUserById(Integer.parseInt(userId));
        if (user == null) {
            delResult.put("delResult", "notexist");
            return JSON.toJSONString(delResult);}
        else{
            int result = adminService.deleteUserById(Integer.parseInt(userId));
                if (result > 0) {
                    delResult.put("delResult", "true");

                } else {
                    delResult.put("delResult", "false");

                }
                return JSON.toJSONString(delResult);
            }
        }
    }