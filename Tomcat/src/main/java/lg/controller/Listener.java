package lg.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;

@WebListener(value = "listener1")
public class Listener implements ServletContextListener {

    public Listener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        // 这个动态注册感觉优点鸡肋
        ServletContext servletContext = sce.getServletContext();
        ServletRegistration.Dynamic d = servletContext.addServlet("d", Servlet.class);
        d.addMapping("/servlet");
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }
}
