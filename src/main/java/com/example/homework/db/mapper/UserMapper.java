package com.example.homework.db.mapper;


import com.example.homework.db.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * @Author:GQM
 * @Date:created in 20:57 2020/5/27
 * @Description:
 * @Modifyed_By:
 */
public interface UserMapper {

    @Select("SELECT * from user")
    @Results(id="alluser",value = {
        @Result(property = "userId", column = "user_id"),
        @Result(property = "userPassword",column = "user_password"),
        @Result(property = "userType",column = "user_type"),
        @Result(property = "userName",column = "user_name"),
        @Result(property = "userName",column = "user_name")
        })
    List<User> selectAllUser();


    @Select("SELECT * from user where user_id = #{id}")
    @Results(id="userbyId",value = {
        @Result(property = "userId", column = "user_id"),
        @Result(property = "userPassword",column = "user_password"),
        @Result(property = "userType",column = "user_type"),
        @Result(property = "userName",column = "user_name")
    })
    List<User> selectUserById(long id);

    @Select("SELECT * from user where user_type = 0")
    @Results(id="student",value = {
        @Result(property = "userId", column = "user_id"),
        @Result(property = "userPassword",column = "user_password"),
        @Result(property = "userType",column = "user_type"),
        @Result(property = "userName",column = "user_name")
    })
    List<User> selectAllStudent();

    @Select("SELECT * from user where user_type = 1")
    @Results(id="teacher",value = {
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userPassword",column = "user_password"),
            @Result(property = "userType",column = "user_type"),
            @Result(property = "userName",column = "user_name")
    })
    List<User> selectAllTeacher();

    @Insert("INSERT INTO user(user_id,user_password,user_name,user_type) VALUES (#{userId},#{userPassword},#{userName},#{userType})")
    int add(User user);


}
