import org.example.config.MyInitializer;
import org.example.config.RootConfig;
import org.example.config.WebConfig;
import org.example.controller.Hello;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {RootConfig.class, WebConfig.class, MyInitializer.class})
@WebAppConfiguration
public class MockTest {

    @Autowired
    private Hello hello;

    MockMvc mvc;

    @Before
    public void setOn() {
        this.mvc = MockMvcBuilders.standaloneSetup(hello).build();
    }

    @Test
    public void fun1() {
        Assert.assertNotNull(mvc);
        System.out.println(mvc);
    }
}
