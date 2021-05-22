package properties;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class OperatePropertiesTest {
    OperateProperties properties = null;

    @Before
    public void initObject() {
        properties = new OperateProperties();
    }

    @Test
    public void create() {
        Assert.assertTrue("tomcat".equals("tomcat"));
    }

    @Test
    public void systemInformation() {
        properties.systemInformation();
    }

    @Test
    public void loadFile() throws IOException {
        String s = properties.loadFile();
        Assert.assertTrue("tomcat:tomcat".equals(s));
    }
}