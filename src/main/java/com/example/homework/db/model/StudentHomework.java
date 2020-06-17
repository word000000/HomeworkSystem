package com.example.homework.db.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;

/**
 * @Author:GQM
 * @Date:created in 18:03 2020/3/7
 * @Description:
 * @Modifyed_By:
 */
@Getter
@Setter
@Configuration
public class StudentHomework {

    private Long id;
    private Long studentId;
    private Long homeworkId;
    private String homeworkTitle;
    private String homeworkContent;
    private Timestamp createTime;
    private Timestamp updateTime;
    
}
