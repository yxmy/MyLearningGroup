package com.yx.springboot.demospring.testlist.mybatis.mapper;

import com.yx.springboot.demospring.testlist.mybatis.model.User;
import com.yx.springboot.demospring.testlist.mybatis.provider.UserSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 方式1：使用注解编写SQL
     * @return List<User>
     */
    @Select("select * from t_user ")
    List<User> list();

    /**
     * 方式2：使用注解指定某个工具类的方法来动态编写SQL
     * @param username username
     * @return List<User>
     */
    @SelectProvider(type = UserSqlProvider.class,method = "listByUsername")
    List<User> listByUsername(String username);

    /**
     *  延伸：上述两种方式都可以附加@Results注解来指定结果集的映射关系.
     *  PS：如果符合下划线转驼峰的匹配项可以忽略不写
     * @return List<User>
     */
    @Results({
            @Result(property = "userId", column = "USER_ID"),
            @Result(property = "username", column = "USERNAME"),
            @Result(property = "password", column = "PASSWORD"),
            @Result(property = "mobileNum", column = "PHONE_NUM")
    })
    @Select("select * from t_user ")
    List<User> listSimple();

    /**
     * 延伸：无论什么方式,如果涉及多个参数,则必须加上@Param注解,否则无法使用EL表达式获取参数。
     * @param username username
     * @param password password
     * @return User
     */
    @Select("select * from t_user where username like #{username} and password like #{password}")
    User get(@Param("username") String username, @Param("password") String password);

    /**
     * 获取用户信息
     * @param username username
     * @param password password
     * @return User
     */
    @SelectProvider(type = UserSqlProvider.class, method = "getUser")
    User getUser(@Param("username") String username, @Param("password") String password);
}
