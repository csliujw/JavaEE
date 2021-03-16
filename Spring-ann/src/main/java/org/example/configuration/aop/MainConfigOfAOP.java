package org.example.configuration.aop;

import com.google.inject.internal.util.Join;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Arrays;

/**
 * AOP[动态代理]
 * 指程序运行期间动态的将某段代码切入到指定位置进行运行的编程方式
 * 1、导入AOP模块：Spring AOP（spring-aspects）
 * 2、定义一个业务逻辑类（MathCalculator），在业务逻辑运行的时候将日志进行打印（方法运行之前，方法运行之后，方法出现异常，xxx）。
 * 3、定义一个日志切面类（logAspects），切面里面的方法需要动态感知    MathCalculator.div运行到了哪里，然后执行。
 * --------通知方法：
 * -----------前置通知(@Before)：logStart 在目标方法（div） 运行之前运行
 * -----------后置通知(@After)：logEbd 在目标方法（div） 运行结束之后运行
 * -----------返回通知(@AfterReturning)：logReturn 在目标方法（div） 正常返回之后
 * -----------异常通知(@AfterThrowing)：logException 在目标方法（div） 出现异常以后运行
 * -----------环绕通知(@Around)：动态代理，手动推进目标方法运行（joinPoint.procced()）
 * 4、给切面类的目标方法标准何时何地运行(通知注解)
 * 5、将切面类和业务逻辑类（目标方法所在类）都加入到容器中
 * 6、必须告诉Spring，那个类是切面类（给切面类加注解）
 * 7、给配置类中加 @EnableAspectJAutoProxy [开启基于注解的AOP模式]
 * 在Spring中 EnableXxx都是开启某项功能的。
 */
@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {

    @Bean
    public MathCalculator calculator() {
        return new MathCalculator();
    }

    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        MathCalculator bean = context.getBean(MathCalculator.class);
        bean.div(2, 3);
    }
}


/**
 * 用AOP做个日志
 */
class MathCalculator {
    public int div(int i, int j) {
        System.out.println("div method");
        int s = 2 / 0;
        return i / j;
    }
}

@Aspect
//告诉Spring容器 当前类是一个切面类
class LogAspects {
    /**
     * 抽取公共的表达式 需要使用execution
     */
    @Pointcut("execution(public int org.example.configuration.aop.MathCalculator.*(..))")
    public void pointCut() {
    }

    // 指定只切入某个方法 @Before("public int org.example.configuration.aop.MathCalculator.div(int,int)")
    // 指定切入该类的所有方法..任意多参数 @Before("public int org.example.configuration.aop.MathCalculator.*(..)")
    @Before("pointCut()")
    // JoinPoint一定要出现在参数列表的第一位
    public void logStart(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        System.out.println("log Start 的方法签名是" + signature + " 参数列表是：" + Arrays.asList(args));
    }

    @After("pointCut()")
    public void logEnd() {
        System.out.println("log End");
    }

    @AfterReturning(value = "pointCut()", returning = "res")
    public void logReturn(Object res) {
        System.out.println("log Return, 运行结果是" + res);
    }

    @AfterThrowing(value = "pointCut()", throwing = "exc")
    public void logException(JoinPoint joinPoint, Exception exc) {
        System.out.println("log Exception, 方法签名是" + joinPoint.getSignature().getName() + ",异常是：" + exc);
    }
}