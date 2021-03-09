package com.four.controller;

import com.four.entity.User;
import com.four.service.UserService;
import com.four.tools.Constants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/workLife.html")
    public String workLife(){
        return "workLife";
    }


    @RequestMapping("/baseInfo.html")
    public String baseInfo(){
        return "baseInfo";
    }

    @RequestMapping("/detailInfo.html")
    public String detailInfo(){
        return "detailInfo";
    }

    @RequestMapping("/detailInfoJs.html")
    public String detailInfoJs(){
        return "detailInfoJs";
    }

    @RequestMapping("/visit.html")
    public String visit(){
        return "visit";
    }

    @RequestMapping("/monologue.html")
    public String monologue(){
        return "monologue";
    }

    @RequestMapping("/pic.html")
    public String pic(){
        return "pic";
    }

    @RequestMapping("/personalInfo.html")
    public String personalInfo(@RequestParam(value="userId", required=false, defaultValue = "none")String userId, Model model){
        if(!userId.equals("none")){
            model.addAttribute("userId",userId);
        }
        return "personalInfo";
    }


    @RequestMapping("/message.html")
    public String message(){
        return "message";
    }

    @RequestMapping("/myFocus.html")
    public String myFocus(){
        return "myFocus";
    }

    @RequestMapping("/search.html")
    public String search(){
        return "search";
    }

    @RequestMapping("/vip.html")
    public String vip(){
        return "vip";
    }
    /*--------------------------------以上为跳转页面--------------------------------*/

    /*--------------------------------展示信息 条件查询--------------------------------*/
    @ResponseBody
    @RequestMapping("/getUserByCondition")
    public Collection<User> getAllUser(HttpServletRequest rq){
        //取值
        User user = new User();
        String income = rq.getParameter("income");
        String nativePlace = rq.getParameter("nativePlace");
        String height = rq.getParameter("height");
        String age = rq.getParameter("age");
        //存值 去空格
        if(income != null && !income.contains("不限")) {
            String income2 = income.trim();
            user.setIncome(income2);
        }
        if(nativePlace != null && !nativePlace.contains("不限")){
            String nativePlace2 = nativePlace.trim();
            user.setNativePlace(nativePlace2);
        }
        if(height != null && !height.contains("不限")){
            String height2 = height.trim();
            user.setHeight(height2);
        }
        if(age != null && !age.contains("不限")){
            String age2 = age.trim();
            int age3 = Integer.parseInt(age2);
            //年龄转年份
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            Date date = new Date();
            int yearNow = Integer.parseInt(sdf.format(date));
            int year = yearNow - age3;
            user.setAge(year);
        }

        //取分页值
        int pageIndex = Integer.parseInt(rq.getParameter("page"));
        PageHelper.startPage(pageIndex,10);
        //调用方法
        List<User> allUser = userService.getUserByCondition(user);
        //获取总页数
        if(pageIndex == 1){
            PageInfo<User> pageInfo = new PageInfo<User>(allUser);
            int pages = pageInfo.getPages();
            rq.getSession().setAttribute("pages", pages);
        }

        return allUser;
    }

    /*--------------------------------根据个人id查看信息--------------------------------*/
    @ResponseBody
    @RequestMapping("/getUserById")
    public Collection<User> getUserById(HttpServletRequest rq,@RequestParam(value="userId", required=false, defaultValue = "none")String userId){

        //单击某人信息时查看详情
        if(!userId.equals("none")){
            List<User> userById = userService.getUserById(userId);
            return userById;
        }
/*        if(rq.getParameter("userId") != null){
            String userId = rq.getParameter("userId");
            List<User> userById = userService.getUserById(userId);
            return userById;
        }*/
        //否则就是查看自己的信息
        //获取id
        //调用方法
        List<User> userById = userService.getUserById("2");

        return userById;
    }

    /*--------------------------------修改个人信息--------------------------------*/
    @ResponseBody
    @RequestMapping("/updateUser")
    public String updateUser(HttpServletRequest rq){
        //获取id

        //取值
        User user = new User();
        /*~~~~~~基本信息~~~~~~*/
        String gender = rq.getParameter("gender");
        String maritalStatus = rq.getParameter("maritalStatus");
        String education = rq.getParameter("education");
        String height = rq.getParameter("height");
        String username = rq.getParameter("username");
        String phone = rq.getParameter("phone");
        String province = rq.getParameter("province");
        String income = rq.getParameter("income");
        /*~~~~~~详细信息~~~~~~*/
        String nativePlace = rq.getParameter("nativePlace");
        String weight = rq.getParameter("weight");
        String nation = rq.getParameter("nation");
        /*~~~~~~工作生活~~~~~~*/
        String jobClass = rq.getParameter("jobClass");
        String house = rq.getParameter("house");
        String car = rq.getParameter("car");
        String smoke = rq.getParameter("smoke");
        String drink = rq.getParameter("drink");
        /*~~~~~~内心独白~~~~~~*/
        String conduction = rq.getParameter("monologue");

        //存值 去空格
        /*~~~~~~基本信息~~~~~~*/
        if(gender != null && !gender.contains("请选择")) {
            String gender2 = gender.trim();
            user.setGender(gender2);
        }
        if(maritalStatus != null && !maritalStatus.contains("请选择")) {
            String maritalStatus2 = maritalStatus.trim();
            user.setMaritalStatus(maritalStatus2);
        }
        if(education != null && !education.contains("请选择")) {
            String education2 = education.trim();
            user.setEducation(education2);
        }
        if(height != null && !height.contains("请选择")) {
            String height2 = height.trim();
            user.setHeight(height2);
        }
        if(username != null && !username.contains("请选择")) {
            String username2 = username.trim();
            user.setUserName(username2);
        }
        if(phone != null && !phone.contains("请选择")) {
            String phone2 = phone.trim();
            user.setPhone(phone2);
        }
        if(province != null && !province.contains("请选择")) {
            String province2 = province.trim();
            user.setWorkplace(province2);
        }
        if(income != null && !income.contains("请选择")) {
            String income2 = income.trim();
            user.setIncome(income2);
        }
        /*~~~~~~详细信息~~~~~~*/
        if(nativePlace != null && !nativePlace.contains("请选择")) {
            String nativePlace2 = nativePlace.trim();
            user.setNativePlace(nativePlace2);
        }
        if(weight != null && !weight.contains("请选择")) {
            String weight2 = weight.trim();
            user.setWeight(weight2);
        }
        if(nation != null && !nation.contains("请选择")) {
            String nation2 = nation.trim();
            user.setNation(nation2);
        }
        /*~~~~~~工作生活~~~~~~*/
        if(jobClass != null && !jobClass.contains("请选择")) {
            String jobClass2 = jobClass.trim();
            user.setJobClass(jobClass2);
        }
        if(house != null && !house.contains("请选择")) {
            String house2 = house.trim();
            user.setHouse(house2);
        }
        if(car != null && !car.contains("请选择")) {
            String car2 = car.trim();
            user.setCar(car2);
        }if(smoke != null && !smoke.contains("请选择")) {
            String smoke2 = smoke.trim();
            user.setSmoke(smoke2);
        }
        if(drink != null && !drink.contains("请选择")) {
            String drink2 = drink.trim();
            user.setDrink(drink2);
        }
        /*~~~~~~内心独白~~~~~~*/
//        String conduction = rq.getParameter("monologue");
        if(conduction != null && !conduction.contains("请选择")) {
            String conduction2 = conduction.trim();
            user.setConduction(conduction2);
        }

        user.setUserId(2);

        //调用方法
        userService.updateUser(user);

        return "true";
    }

    //文件上传
    @RequestMapping("/up")
    public String up(MultipartFile uploadFile, HttpSession session) throws IOException {
        //获取上传文件名称
        String fileName = uploadFile.getOriginalFilename();
        String finalFileName = UUID.randomUUID() + fileName.substring(fileName.lastIndexOf("."));
        String path = session.getServletContext().getRealPath("img")+ File.separator + finalFileName;
        System.out.println(path);
        File file = new File(path);
        uploadFile.transferTo(file);

        //上传成功后，将地址存入数据库，让前端可以直接拿图片
        String idPic = "/img/" + finalFileName;
        User user = new User();
        user.setIdPic(idPic);
        //获取id值
        user.setUserId(2);
        userService.updateUser(user);

        return "redirect:/baseInfo.html";
    }

/***********************以下是用户登录注册***************************/
// 日志处理
private Logger logger = Logger.getLogger(UserController.class);


    @RequestMapping("/login.html")
    public String login() {
        logger.debug("===============用户访问了UserController的login方法===============");
        return "login";
    }


    //访问register.jsp
    @RequestMapping("/register.html")
    public String userRegister(@ModelAttribute("user") User user) {
        logger.debug("===============用户访问了UserController的userRegister方法===============");
        return "register";
    }

    @RequestMapping("/index.html")
    public String index() {
        logger.debug("===============用户访问了UserController的login方法===============");
        return "index";
    }

    /*新增*/
    @RequestMapping("/userRegisterSave.html")
    public String userRegisterSave(@RequestParam("userName") String userName,

                                   @RequestParam("password") String password,
                                   @RequestParam("gender") String gender,
                                   @RequestParam("roleCode") int roleCode,
                                   @RequestParam("maritalStatus") String maritalStatus,
                                   @RequestParam("workplace") String workplace,

                                   @RequestParam("height") String height,
                                   @RequestParam("education") String education,



                                   HttpSession session, HttpServletRequest request) {
        logger.debug("===============用户访问了UserController的userRegisterSave方法===============");
        // 调用 userService.registerAdd
        User user=new User();
        user.setUserName(userName);

        user.setPassword(password);
        user.setGender(gender);
        user.setRoleCode(roleCode);
        user.setMaritalStatus(maritalStatus);
        user.setWorkplace(workplace);
        user.setHeight(height);
        user.setEducation(education);

        int result= userService.registerAdd(user);
        if (result>0) { // 注册成功

            return "redirect:/login.html";
        } else {
            // 页面跳转（Login.jsp)
            //   request.getSession().setAttribute("error", "用户名或者密码不正确");
            throw new RuntimeException("用户名账号密码错误");
        }
    }
    /**
     * 登录验证
     *
     * @return
     */
    @RequestMapping("/dologin.html")
    public String dologin(@RequestParam("userName") String userName, @RequestParam("password") String password,
                          HttpSession session, HttpServletRequest request) {
        logger.debug("===============用户访问了UserController的dologin方法===============");
        // 调用 userService.login
        User user = userService.login(userName, password);
        if (null != user) { // 登录成功
            // 放入session
            request.getSession().setAttribute(Constants.USER_SESSION, user);
            // 重定向到/main.html 页面跳转(frame.jsp)
            return "redirect:/index.html";
        } else {
            // 页面跳转（Login.jsp)
            request.getSession().setAttribute("error", "用户名或者密码不正确");
            throw new RuntimeException("用户名账号密码错误");
        }
    }

    @RequestMapping("/exlogin.xml")
    public String exlogin(@RequestParam("userName") String userName, @RequestParam("password") String password,
                          HttpSession session, HttpServletRequest request) {
        logger.debug("===============用户访问了UserController的exlogin方法===============");
        System.out.println("-----------------------"+userName+"+++++"+password);
        // 调用 userService.login
        User user = userService.login(userName, password);
        if (null != user) { // 登录成功
            // 放入session
            request.getSession().setAttribute(Constants.USER_SESSION, user);
            // 重定向到/index.html 页面跳转(index.jsp)
            return "redirect:/index.html";
        } else {
            // 页面跳转（login.jsp)
            request.getSession().setAttribute("error", "用户名或者密码不正确");
            return "redirect:/login.html";
            //  throw new RuntimeException("用户名账号密码错误");
        }
    }
}
