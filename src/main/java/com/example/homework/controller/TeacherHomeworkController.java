package com.example.homework.controller;



import com.example.homework.core.DateUtils1;
import com.example.homework.core.response.DataResponse;
import com.example.homework.db.model.StudentHomework;
import com.example.homework.db.model.TeacherHomework;
import com.example.homework.db.service.StudentHomeworkService;
import com.example.homework.db.service.TeacherHomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:GQM
 * @Date:created in 18:03 2020/4/21
 * @Description:
 * @Modifyed_By:
 */
@RequestMapping("/teacherhomework")
@RestController
@ComponentScan("com.example.homework.*")
public class TeacherHomeworkController {

    @Autowired
    TeacherHomework teacherHomework;
    @Autowired
    TeacherHomeworkService teacherHomeworkService;
    @Autowired
    StudentHomeworkService studentHomeworkService;


    /**
     * 教师发布作业
     * @throws IOException
     */
    @RequestMapping("/createhomework")
    private DataResponse<String> createHomework(@RequestBody Map<String,Object> json) {
        DataResponse<String> dataResponse = new DataResponse<>();
        String response="";
        TeacherHomework teacherHomework = new TeacherHomework();
        long teacherId = Long.valueOf(json.get("teacherId").toString());
        String homeworkTitle = json.get("homeworkTitle").toString();
        String homeworkRequire = json.get("homeworkRequire").toString();
        Timestamp createTime = new Timestamp(System.currentTimeMillis());
        Timestamp finalTime;
        try {
            String finalTime1= DateUtils1.dealDateFormat(json.get("finalTime").toString());
            finalTime = Timestamp.valueOf(finalTime1);
        }catch (Exception e){
            e.printStackTrace();
            dataResponse.setCode(2);
            dataResponse.setMsg("失败");
            dataResponse.setData("时间格式不对");
            return dataResponse;
        }


        teacherHomework.setTeacherId(teacherId);
        teacherHomework.setHomeworkTitle(homeworkTitle);
        teacherHomework.setHomeworkRequire(homeworkRequire);
        teacherHomework.setCreateTime(createTime);
        teacherHomework.setFinalTime(finalTime);

        try {
            response=teacherHomeworkService.createHomework(teacherHomework);
        } catch (Exception e) {
            e.printStackTrace();
        }
        dataResponse.setCode(1);
        dataResponse.setMsg("成功");
        dataResponse.setData(response);
        return dataResponse;
    }



    /**
     * 跳转界面 查看作业记录
     * @return
     */
    @RequestMapping("/searchallhomework")
    private DataResponse<List<TeacherHomework>> searchAllHomework(){
        DataResponse<List<TeacherHomework>> dataResponse = new DataResponse<>();
        List<TeacherHomework> teacherHomeworkList = null;
        try {
            teacherHomeworkList = teacherHomeworkService.selectAllTeacherHomework();
        } catch (Exception e) {
            e.printStackTrace();
        }
        dataResponse.setCode(1);
        dataResponse.setMsg("成功");
        dataResponse.setData(teacherHomeworkList);
        return dataResponse;
    }

    /**
     * 跳转界面 查看作业记录
     * @return
     */
    @RequestMapping("/searchbyteacherid")
    private DataResponse<List<TeacherHomework>> searchHomeworkByTeacherId(@RequestBody Map<String,Object> json){
        DataResponse<List<TeacherHomework>> dataResponse = new DataResponse<>();
        long teacherId = Long.valueOf(json.get("teacherId").toString());
        List<TeacherHomework> teacherHomeworkList = null;
        try {
            teacherHomeworkList = teacherHomeworkService.selectTeacherHomeworkByTeacherId(teacherId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        dataResponse.setCode(1);
        dataResponse.setMsg("成功");
        dataResponse.setData(teacherHomeworkList);
        return dataResponse;
    }


    /**
     *
     * @return
     */
    @RequestMapping("/gethomeworkstatement")
    private DataResponse<Map<String,Object>> searchAllHomework(@RequestBody Map<String,Object> json){
        DataResponse<Map<String,Object>> dataResponse = new DataResponse<>();
        List<TeacherHomework> teacherHomeworkList = null;
        long homeworkId=Long.valueOf(json.get("homeworkId").toString());
        List<StudentHomework> studentHomeworkList = null;
        Map<String,Object> map = new HashMap<>();
        try {
            teacherHomeworkList = teacherHomeworkService.selectTeacherHomeworkById(homeworkId);
            studentHomeworkList = studentHomeworkService.selectStudentHomeworkByHomeworkId(homeworkId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("teacherhomework",teacherHomeworkList);
        map.put("studenthomework",studentHomeworkList);
        dataResponse.setCode(1);
        dataResponse.setMsg("成功");
        dataResponse.setData(map);
        return dataResponse;
    }
}
