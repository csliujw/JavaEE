package org.example.configuration.ioc.automatically;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.*;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.stream.Stream;

public class ProfileConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("test", "prod");
        context.register(ProfileDemo.class);
        context.refresh();
        String[] beanNamesForType = context.getBeanNamesForType(DataSource.class);
        Stream.of(beanNamesForType).forEach(System.out::println);
    }
}

@PropertySource("classpath:/dbconfig.properties")
@Configuration
class ProfileDemo implements EmbeddedValueResolverAware {

    private StringValueResolver resolver;

    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;
    @Value("${db.driverClass}")
    private String driverClass;

    @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSourceTest() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setDriverClass(driverClass);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mybatis?serverTimezone=UTC");
        return dataSource;
    }

    @Profile("dev")
    @Bean("devDataSource")
    public DataSource dataSourceDev() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        String driverClassString = resolver.resolveStringValue("${db.driverClass}");
        dataSource.setDriverClass(driverClassString);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mybatis05?serverTimezone=UTC");
        return dataSource;
    }

    @Profile("prod")
    @Bean("prodDataSource")
    public DataSource dataSourceProd() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setDriverClass(driverClass);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mysql_book?serverTimezone=UTC");
        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.resolver = resolver;
    }
}