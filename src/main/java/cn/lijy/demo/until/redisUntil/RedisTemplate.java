package cn.lijy.demo.until.redisUntil;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @program: cn.lijy.demo.until.redisUntil
 * @description: redis方法封装
 * @author: JF1sh
 * @create: 2019-11-08 09:03
 **/
//@Component
public class RedisTemplate {
    private static Logger log = Logger.getLogger(RedisTemplate.class);

    /**
     * 连接单台redis调用类
     */
    @Resource
    private StringRedisTemplate stringRedisTemplate;


    /**
     * 连接redis集群调用类
     */
    @Autowired
    org.springframework.data.redis.core.RedisTemplate<String, String> redisTemplate;

    /**
     * @Description: 存值，默认失效时间1天
     * @Param: [key, value]
     * @return: void
     * @Author: JF1sh
     * @Date: 2019/11/8
     * @Time: 9:23
     **/
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value, 1, TimeUnit.DAYS);
    }

    /**
     * @Description: 取值，有则返回值，无值返回null
     * @Param: [key]
     * @return: java.lang.String
     * @Author: JF1sh
     * @Date: 2019/11/8
     * @Time: 10:07
     **/
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * @Description: 向list中存值，如果key不存在，新建。如果存在返回添加个数。
     * @Param: [key, value]
     * @return: java.lang.Long
     * @Author: JF1sh
     * @Date: 2019/11/8
     * @Time: 10:16
     **/
    public Long lpush(String key, String value) {
        return stringRedisTemplate.opsForList().leftPush(key, value);
    }

    /**
     * @Description: 根据下标获取list的值
     * @Param: [key, start, end]
     * @return: java.util.List<?>
     * @Author: JF1sh
     * @Date: 2019/11/8
     * @Time: 10:22
     **/
    public List<String> lrange(String key, int start, int end) {
        return stringRedisTemplate.opsForList().range(key, start, end);
    }

    /**
     * @Description: 获取集合长度
     * @Param: [key]
     * @return: int
     * @Author: JF1sh
     * @Date: 2019/11/8
     * @Time: 10:29
     **/
    public int llen(String key) {
        return Math.toIntExact(stringRedisTemplate.opsForList().size(key));
    }

    /**
     * @Description: 删除指定的key
     * @Param: [key]
     * @return: boolean
     * @Author: JF1sh
     * @Date: 2019/11/8
     * @Time: 10:30
     **/
    public boolean delete(String key) {
        return stringRedisTemplate.opsForList().getOperations().delete(key);
    }


    /**
     * @Description: 分布式锁
     * 当key不存在：自动创建，返回true
     * 当key存在: 不做任何操作
     * @Param: [key]
     * @return: boolean
     * @Author: JF1sh
     * @Date: 2019/11/8
     * @Time: 10:46
     **/
    public boolean clock(String key) {
        int LOCK_EXPIRE_TIME = 3600 * 1000; //毫秒
        Long epireTime = System.currentTimeMillis() + LOCK_EXPIRE_TIME; //当前值+设置值；过来这个时间锁失效
        Boolean isExists = redisTemplate.boundValueOps(key).setIfAbsent(String.valueOf(epireTime));
        if (isExists) {
            return true;
        } else {
            return false;
        }
    }


}
