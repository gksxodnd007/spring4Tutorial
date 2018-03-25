package com.codingsquid.spring4Tutorial.model;

import lombok.Data;

@Data
public class Mentor {

    private String name;
    private Student mentee;

}
