package com.atguigu.crowd.factory;

import com.atguigu.crowd.api.RedisRemoteService;
import com.atguigu.crowd.util.ResultEntity;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author 陈江林
 * @date 2022/9/9 12:39
 */
@Component
public class RedisFallBackFactory implements FallbackFactory<RedisRemoteService> {

    @Override
    public RedisRemoteService create(Throwable cause) {
        return new RedisRemoteService() {
            @Override
            public ResultEntity<String> setRedisKeyValueRemote(String key, String value) {
                return ResultEntity.failed("降级机制生效: " + cause.getMessage());
            }

            @Override
            public ResultEntity<String> setRedisKeyValueRemoteWithTimeout(String key, String value, long time, TimeUnit timeUnit) {
                return ResultEntity.failed("降级机制生效: " + cause.getMessage());
            }

            @Override
            public ResultEntity<String> getRedisKeyValueByKey(String key) {
                return ResultEntity.failed("降级机制生效: " + cause.getMessage());
            }

            @Override
            public ResultEntity<String> removeRedisKeyRemote(String key) {
                return ResultEntity.failed("降级机制生效: " + cause.getMessage());
            }
        };
    }

}
