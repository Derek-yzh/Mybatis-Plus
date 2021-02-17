package com.example.mp;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mp.dao.UserDao;
import com.example.mp.entity.User;
import com.example.mp.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@SpringBootTest
@SuppressWarnings("all")
class MpApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDao userDao;

    /**
     * 测试 mapper 与 Dao 查询byId
     */
    @Test
    void testMp(){
        System.out.println("mapper: " + userMapper.selectById(2));
        System.out.println("dao: " + userDao.queryById((long) 2));
    }

    /**
     * 获取全部User
     */
    @Test
    void testGetAllUsers(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    /**
     * 插入操作
     */
    @Test
    public void testInsert(){
        User user = new User();
        user.setName("哈哈");
        user.setAge(77);
        user.setEmail("65446433@qq.com");
        int result = userMapper.insert(user);
        System.out.println("影响的行数:" + result);
        System.out.println(user); //id自动回填
    }

    /**
     * 更新操作
     */
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(1361944565199683586L);
        user.setAge(99);
        int rows = userMapper.updateById(user);
        System.out.println("update行数: " + rows);
    }

    /**
     * 测试乐观锁插件 成功 version+1
     */
    @Test
    public void testOptimisticLockerSucess(){
        User user = userMapper.selectById(1361944565199683586L);
        user.setAge(100);
        int rows = userMapper.updateById(user);
        System.out.println("update行数: " + rows);
    }

    /**
     * 测试乐观锁插件 失败
     */
    @Test
    public void testOptimisticLockerFail() {
        //查询
        User user = userMapper.selectById(1361944565199683586L);
        //修改数据
        user.setName("Helen Yao1");
        user.setEmail("helen@qq.com1");
        //模拟取出数据后，数据库中version实际数据比取出的值大，即已被其它线程修改并更新了version
        user.setVersion(user.getVersion() - 1);
        //执行更新
        int row = userMapper.updateById(user);
        System.out.println("row: " + row);
    }

    /**
     * 根据id批量查询
     */
    @Test
    public void testSelectBatchIds(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(2,3));
        users.forEach(System.out::println);
    }

    /**
     * 简单条件查询
     * 注意：map中的key对应的是数据库中的列名。
     * 例如数据库user_id，实体类是userId，这时map的key需要填写user_id
     */
    @Test
    public void testSelectByMap(){
        List<User> users = userMapper.selectByMap(Collections.singletonMap("age", "100"));
        users.forEach(System.out::println);
    }


    /**
     * 简单分页操作
     */
    @Test
    public void testPagelist() {
        //创建page对象，传递两个参数：当前页和每页记录数
        Page<User> page = new Page<>(1,3);
        //调用userMapper里面的方法进行分页查询
        userMapper.selectPage(page,null);
        //通过page对象获取分页数据
        List<User> records = page.getRecords();//每页数据
        long current = page.getCurrent(); //当前页
        long pages = page.getPages();//总页数
        long total = page.getTotal();// 总记录数
        long size = page.getSize();// 每页记录数
        boolean previous = page.hasPrevious(); //是否有上一页
        boolean next = page.hasNext();//是否有下一页

        System.out.println("=============================================");
        System.out.println(records);
        System.out.println(current);
        System.out.println(pages);
        System.out.println(total);
        System.out.println(size);
        System.out.println(previous);
        System.out.println(next);
    }

    /**
     * 简单分页操作 结果集是map
     */
    /*@Test
    public void testPagelistDemo() {
        //创建page对象，传递两个参数：当前页和每页记录数
        Page<User> page = new Page<>(1,3);
        //调用userMapper里面的方法进行分页查询
        IPage<Map<String, Object>> mapIPage = userMapper.selectMapsPage(page, null);

        mapIPage.getRecords().forEach(System.out::println);
        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }*/

    /**
     * 根据id实现简单删除
     */
    @Test
    public void testDeleteById(){
        int result = userMapper.deleteById(2L);
        System.out.println(result);
    }

    /**
     * 测试 逻辑删除
     */
    @Test
    public void testLogicDelete(){
        int result = userMapper.deleteById(3);
        System.out.println(result);
    }


}
