package com.example.homework.db.service;


import com.example.homework.db.model.StudentHomework;

import java.util.List;

/**
 * @Author:GQM
 * @Date:created in 15:23 2020/4/21
 * @Description:
 * @Modifyed_By:
 */
public interface StudentHomeworkService {


    /**
     * 学生提交作业
     * @param nsh
     * @return
     */
    String addStudentHomework(StudentHomework nsh);


    /**
     * 查询所有学生提交的作业记录
     * @return
     */
    List<StudentHomework> selectAllStudentHomework();

    /**
     *
     * @param studentId
     * @return
     */
    List<StudentHomework> selectStudentHomeworkByStudentId(long studentId);


    /**
     *
     * @param homeworkId
     * @return
     */
    List<StudentHomework> selectStudentHomeworkByHomeworkId(long homeworkId);

}
