package com.four.service;

import com.four.entity.heat;
import com.four.mapper.HelloMapper;
import com.four.service.GreetService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("greetService")
public class GreetServiceImpl implements GreetService {

    @Resource//注入
    private HelloMapper helloMapper;


    @Override
    public int insertGreet(String userName, String greetByWho, String greetStatus) {
        return helloMapper.insertGreet(userName,greetByWho,greetStatus);
    }

    @Override
    public List<heat> queryFocus(String focusUserName) {
        return helloMapper.queryFocus(focusUserName);
    }

    @Override
    public List<heat> myFocus(String userName) {
        return helloMapper.myFocus(userName);
    }
}
