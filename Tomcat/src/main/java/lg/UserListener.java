package lg;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class UserListener implements ServletContextListener, Hello {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("UserListener init");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("UserListener destroy");
    }
}