package com.atguigu.crowd.handler;

import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.util.ResultEntity;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author 陈江林
 * @date 2022/8/28 21:39
 */
@RestController
public class RedisHandler {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 保存
     *
     * @param key
     * @param value
     * @return
     */
    @HystrixCommand(fallbackMethod = "setRedisKeyValueRemoteBackup")
    @RequestMapping("/set/redis/key/value/remote")
    public ResultEntity<String> setRedisKeyValueRemote(
            @RequestParam("key") String key,
            @RequestParam("value") String value) {
        try {
            ValueOperations<String, String> operations = redisTemplate.opsForValue();
            operations.set(key, value);

            return ResultEntity.successWithoutData();
        } catch (Exception e) {
            return ResultEntity.failed(e.getMessage());
        }
    }

    public ResultEntity<String> setRedisKeyValueRemoteBackup(
            @RequestParam("key") String key,
            @RequestParam("value") String value) {
        return ResultEntity.failed(CrowdConstant.MESSAGE_HYSTRIX_BACKUP);
    }

    /**
     * 设置带超时时间的
     *
     * @param key
     * @param value
     * @param time     时间
     * @param timeUnit 时间单位
     * @return
     */
    @HystrixCommand(fallbackMethod = "setRedisKeyValueRemoteWithTimeoutBackup")
    @RequestMapping("/set/redis/key/value/remote/with/timeout")
    public ResultEntity<String> setRedisKeyValueRemoteWithTimeout(
            @RequestParam("key") String key,
            @RequestParam("value") String value,
            @RequestParam("time") long time,
            @RequestParam("timeUnit") TimeUnit timeUnit) {
        try {
            ValueOperations<String, String> operations = redisTemplate.opsForValue();
            operations.set(key, value, time, timeUnit);

            return ResultEntity.successWithoutData();
        } catch (Exception e) {
            return ResultEntity.failed(e.getMessage());
        }
    }

    public ResultEntity<String> setRedisKeyValueRemoteWithTimeoutBackup(
            @RequestParam("key") String key,
            @RequestParam("value") String value,
            @RequestParam("time") long time,
            @RequestParam("timeUnit") TimeUnit timeUnit) {
        return ResultEntity.failed(CrowdConstant.MESSAGE_HYSTRIX_BACKUP);
    }

    /**
     * 根据 Key 获取
     *
     * @param key
     * @return
     */
    @HystrixCommand(fallbackMethod = "getRedisKeyValueByKeyBackup")
    @RequestMapping("get/redis/key/value/by/key")
    public ResultEntity<String> getRedisKeyValueByKey(@RequestParam("key") String key) {
        try {
            ValueOperations<String, String> operations = redisTemplate.opsForValue();
            String value = operations.get(key);

            return ResultEntity.successWithData(value);
        } catch (Exception e) {
            return ResultEntity.failed(e.getMessage());
        }
    }

    public ResultEntity<String> getRedisKeyValueByKeyBackup(@RequestParam("key") String key) {
        return ResultEntity.failed(CrowdConstant.MESSAGE_HYSTRIX_BACKUP);
    }

    /**
     * 根据 Key 删除
     *
     * @param key
     * @return
     */
    @HystrixCommand(fallbackMethod = "removeRedisKeyRemoteBackup")
    @RequestMapping("remove/redis/key/remote")
    public ResultEntity<String> removeRedisKeyRemote(@RequestParam("key") String key) {
        try {
            redisTemplate.delete(key);

            return ResultEntity.successWithoutData();
        } catch (Exception e) {
            return ResultEntity.failed(e.getMessage());
        }
    }

    public ResultEntity<String> removeRedisKeyRemoteBackup(@RequestParam("key") String key) {
        return ResultEntity.failed(CrowdConstant.MESSAGE_HYSTRIX_BACKUP);
    }

}
