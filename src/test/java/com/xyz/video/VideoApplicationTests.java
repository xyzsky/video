package com.xyz.video;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xyz.video.entity.User;
import com.xyz.video.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class VideoApplicationTests {

    @Autowired
    private UserMapper userMapper;
    //查询user表数据
    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    void addUser() {
        User user = new User();
        user.setName("桃园结义");
        user.setAge(30);
        user.setEmail("xyz@163.com");
        int insert = userMapper.insert(user);
        System.out.println("insert" + insert);
    }

    @Test
    void updateUser() {
        User user = new User();
        user.setId(1l);
        user.setAge(120);
        int row = userMapper.updateById(user);
        System.out.println(row);
    }

    @Test
    void Optimistic() {
        User user = userMapper.selectById(9);
        user.setAge(200);
        userMapper.updateById(user);
    }

    @Test
    void testPage() {
        Page<User> objectPage = new Page<>(1, 3);
        userMapper.selectPage(objectPage,null);
        System.out.println(objectPage.getCurrent());
        System.out.println(objectPage.getRecords());
        System.out.println(objectPage.getTotal());
        System.out.println(objectPage.getSize());
        System.out.println(objectPage.getPages());
        System.out.println(objectPage.hasNext());
        System.out.println(objectPage.hasPrevious());
    }
    @Test
    void testDelete() {
        int i = userMapper.deleteById(10);
        System.out.println(i);
    }
    @Test
    void query() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("age",25);
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }
}
