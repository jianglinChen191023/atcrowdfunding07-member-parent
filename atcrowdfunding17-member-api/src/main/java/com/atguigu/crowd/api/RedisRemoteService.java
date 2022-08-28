package com.atguigu.crowd.api;

import com.atguigu.crowd.util.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.TimeUnit;

/**
 * @author 陈江林
 * @date 2022/8/28 21:30
 */
@FeignClient("atguigu-crowd-redis")
public interface RedisRemoteService {

    /**
     * 保存
     *
     * @param key
     * @param value
     * @return
     */
    @RequestMapping("/set/Redis/Key/Value/Remote")
    ResultEntity<String> setRedisKeyValueRemote(
            @RequestParam("key") String key,
            @RequestParam("value") String value);

    /**
     * 设置带超时时间的
     *
     * @param key
     * @param value
     * @param time  时间
     * @param timeUnit 时间单位
     * @return
     */
    @RequestMapping("/set/Redis/Key/Value/Remote/With/Timeout")
    ResultEntity<String> setRedisKeyValueRemoteWithTimeout(
            @RequestParam("key") String key,
            @RequestParam("value") String value,
            @RequestParam("time") long time,
            @RequestParam("timeUnit") TimeUnit timeUnit);

    /**
     * 根据 Key 获取
     *
     * @param key
     * @return
     */
    @RequestMapping("get/Redis/Key/Value/By/Key")
    ResultEntity<String> getRedisKeyValueByKey(@RequestParam("key") String key);

    /**
     * 根据 Key 删除
     *
     * @param key
     * @return
     */
    @RequestMapping("remove/Redis/Key/Remote")
    ResultEntity<String> removeRedisKeyRemote(@RequestParam("key") String key);

}