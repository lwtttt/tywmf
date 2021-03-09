package com.four.controller;

import com.alibaba.fastjson.JSON;
import com.four.entity.User;
import com.four.entity.heat;
import com.four.service.GreetService;
import com.four.service.UserService;
import com.four.tools.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @Resource
    private GreetService greetService;

    @Resource
    private UserService userService;

    @RequestMapping(value="/addGreet",method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String addGreet(@RequestParam("userName") String userName,
                           HttpSession session){
        String  greetByWho= ((User)session.getAttribute(Constants.USER_SESSION)).getUserName();
        String greetStatus="未读";
        int result=greetService.insertGreet(userName,greetByWho,greetStatus);
        if (result>=0){
            return JSON.toJSONString(1);
        }else{
            return JSON.toJSONString(0);
        }
    }

    @RequestMapping("/queryFocus")
    public String queryFocus(Model model,@RequestParam("userName") String focusUserName){
        List<heat> list=greetService.queryFocus(focusUserName);     //查询谁关注了我
        List<heat> myFocusList=greetService.myFocus(focusUserName);  //查询我关注了谁
        List<User> focusMe= new ArrayList<User>();
        List<User> myFocus=new ArrayList<User>();
        if (list.size()>0){
        for (heat h:list){
            User user = userService.getLoginUser(h.getUserName());  //查询所有关住我的人的详细信息
            focusMe.add(user);
        }}
        if (myFocusList.size()>0){
        for (heat h2:myFocusList){
            User user = userService.getLoginUser(h2.getFocusUserName());  //查询所有我关注的人的详细信息
            myFocus.add(user);
        }}
        model.addAttribute("myFocus",myFocus);
        model.addAttribute("focusMe",focusMe);

        return "myFocus";
    }

}
