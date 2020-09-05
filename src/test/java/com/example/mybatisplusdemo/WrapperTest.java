package com.example.mybatisplusdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplusdemo.pojo.User;
import com.example.mybatisplusdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @author long
 * @version 1.0.0
 * @date 2020/9/4
 *
 * 测试条件查询wrapper方法的类
 */
@SpringBootTest
public class WrapperTest {
    //继承了BaseMapper所有的方法，我们也可以编写自己的扩展方法
    @Autowired
    private UserMapper userMapper;

    // 测试查询name不为空的用户，并且邮箱不为空，年龄大于20岁的用户
    @Test
    void contextLoads() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("name")
                .isNotNull("email")
                .ge("age",21);
        // 该参数是一个wrapper对象，条件构造器，若为null则查询全部用户
        List<User> user = userMapper.selectList(wrapper);
        user.forEach(System.out::println);
    }

    // 测试查询名字为long的用户
    @Test
    void test2(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","long");
        // selectOne方法用于查询一个数据；若出现多个结果时使用List或者Map。
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    // 测试查询名字为longlong的用户
    @Test
    void test3(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","longlong");
        // selectOne方法用于查询一个数据；若出现多个结果时使用List或者Map。
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    // 测试查询年龄在20-30之间的用户
    @Test
    void test4(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age",20,30);  // 输入一个查询区间
        Integer count = userMapper.selectCount(wrapper);  // 查询的结果数
        System.out.println(count);
    }

    // 测试模糊查询
    @Test
    void test5(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.notLike("name","k")
                .likeRight("email","t");    // 左：%t    右：t%     两边：%t%
//                .likeLeft("name","y");
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    // 测试连接查询，内查询（嵌入查询）
    @Test
    void test6(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // id在子查询中查出来
        wrapper.inSql("id","select id from user where id<3");
        List<Object> objects = userMapper.selectObjs(wrapper);
        System.out.println(objects);
        objects.forEach(System.out::println);
    }

    // 测试通过age排序  Desc降序排序  Asc升序排序
    @Test
    void test7(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("age");
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
        users.forEach(System.out::println);
    }
}
