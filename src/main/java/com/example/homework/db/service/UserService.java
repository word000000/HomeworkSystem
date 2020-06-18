package com.example.homework.db.service;


import com.example.homework.db.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author:GQM
 * @Date:created in 15:23 2020/4/21
 * @Description:
 * @Modifyed_By:
 */
public interface UserService {

    /**
     * 查找所有学生名单
     * @return
     */
    List<User> selectAllStudent();

    /**
     * 查找所有教师名单
     * @return
     */
    List<User> selectAllTeacher();
    /**
     * 查找所有用户
     * @param userId
     * @return
     */
    List<User> selectById(long userId);

    /**
     * 根据ID来查找用户
     * @param id
     * @return
     */
    String login(Long userId ,String password);
    /**
     * 新增学生
     * @param newUser
     * @return
     */
    String addUser(User newUser) throws SQLException;
}
