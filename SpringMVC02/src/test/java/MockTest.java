import org.example.config.MyWebApplicationInitializer;
import org.example.config.RootConfig;
import org.example.config.WebConfig;
import org.example.controller.HelloController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {RootConfig.class, WebConfig.class, MyWebApplicationInitializer.class})
@WebAppConfiguration
public class MockTest {
    private MockMvc mvc;

    @Autowired
    private HelloController helloController;

    @Before
    public void before() {
        this.mvc = MockMvcBuilders.standaloneSetup(helloController).build();
    }

    @Test
    public void test1() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");
        mvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().string(equalTo("inde2x")));
    }

    /**
     * NoSuchMethodError
     * org.springframework.web.util.NestedServletException:
     * Handler dispatch failed; nested exception is java.lang.NoSuchMethodError:
     * 1
     * 2
     * 造成这个错误的原因可能为: A-module的pom依赖了B-module和C-module, 然而B-module的pom也依赖了C-module导致
     * 简单来说就是: 重复依赖导致
     * 解决方法: A-module的pom中把C-module去掉即可
     * 总之, 遇到这个异常应该留意一下各模块之间是否有重复依赖的问题
     */
    @Test
    public void testUserController() throws Exception {
        // 测试UserController
        RequestBuilder request;

        // 1、get查一下user列表，应该为空
        request = MockMvcRequestBuilders.get("/users/");
        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().string(equalTo("[]")));

        // 2、post提交一个user
        request = MockMvcRequestBuilders.post("/users/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"name\":\"测试大师\",\"age\":20}");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        // 3、get获取user列表，应该有刚才插入的数据
        request = MockMvcRequestBuilders.get("/users/");
        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"测试大师\",\"age\":20}]")));

        // 4、put修改id为1的user
        request = MockMvcRequestBuilders.put("/users/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"测试终极大师\",\"age\":30}");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        // 5、get一个id为1的user
        request = MockMvcRequestBuilders.get("/users/1");
        mvc.perform(request)
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"测试终极大师\",\"age\":30}")));

        // 6、del删除id为1的user
        request = MockMvcRequestBuilders.delete("/users/1");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        // 7、get查一下user列表，应该为空
        request = MockMvcRequestBuilders.get("/users/");
        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().string(equalTo("[]")));

    }
}
