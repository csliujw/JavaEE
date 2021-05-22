package properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

/**
 * 操作Properties类
 */
public class OperateProperties {
    public String create() {
        Properties properties = new Properties();
        properties.setProperty("name", "tomcat");
        return properties.get("name").toString();
    }

    public void systemInformation() {
        Properties properties = System.getProperties();
        Enumeration<Object> elements = properties.elements();
        while (elements.hasMoreElements()) {
            System.out.println(elements.nextElement());
        }
        System.out.println("==============");
        Set<Object> objects = properties.keySet();
        for (Object key : objects) {
            System.out.println("key:=" + key + "==== value=" + properties.get(key));
        }
    }

    public String loadFile() throws IOException {
        Properties properties = new Properties();
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
        properties.load(resourceAsStream);
        String retVal = properties.get("username") + ":" + properties.get("password");
        return retVal;
    }

}
