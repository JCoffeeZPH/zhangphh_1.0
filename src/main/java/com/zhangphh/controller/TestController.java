package com.zhangphh.controller;

import com.zhangphh.common.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * com.zhangphh.controller
 *
 * @author penghui.zhang
 * @date 2020/6/30 20:19
 */
@Controller
public class TestController {

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        String key = "myname";
        String value = "张鹏辉";

        redisUtils.set(key,value,11);
        return redisUtils.get(key,11);
    }
}
