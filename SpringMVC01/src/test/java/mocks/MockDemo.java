package mocks;

import cn.payphone.config.MyWebServletInitializer;
import cn.payphone.config.RootConfig;
import cn.payphone.config.WebConfig;
import cn.payphone.controller.Demo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * @WebAppConfiguration是一个类级注释，用于声明为集成测试加载的ApplicationContext应该是一个WebApplicationContext。
 * @ContextConfiguration定义类级元数据，用于确定如何为集成测试加载和配置ApplicationContext。
 * @RunWith注释的类或扩展用@RunWith注释的类时，JUnit将调用它引用的类来运行该类中的测试，而不是内置在JUnit中的运行器。我们在开发后期添加了这个特性。虽然它看起来很强大，但我们希望当我们了解人们如何真正使用它时，runner API会有所改变。目前内部的一些类可能会被细化，变成公共的。例如，JUnit 4中的套件是使用RunWith和一个名为Suite的自定义运行器构建的:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, MyWebServletInitializer.class})
public class MockDemo {

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    Demo demo;

    @Before
    public void setup() {
        this.mockMvc = standaloneSetup(demo).build();
    }

    @Test
    public void fun1() throws Exception {
        MockHttpServletRequestBuilder post = MockMvcRequestBuilders.get("/demo/user/{id}", 1);
        mockMvc.perform(post).andDo(print());
    }

    @Test
    public void fun2() throws Exception {
        MockHttpServletRequestBuilder post = MockMvcRequestBuilders.get("/ant/antTest01");
        mockMvc.perform(post).andDo(print());
    }
}
