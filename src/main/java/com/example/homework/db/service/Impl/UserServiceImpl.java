package com.example.homework.db.service.Impl;



import com.example.homework.db.mapper.UserMapper;
import com.example.homework.db.model.User;
import com.example.homework.db.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author:GQM
 * @Date:created in 15:26 2020/4/21
 * @Description:
 * @Modifyed_By:
 */

@Component
@ComponentScan("com.example.homework.*")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> selectAllStudent(){
        List<User> list = null;
        list = userMapper.selectAllStudent();
        return list;
    }

    @Override
    public List<User> selectAllTeacher(){
        List<User> list = null;
        list = userMapper.selectAllTeacher();
        return list;
    }

    /**
     * 查找所有用户
     *
     * @return
     */
    @Override
    public List<User> selectById(long userId) {
        List<User> list = null;
        list = userMapper.selectUserById(userId);
        return list;
    }

    /**
     * 根据ID来查找用户
     *
     * @param id
     * @return
     */
    @Override
    public String login(Long userId , String password) {
        List<User> list = null;
        list = userMapper.selectUserById(userId);
        String response;
        if(list.size()==1){
            if(password.equals(list.get(0).getUserPassword())){
                response = "登录成功，欢迎你"+list.get(0).getUserName();
            }else {
                response= "登录失败";
            }
        }else if(list.size()==0) {
            response= "账号不存在或密码错误";
        }else {
            response="账户异常";
        }
        return response;
    }


    @Override
    public String addUser(User newUser){
        List<User> userList = null;
        String response ="";
        userList = userMapper.selectUserById(newUser.getUserId());
        if(userList.size()>=1){
            return "该账户已注册";
        }
        if(userMapper.add(newUser)>0){
            response ="注册成功";
        }else {
            response = "注册失败";
        }

        return response;
    }
}
