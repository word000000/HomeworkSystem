package com.example.homework.controller;


import com.example.homework.core.response.DataResponse;
import com.example.homework.db.model.User;
import com.example.homework.db.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;


/**
 * @Author:GQM
 * @Date:created in 18:05 2020/4/21
 * @Description:
 * @Modifyed_By:
 */

@RestController
@ComponentScan("com.example.homework.*")
@RequestMapping("/")
public class UserController {


    @Autowired
    UserService userService;
    /**
     * 跳转界面 学生名单操作

     * @return
     * @throws IOException
     */
    @RequestMapping("searchstudent")
    private DataResponse<List<User>> searchStudent(){
        List<User> list = null;
        DataResponse<List<User>> dataResponse = new DataResponse<>();
        try {
            list = userService.selectAllStudent();
        } catch (Exception e) {
            e.printStackTrace();
        }
        dataResponse.setCode(0);
        dataResponse.setMsg("查询成功");
        dataResponse.setData(list);
        return dataResponse;
    }

    @RequestMapping("searchteacher")
    private DataResponse<List<User>> searchTeacher(){
        List<User> list = null;
        DataResponse<List<User>> dataResponse = new DataResponse<>();
        try {
            list = userService.selectAllTeacher();
        } catch (Exception e) {
            e.printStackTrace();
        }
        dataResponse.setCode(0);
        dataResponse.setMsg("查询成功");
        dataResponse.setData(list);
        return dataResponse;
    }

    /**
     * 注册
     * @throws IOException
     */
    @RequestMapping("register")
    private DataResponse<String> register(@RequestBody User user) {
        DataResponse<String> dataResponse = new DataResponse<>();
        String response ="";
        try {
            response = userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        dataResponse.setCode(1);
        dataResponse.setMsg("成功");
        dataResponse.setData(response);
        return dataResponse;
    }

    /**
     * 登录
     */
    @RequestMapping("login")
    private DataResponse<String> login(@RequestBody Map<String,Object> json){

        DataResponse<String> dataResponse = new DataResponse<>();
        String response="";
        long userId = Long.valueOf(json.get("userId").toString());
        String userPassword = (String) json.get("userPassword");
        try{
            response = userService.login(userId,userPassword);
        }catch (Exception e){
            e.printStackTrace();
        }
        dataResponse.setCode(1);
        dataResponse.setMsg("成功");
        dataResponse.setData(response);
        return dataResponse;
    }
}
