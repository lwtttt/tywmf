package com.four.mapper;


import com.four.entity.heat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface HelloMapper {
    /*
     * 添加打招呼信息
     *
     * */
    public int insertGreet(String userName, String greetByWho, String greetStatus);

    /**
     * 查询谁关注了我
     */
    public List<heat> queryFocus(String focusUserName);

    /**
     * 查询我关注了谁
     */
    public List<heat> myFocus(String userName);



}
