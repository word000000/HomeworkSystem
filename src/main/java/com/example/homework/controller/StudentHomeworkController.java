package com.example.homework.controller;

import com.example.homework.core.response.DataResponse;
import com.example.homework.db.model.StudentHomework;
import com.example.homework.db.service.StudentHomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * @Author:GQM
 * @Date:created in 18:01 2020/4/21
 * @Description:
 * @Modifyed_By:
 */

@RequestMapping("/studenthomework")
@RestController
@ComponentScan("com.example.homework.*")
public class StudentHomeworkController {

    @Autowired
    StudentHomeworkService studentHomeworkService;

    /**
     学生提交作业
     */
    @RequestMapping("/submit")
    private DataResponse<String> submit(@RequestBody Map<String,Object> json){
        DataResponse<String> dataResponse = new DataResponse<>();
        StudentHomework nsh = new StudentHomework();

        long studentId = Long.valueOf(json.get("studentId").toString());
        long homeworkId = Long.valueOf(json.get("homeworkId").toString());
        String homeworkContent = json.get("homeworkContent").toString();

        nsh.setStudentId(studentId);
        nsh.setHomeworkId(homeworkId);
        nsh.setHomeworkContent(homeworkContent);
        Timestamp dateNow = new Timestamp(System.currentTimeMillis());
        nsh.setUpdateTime(dateNow);
        String response = null;
        try {
            response = studentHomeworkService.addStudentHomework(nsh);
        } catch (Exception e) {
            e.printStackTrace();
        }
        dataResponse.setCode(1);
        dataResponse.setMsg("成功");
        dataResponse.setData(response);
        return dataResponse;
    }

    @RequestMapping("/update")
    private DataResponse<String> update(@RequestBody Map<String,Object> json){
        DataResponse<String> dataResponse = new DataResponse<>();
        StudentHomework nsh = new StudentHomework();

        long studentId = Long.valueOf(json.get("studentId").toString());
        long homeworkId = Long.valueOf(json.get("homeworkId").toString());
        String homeworkContent = json.get("homeworkContent").toString();

        nsh.setStudentId(studentId);
        nsh.setHomeworkId(homeworkId);
        nsh.setHomeworkContent(homeworkContent);

        Timestamp dateNow = new Timestamp(System.currentTimeMillis());
        nsh.setUpdateTime(dateNow);
        String response = null;
        try {
            response = studentHomeworkService.update(nsh);
        } catch (Exception e) {
            e.printStackTrace();
        }
        dataResponse.setCode(1);
        dataResponse.setMsg("成功");
        dataResponse.setData(response);
        return dataResponse;
    }

    /**
     *
     * @param json
     * @return
     */
    @RequestMapping("/bysid")
    private DataResponse<List<StudentHomework>> selectBySId(@RequestBody Map<String,Object> json){
        DataResponse<List<StudentHomework>> dataResponse = new DataResponse<>();
        StudentHomework nsh = new StudentHomework();
        long studentId = Long.valueOf(json.get("studentId").toString());
        List<StudentHomework> list = studentHomeworkService.selectStudentHomeworkByStudentId(studentId);
        dataResponse.setCode(1);
        dataResponse.setMsg("成功");
        dataResponse.setData(list);
        return dataResponse;
    }

    /**
     *
     * @param json
     * @return
     */
    @RequestMapping("/bythid")
    private DataResponse<List<StudentHomework>> selectByTHId(@RequestBody Map<String,Object> json){
        DataResponse<List<StudentHomework>> dataResponse = new DataResponse<>();
        StudentHomework nsh = new StudentHomework();
        long homeworkId = Long.valueOf(json.get("homeworkId").toString());
        List<StudentHomework> list = studentHomeworkService.selectStudentHomeworkByHomeworkId(homeworkId);
        dataResponse.setCode(1);
        dataResponse.setMsg("成功");
        dataResponse.setData(list);
        return dataResponse;
    }

    @RequestMapping("/byshid")
    private DataResponse<List<StudentHomework>> selectBySHId(@RequestBody Map<String,Object> json){
        DataResponse<List<StudentHomework>> dataResponse = new DataResponse<>();
        StudentHomework nsh = new StudentHomework();
        long homeworkId = Long.valueOf(json.get("homeworkId").toString());
        long studentId = Long.valueOf(json.get("studentId").toString());
        List<StudentHomework> list = studentHomeworkService.selectStudentHomeworkByshId(homeworkId,studentId);
        dataResponse.setCode(1);
        dataResponse.setMsg("成功");
        dataResponse.setData(list);
        return dataResponse;
    }
}
