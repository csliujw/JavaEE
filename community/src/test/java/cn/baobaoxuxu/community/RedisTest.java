package cn.baobaoxuxu.community;

import cn.baobaoxuxu.community.pojo.Role;
import cn.baobaoxuxu.community.repository.RoleRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CommunityApplication.class)
public class RedisTest {

    @Autowired
    RoleRepository dao;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Test
    public void test1() throws JsonProcessingException {
        // 1. 从redis拿数据
        String s = redisTemplate.boundValueOps("user.findAll").get();
        if (s == null) {
            List<Role> all = dao.findAll();
            ObjectMapper objectMapper = new ObjectMapper();
            String s1 = objectMapper.writeValueAsString(all);
            redisTemplate.boundValueOps("user.findAll").set(s1);
            System.out.println("从数据库拿了 存到了redis");
        }else{
            System.out.println("直接從redis拿");
        }
    }
}
