package com.yonyou.test.controller;

import com.yonyou.test.entity.User;
import com.yonyou.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



/**
 * Created by xinggq on 17-3-24.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/selectById/{id}")
    public User selectById(@PathVariable("id") String id){

        return userService.selectById(id);
    }


}
