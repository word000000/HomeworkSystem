package com.example.homework.db.service.Impl;


import com.example.homework.db.mapper.StudentHomeworkMapper;
import com.example.homework.db.mapper.UserMapper;
import com.example.homework.db.mapper.TeacherHomeworkMapper;
import com.example.homework.db.model.User;
import com.example.homework.db.model.StudentHomework;
import com.example.homework.db.model.TeacherHomework;
import com.example.homework.db.service.StudentHomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * @Author:GQM
 * @Date:created in 15:25 2020/4/21
 * @Description:
 * @Modifyed_By:
 */


@Component
@ComponentScan("com.example.homework.*")

public  class StudentHomeworkServiceImpl implements StudentHomeworkService {


    @Autowired
    StudentHomeworkMapper studentHomeworkMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    TeacherHomeworkMapper teacherHomeworkMapper;

    @Override
    public String addStudentHomework(StudentHomework nsh){
        String respone = "提交成功";
        List<StudentHomework> shlist = null;
        List<TeacherHomework> thlist = null;
        shlist = studentHomeworkMapper.selectAllStudentHomework();

        if(userMapper.selectUserById(nsh.getStudentId()).size()==0){
            return  "当前学生id不存在";
        }

        thlist = teacherHomeworkMapper.selectTeacherHomeworkById(nsh.getHomeworkId());
        if(thlist.size()==0){
            return  "未发现该作业";
        }

        if(nsh.getHomeworkContent().equals("")){
            return  "作业内容不为空";
        }

        if(nsh.getUpdateTime().before(thlist.get(0).getCreateTime())){
            return "作业未开放提交通道";
        }else if(nsh.getUpdateTime().after(thlist.get(0).getFinalTime())){
            return "作业已关闭提交通道";
        }
        nsh.setCreateTime(thlist.get(0).getCreateTime());
        nsh.setHomeworkTitle(thlist.get(0).getHomeworkTitle());

        if(studentHomeworkMapper.addnStudentHomework(nsh)>0){
            return respone;
        }else {
            return "提交失败";
        }
    }

    @Override
    public String update(StudentHomework nsh){
        String respone = "更新成功";
        List<TeacherHomework> thlist = null;
        if(userMapper.selectUserById(nsh.getStudentId()).size()==0){
            return  "当前学生id不存在";
        }
        thlist = teacherHomeworkMapper.selectTeacherHomeworkById(nsh.getHomeworkId());
        if(thlist.size()==0){
            return  "未发现该作业";
        }
        if(nsh.getHomeworkContent().equals("")){
            return  "作业内容不为空";
        }

        if(nsh.getUpdateTime().before(thlist.get(0).getCreateTime())){
            return "作业未开放提交通道";
        }else if(nsh.getUpdateTime().after(thlist.get(0).getFinalTime())){
            return "作业已关闭提交通道";
        }
        nsh.setCreateTime(thlist.get(0).getCreateTime());
        nsh.setHomeworkTitle(thlist.get(0).getHomeworkTitle());

        if(studentHomeworkMapper.update(nsh)>0){
            return respone;
        }else {
            return "提交失败";
        }
    }

    @Override
    public List<StudentHomework> selectAllStudentHomework() {
        List<StudentHomework> list =null;
        list= studentHomeworkMapper.selectAllStudentHomework();
        return list;
    }

    @Override
    public List<StudentHomework> selectStudentHomeworkByStudentId(long studentId) {


        List<StudentHomework> list =null;
        list= studentHomeworkMapper.selectStudentHomeworkByStudentId(studentId);
        return list;
    }

    @Override
    public List<StudentHomework> selectStudentHomeworkByHomeworkId(long homeworkId) {
        List<StudentHomework> list =null;
        list= studentHomeworkMapper.selectStudentHomeworkByhomeworkId(homeworkId);
        return list;
    }

    @Override
    public List<StudentHomework> selectStudentHomeworkByshId(long homeworkId,long studentId) {
        List<StudentHomework> list =null;
        list= studentHomeworkMapper.selectStudentHomeworkByshid(homeworkId,studentId);
        return list;
    }
}

