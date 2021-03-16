package mocks;

import cn.payphone.config.MyWebServletInitializer;
import cn.payphone.config.RootConfig;
import cn.payphone.config.SpringBean;
import cn.payphone.config.WebConfig;
import cn.payphone.controller.Demo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {WebConfig.class, RootConfig.class, MyWebServletInitializer.class})
@WebAppConfiguration
public class SpringMVCTest {

    @Autowired
    Demo demo;

    MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;


    @Before
    public void seton() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(demo).build();
    }

    @Test
    public void fun1() throws Exception {
        MockHttpServletRequestBuilder get = MockMvcRequestBuilders.get("/demo/user/{id}", 100);
        mockMvc.perform(get).andDo(MockMvcResultHandlers.print());
    }
}
