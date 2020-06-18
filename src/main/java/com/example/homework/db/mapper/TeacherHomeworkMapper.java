package com.example.homework.db.mapper;

import com.example.homework.db.model.TeacherHomework;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.sql.Timestamp;
import java.util.List;


/**
 * @Author:GQM
 * @Date:created in 20:58 2020/5/27
 * @Description:
 * @Modifyed_By:
 */
public interface TeacherHomeworkMapper {
    @Insert("INSERT INTO teacher_homework(homework_id,teacher_id,homework_title,homework_require,create_time,final_time)" +
            "VALUES (#{homeworkId},#{teacherId},#{homeworkTitle},#{homeworkRequire},#{createTime},#{finalTime})")
    int addTeacherHomework(TeacherHomework teacherHomework);

    @Select("SELECt * from teacher_homework")
    @Results(id = "teacherhomework", value={
            @Result(property = "homeworkId",column = "homework_id",javaType = long.class),
            @Result(property = "teacherId",column = "teacher_id",javaType = long.class),
            @Result(property = "homeworkTitle",column = "homework_title",javaType = String.class),
            @Result(property = "homeworkRequire",column = "homework_require",javaType = String.class),
            @Result(property = "createTime",column = "create_time",javaType = Timestamp.class),
            @Result(property =  "finalTime",column = "final_time",javaType=Timestamp.class)
    })
    List<TeacherHomework> selectAllTeacherHomework();

    @Select("SELECt * from teacher_homework where homework_id = #{id}")
    @Results(id = "teacherhomeworkbyID", value={
            @Result(property = "homeworkId",column = "homework_id",javaType = long.class),
            @Result(property = "teacherId",column = "teacher_id",javaType = long.class),
            @Result(property = "homeworkTitle",column = "homework_title",javaType = String.class),
            @Result(property = "homeworkRequire",column = "homework_require",javaType = String.class),
            @Result(property = "createTime",column = "create_time",javaType = Timestamp.class),
            @Result(property =  "finalTime",column = "final_time",javaType=Timestamp.class)

    })
    List<TeacherHomework> selectTeacherHomeworkById(long id);

    @Select("SELECt * from teacher_homework where teacher_id = #{teacherId}")
    @Results(id = "teacherhomeworkbytID", value={
            @Result(property = "homeworkId",column = "homework_id",javaType = long.class),
            @Result(property = "teacherId",column = "teacher_id",javaType = long.class),
            @Result(property = "homeworkTitle",column = "homework_title",javaType = String.class),
            @Result(property = "homeworkRequire",column = "homework_require",javaType = String.class),
            @Result(property = "createTime",column = "create_time",javaType = Timestamp.class),
            @Result(property =  "finalTime",column = "final_time",javaType=Timestamp.class)

    })
    List<TeacherHomework> selectTeacherHomeworkByTId(long teacherId);

}
