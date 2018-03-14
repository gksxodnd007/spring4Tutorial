package com.codingsquid.spring4Tutorial.rest_controller.command;

import lombok.Data;

@Data
public class StudentCommand {

    private String name;
    private int age;
    private int identifier_num;

}
