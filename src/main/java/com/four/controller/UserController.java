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
    /*--------------------------------?????????????????????--------------------------------*/

    /*--------------------------------???????????? ????????????--------------------------------*/
    @ResponseBody
    @RequestMapping("/getUserByCondition")
    public Collection<User> getAllUser(HttpServletRequest rq){
        //??????
        User user = new User();
        String income = rq.getParameter("income");
        String nativePlace = rq.getParameter("nativePlace");
        String height = rq.getParameter("height");
        String age = rq.getParameter("age");
        //?????? ?????????
        if(income != null && !income.contains("??????")) {
            String income2 = income.trim();
            user.setIncome(income2);
        }
        if(nativePlace != null && !nativePlace.contains("??????")){
            String nativePlace2 = nativePlace.trim();
            user.setNativePlace(nativePlace2);
        }
        if(height != null && !height.contains("??????")){
            String height2 = height.trim();
            user.setHeight(height2);
        }
        if(age != null && !age.contains("??????")){
            String age2 = age.trim();
            int age3 = Integer.parseInt(age2);
            //???????????????
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            Date date = new Date();
            int yearNow = Integer.parseInt(sdf.format(date));
            int year = yearNow - age3;
            user.setAge(year);
        }

        //????????????
        int pageIndex = Integer.parseInt(rq.getParameter("page"));
        PageHelper.startPage(pageIndex,10);
        //????????????
        List<User> allUser = userService.getUserByCondition(user);
        //???????????????
        if(pageIndex == 1){
            PageInfo<User> pageInfo = new PageInfo<User>(allUser);
            int pages = pageInfo.getPages();
            rq.getSession().setAttribute("pages", pages);
        }

        return allUser;
    }

    /*--------------------------------????????????id????????????--------------------------------*/
    @ResponseBody
    @RequestMapping("/getUserById")
    public Collection<User> getUserById(HttpServletRequest rq,@RequestParam(value="userId", required=false, defaultValue = "none")String userId){

        //?????????????????????????????????
        if(!userId.equals("none")){
            List<User> userById = userService.getUserById(userId);
            return userById;
        }
/*        if(rq.getParameter("userId") != null){
            String userId = rq.getParameter("userId");
            List<User> userById = userService.getUserById(userId);
            return userById;
        }*/
        //?????????????????????????????????
        //??????id
        //????????????
        List<User> userById = userService.getUserById("2");

        return userById;
    }

    /*--------------------------------??????????????????--------------------------------*/
    @ResponseBody
    @RequestMapping("/updateUser")
    public String updateUser(HttpServletRequest rq){
        //??????id

        //??????
        User user = new User();
        /*~~~~~~????????????~~~~~~*/
        String gender = rq.getParameter("gender");
        String maritalStatus = rq.getParameter("maritalStatus");
        String education = rq.getParameter("education");
        String height = rq.getParameter("height");
        String username = rq.getParameter("username");
        String phone = rq.getParameter("phone");
        String province = rq.getParameter("province");
        String income = rq.getParameter("income");
        /*~~~~~~????????????~~~~~~*/
        String nativePlace = rq.getParameter("nativePlace");
        String weight = rq.getParameter("weight");
        String nation = rq.getParameter("nation");
        /*~~~~~~????????????~~~~~~*/
        String jobClass = rq.getParameter("jobClass");
        String house = rq.getParameter("house");
        String car = rq.getParameter("car");
        String smoke = rq.getParameter("smoke");
        String drink = rq.getParameter("drink");
        /*~~~~~~????????????~~~~~~*/
        String conduction = rq.getParameter("monologue");

        //?????? ?????????
        /*~~~~~~????????????~~~~~~*/
        if(gender != null && !gender.contains("?????????")) {
            String gender2 = gender.trim();
            user.setGender(gender2);
        }
        if(maritalStatus != null && !maritalStatus.contains("?????????")) {
            String maritalStatus2 = maritalStatus.trim();
            user.setMaritalStatus(maritalStatus2);
        }
        if(education != null && !education.contains("?????????")) {
            String education2 = education.trim();
            user.setEducation(education2);
        }
        if(height != null && !height.contains("?????????")) {
            String height2 = height.trim();
            user.setHeight(height2);
        }
        if(username != null && !username.contains("?????????")) {
            String username2 = username.trim();
            user.setUserName(username2);
        }
        if(phone != null && !phone.contains("?????????")) {
            String phone2 = phone.trim();
            user.setPhone(phone2);
        }
        if(province != null && !province.contains("?????????")) {
            String province2 = province.trim();
            user.setWorkplace(province2);
        }
        if(income != null && !income.contains("?????????")) {
            String income2 = income.trim();
            user.setIncome(income2);
        }
        /*~~~~~~????????????~~~~~~*/
        if(nativePlace != null && !nativePlace.contains("?????????")) {
            String nativePlace2 = nativePlace.trim();
            user.setNativePlace(nativePlace2);
        }
        if(weight != null && !weight.contains("?????????")) {
            String weight2 = weight.trim();
            user.setWeight(weight2);
        }
        if(nation != null && !nation.contains("?????????")) {
            String nation2 = nation.trim();
            user.setNation(nation2);
        }
        /*~~~~~~????????????~~~~~~*/
        if(jobClass != null && !jobClass.contains("?????????")) {
            String jobClass2 = jobClass.trim();
            user.setJobClass(jobClass2);
        }
        if(house != null && !house.contains("?????????")) {
            String house2 = house.trim();
            user.setHouse(house2);
        }
        if(car != null && !car.contains("?????????")) {
            String car2 = car.trim();
            user.setCar(car2);
        }if(smoke != null && !smoke.contains("?????????")) {
            String smoke2 = smoke.trim();
            user.setSmoke(smoke2);
        }
        if(drink != null && !drink.contains("?????????")) {
            String drink2 = drink.trim();
            user.setDrink(drink2);
        }
        /*~~~~~~????????????~~~~~~*/
//        String conduction = rq.getParameter("monologue");
        if(conduction != null && !conduction.contains("?????????")) {
            String conduction2 = conduction.trim();
            user.setConduction(conduction2);
        }

        user.setUserId(2);

        //????????????
        userService.updateUser(user);

        return "true";
    }

    //????????????
    @RequestMapping("/up")
    public String up(MultipartFile uploadFile, HttpSession session) throws IOException {
        //????????????????????????
        String fileName = uploadFile.getOriginalFilename();
        String finalFileName = UUID.randomUUID() + fileName.substring(fileName.lastIndexOf("."));
        String path = session.getServletContext().getRealPath("img")+ File.separator + finalFileName;
        System.out.println(path);
        File file = new File(path);
        uploadFile.transferTo(file);

        //???????????????????????????????????????????????????????????????????????????
        String idPic = "/img/" + finalFileName;
        User user = new User();
        user.setIdPic(idPic);
        //??????id???
        user.setUserId(2);
        userService.updateUser(user);

        return "redirect:/baseInfo.html";
    }

/***********************???????????????????????????***************************/
// ????????????
private Logger logger = Logger.getLogger(UserController.class);


    @RequestMapping("/login.html")
    public String login() {
        logger.debug("===============???????????????UserController???login??????===============");
        return "login";
    }


    //??????register.jsp
    @RequestMapping("/register.html")
    public String userRegister(@ModelAttribute("user") User user) {
        logger.debug("===============???????????????UserController???userRegister??????===============");
        return "register";
    }

    @RequestMapping("/index.html")
    public String index() {
        logger.debug("===============???????????????UserController???login??????===============");
        return "index";
    }

    /*??????*/
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
        logger.debug("===============???????????????UserController???userRegisterSave??????===============");
        // ?????? userService.registerAdd
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
        if (result>0) { // ????????????

            return "redirect:/login.html";
        } else {
            // ???????????????Login.jsp)
            //   request.getSession().setAttribute("error", "??????????????????????????????");
            throw new RuntimeException("???????????????????????????");
        }
    }
    /**
     * ????????????
     *
     * @return
     */
    @RequestMapping("/dologin.html")
    public String dologin(@RequestParam("userName") String userName, @RequestParam("password") String password,
                          HttpSession session, HttpServletRequest request) {
        logger.debug("===============???????????????UserController???dologin??????===============");
        // ?????? userService.login
        User user = userService.login(userName, password);
        if (null != user) { // ????????????
            // ??????session
            request.getSession().setAttribute(Constants.USER_SESSION, user);
            // ????????????/main.html ????????????(frame.jsp)
            return "redirect:/index.html";
        } else {
            // ???????????????Login.jsp)
            request.getSession().setAttribute("error", "??????????????????????????????");
            throw new RuntimeException("???????????????????????????");
        }
    }

    @RequestMapping("/exlogin.xml")
    public String exlogin(@RequestParam("userName") String userName, @RequestParam("password") String password,
                          HttpSession session, HttpServletRequest request) {
        logger.debug("===============???????????????UserController???exlogin??????===============");
        System.out.println("-----------------------"+userName+"+++++"+password);
        // ?????? userService.login
        User user = userService.login(userName, password);
        if (null != user) { // ????????????
            // ??????session
            request.getSession().setAttribute(Constants.USER_SESSION, user);
            // ????????????/index.html ????????????(index.jsp)
            return "redirect:/index.html";
        } else {
            // ???????????????login.jsp)
            request.getSession().setAttribute("error", "??????????????????????????????");
            return "redirect:/login.html";
            //  throw new RuntimeException("???????????????????????????");
        }
    }
}
