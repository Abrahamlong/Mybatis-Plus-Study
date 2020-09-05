package com.example.mybatisplusdemo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo.POJO.User;
import com.example.mybatisplusdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.plaf.PopupMenuUI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisplusdemoApplicationTests {

    //继承了BaseMapper所有的方法，我们也可以编写自己的扩展方法
    @Autowired
    private UserMapper userMapper;

    // 测试查询全部用户
    @Test
    void contextLoads() {
        // 该参数是一个wrapper对象，条件构造器，若为null则查询全部用户
        List<User> user = userMapper.selectList(null);
        user.forEach(System.out::println);
    }

    // 测试插入操作
    @Test
    public void testInsert(){

        User user = new User();
//        user.setId((long) 6);
        user.setName("longlong");
        user.setAge(22);
        user.setEmail("long@888.com");

        int result = userMapper.insert(user);
        System.out.println(result);
        System.out.println(user);
    }

    // 测试更新操作
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(6L);
        user.setName("long");
        user.setAge(18);
        user.setEmail("long@888.com");
        int i = userMapper.updateById(user);
        System.out.println(i);
    }

    //测试乐观锁成功
    @Test
    public void testOptimisticLocker(){
        // 1.查询用户信息
        User user = userMapper.selectById(1L);
        // 2.修改用户信息
        user.setName("longjian");
        user.setEmail("longjian@66.com");
        // 3.执行更新操作
        int i = userMapper.updateById(user);
        System.out.println(i);
    }

    //测试乐观锁失败
    @Test
    public void testOptimisticLocker2(){
        // 线程1
        User user = userMapper.selectById(1L);
        user.setName("longjian");
        user.setEmail("longjian@66.com");
        //模拟另外一个线程线程执行了插队操作
        User user2 = userMapper.selectById(1L);
        user2.setName("abraham");
        user2.setEmail("longjian@888.com");
        // 线程2执行更新
        int i = userMapper.updateById(user2);
        System.out.println(i);
        // 线程1执行更新
        int ii = userMapper.updateById(user);  //如果没有乐观锁就会覆盖插队线程的值
        System.out.println(ii);
    }

    // 测试查询
    @Test
    public void testSelectById(){
        User user = userMapper.selectById(3L);
        System.out.println(user);
    }
    // 测试批量查询
    @Test
    public void testSelectBatchById(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3, 4));
        users.forEach(System.out::println);
    }

    // 测试条件查询:使用map操作
    @Test
    public void testSelectBatchByIds(){
        HashMap<String, Object> map = new HashMap<>();
        // 自定义要查询的条件
        map.put("name","longlong");
        map.put("age",23);

        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);

    }

    // 测试分页查询操作
    @Test
    public void testPage(){
        //参数一：当前页    参数二：页面大小
        //使用分页查询之后分页操作变得更简单了
        Page<User> page = new Page<>(2,4);
        userMapper.selectPage(page,null);

        page.getRecords().forEach(System.out::println);
        System.out.println(page.getTotal());
    }

    // 测试删除操作
    @Test
    public void testDeleteById(){
        userMapper.deleteById(1L);
    }
    // 测试批量删除
    @Test
    public void testDeleteBatchId(){
        userMapper.deleteBatchIds(Arrays.asList(1301761093335953409L,1301803838637252609L));
    }

    // 通过map按条件删除
    @Test
    public void testDeleteMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","longlong");
        map.put("age",22);
        int i = userMapper.deleteByMap(map);
        System.out.println(i);
    }
}
