package com.inet;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.digest.Digester;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import com.inet.code.entity.User;
import com.inet.code.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
class INetApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads1() {
        System.out.println(IdUtil.randomUUID());
    }

    @Test
    void configLoads2(){
        Digester md5 = new Digester(DigestAlgorithm.MD5);
        System.out.println(md5.digestHex("123"));//202cb962ac59075b964b07152d234b70
        System.out.println(DigestUtil.md5Hex("123"));
    }

    /**
     * 测试登录请求
     * @author HCY
     * @since 2020-11-14
     */
    @Test
    void configLoads3(){
        Digester md5 = new Digester(DigestAlgorithm.MD5);
        String account = "huchengyea@163.com";
        String password = md5.digestHex("123");
        User user = userMapper.getLogin(account, password);
        System.out.println(user);
    }

    @Test
    void configLoads4(){
        Boolean one = true;
        Boolean two = false;
        if (!one.equals(two)){
            System.out.println("1");
        }else {
            System.out.println("2");
        }
    }

    @Test
    void configLoads5(){
        Date date = new Date();
        if (!date.equals("")){
            System.out.println(1);
        }else {
            System.out.println(2);
        }
    }

    @Test
    void configLoads6(){
        redisTemplate.opsForValue().set("key1","xxy");
    }

    @Test
    void configLoads7(){
        redisTemplate.delete("key1");
    }

    @Test
    void configLoads8(){

        MailAccount account = new MailAccount();
        account.setHost("smtp.163.com");
        account.setPort(25);
        account.setAuth(true);
        account.setFrom("huchengyea@163.com");
        account.setUser("huchengyea");
        account.setPass("SDZSHTMHUKMVSCRA");
        MailUtil.send(account,"3522758312@QQ.com", "测试", "邮件来自晓寻遥测试", false);
    }

    @Test
    void configLoads9(){
        System.out.println(RandomUtil.randomString(5));
    }

}
