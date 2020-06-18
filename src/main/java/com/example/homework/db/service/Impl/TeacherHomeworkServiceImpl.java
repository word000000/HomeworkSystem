package com.example.homework.db.service.Impl;

import com.example.homework.db.mapper.TeacherHomeworkMapper;
import com.example.homework.db.model.TeacherHomework;
import com.example.homework.db.service.TeacherHomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:GQM
 * @Date:created in 15:26 2020/4/21
 * @Description:
 * @Modifyed_By:
 */


@ComponentScan("com.example.homework.*")
@Component
public class TeacherHomeworkServiceImpl implements TeacherHomeworkService {
    @Autowired
    TeacherHomeworkMapper teacherHomeworkMapper;


   @Override
   public String createHomework(TeacherHomework nth){
       String response = "";
       List<TeacherHomework> thList = null;
       thList = teacherHomeworkMapper.selectAllTeacherHomework();
       for(TeacherHomework th:thList){
           //使用equals方法
           if(nth.getHomeworkId()==th.getHomeworkId()){
               return "该id已被使用,3s后跳转";
           }
       }
       if(nth.getHomeworkTitle().equals("")){
           return "作业名不为空，请检查后再添加,3s后跳转";
       }else{
           if(teacherHomeworkMapper.addTeacherHomework(nth)>=0){
               response ="添加成功,3s后跳转";
           }else {
               response = "添加失败，请检查后再添加,3s后跳转";
           }
       }
       //延时跳转
        return response;
   }

   @Override
    public List<TeacherHomework> selectAllTeacherHomework(){

       List<TeacherHomework> list= new ArrayList<TeacherHomework>();
       list = teacherHomeworkMapper.selectAllTeacherHomework();
       return list;

   }

    @Override
    public List<TeacherHomework> selectTeacherHomeworkById(long teacherHomeworkId){
        List<TeacherHomework> list= new ArrayList<>();
        list = teacherHomeworkMapper.selectTeacherHomeworkById(teacherHomeworkId);
        return list;

    }

    @Override
    public List<TeacherHomework> selectTeacherHomeworkByTeacherId(long teacherId){
        List<TeacherHomework> list= new ArrayList<>();
        list = teacherHomeworkMapper.selectTeacherHomeworkByTId(teacherId);
        return list;

    }
}
