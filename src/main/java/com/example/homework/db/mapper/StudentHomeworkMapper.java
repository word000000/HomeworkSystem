package com.example.homework.db.mapper;


import com.example.homework.db.model.StudentHomework;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.List;


/**
 * @Author:GQM
 * @Date:created in 19:16 2020/5/27
 * @Description:
 * @Modifyed_By:
 */
public interface StudentHomeworkMapper {


    @Select("SELECT * FROM student_homework")
    @Results(id = "studentAllHomework",value = {
            @Result(property = "id",column = "id"),
            @Result(property = "studentId",column = "student_id"),
            @Result(property = "homeworkId",column = "homework_id"),
            @Result(property = "homeworkTitle",column = "homework_title"),
            @Result(property = "homeworkContent",column = "homework_content"),
            @Result(property = "createTime",column = "create_time",javaType = Timestamp.class),
            @Result(property = "updateTime",column = "update_time",javaType = Timestamp.class)
    })
    List<StudentHomework> selectAllStudentHomework();

    @Select("SELECT * FROM student_homework where student_id = #{studentId}")
    @Results(id = "studentHomeworksId",value = {
            @Result(property = "id",column = "id"),
            @Result(property = "studentId",column = "student_id"),
            @Result(property = "homeworkId",column = "homework_id"),
            @Result(property = "homeworkTitle",column = "homework_title"),
            @Result(property = "homeworkContent",column = "homework_content"),
            @Result(property = "createTime",column = "create_time",javaType = Timestamp.class),
            @Result(property = "updateTime",column = "update_time",javaType = Timestamp.class)
    })
    List<StudentHomework> selectStudentHomeworkByStudentId(long studentId);

    @Select("SELECT * FROM student_homework where homework_id = #{homeworkId}")
    @Results(id = "studentHomeworkhId",value = {
            @Result(property = "id",column = "id"),
            @Result(property = "studentId",column = "student_id"),
            @Result(property = "homeworkId",column = "homework_id"),
            @Result(property = "homeworkTitle",column = "homework_title"),
            @Result(property = "homeworkContent",column = "homework_content"),
            @Result(property = "createTime",column = "create_time",javaType = Timestamp.class),
            @Result(property = "updateTime",column = "update_time",javaType = Timestamp.class)
    })
    List<StudentHomework> selectStudentHomeworkByhomeworkId(long homeworkId);

    @Select("SELECT * FROM student_homework where homework_id = #{homeworkId} and student_id = #{studentId}")
    @Results(id = "studentHomeworkshId",value = {
            @Result(property = "id",column = "id"),
            @Result(property = "studentId",column = "student_id"),
            @Result(property = "homeworkId",column = "homework_id"),
            @Result(property = "homeworkTitle",column = "homework_title"),
            @Result(property = "homeworkContent",column = "homework_content"),
            @Result(property = "createTime",column = "create_time",javaType = Timestamp.class),
            @Result(property = "updateTime",column = "update_time",javaType = Timestamp.class)
    })
    List<StudentHomework> selectStudentHomeworkByshid(long homeworkId,long studentId);

    @Insert("Insert INTO student_homework(student_id,homework_id,homework_title,homework_content,create_time,update_time)" +
            "VALUES(#{studentId},#{homeworkId},#{homeworkTitle},#{homeworkContent},#{createTime},#{updateTime})")
    int addnStudentHomework(StudentHomework studentHomework);

    @Update("update student_homework set homework_content=#{homeworkContent},update_time=#{updateTime} where student_id= #{studentId} and homework_id = #{homeworkId}")
    int update(StudentHomework studentHomework);
}
