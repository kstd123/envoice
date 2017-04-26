package com.yonyou.test.dao;

import com.yonyou.test.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


/**
 * Created by xinggq on 17-3-24.
 */
@Mapper
public interface UserDao {

    User selectById(String id);

    @Select("select * from user where name = #{name}")
    User selectByName(String name);


}
