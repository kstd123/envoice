package com.yonyou.test.service;

import com.yonyou.test.dao.UserDao;
import com.yonyou.test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by xinggq on 17-3-24.
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User selectById(String id){
        return userDao.selectById(id);
    }


}
