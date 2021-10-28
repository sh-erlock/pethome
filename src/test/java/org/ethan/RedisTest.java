package org.ethan;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisTest extends BaseTest{

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testName(){
        redisTemplate.opsForValue().set("name", "Ethan");
        System.out.println(redisTemplate.opsForValue().get("name"));
    }

}
