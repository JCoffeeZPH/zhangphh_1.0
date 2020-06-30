package com.zhangphh;

import com.zhangphh.common.redis.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class ZhangphhApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtils redisUtils;

    @Test
    void contextLoads() {
        String key = "myname";
//        String value = "张鹏辉";
//
//        redisUtils.set(key,value,11);
//        System.out.println(redisUtils.get(key,11));

        System.out.println(redisUtils.del(11,key));
    }

}
