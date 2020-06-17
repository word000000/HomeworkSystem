package com.example.homework.db.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:GQM
 * @Date:created in 21:32 2020/3/7
 * @Description:
 * @Modifyed_By:
 */

@Getter
@Setter
@Configuration
public class User {


    private Long userId;
    private String userPassword;
    private int userType;
    private String userName;
}
