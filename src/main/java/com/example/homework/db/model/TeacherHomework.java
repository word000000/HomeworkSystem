package com.example.homework.db.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;

/**
 * @Author:GQM
 * @Date:created in 23:05 2020/3/7
 * @Description:
 * @Modifyed_By:
 */
@Getter
@Setter
@Configuration
public class TeacherHomework {

    private long homeworkId;
    private long teacherId;
    private String homeworkTitle;
    private String homeworkRequire;
    private Timestamp createTime;
    private Timestamp finalTime;

}
