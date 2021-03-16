# 前言
常用快捷键
## w10快捷键
- Alt + Tab 选择活动窗口
 
## idea快捷键
- ctrl + Tab 切换窗口
- ctrl + E 最近编辑的窗口 
- Alt + 1 显示/隐藏侧边栏
- ctrl + F4 关闭当前窗口
- Alt + Insert 插入代码【如：生成set get方法】
- Alt + Shift + R 重命名
- Ctrl + Shift + F10 运行代码
- Ctrl + W 关闭侧边栏

# MyBatis学习
## MyBatis（一）
### 解决的问题
MyBatis解决了持久层重复代码多的问题，简化了持久层的开发，减少了持久层的代码量。
### 配置文件的书写
配置文件中要书写的就是传统开发中需要配置的那些jdbc参数信息。
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!--配置包别名【resultType】-->
    <typeAliases>
        <package name="com.bbxx.pojo"/>
    </typeAliases>
    <!-- 配置 mybatis 的环境 -->
    <environments default="mysql">
        <!-- 配置 mysql 的环境 -->
        <environment id="mysql">
            <!-- 配置事务的类型 -->
            <transactionManager type="JDBC"></transactionManager>
            <!-- 配置连接数据库的信息：用的是数据源(连接池) -->
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/mybatis?serverTimezone=UTC"/>
                <property name="username" value="root"/>
                <property name="password" value="root"/>
            </dataSource>
        </environment>
    </environments>
    <!-- 告知 mybatis 映射配置的位置 -->
    <!-- com/bbxx/dao/UserDao.xml是mavenresouce目录下的哦！ -->
    <mappers>
        <mapper resource="com/bbxx/dao/UserDao.xml"/>
        <!-- 如果是用的注解SQL，则采用,因为注解方式不用Mapper文件！ -->
        <mapper class="com.bbxx.dao.IUserDao"/>
    </mappers>
</configuration>
```
SQL文件配置
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.bbxx.dao.IUserDao">
    <!-- 配置查询所有操作 -->
    <select id="findAll" resultType="com.bbxx.pojo.UserVO">
        select * from users
    </select>
</mapper>
```
log4j日志配置
```properties
#log4j基本配置
log4j.rootLogger=DEBUG,console,file
#设置输出控制台信息
log4j.appender.console=org.apache.log4j.ConsoleAppender
log4j.appender.console.Target = System.out
log4j.appender.console.Threshold=DEBUG     #控制台只会打印INFO级别及以上的日志信息
log4j.appender.console.layout = org.apache.log4j.PatternLayout
log4j.appender.console.layout.ConversionPattern=%c-%m%n
#设置输出文件信息
log4j.appender.file = org.apache.log4j.RollingFileAppender
log4j.appender.file.File=log/mybatis.log     #日志文件路径，在应用下的log/mybatis.log文件中
log4j.appender.file.Append=true   #追加
log4j.appender.file.MaxFileSize=100mb    #达到100m后产生一个新文件
log4j.appender.file.Threshold=ERROR      #只会写ERROR级别及以上的日志信息
log4j.appender.file.layout=org.apache.log4j.PatternLayout     #布局器
log4j.appender.file.layout.ConversionPattern=%c-%m%n   #布局器格式
```
**log4j仅打印SQL语句**
```properties
# 全局日志配置
log4j.rootLogger=ERROR, stdout
# MyBatis 日志配置  com.bbxx.dao是包名。
log4j.logger.com.bbxx.dao=TRACE
# 控制台输出
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%5p [%t] - %m%n
```
### Dao层代码

## MyBatis(二)
### 简单的CURD
```java

package com.bbxx.dao;

import com.bbxx.pojo.UserVO;

import java.util.List;

public interface IUserDao {

    // 查询所有
    List<UserVO> findAll();

    // 条件查询
    List<UserVO> findCondition(UserVO vo);

    // 删除
    Integer delete(Integer id);

    // 修改
    Boolean update(UserVO vo);

    // 新增
    Boolean insert(UserVO vo);

    // 模糊查询
    List<UserVO> findByName(String username);

    // 聚合函数
    Long findTotal();
}
```
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.bbxx.dao.IUserDao">
    <!-- 配置查询所有操作 -->
    <select id="findAll" resultType="com.bbxx.pojo.UserVO">
        select *
        from users
    </select>

    <select id="findCondition" resultType="UserVO">
        select * from users where 1 = 1
        <if test="id!=null">
            and id=#{id}
        </if>
        <if test="username!=null">
            and username=#{username}
        </if>
        <if test="birthday!=null">
            and birthday=#{birthday}
        </if>
    </select>

    <delete id="delete">
        delete
        from users
        where id = #{value}
    </delete>

    <update id="update" parameterType="UserVO">
        update users
        <set>
            <if test="username!=null">
                username = #{username}
            </if>
        </set>
        where id=#{id}
    </update>

    <insert id="insert">
        insert into users(username, birthday, address)
        values (#{username}, #{birthday}, #{address})
    </insert>

    <select id="findByName" resultType="UserVO">
        select *
        from users
        where username like concat("%", #{value}, "%")
    </select>

    <select id="findTotal" resultType="long">
        select count(1)
        from users
    </select>
</mapper>
```
### #和$
`#{}`表示一个占位符号

通过`#{}`可以实现 preparedStatement 向占位符中设置值，自动进行 java 类型和 jdbc 类型转换，

`#{}`可以有效防止 sql 注入。 `#{}`可以接收简单类型值或 pojo 属性值。 如果 parameterType 传输单个简单类
型值，`#{}`括号中可以是 value 或其它名称。

`${}`表示拼接 sql 串

通过`${}`可以将 parameterType 传入的内容拼接在 sql 中且不进行 jdbc 类型转换， `${}`可以接收简
单类型值或 pojo 属性值，如果 parameterType 传输单个简单类型值，`${}`括号中只能是 value。

> 源码级别解析

```java
class A{
    @Override
    public String handleToken(String content) {
      Object parameter = context.getBindings().get("_parameter");
      if (parameter == null) {
        context.getBindings().put("value", null);
      } else if (SimpleTypeRegistry.isSimpleType(parameter.getClass())) {
        context.getBindings().put("value", parameter);
      }
      Object value = OgnlCache.getValue(content, context.getBindings());
      String srtValue = (value == null ? "" : String.valueOf(value)); // issue #274 return "" instead of "null"
      checkInjection(srtValue);
      return srtValue;
    }
}
```
>读取的 key 的名字就是”value”，所以我们在绑定参数时就只能叫 value 的名字