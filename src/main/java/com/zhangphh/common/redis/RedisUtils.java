package com.zhangphh.common.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.PostConstruct;
import java.util.Arrays;


/**
 * com.zhangphh.common.redis
 *
 * @author penghui.zhang
 * @date 2020/6/30 19:29
 */
@Component
public class RedisUtils {

    private static Logger logger = LoggerFactory.getLogger(RedisUtils.class);

    @Autowired
    private JedisPool jedisPool;


    /**
     *
     * @param key
     * @param value
     * @param indexDB 选择库0-15
     */
    public void set(String key,String value,int indexDB){
        try {
            Jedis jedis = jedisPool.getResource();
            if (jedis == null) {
                logger.info("jedis == null");
            }
            jedis.select(indexDB);
            jedis.set(key,value);
            logger.info("选择redis的 " + indexDB +" 号库设置 {key:" + key + ", value: " + value + "} 成功");
        } catch (Exception e) {
            logger.error("选择redis的 " + indexDB +" 号库设置 {key:" + key + ", value: " + value + "} 出错，异常信息为: " + e.getMessage());
        }

    }

    /**
     *
     * @param key
     * @param indexDB
     * @return 选择库0-15
     */
    public String get(String key,int indexDB){
        try {
            Jedis jedis = jedisPool.getResource();
            jedis.select(indexDB);
            String value = jedis.get(key);
            logger.info("获取 " + indexDB + "号库的 key为：" + key + " 值为：" + value + " 的数据成功");
            return value;
        } catch (Exception e) {
            logger.error("获取 " + indexDB + "号库的key为：" + key + "的数据失败，异常信息为: " + e.getMessage());
            return null;
        }
    }

    /**
     * 删除指定的key
     * @param key
     * @return
     */
    public long del(int indexDB,String key){
        try {
            Jedis jedis = jedisPool.getResource();
            jedis.select(indexDB);
            long res = jedis.del(key);
            logger.info("删除"+ indexDB + "库的key为：" + key + " 的值成功");
            return res;
        } catch (Exception e) {
            logger.error("删除" + indexDB +"key为：" + key + " 的值出错： " + e.getMessage());
            return -1L;
        }
    }


}
