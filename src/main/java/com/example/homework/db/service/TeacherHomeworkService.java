package com.example.homework.db.service;

import com.example.homework.db.model.TeacherHomework;

import java.util.List;

/**
 * @Author:GQM
 * @Date:created in 15:24 2020/4/21
 * @Description:
 * @Modifyed_By:
 */
public interface TeacherHomeworkService {
    /**
     * 教师发布一个作业
     * @param teacherHomework
     * @return
     */
    String createHomework(TeacherHomework teacherHomework);

    /**
     * 获取所有布置过的作业
     * @return
     */
    List<TeacherHomework> selectAllTeacherHomework();

    /**
     *
     * @param teacherHomeworkId
     * @return
     */
    List<TeacherHomework> selectTeacherHomeworkById(long teacherHomeworkId);

    /**
     *
     * @param teacherHomeworkId
     * @return
     */
    List<TeacherHomework> selectTeacherHomeworkByTeacherId(long teacherId);

}
